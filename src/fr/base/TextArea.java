package fr.base;

import fr.AbstractComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 此类基负责textRow的储存，关于文字的属性，如颜色、字体等，实际由内部的row储存
 */
public class TextArea extends AbstractComponent {

    private final int height;

    private final List<TextRow> rows;


    public TextArea(int width, String text, Font font) {
        super(width);

        // if text area is too small to put a char
        if (font.getSize() > width)
            throw new IllegalArgumentException("Font size is too big");

        List<Token> tokens = Token.StringToTokenList(text);

        rows = new ArrayList<>();
        TextRow row = new TextRow(this.width, font);
        for (Token t : tokens) {
            if (!row.append(t)) {
                rows.add(row);
                row = new TextRow(this.width, font);
                row.append(t);
            }
        }
        rows.add(row);

        this.height = rows.size() * rows.get(0).getHeight();
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void draw(Graphics2D g, ComponentPosition relativeOriginal) {
        drawBackground(g, relativeOriginal);

        int x = relativeOriginal.x;
        int y = relativeOriginal.y;
        for (TextRow tr : rows) {
            tr.draw(g, new ComponentPosition(x, y));
            y += tr.getHeight();
        }
    }

    public void setFontColor(Color color) {
        for (TextRow tr : rows) {
            tr.setFontColor(color);
        }
    }

}
