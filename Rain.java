
/**
 * This is the constructor for the raindrops.
 * 
 * It contains the move, hide / removeFromCanvas, setColor,
 * and overlaps methods.
 * 
 */

import objectdraw.*;
import java.awt.*;

public class Rain extends ActiveObject{
    
    public FramedTriangle top;
    public FilledCircle bottom;
    
    
    // Constructor globals
    
    private double xGlobal;
    private double yGlobal;
    
    private DrawingCanvas canvasGlobal;
    
    // Misc.
    
    public static final int DROP_AMOUNT = 10;
    public static final int PAUSE_AMOUNT = 100;
    
    /**
     * This is the rain object.
     */
    
    public Rain(double x, double y, double width, double height, 
                DrawingCanvas canvas){
        
        bottom = new FilledCircle( (x - width),
                                 (y + (height/2) ),
                                  width, canvas);
    
        top = new FramedTriangle(x, y, 
                             (x - width), (y + height),
                             (x + width), (y + height), canvas);  
        
        //////////////////////////////////////////////////////
        
        xGlobal = x;
        yGlobal = y;
        canvasGlobal = canvas;
        
        //////////////////////////////////////////////////////
        
        start();
                             
    }
    
    /**
     * This moves the raindrops a specific distance.
     */
    
    private void move(double dx, double dy){
        
        top.move(dx, dy);
        bottom.move(dx, dy);
        
    }
    
    /**
     * This hides the object.
     */
    
    public void hide(){
        
        top.hide();
        bottom.hide();
        
    }
    
    /**
     * This removes the object from the canvas.
     */
    
    public void removeFromCanvas(){
        
        top.removeFromCanvas();
        bottom.removeFromCanvas();
        
    }
    
    /**
     * This tells the object what happens when it moves.
     * -----------------------------------------------------
     * The raindrops will fall down the screen until 
     * they reach the bottom, then they will be removed from 
     * the canvas.
     */
    
    public void run(){
        
        while (yGlobal < canvasGlobal.getHeight() &&
               GameWindow.gameStart == true){
            
            this.move(0, DROP_AMOUNT);
            
            pause(PAUSE_AMOUNT);
            
            //--------------------------------
            
            yGlobal = (yGlobal + DROP_AMOUNT);
            
            if (yGlobal > canvasGlobal.getHeight() ){
                
                this.removeFromCanvas();
                
            }
            
            if (BlockUnitCreator.defenderBlockA.overlapsBlock(
                     bottom.getDrawable2DInterface() ) ){
                
                this.removeFromCanvas();
                
            }
            else if (BlockUnitCreator.defenderBlockB.overlapsBlock(
                     bottom.getDrawable2DInterface() ) ){
                
                this.removeFromCanvas();
                
            }
            else if (BlockUnitCreator.defenderBlockC.overlapsBlock(
                     bottom.getDrawable2DInterface() ) ){
                
                this.removeFromCanvas();
                
            }
            
            if (this.overlaps(GameWindow.thePlayer) ){
                
                if (GameWindow.thePlayer != null){
                     
                    GameWindow.thePlayer.removeFromCanvas();

                }
                
                GameWindow.playerHidden = true;
                
                GameWindow.playerLost();
                GameWindow.gameEnd();
                
            }
            
        }

    }
    
    /**
     * This changes the color of the object.
     */
    
    public void setColor(Color newColor){
        
        top.setColor(newColor);
        bottom.setColor(newColor);
        
    }
    
    public boolean overlaps(BlockBlocker aBlock){
        
        if (aBlock.leftEndpoint <= xGlobal &&       
            aBlock.rightEndpoint >= xGlobal){
            
            if (aBlock.globalY == yGlobal){
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    public boolean overlaps(Cannon aPlayer){
        
        if (aPlayer.overlapsCannon(bottom.getDrawable2DInterface() )){
              
             return true;
                
        }
        
        return false;
        
    }
    
}