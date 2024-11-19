package view;

import model.ImageModel;

public class ThumbnailView implements Observer{
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
