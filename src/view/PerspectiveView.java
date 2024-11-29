package view;

import model.ImageModel;

import javax.swing.*;

public class PerspectiveView extends JPanel implements Observer{
    private ImageModel perspectiveModel;

    public PerspectiveView(ImageModel perspectiveModel) {
        this.perspectiveModel = perspectiveModel;
        perspectiveModel.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Perspective updated: " + perspectiveModel.getImagePath());

    }
}
