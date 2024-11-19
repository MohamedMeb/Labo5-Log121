package controller;

import model.ImageModel;

public class ImageController {
    private ImageModel model;

    public ImageController(ImageModel model) {
        this.model = model;
    }

    public void setModel(ImageModel model) {
        this.model = model;
    }
}
