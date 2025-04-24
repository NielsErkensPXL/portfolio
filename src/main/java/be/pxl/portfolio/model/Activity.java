package be.pxl.portfolio.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String type;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> imagePaths;
    private String description;
    public Activity(String title, List<String> imagePath, String type, String description) {
        this.title = title;
        this.imagePaths = imagePath;
        this.type = type;
        this.description = description;
    }
    public Activity() {
        this.title = "Test title";
        this.imagePaths = List.of("path/to/image.jpg");
        this.type = "Test type";
        this.description = "Test description";
    }
    public String getTitle() {
        return title;
    }
    public List<String> getImagePaths() {
        return imagePaths;
    }
    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }
}