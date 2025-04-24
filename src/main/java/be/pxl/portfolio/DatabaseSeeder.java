package be.pxl.portfolio;

import be.pxl.portfolio.model.Activity;
import be.pxl.portfolio.repository.ActivityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final ActivityRepository activityRepository;

    public DatabaseSeeder(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void run(String... args) {
        List<String> austriaImagePaths = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            URL imageUrl = getClass().getClassLoader().getResource("images/austria/" + i + ".jpg");
            if (imageUrl != null) {
                austriaImagePaths.add("images/austria/" + i + ".jpg");
            } else {
                System.err.println("Image file not found: images/austria/" + i + ".jpg");
            }
        }

        activityRepository.save(new Activity(
                "Reis naar Oostenrijk",
                austriaImagePaths,
                "oostenrijk",
                "Studentenreis Oostenrijk"
        ));

        List<String> hackathonImagePaths = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            URL imageUrl = getClass().getClassLoader().getResource("images/hackathon/" + i + ".jpg");
            if (imageUrl != null) {
                hackathonImagePaths.add("images/hackathon/" + i + ".jpg");
            } else {
                System.err.println("Image file not found: images/hackathon/" + i + ".jpg");
            }
        }

        activityRepository.save(new Activity(
                "Hackathon",
                hackathonImagePaths,
                "hackathon",
                "Hack the Future hackathon"
        ));

        List<String> popImagePaths = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            URL imageUrl = getClass().getClassLoader().getResource("images/pop/" + i + ".jpg");
            if (imageUrl != null) {
                popImagePaths.add("images/pop/" + i + ".jpg");
            } else {
                System.err.println("Image file not found: images/pop/" + i + ".jpg");
            }
        }

        activityRepository.save(new Activity(
                "Pop Sessie 3TIN",
                popImagePaths,
                "pop",
                "POP-sessie My Team and I"
        ));

        List<String> innovatieImagePaths = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            URL imageUrl = getClass().getClassLoader().getResource("images/innovatie/" + i + ".jpg");
            if (imageUrl != null) {
                innovatieImagePaths.add("images/innovatie/" + i + ".jpg");
            } else {
                System.err.println("Image file not found: images/pop/" + i + ".jpg");
            }
        }

        activityRepository.save(new Activity(
                "Innovatieroute: Domain Driven Design",
                innovatieImagePaths,
                "innovatieroute",
                "Innovatieroute over Domain Driven Design met focus op samenwerking tussen business en IT"
        ));

        activityRepository.save(new Activity(
                "Harmony group: The rise of low code",
                null,
                "seminarie",
                "Seminarie over low code"
        ));

        activityRepository.save(new Activity(
                "VMWare: Full stack Development ",
                null,
                "seminarie",
                "Seminarie over Virtual Machines binnen ontwikkeling"
        ));

        activityRepository.save(new Activity(
                "Cegeka: Agile Testing",
                null,
                "seminarie",
                "Seminarie over Agile Testing waarbij teamleden een vooraf gedefinieerde testflow volgen"
        ));

        activityRepository.save(new Activity(
                "Tobania: API Testing",
                null,
                "seminarie",
                "Seminarie met uitleg en hands-on oefening in API-testing via Postman"
        ));

        activityRepository.save(new Activity(
                "IT Licious: Flutter",
                null,
                "seminarie",
                "Presentatie over Flutter met interactieve opdracht en quiz"
        ));

        activityRepository.save(new Activity(
                "Infosupport: Reactive Programming",
                null,
                "seminarie",
                "Seminarie over reactief programmeren en het reageren op data en events"
        ));

        activityRepository.save(new Activity(
                "Jidoka: Svelte",
                null,
                "seminarie",
                "Introductie tot het front-end framework Svelte met een kleine hands-on opdracht"
        ));

        activityRepository.save(new Activity(
                "Cegeka: Dark launches and gradual release",
                null,
                "seminarie",
                "Seminarie over release strategieën via feature flags en stapsgewijze uitrol"
        ));

        activityRepository.save(new Activity(
                "CA group: From Hello World to Hello Work",
                null,
                "seminarie",
                "Seminarie over het bouwen van applicaties vanaf nul"
        ));

        activityRepository.save(new Activity(
                "Politie: Digital forensics",
                null,
                "seminarie",
                "Seminarie over digitale forensiek en methodes bij cybercriminaliteit"
        ));

        activityRepository.save(new Activity(
                "ITLicious: Flutter",
                null,
                "seminarie",
                "Seminarie over Flutter met uitleg, hands-on opdracht en quiz"
        ));

        activityRepository.save(new Activity(
                "Cegeka: Enterprise Architecture",
                null,
                "seminarie",
                "Informatieve seminarie over strategieën, processen en structuren binnen business architectuur"
        ));

        activityRepository.save(new Activity(
                "ACA: Behavior Driven Development",
                null,
                "seminarie",
                "Seminarie over BDD met focus op gedragsanalyse en implementatie via Cucumber"
        ));

        activityRepository.save(new Activity(
                "The value hub: How to facilitate a workshop",
                null,
                "seminarie",
                "Seminarie over het faciliteren van effectieve workshops voor kennisdeling"
        ));

        activityRepository.save(new Activity(
                "POP-sessie: POPping",
                null,
                "pop",
                "POP-sessie over stress, persoonlijke ontwikkeling en feedback"
        ));

        activityRepository.save(new Activity(
                "POP-sessie: Brein aan het werk",
                null,
                "pop",
                "POP-sessie over afleiding, focus en studeertechnieken"
        ));

    }
}