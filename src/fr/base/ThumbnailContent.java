package fr.base;


/**
 * 封装缩略图(Thumbnail)的内容，一张图片，2段文字.
 */
public class ThumbnailContent {
    public final String imageBase64;
    public final String name;
    public final String price;
    public final String description;

    public ThumbnailContent(String imageBase64, String name, String price, String description) {
        this.imageBase64 = imageBase64;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ThumbnailContent{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
