package view;

import model.ImageModel;

import javax.swing.*;

public class ThumbnailView extends JPanel implements Observer {
    private ImageModel thumbnailModel;

    public ThumbnailView(ImageModel model) {
        this.thumbnailModel = model;
        model.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Thumbnail updated: " + thumbnailModel.getImagePath());
    }
}
