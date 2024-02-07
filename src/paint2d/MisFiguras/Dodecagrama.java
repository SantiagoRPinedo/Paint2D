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

public class Dodecagrama implements Serializable{
    
    public Dodecagrama(){
    }
    
    public Shape crear(int x, int y, int w, int h, int lados) {
        int puntas = lados;
        puntas = 12;
//Distancia de la punta hasta centro del poligono
        double radioExterior = w;
//Distancia del valle interior hasta el centro
        double radioInterior = h;
//Coordenadas en el frame para del centro del poligono
        int xCentro = x / 2, yCentro = y / 2;
//Inclinacion inicial si no queremos que la punta este en angulo 0
        double inclinacionPrimeraPunta = Math.PI;//Punta hacia arriba
        Polygon poligono = new Polygon();

//Calculamos los puntos por trigonometria
        double anguloEntreVertices = Math.PI / puntas;
        for (int i = 0; i < puntas * 2; i++) {
            //Vamos alternando entre los radios de punta y valle
            double r = (i % 2 == 0) ? radioExterior : radioInterior;
            double a = i * anguloEntreVertices + inclinacionPrimeraPunta;
            //Añadimos el nuevo punto al poligono
            poligono.addPoint(
                    //Coordenada X
                    (int) (r * Math.sin(a) + xCentro),
                    //Coordenada Y
                    (int) (r * Math.cos(a) + yCentro));
        }

        return poligono;
    }

    
}