/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint2d.MisFiguras;

/**
 *
 * @author pollu
 */
import java.awt.Polygon;
import java.awt.Shape;
import java.io.Serializable;

public class DobleT implements Serializable{
    public DobleT(){
    }
  public Shape dibujar(int x,int y,int w,int h, int lados) {


   int xCenter = x;
    int yCenter = y;
    int radius = (int)(Math.min(w, h) * 0.5);

    
    Polygon polygon = new Polygon();

    //g.setColor(Color.RED);
    polygon.addPoint(xCenter - radius/5, yCenter - radius/5);
    polygon.addPoint((int)(xCenter *
      Math.cos(Math.PI / lados)), (int)(yCenter - xCenter *
      Math.sin( Math.PI / lados)));
      for (int i = 2; i <= lados; i++) {
           polygon.addPoint((int)(xCenter - yCenter *
           Math.cos(i * Math.PI / lados)), (int)(yCenter *
           Math.sin(i  * Math.PI / lados)));
      }
      return polygon;
  }   
}
