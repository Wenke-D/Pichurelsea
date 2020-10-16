package fr.base;

import fr.AbstractComponent;

import java.awt.*;

import fr.base.TextArea;


/**
 * 这个类代表用于展示物品的缩略图，由一张图片和两个文本区域组成
 * 其中第一个文本区域固定为一行，第二个文本区域可以填充多行文字
 * <p>
 * 缩略图的宽度、文本区域的宽度与传入图像的宽度一致，高度根据内容自动增加，
 */
public class Thumbnail extends AbstractComponent {

    private final ImageContainer imageContainer;
    private final TextRow textRow;
    private final TextArea textArea;

    private final int height;

    private final ComponentPosition textRowLocation;
    private final ComponentPosition textAreaLocation;

    private static final int IMAGE_TEXT_GAP = 50;
    private static final int TEXT_TEXT_GAP = 20;


    Thumbnail(Image image, String text1, String text2, Font font) {
        super(image.getWidth(null));

        imageContainer = new ImageContainer(image);


        textRow = new TextRow(text1, width, font);

        textArea = new TextArea(width, text2, font);

        int x = 0, y = imageContainer.getHeight() + IMAGE_TEXT_GAP;
        textRowLocation = new ComponentPosition(x, y);

        y += textRow.getHeight() + TEXT_TEXT_GAP;
        textAreaLocation = new ComponentPosition(x, y);


        this.height = y + textArea.getHeight();
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void draw(Graphics2D g, ComponentPosition relativeOriginal) {
        drawBackground(g, relativeOriginal);

        imageContainer.draw(g, relativeOriginal);

        textRow.draw(g, relativeOriginal.merge(textRowLocation));

        textArea.draw(g, relativeOriginal.merge(textAreaLocation));
    }


    public void setFontColor(Color color) {
        this.textRow.setFontColor(color);
        this.textArea.setFontColor(color);
    }

}
