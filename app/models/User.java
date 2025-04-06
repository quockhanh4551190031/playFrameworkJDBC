package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Timestamp;

public class User {
    private Long id;
    private String username;
    private String password;
    private String role;
    private Timestamp createdAt;

    public User() {
        // Default constructor
    }

    public User(Long id, String username, String password, String role, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
} 