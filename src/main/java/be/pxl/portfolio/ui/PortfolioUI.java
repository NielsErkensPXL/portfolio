package be.pxl.portfolio.ui;

import be.pxl.portfolio.model.Activity;
import be.pxl.portfolio.service.ActivityService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PortfolioUI extends JFrame {
    private final ActivityService service;
    private final JPanel contentPanel;

    public PortfolioUI(ActivityService service) {
        this.service = service;
        setTitle("Activity Portfolio");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        add(scrollPane);
        loadActivities();
        setVisible(true);
    }
    private void loadActivities() {
        List<Activity> activities = service.getAll();
        for (Activity a : activities) {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            JLabel titleLabel = new JLabel(a.getTitle());
            JLabel imageLabel = new JLabel();
            try {
                BufferedImage img = ImageIO.read(new File(a.getImagePath()));
                imageLabel.setIcon(new ImageIcon(img.getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
            } catch (IOException e) {
                imageLabel.setText("Image not found");
            }
            JTextArea reflectionArea = new JTextArea(a.getReflection());
            reflectionArea.setLineWrap(true);
            reflectionArea.setWrapStyleWord(true);
            reflectionArea.setEditable(false);
            panel.add(titleLabel, BorderLayout.NORTH);
            panel.add(imageLabel, BorderLayout.CENTER);
            panel.add(reflectionArea, BorderLayout.SOUTH);
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            contentPanel.add(panel);
        }
        contentPanel.revalidate();
    }
}

