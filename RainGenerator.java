
/**
 * This class uses the Rain object.
 * 
 * If this class is called, rain will be generated
 * continuously on a canvas.
 * 
 */

import objectdraw.*;
import java.awt.*;

public class RainGenerator extends ActiveObject{
    
    public Cloud cloudA, cloudB;
    
    public static Rain dropsA, dropsB;
    
    //-------
    
    private DrawingCanvas canvasGlobal;
    
    
    // Misc.
   
    private static final int RGB_VALUE_PLUS_ONE = 256;
    
    private static final int PAUSE_INTERVAL = 909000900;
    

    /**
     * Constructor for objects of class DefenderGenerator
     */
    
    public RainGenerator(DrawingCanvas canvas){
        
        canvasGlobal = canvas;
        
        //////////////////////////////////////////////////////
        
        start();
        
    }
    
    /**
     * This method describes what happens when the object
     * is run. Two drops are made after a specific amount
     * of time has passed in specific locations, continuously.
     */
    
    public void run(){
        
        int secondsInterval = 0;
        
        /////////////////////////////////////////////////////
        
        int colorValue3;
     
        colorValue3 = (int)(Math.random() * RGB_VALUE_PLUS_ONE);
        
        Color randomBlueColor = new Color(0, 0, colorValue3 );
        
        while (true){
            
            secondsInterval++;
            
            while (secondsInterval == PAUSE_INTERVAL){
                
                dropsA = new Rain(GameWindow.TOPCLO_A_X + 
                              GameWindow.CLOUD_WIDTH, 
                              GameWindow.TOPCLO_Y + 
                              GameWindow.cloudHeight, 
                              Cannon.LAZER_WIDTH, 
                              GameWindow.DROP_HEIGHT, 
                              canvasGlobal);
            
                dropsB = new Rain(GameWindow.TOPCLO_B_X + 
                              GameWindow.CLOUD_WIDTH, 
                              GameWindow.TOPCLO_Y + 
                              GameWindow.cloudHeight, 
                              Cannon.LAZER_WIDTH, 
                              GameWindow.DROP_HEIGHT, 
                              canvasGlobal);
                
                dropsA.setColor(ColorPalette.defenderColor);
                dropsB.setColor(ColorPalette.defenderColor);
                
                ////////////////////////////////////////////
                              
                secondsInterval = 0;
                              
            }
            
        }
        
    }
    
}
