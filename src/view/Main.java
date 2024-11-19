package view;

import controller.ImageController;
import model.ImageModel;
import view.ThumbnailView;
import view.PerspectiveView;
import view.DetailView;

public class Main {
    public static void main(String[] args) {

        ImageModel model = new ImageModel();
        ThumbnailView thumbnailView = new ThumbnailView(model);
        PerspectiveView perspectiveView = new PerspectiveView(model);
        DetailView detailView = new DetailView();



        System.out.println("Hello world!");
    }
}