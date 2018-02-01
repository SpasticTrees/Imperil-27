
/**
 * This is a filled circle constructor. 
 * It makes a filled circle.
 * 
 * It contains the setColor, move, overlaps, and removeFromCanvas 
 * / hide methods.
 * 
 */

import objectdraw.*;
import java.awt.*;

public class FilledCircle{
    
    public FilledOval circle;
    
    //----------------
    
    private double globalX;
    private double globalY;
    
    private double globalRadius;
    
    /**
     * This is the constructor.
     */
    
    public FilledCircle(double x, double y, double radius,
                          DrawingCanvas canvas){
        
        globalX = x;
        globalY = y;
        
        globalRadius = radius;                    
              
        //////////////////////////////////////////////////////
        
        circle = new FilledOval(x, y, (radius * 2), 
                               (radius * 2), canvas);
        
    }
    
    /**
     * This changes the color.
     */
    
    public void setColor(Color newColor){
        
        circle.setColor(newColor);
        
    }
    
    /**
     * This moves the circle a specific distance.
     */
    
    public void move(double dx, double dy){
        
        circle.move(dx, dy);
        
    }

    
    /**
     * This removes the circle from the canvas. The if statement
     * checks if there is / isn't a FilledCircle on the canvas.
     * This is needed to prevent errors.
     */
    
    public void removeFromCanvas(){
        
        if(circle.getCanvas() != null){
            
            circle.removeFromCanvas();
            
        }
        
    }
    
    /**
     * This hides the circle.
     */
    
    public void hide(){
        
        circle.hide();
        
    }
    
    /**
     * This returns the FilledOval from the FilledCircle.
     * This is needed to use the objectDraw library methods.
     * FilledCircle does not have access to them because
     * it is not part of objectDraw.
     */
    
    public FilledOval getDrawable2DInterface(){
        
        return circle;
        
    }
    
}
