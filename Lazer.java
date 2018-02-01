 
/**
 * This is the constructor for the lazer object.
 * 
 * It contains the move, setColor, hide / removeFromCanvas,
 * and overlaps (block and cloud) methods.
 * 
 */

import objectdraw.*;
import java.awt.*;

import java.awt.event.*;

public class Lazer extends ActiveObject{
    
    //private Line body;
    
    private FilledArc body;
    
    //------
    
    private static final int START_ANGLE = 90;
    private static final int COMPLETE_TURN = 360;
    
    
    // Constructor globals
    
    public double xGlobal;
    public double yGlobal;
    
    private DrawingCanvas canvasGlobal;
    
    
    // Run Amounts
    
    public static final int DROP_AMOUNT = (-10);
    public static final int PAUSE_AMOUNT = 100;
    
    
    // isHidden booleans
    
    public static boolean mCloAHidden;
    public static boolean mCloBHidden;
    public static boolean mCloCHidden;
    
    public static boolean bCloAHidden;
    public static boolean bCloBHidden;
    
    //----
    
    public static boolean allCloudsHidden;
    
    /**
     * This is the constructor.
     */
    
    public Lazer(double x, double y, double width, double height, 
                 DrawingCanvas canvas){
        
        //body = new Line(x, y, x, (y + height), canvas);
        body = new FilledArc(x, y, width, 
                             height,
                             START_ANGLE, COMPLETE_TURN, canvas);
        
        //////////////////////////////////////////////////////
        
        xGlobal = x;
        yGlobal = y;
        canvasGlobal = canvas;
        
        //////////////////////////////////////////////////////
        
        start();
        
    }
    
    /**
     * This moves the object a specific amount.
     */
    
    public void move(double dx, double dy){
        
        body.move(dx, dy);
        
    }
    
    /**
     * This tells the object what to do when it moves.
     * -----------------------------------------------
     * The lazer shoots up from the bottom of the canvas
     * and is removed from the canvas when it reaches the 
     * top.
     * 
     * If the lazer touches the clouds, then the clouds are
     * removed from the canvas.
     * 
     * If the lazer touches the blocks, then the lazers are
     * removed from the canvas.
     */
    
    public void run(){
        
        while (yGlobal < canvasGlobal.getHeight() && 
               GameWindow.thePlayer.getCanvas() != null){
            
            this.move(0, DROP_AMOUNT);
            
            pause(PAUSE_AMOUNT);
            
            //--------------------------------
            
            yGlobal = (yGlobal + DROP_AMOUNT);
            
            if (GameWindow.middleCloA.overlapsCloud(body) ){
            
                GameWindow.middleCloA.hide();
                 
                mCloAHidden = true;
                
                this.removeFromCanvas();
            
            }
            else if (GameWindow.middleCloB.overlapsCloud(body) ){
            
                GameWindow.middleCloB.hide();
                
                mCloBHidden = true;
                
                this.removeFromCanvas();
            
            }
            else if (GameWindow.middleCloC.overlapsCloud(body) ){
            
                GameWindow.middleCloC.hide();
                
                mCloCHidden = true;
                
                this.removeFromCanvas();
            
            }
            else if (GameWindow.bottomCloA.overlapsCloud(body) ){
            
                GameWindow.bottomCloA.hide();
                
                bCloAHidden = true;
                
                this.removeFromCanvas();
            
            }
            else if (GameWindow.bottomCloB.overlapsCloud(body) ){
            
                GameWindow.bottomCloB.hide();
                
                bCloBHidden = true;
                
                this.removeFromCanvas();
            
            }
            
            if (mCloAHidden == true && 
                mCloBHidden == true &&
                mCloCHidden == true &&
                 
                bCloAHidden == true && 
                bCloBHidden == true ){
                
                allCloudsHidden = true;
                    
                GameWindow.playerWon();
                GameWindow.gameEnd();
                
            }
            
            if (BlockUnitCreator.defenderBlockA.overlapsBlock(body) 
                || 
                BlockUnitCreator.defenderBlockB.overlapsBlock(body) 
                ||
                BlockUnitCreator.defenderBlockC.overlapsBlock(body) ){
                 
                 this.removeFromCanvas();
                 
            }
            
            if (yGlobal == 0){
                
                this.removeFromCanvas();
                
            }
            
        }
        
    }
    
    /**
     * This changes the color of the object.
     */
    
    public void setColor(Color newColor){
        
        body.setColor(newColor);
        
    }
   
    /**
     * This hides the object.
     */
    
    public void hide(){
        
        body.hide();
        
    }
    
    /**
     * This removes the object from the canvas. The if statement
     * checks if there is / isn't a Lazer on the canvas.
     * This is needed to prevent errors.
     */
    
    public void removeFromCanvas(){
        
        if(body.getCanvas() != null){
            
            body.removeFromCanvas();
            
        }
        
    }

}
