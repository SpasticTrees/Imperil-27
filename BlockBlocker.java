
/**
 * This is the construtor for the blocks.
 * 
 * The blocks can be an active object, but the active parts are 
 * currently commented out for reasons.
 * 
 * It contains the setColor, and move / moveTo methods.
 * 
 */

import objectdraw.*;
import java.awt.*;

public class BlockBlocker{
    
    public FilledRect mainBody;
    public FramedTriangle leftSide;
    public FramedTriangle rightSide;
    
    //------
    
    public double globalX;
    public double globalY;
    
    public static double leftEndpoint;
    public static double rightEndpoint;
    
    public double widthGlobal;
    
    public DrawingCanvas canvasGlobal;

    
    /**
     * This is the constructor.
     */
    
    public BlockBlocker(double x, double y, double width,
                        double height, DrawingCanvas canvas){
        
        globalX = x;
        globalY = y;
        
        leftEndpoint = x - width;
        rightEndpoint = x + width;
        
        widthGlobal = width;
        
        canvasGlobal = canvas;
        
        //////////////////////////////////////////////////////
                            
        mainBody = new FilledRect( (x - (width/2) ),
                              y, width, height, canvas);
                              
        leftSide = new FramedTriangle( (x - width), y, 
                                  (x - (width/2) ), y, 
                                  (x - (width/2) ), (y + height),
                                  canvas);
        
        rightSide = new FramedTriangle( (x + width), y,
                                   (x + (width/2) ), y,
                                   (x + (width/2) ), 
                                   (y + height), canvas);
                                   
    }
    
    /**
     * This changes the color of the object.
     */
    
    public void setColor(Color newColor){
        
        mainBody.setColor(newColor);
        leftSide.setColor(newColor);
        rightSide.setColor(newColor);
        
    }
    
    /**
     * This hides the object.
     */
    
    public void hide(){
        
        mainBody.hide();
        leftSide.hide();
        rightSide.hide();
        
    }
    
    /**
     * This removes the object from the canvas.
     */
    
    public void removeFromCanvas(){
        
        mainBody.removeFromCanvas();
        leftSide.removeFromCanvas();
        rightSide.removeFromCanvas();
        
    }
    
    /**
     * This adds the object to the canvas.
     */
    
    public void addToCanvas(DrawingCanvas canvas){
        
        mainBody.addToCanvas(canvas);
        leftSide.addToCanvas(canvas);
        rightSide.addToCanvas(canvas);
        
    }
    
    /**
     * This shows the object.
     */
    
    public void show(){
        
        mainBody.show();
        leftSide.show();
        rightSide.show();
        
    }
    
    /**
     * This moves the object a specific distance.
     */
    
    public void move(double dx, double dy){
        
        mainBody.move(dx, dy);
        leftSide.move(dx, dy);
        rightSide.move(dx, dy);
        
    }
    
    /**
     * This moves the object to a specific spot.
     */
    
    public void moveTo(double dx, double dy){
        
        mainBody.moveTo(dx, dy);
        leftSide.moveTo(dx, dy);
        rightSide.moveTo(dx, dy);
        
    }
    
    /**
     * This returns the Block's left endpoint.
     */
    
    public static double getLeftX(BlockBlocker aBlock){
        
        return leftEndpoint;
        
    }
    
    /**
     * This returns the Block's right endpoint.
     */
    
    public static double getRightX(BlockBlocker aBlock){
        
        return rightEndpoint;
        
    }
    
    /**
     * This method checks whether or not the block overlaps
     * with another object. It returns either true or false.
     */
    
    public boolean overlapsBlock(Drawable2DInterface item){
        
        if(mainBody.overlaps(item) ){
            
            return true;
            
        }
        
        return false;
        
    }
    
}
