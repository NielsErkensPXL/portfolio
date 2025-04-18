package be.pxl.portfolio.service;

import be.pxl.portfolio.model.Activity;
import be.pxl.portfolio.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepository repo;

    public ActivityService(ActivityRepository repo) {
        this.repo = repo;
    }

    public List<Activity> getAll() {
        return repo.findAll();
    }

    public Activity save(Activity a) {
        return repo.save(a);
    }
}
