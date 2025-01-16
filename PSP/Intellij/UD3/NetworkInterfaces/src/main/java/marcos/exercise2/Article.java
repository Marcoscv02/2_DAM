package marcos.exercise2;

import java.time.LocalDateTime;

public class Article {
    private Long id, userId;
    private String tittle, description, photoUrl, category, contentText, contentHtml;
    private LocalDateTime createdAt, UpdatedAt;

    public Article() {
    }

    public Article(Long id, String tittle, String description, String photoUrl, String category, String contentText, String contentHtml, LocalDateTime createdAt, LocalDateTime updatedAt, Long userId) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.photoUrl = photoUrl;
        this.category = category;
        this.contentText = contentText;
        this.contentHtml = contentHtml;
        this.createdAt = createdAt;
        UpdatedAt = updatedAt;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", userId=" + userId +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", category='" + category + '\'' +
                ", contentText='" + contentText + '\'' +
                ", contentHtml='" + contentHtml + '\'' +
                ", createdAt=" + createdAt +
                ", UpdatedAt=" + UpdatedAt +
                '}';
    }
}
