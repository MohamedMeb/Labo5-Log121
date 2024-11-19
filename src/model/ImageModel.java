package model;

public class ImageModel extends Subject{
    private String imagePath;

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
        notifyObservers();
    }

    public String getImagePath() {
        return imagePath;
    }
}
