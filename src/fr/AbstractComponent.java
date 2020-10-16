package fr;

import fr.base.ComponentPosition;

import java.awt.*;

public abstract class AbstractComponent implements Component {

    /**
     * width of this component
     */
    protected final int width;

    /**
     * Background is transparent by default
     */
    private Color backgroundColor = new Color(0, 0, 0, 0);

    public AbstractComponent(int width) {
        this.width = width;
    }


    /**
     * Fill background with color set in attribute{@code backgroundColor}
     *
     * @param g graphic context
     * @param p location
     */
    protected void drawBackground(Graphics2D g, ComponentPosition p) {

        // save original graphics context color and apply background color
        Color old_color = g.getColor();
        g.setColor(this.backgroundColor);

        // draw background
        g.fillRect(p.x, p.y, width, getHeight());

        // restore graphic context color
        g.setColor(old_color);
    }

    public int getWidth() {
        return width;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }



}
