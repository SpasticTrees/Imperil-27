 
/**
 * This is the class for the cloud constructor.
 * 
 * It contains the setColor, move, hide / removeFromCanvas,
 * and isHidden methods.
 */

import objectdraw.*;
import java.awt.*;

public class Cloud{

    private FilledOval topCirc;
    private FilledOval bottomCirc;
    private FilledOval leftCirc;
    private FilledOval rightCirc;
    
    //------
    
    public double globalX;
    public double globalY;
    
    public double widthGlobal;
    
    public DrawingCanvas canvasGlobal;
    
    public double leftEndpoint;
    public double rightEndpoint;
    
    /**
     * This is the constructor.
     */
    
    public Cloud(double x, double y, double width, double height,
                 DrawingCanvas canvas){
        
        globalX = x;
        globalY = y;
        
        leftEndpoint = x - (width/3 - width/4);
        rightEndpoint = x + (width/3 + width);
         
        widthGlobal = width;
        
        canvasGlobal = canvas;
        
        //////////////////////////////////////////////////////
        
        leftCirc = new FilledOval(x - (width/3 - width/4), 
              (y + height), width, height, canvas); 
        
        rightCirc = new FilledOval(x + (width/3 + width/2), 
                (y + height), width, height, canvas); 
        
        bottomCirc = new FilledOval(x + width/3, (y + height), 
                     width, height, canvas);      
        
        topCirc = new FilledOval(x + width/3, (y + height/2), 
                  width, height, canvas);        
                  
    }
    
    /**
     * This changes the color of the object.
     */
    
    public void setColor(Color newColor){
        
        topCirc.setColor(newColor);
        bottomCirc.setColor(newColor);
        leftCirc.setColor(newColor);
        rightCirc.setColor(newColor);
        
    }
    
    /**
     * This moves the object a specific amount.
     */
    
    public void move(double dx, double dy){
        
        topCirc.move(dx, dy);
        bottomCirc.move(dx, dy);
        leftCirc.move(dx, dy);
        rightCirc.move(dx, dy);

    }
    
    /**
     * This hides the object.
     */
    
    public void hide(){
        
        topCirc.hide();
        bottomCirc.hide();
        leftCirc.hide();
        rightCirc.hide();
        
    }
    
    /**
     * This shows the object.
     */
    
    public void show(){
        
        topCirc.show();
        bottomCirc.show();
        leftCirc.show();
        rightCirc.show();
        
    }
    
    /**
     * This returns a boolean to tell if the object is 
     * hidden or not. If it is, it returns true. If not,
     * false.
     */
    
    public boolean isHidden(){
        
        if (topCirc.isHidden() == true &&
            bottomCirc.isHidden() == true &&
            leftCirc.isHidden() == true &&
            rightCirc.isHidden() == true){
            
            return true;
            
        }
        
        else{
            
            return false;
            
        }
        
    }
    
    /**
     * This removes the object from the canvas.
     */
    
    public void removeFromCanvas(){
        
        topCirc.removeFromCanvas();
        bottomCirc.removeFromCanvas();
        leftCirc.removeFromCanvas();
        rightCirc.removeFromCanvas();
        
    }
    
    /**
     * This removes the object from the canvas.
     */
    
    public void addToCanvas(DrawingCanvas canvas){
        
        topCirc.addToCanvas(canvas);
        bottomCirc.addToCanvas(canvas);
        leftCirc.addToCanvas(canvas);
        rightCirc.addToCanvas(canvas);
        
    }
    
    /**
     * This method checks whether or not the cloud overlaps
     * with another object. It returns either true or false.
     */
    
    public boolean overlapsCloud(Drawable2DInterface item){
        
        if(topCirc.overlaps(item) || bottomCirc.overlaps(item) 
           || leftCirc.overlaps(item) || 
              rightCirc.overlaps(item) ){
            
            return true;
            
        }
        
        return false;
        
    }
    
}