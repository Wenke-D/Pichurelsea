package fr;

import fr.base.ComponentPosition;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface Component {

    /**
     * Return width of this component
     *
     * @return width of this component
     */
    int getWidth();

    /**
     * Return height of this component
     *
     * @return height of this component
     */
    int getHeight();

    /**
     * Draw this component in specific position by using a outer graphics2D context.
     * <p>
     * Attention some components will change attributes of graphic context, like font, color etc.
     * Because it will call function {@code draw()} of its inner component.
     *
     * @param g a graphics2D object
     * @param relativeOriginal left-top position of this component
     */
    void draw(Graphics2D g, ComponentPosition relativeOriginal);

    /**
     * Set background color of this component.
     *
     * @param color color
     */
    void setBackgroundColor(Color color);

    /**
     * Draw this component in a image and returned it.
     *
     * @return A Image of this component.
     */
    default BufferedImage createImage() {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        draw(g2d, new ComponentPosition(0, 0));
        return image;
    }


}
