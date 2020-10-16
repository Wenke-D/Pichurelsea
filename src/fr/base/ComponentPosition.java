package fr.base;

/**
 * 封装组件的位置信息
 */
public class ComponentPosition {
    public final int x;
    public final int y;


    public ComponentPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * merge 2 points, p1.merge(p2) => (p1.x + p2.x, p1.y + p2.y)
     * @param p another point
     * @return new point.
     */
    public ComponentPosition merge(ComponentPosition p){
        return new ComponentPosition(x + p.x, y + p.y);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
