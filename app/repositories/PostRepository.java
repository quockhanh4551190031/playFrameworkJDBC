package repositories;

import models.Post;
import models.User;
import models.Pair;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import java.util.ArrayList;

public class PostRepository {
    public CompletionStage<Post> create(Post post) {
        return supplyAsync(() -> {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO posts (title, body, user_id, status, created_at) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    statement.setString(1, post.getTitle());
                    statement.setString(2, post.getBody());
                    statement.setLong(3, post.getUserId());
                    statement.setString(4, post.getStatus());
                    statement.setTimestamp(5, post.getCreatedAt());
                    statement.executeUpdate();
                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            post.setId(generatedKeys.getLong(1));
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return post;
        });
    }

    public CompletionStage<List<Pair<Post, User>>> getAllPostsWithUsers() {
        return supplyAsync(() -> {
            List<Pair<Post, User>> postsWithUsers = new ArrayList<>();
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "SELECT p.*, u.* FROM posts p JOIN users u ON p.user_id = u.id";
                try (PreparedStatement statement = connection.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Post post = new Post(
                            resultSet.getLong("id"),
                            resultSet.getString("title"),
                            resultSet.getString("body"),
                            resultSet.getLong("user_id"),
                            resultSet.getString("status"),
                            resultSet.getTimestamp("created_at")
                        );
                        User user = new User(
                            resultSet.getLong("u.id"),
                            resultSet.getString("u.username"),
                            resultSet.getString("u.password"),
                            resultSet.getString("u.role"),
                            resultSet.getTimestamp("u.created_at")
                        );
                        postsWithUsers.add(new Pair<>(post, user));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return postsWithUsers;
        });
    }

    // Other methods should also be updated similarly
} 