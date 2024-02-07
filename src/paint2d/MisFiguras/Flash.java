/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint2d.MisFiguras;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
    import java.io.Serializable;
/**
 *
 * @author pollu
 */
public class Flash  implements Shape,Serializable{
    GeneralPath path;

    public Flash(float x, float y, float w, float h) {
        path = new GeneralPath();
        float x0 = x ;
        float y0 = y ;
        float x1 = x + 2f * w;
        float y1 = y + 0f * h;
        float x2 = x + -1f * w;
        float y2 = y + 0.5f * h;
        float x3 = x + 0.5f * w;
        float y3 = y + 0.5f * h;
        float x4 = x + -1f * w;
        float y4 = y + 1f * h;
        float x5 = x + 2f * w;
        float y5 = y + 0.4f * h;
        float x6 = x + 0.5f * w;
        float y6 = y + 0.4f * h;
        
        
        //path.moveTo(x0, y0);
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        //path.moveTo(x3, y3);
        path.lineTo(x4, y4);
        //path.moveTo(x4, y4);
        path.lineTo(x5, y5);
        //path.moveTo(x5, y5);
        path.lineTo(x6, y6);
        //path.moveTo(x6, y6);
        path.lineTo(x1, y1);
        //path.moveTo(x0, y0);
        
    }

    @Override
    public boolean contains(Rectangle2D rect) {
        return path.contains(rect);
    }

    @Override
    public boolean contains(Point2D point) {
        return path.contains(point);
    }

    @Override
    public boolean contains(double x, double y) {
        return path.contains(x, y);
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return path.contains(x, y, w, h);
    }

    @Override
    public Rectangle getBounds() {
        return path.getBounds();
    }

    @Override
    public Rectangle2D getBounds2D() {
        return path.getBounds2D();
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return path.getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return path.getPathIterator(at, flatness);
    }

    @Override
    public boolean intersects(Rectangle2D rect) {
        return path.intersects(rect);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return path.intersects(x, y, w, h);
    }

}
