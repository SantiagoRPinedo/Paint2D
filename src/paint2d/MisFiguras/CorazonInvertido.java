/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint2d.MisFiguras;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 */
public class CorazonInvertido implements Shape,Serializable{
      GeneralPath path;
 
  public CorazonInvertido(float x, float y, float w, float h) {
    path = new GeneralPath();
    float x0 = x + 0.5f*h;
    float y0 = y + 0.3f*w;
    float x1 = x + 0.1f*h;
    float y1 = y + 0f * w;
    float x2 = x + 0f * h;
    float y2 = y + 0.6f * w;
    float x3 = x + 0.5f * h;
    float y3 = y + 0.9f * w;
    float x4 = x + 1f * h;
    float y4 = y + 0.6f * w;
    float x5 = x + 0.9f * h;
    float y5 = y + 0f * w;
    path.moveTo(x0, y0);
    path.curveTo(x3, y3, x2, y2, x1, y1);
    path.curveTo(x4, y5, x5, y4, x0, y0);
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