package fr.base;

import java.awt.*;
import java.util.ArrayList;

/**
 * 代表不可分割的最小文本单元，如一个汉字字符，或一个单词
 *
 * 请注意，当font的size小于12，调用createImage生成图片时，
 * 会出现字符渲染不完整的情况，原因咱不明
 */
public class Token{

    private final String token;


    public Token(String str) {
        this.token = str;
    }

    public int getWidth(FontMetrics fontMetrics) {
        return fontMetrics.stringWidth(token);
    }

    public int getHeight(FontMetrics fontMetrics) {
        return fontMetrics.getHeight();
    }

    public void draw(Graphics2D g, ComponentPosition p) {
        FontMetrics metrics = g.getFontMetrics();
        g.drawString(token, p.x, p.y + metrics.getMaxAscent());
    }

    @Override
    public String toString() {
        return "Token{" + token + '}';
    }


    /**
     * Convert a string to a list of token
     *
     * @param str String to convert
     * @return list of token
     */
    public static ArrayList<Token> StringToTokenList(String str) {

        ArrayList<Token> tokens = new ArrayList<>();
        int length = str.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char cur_ch = str.charAt(i);
            if (('a' <= cur_ch && cur_ch <= 'z') || ('A' <= cur_ch && cur_ch <= 'Z')) {
                sb.append(cur_ch);
            } else {
                if (sb.length() != 0) {
                    tokens.add(new Token(sb.toString()));

                    sb = new StringBuilder();
                }
                tokens.add(new Token(String.valueOf(cur_ch)));
            }
        }
        if (sb.length() != 0) {
            tokens.add(new Token(sb.toString()));
        }

        return tokens;
    }
}
