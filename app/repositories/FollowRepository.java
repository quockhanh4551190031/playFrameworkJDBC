package repositories;

import models.Follow;
import models.User;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CompletionStage;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import java.util.ArrayList;

public class FollowRepository {
    public CompletionStage<Void> follow(Long followerId, Long followedId) {
        return supplyAsync(() -> {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO follows (follower_id, followed_id, created_at) VALUES (?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setLong(1, followerId);
                    statement.setLong(2, followedId);
                    statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
    }

    public CompletionStage<Void> unfollow(Long followerId, Long followedId) {
        return supplyAsync(() -> {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM follows WHERE follower_id = ? AND followed_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setLong(1, followerId);
                    statement.setLong(2, followedId);
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
    }

    public CompletionStage<List<User>> getFollowers(Long userId) {
        return supplyAsync(() -> {
            List<User> followers = new ArrayList<>();
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "SELECT u.* FROM users u " +
                           "JOIN follows f ON u.id = f.follower_id " +
                           "WHERE f.followed_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setLong(1, userId);
                    try (ResultSet rs = statement.executeQuery()) {
                        while (rs.next()) {
                            User user = new User(
                                rs.getLong("id"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("role"),
                                rs.getTimestamp("created_at")
                            );
                            followers.add(user);
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return followers;
        });
    }

    public CompletionStage<List<User>> getFollowing(Long userId) {
        return supplyAsync(() -> {
            List<User> following = new ArrayList<>();
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "SELECT u.* FROM users u " +
                           "JOIN follows f ON u.id = f.followed_id " +
                           "WHERE f.follower_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setLong(1, userId);
                    try (ResultSet rs = statement.executeQuery()) {
                        while (rs.next()) {
                            User user = new User(
                                rs.getLong("id"),
                                rs.getString("username"), 
                                rs.getString("password"),
                                rs.getString("role"),
                                rs.getTimestamp("created_at")
                            );
                            following.add(user);
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return following;
        });
    }

    public CompletionStage<Boolean> isFollowing(Long followerId, Long followedId) {
        return supplyAsync(() -> {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "SELECT COUNT(*) as count FROM follows " +
                           "WHERE follower_id = ? AND followed_id = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setLong(1, followerId);
                    statement.setLong(2, followedId);
                    try (ResultSet rs = statement.executeQuery()) {
                        if (rs.next()) {
                            return rs.getInt("count") > 0;
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return false;
        });
    }
} 