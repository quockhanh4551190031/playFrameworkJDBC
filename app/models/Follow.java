package models;

import java.sql.Timestamp;

public class Follow {
    private Long id;
    private Long followerId;
    private Long followedId;
    private Timestamp createdAt;

    public Follow() {
        // Default constructor
    }

    public Follow(Long id, Long followerId, Long followedId, Timestamp createdAt) {
        this.id = id;
        this.followerId = followerId;
        this.followedId = followedId;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getFollowerId() { return followerId; }
    public void setFollowerId(Long followerId) { this.followerId = followerId; }
    public Long getFollowedId() { return followedId; }
    public void setFollowedId(Long followedId) { this.followedId = followedId; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
} 