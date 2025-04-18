package be.pxl.portfolio.repository;

import be.pxl.portfolio.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
