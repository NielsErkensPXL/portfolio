package be.pxl.portfolio;

import be.pxl.portfolio.service.ActivityService;
import be.pxl.portfolio.ui.PortfolioUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class PortfolioApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PortfolioApplication.class, args);
		ActivityService service = context.getBean(ActivityService.class);
		SwingUtilities.invokeLater(() -> new PortfolioUI(service));
	}
}
