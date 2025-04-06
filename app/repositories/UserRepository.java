package repositories;

import models.User;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class UserRepository {
    public CompletionStage<User> create(User user) {
        return supplyAsync(() -> {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO users (username, password, role, created_at) VALUES (?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    statement.setString(1, user.getUsername());
                    statement.setString(2, user.getPassword());
                    statement.setString(3, user.getRole());
                    statement.setTimestamp(4, user.getCreatedAt());
                    statement.executeUpdate();
                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            user.setId(generatedKeys.getLong(1));
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return user;
        });
    }

    public CompletionStage<Optional<User>> findByUsername(String username) {
        return supplyAsync(() -> {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "SELECT * FROM users WHERE username = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, username);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            User user = new User(
                                resultSet.getLong("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getString("role"),
                                resultSet.getTimestamp("created_at")
                            );
                            return Optional.of(user);
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return Optional.empty();
        });
    }
} 