
/**
 * This class uses the BlockBlocker Class.
 * 
 * It creates three blocks into a unit.
 * 
 * This is needed for synchronized movement.
 * Without a unit, the blocks would move independently
 * and that would not work for the needs of the program.
 * 
 * This unit is created for the purpose of making the 
 * back and forth movement of the blocks to work properly.
 * 
 */

import objectdraw.*;
import java.awt.*;

public class BlockUnitCreator extends ActiveObject{
    
    // Blocks
    
    public static BlockBlocker defenderBlockA, defenderBlockB, 
                         defenderBlockC;
    
    public static final int BLOCK_WIDTH = 50;
    public static final int blockHeight = 40;
    
    //------
    
    public static double DEFENDER_Y = GameWindow.CLOUDAREA_END + 
                              (GameWindow.BLOCKAREA_SIZE/2);
    
    public static final double DEFENDER_A_X = 
            GameWindow.CENTERFRAME_START + 125;
    public static final double DEFENDER_B_X = 
            GameWindow.CENTERFRAME_START +
           (GameWindow.CENTERFRAME_WIDTH/2);
    public static final double DEFENDER_C_X = 
            GameWindow.CENTERFRAME_START + 375;
    
    //------
    
    public static final int BLOCK_TOTALWIDTH = 300;
    
    public static int BLOCKS_STARTX = 275;
    public static int BLOCKS_ENDX = 575;
    
    public static double blockersLeft;
    public static double blockersRight;
    
    
    
    // Misc.
    
    public static final int MOVE_AMOUNT = (10);
    public static final int PAUSE_AMOUNT = (100);
    
    private DrawingCanvas canvasGlobal;
    
    
    /**
     * Constructor for objects of class BlockUnitCreator
     */
    
    public BlockUnitCreator(DrawingCanvas canvas){
        
        canvasGlobal = canvas;
        
        /////////////////////////////////////////////////////////
        
                            /** BLOCKS **/
        
        defenderBlockA = new BlockBlocker(DEFENDER_A_X, DEFENDER_Y, 
                         BLOCK_WIDTH, blockHeight, canvas);
                         
        defenderBlockB = new BlockBlocker(DEFENDER_B_X, DEFENDER_Y, 
                         BLOCK_WIDTH, blockHeight, canvas);
        
        defenderBlockC = new BlockBlocker(DEFENDER_C_X, DEFENDER_Y, 
                         BLOCK_WIDTH, blockHeight, canvas);
                   
        defenderBlockA.setColor(ColorPalette.sideBlockColor);
        defenderBlockB.setColor(ColorPalette.sideBlockColor);
        defenderBlockC.setColor(ColorPalette.sideBlockColor);
        
        //////////////////////////////////////////////////////
        
        start();
        
    }
    
    /**
     * This hides the object.
     */
    
    public void hide(){
        
        defenderBlockA.hide();
        defenderBlockB.hide();
        defenderBlockC.hide();
        
    }
    
    /**
     * This removes the object from the canvas.
     */
    
    public void removeFromCanvas(){
        
        defenderBlockA.removeFromCanvas();
        defenderBlockB.removeFromCanvas();
        defenderBlockC.removeFromCanvas();
        
    }
    
    /**
     * This shows the object.
     */
    
    public void show(){
        
        defenderBlockA.show();
        defenderBlockB.show();
        defenderBlockC.show();
        
    }
    
    /**
     * This moves the object a specific distance.
     */
    
    public void move(double dx, double dy){
        
        defenderBlockA.move(dx, dy);
        defenderBlockB.move(dx, dy);
        defenderBlockC.move(dx, dy);
        
    }
    
    /**
     * This moves the object to a specific spot.
     */
    
    public void moveTo(double dx, double dy){
        
        defenderBlockA.moveTo(dx, dy);
        defenderBlockB.moveTo(dx, dy);
        defenderBlockC.moveTo(dx, dy);
        
    }
    
    /**
     * This adds the object to the canvas.
     */
    
    public void addToCanvas(DrawingCanvas canvas){
        
        defenderBlockA.addToCanvas(canvas);
        defenderBlockB.addToCanvas(canvas);
        defenderBlockC.addToCanvas(canvas);
        
    }
    
    /**
     * This describes what happens when the program runs.
     * 
     * The method creates a boolean movement and direction int.
     * These two things are needed to determine the direction
     * of the blocks and allows for the reversal [of the 
     * direction].
     */
    
    public void run(){
        
        boolean movement = true;
        
        int direction = 1;
        
        while (movement == true){
            
            this.move( (MOVE_AMOUNT * direction), 0);
        
            pause(PAUSE_AMOUNT);
            
            //--------------------------------
            
            GameWindow.blockersLeft = 
                GameWindow.blockersLeft + 
                (MOVE_AMOUNT * direction);
                
            GameWindow.blockersRight = 
                GameWindow.blockersRight + 
                (MOVE_AMOUNT * direction);
            
            if (GameWindow.blockersLeft <= 
                GameWindow.CENTERFRAME_START || 
                GameWindow.blockersRight >=
                GameWindow.CENTERFRAME_END){
                
                direction = direction * (-1);
                
            }
            
            if (GameWindow.playerWon == true){
                
                movement = false;
                
            }
            
        }
        
    }
    
    /**
     * This method changes the colors of the blocks.
     */
    
    public void setColor(Color newColor){
        
        defenderBlockA.setColor(newColor);
        defenderBlockB.setColor(newColor);
        defenderBlockC.setColor(newColor);
        
    }
    
}
