
/**
 * This class is the constructor for a framed triangle and its
 * methods.
 * 
 * It has setColor, move / moveTo, overlaps, removeFromCanvas / 
 * hide.
 * 
 */

import objectdraw.*;
import java.awt.*;

public class FramedTriangle{
    
    public Line side1, side2, side3;
    
    public DrawingCanvas canvasGlobal;
    
    /**
     * This is the constructor.
     */
    
    public FramedTriangle(double x1, double y1, double x2, 
                          double y2, double x3, double y3,
                          DrawingCanvas canvas){
        
        canvasGlobal = canvas;
                              
        ///////////////////////////////////////////
                              
        side1 = new Line(x1, y1, x2, y2, canvas);
        side2 = new Line(x2, y2, x3, y3, canvas);
        side3 = new Line(x3, y3, x1, y1, canvas);
        
    }
    
    /**
     * This changes the color of the lines.
     */
    
    public void setColor(Color newColor){
        
        side1.setColor(newColor);
        side2.setColor(newColor);
        side3.setColor(newColor);
        
    }
    
    /**
     * This moves the triangle a specific distance.
     */
    
    public void move(double dx, double dy){
        
        side1.move(dx, dy);
        side2.move(dx, dy);
        side3.move(dx, dy);
        
    }
    
    /**
     * This moves the triangle to a specific spot.
     */
    
    public void moveTo(double dx, double dy){
        
        side1.moveTo(dx, dy);
        side2.moveTo(dx, dy);
        side3.moveTo(dx, dy);
        
    }
    
    /**
     * This checks whether the triangle overlaps with a point.
     */
    
    public boolean overlaps(Location point){
       
        if (side1.contains(point) && side2.contains(point) 
            && side3.contains(point) ){
            
            return true;
            
        }
        else{
            
            return false;
            
        }
        
    }
    
    /**
     * This removes the triangle from the canvas. The if statement
     * checks if there is / isn't a FramedTriangle on the canvas.
     * This is needed to prevent errors.
     */
    
    public void removeFromCanvas(){
        
        if(side1.getCanvas() != null){
            
            side1.removeFromCanvas();
            side2.removeFromCanvas();
            side3.removeFromCanvas();
            
        }
        
    }
    
    /**
     * This adds the triangle to the canvas.
     */
    
    public void addToCanvas(DrawingCanvas canvas){
        
        side1.addToCanvas(canvas);
        side2.addToCanvas(canvas);
        side3.addToCanvas(canvas);
        
    }
    
    /**
     * This hides the triangle.
     */
    
    public void hide(){
        
        side1.hide();
        side2.hide();
        side3.hide();
        
    }
    
    /**
     * This shows the triangle.
     */
    
    public void show(){
        
        side1.show();
        side2.show();
        side3.show();
        
    }
    
}
