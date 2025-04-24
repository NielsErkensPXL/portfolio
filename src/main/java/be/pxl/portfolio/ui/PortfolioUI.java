package be.pxl.portfolio.ui;

import be.pxl.portfolio.model.Activity;
import be.pxl.portfolio.service.ActivityService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PortfolioUI extends JFrame {
    private final ActivityService service;
    private final JTabbedPane tabbedPane;

    public PortfolioUI(ActivityService service) {
        this.service = service;
        setTitle("Activity Portfolio");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
        loadActivities();
        setVisible(true);
    }

    private void loadActivities() {
    List<Activity> activities = service.getAll();
    System.out.println("Number of activities retrieved: " + activities.size());

    Map<String, List<Activity>> activitiesByType = activities.stream()
            .filter(activity -> activity.getType() != null)
            .collect(Collectors.groupingBy(Activity::getType));

    for (Map.Entry<String, List<Activity>> entry : activitiesByType.entrySet()) {
        String type = entry.getKey();
        List<Activity> activitiesOfType = entry.getValue();

        JPanel typePanel = new JPanel();
        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
        typePanel.setBackground(new Color(245, 245, 255)); 
        typePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        if ("seminarie".equals(type)) {
            JPanel gridPanel = new JPanel(new GridLayout(0, 4, 10, 10));
            gridPanel.setBackground(new Color(255, 240, 245));

            for (Activity a : activitiesOfType) {
                JPanel panel = new JPanel(new BorderLayout());
                panel.setPreferredSize(new Dimension(200, 150));
                panel.setBackground(new Color(255, 250, 240));
                panel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
                ));

                JLabel titleLabel = new JLabel(a.getTitle());
                titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
                titleLabel.setForeground(new Color(50, 50, 50));
                titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                titleLabel.setToolTipText(a.getTitle());
                panel.add(titleLabel, BorderLayout.NORTH);

                JLabel descriptionLabel = new JLabel("<html><p style='text-align:center;'>" + a.getDescription() + "</p></html>");
                descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                descriptionLabel.setForeground(new Color(80, 80, 80));
                descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
                descriptionLabel.setToolTipText(a.getDescription());
                panel.add(descriptionLabel, BorderLayout.CENTER);

                gridPanel.add(panel);
            }

            typePanel.add(gridPanel);
        } else {
            for (Activity a : activitiesOfType) {
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setBackground(new Color(240, 255, 240));
                panel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                ));

                JLabel titleLabel = new JLabel(a.getTitle());
                titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
                titleLabel.setForeground(new Color(50, 50, 50));
                titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                titleLabel.setToolTipText(a.getTitle());
                panel.add(titleLabel);

                JLabel descriptionLabel = new JLabel("<html><div style='text-align:center; width:100%; height:50px; overflow:hidden;'>" + a.getDescription() + "</div></html>");
                descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                descriptionLabel.setForeground(new Color(80, 80, 80));
                descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                descriptionLabel.setToolTipText(a.getDescription());
                panel.add(descriptionLabel);

                if (a.getImagePaths() != null && !a.getImagePaths().isEmpty()) {
                    JPanel imagePanel = new JPanel(new GridLayout(0, 3, 10, 10));
                    imagePanel.setBackground(new Color(240, 248, 255)); // Light pastel blue

                    for (String path : a.getImagePaths()) {
                        JLabel imageLabel = new JLabel();
                        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        imageLabel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

                        new SwingWorker<BufferedImage, Void>() {
                            @Override
                            protected BufferedImage doInBackground() throws Exception {
                                URL imageUrl = getClass().getClassLoader().getResource(path);
                                if (imageUrl != null) {
                                    return ImageIO.read(imageUrl.openStream());
                                }
                                return null;
                            }

                            @Override
                            protected void done() {
                                try {
                                    BufferedImage img = get();
                                    if (img != null) {
                                        imageLabel.setIcon(new ImageIcon(img.getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
                                    } else {
                                        imageLabel.setText("Image not found");
                                    }
                                } catch (Exception e) {
                                    imageLabel.setText("Error loading image");
                                }
                            }
                        }.execute();

                        imagePanel.add(imageLabel);
                    }

                    panel.add(imagePanel);
                } else {
                    JLabel noImageLabel = new JLabel("No images available");
                    noImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel.add(noImageLabel);
                }

                typePanel.add(panel);
            }
        }

        JScrollPane scrollPane = new JScrollPane(typePanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        tabbedPane.addTab(type, scrollPane);
    }
}
}