package fr.base;

import fr.AbstractComponent;
import sun.font.FontDesignMetrics;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a row of token with the width fix,
 * token can be added by calling {@code addToken()}.
 *
 * @see #append(Token)
 */
public class TextRow extends AbstractComponent {
    private final ArrayList<Token> tokens;

    private final int height;
    private final Font font;

    private int currentWidth;

    private Color fontColor = Color.BLACK;



    /**
     * Create a token row empty with specific width and font.
     */
    public TextRow(int width, Font font) {
        super(width);


        this.tokens = new ArrayList<>();
        this.height = FontDesignMetrics.getMetrics(font).getHeight();
        this.font = font;
        currentWidth = 0;

    }

    /**
     * Create a row of token with specific width and font, then
     * add text into it by converting text to token, There is no guarantee that all text will be added because of
     * the width of row is fix, extra text will be delete
     *
     * @param text  text to be added
     * @param width width
     * @param font  font
     */
    public TextRow(String text, int width, Font font) {
        this(width, font);

        List<Token> tokens = Token.StringToTokenList(text);
        for (Token t : tokens) {
            if (!append(t)) {
                break;
            }
        }

    }

    @Override
    public int getHeight() {
        return height;
    }


    @Override
    public void draw(Graphics2D g, ComponentPosition relativeOriginal) {
        drawBackground(g, relativeOriginal);

        g.setFont(font);
        g.setColor(fontColor);

        int x = relativeOriginal.x;
        int y = relativeOriginal.y;

        for (Token t : tokens) {
            t.draw(g, new ComponentPosition(x, y));
            x += t.getWidth(FontDesignMetrics.getMetrics(font));
        }
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * Add token to this row, if the row is already full, return false
     *
     * @param t token to add
     * @return true if this action success, false if not.
     */
    public boolean append(Token t) {
        if (currentWidth + t.getWidth(FontDesignMetrics.getMetrics(font)) > width) {
            return false;
        }

        tokens.add(t);
        currentWidth += t.getWidth(FontDesignMetrics.getMetrics(font));

        return true;
    }

}
