package be.pxl.portfolio.service;

import be.pxl.portfolio.model.Activity;
import be.pxl.portfolio.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepository repo;

    public ActivityService(ActivityRepository repo) {
        this.repo = repo;
    }

    public List<Activity> getAll() {
        List<Activity> activities = repo.findAll();
        System.out.println("Activities in the database:");
        for (Activity activity : activities) {
            System.out.println("ID: " + activity.getId());
            System.out.println("Title: " + activity.getTitle());
            System.out.println("Type: " + activity.getType());
            System.out.println("Description: " + activity.getDescription());
            System.out.println("Image Paths: " + activity.getImagePaths());
            System.out.println("-----------------------------------");
        }
        return activities;
    }

    public Activity save(Activity a) {
        return repo.save(a);
    }
}
