package be.pxl.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String imagePath;
    private String reflection;

    public String getTitle() {
        return title;
    }
    public String getImagePath() {
        return imagePath;
    }
    public String getReflection() {
        return reflection;
    }
}