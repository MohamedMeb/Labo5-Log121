package view;

import controller.ImageController;
import model.ImageModel;
import view.ThumbnailView;
import view.PerspectiveView;
import view.DetailView;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        ImageModel model = new ImageModel();
        ThumbnailView thumbnailView = new ThumbnailView(model);
        PerspectiveView perspectiveView = new PerspectiveView(model);
        DetailView detailView = new DetailView();

        JFrame frame = new JFrame("Laboratoire 5: Application images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(1000, 600);


        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton selectImageButton = new JButton("Sélectionner Image");
        JButton saveConfigButton = new JButton("Sauvegarder Configuration");
        JButton loadConfigButton = new JButton("Charger Configuration");

        topPanel.add(selectImageButton);
        topPanel.add(saveConfigButton);
        topPanel.add(loadConfigButton);

        JPanel leftPanel = createUnmodifiableColumn(thumbnailView); // Section non modifiable
        JPanel centerPanel = createColumn(perspectiveView, "Undo", "Redo", "Réinitialiser", true); // Section modifiable
        JPanel rightPanel = createColumn(detailView, "Undo", "Redo", "Réinitialiser", true); // Section modifiable

        JPanel mainPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        mainPanel.add(leftPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(rightPanel);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);


        frame.setVisible(true);
    }

    private static JPanel createUnmodifiableColumn(JPanel view) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Ajouter seulement la vue
        panel.add(view, BorderLayout.CENTER);

        // Ajouter une bordure pour délimiter la section
        panel.setBorder(BorderFactory.createTitledBorder("Vue Non Modifiable"));

        return panel;
    }

    public static JPanel createColumn(JPanel view, String undoText, String redoText, String resetText, boolean enableButtons) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Panneau supérieur pour les boutons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));

        if (!undoText.isEmpty() && !redoText.isEmpty() && !resetText.isEmpty()) {
            JButton undoButton = new JButton(undoText);
            undoButton.setEnabled(enableButtons);

            JButton redoButton = new JButton(redoText);
            redoButton.setEnabled(enableButtons);

            JButton resetButton = new JButton(resetText);
            resetButton.setEnabled(enableButtons);

            buttonPanel.add(undoButton);
            buttonPanel.add(redoButton);
            buttonPanel.add(resetButton);
        }

        // Ajouter les boutons en haut et la vue au centre
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(view, BorderLayout.CENTER);

        // Ajouter une bordure pour délimiter les sections
        panel.setBorder(BorderFactory.createTitledBorder("Section"));

        return panel;
    }
}