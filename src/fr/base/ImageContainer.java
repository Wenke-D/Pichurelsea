package fr.base;

import java.awt.*;

import fr.AbstractComponent;

public class ImageContainer extends AbstractComponent {
    private final Image image;


    public ImageContainer(Image image){
        super(image.getWidth(null));
        this.image = image;

    }

    @Override
    public int getHeight() {
        return image.getHeight(null);
    }

    @Override
    public void draw(Graphics2D g, ComponentPosition relativeOriginal) {
        g.drawImage(image, relativeOriginal.x, relativeOriginal.y,null);
    }
}
