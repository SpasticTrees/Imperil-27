
/**
 * This is the constructor for the player object.
 * 
 * It contains the setColor, moveTo, removeFromCanvas / hide,
 * and isHidden methods.
 * 
 * It also has a KeyListener. This is the part of the program
 * that controls the interaction between the keyboard and the
 * game.
 * 
 */

import objectdraw.*;
import java.awt.*;

import java.awt.event.*;

public class Cannon implements KeyListener{
    
    private FilledRect nose;
    private FilledArc can_ball;
    
    //----------
    
    public static double globalX;
    public double globalY;
    
    private double widthGlobal;
    
    private DrawingCanvas canvasGlobal;
    
    public static final int X_OFFSET = 30;
    public static final int Y_OFFSET = 20;
    
    //----------
    
    public double leftEndpoint;
    public double rightEndpoint;
    
    public static final int FULL_TURN = 180;
    
    //----------
    
    public static final int MOVEMENT_DEFAULT = 50;
    
    
    // Lazers
    
    private Lazer aLazer;
       
    public static final int LAZER_WIDTH = 10;
    public static final int LAZER_HEIGHT = 15;
    
    private static final int LAZER_XOFFSET = 15;
    
    
    // Misc.
   
    private static final int RGB_VALUE_PLUS_ONE = 256;
    
    
    /**
     * This is the constructor.
     */
    
    public Cannon(double x, double y, double width, 
                  double height, DrawingCanvas canvas){
        
        globalX = x;
        globalY = y;
        
        widthGlobal = width;
        
        canvasGlobal = canvas;
        
        leftEndpoint = x - width/2;
        rightEndpoint = x + width/2;
                      
        /////////////////////////////////////////////////////
                      
        nose = new FilledRect(x + width/2, y, width, height, 
               canvas);
               
        nose.setColor(Color.WHITE);
        
        can_ball = new FilledArc( (x - width/2), y, width * 3, 
                   height * 4, 0, FULL_TURN, canvas);
               
        /////////////////////////////////////////////////////
                   
        canvas.addKeyListener(this);
                   
    }
    
    /**
     * This changes the color of the object.
     */
    
    public void setColor(Color newColor){
        
        can_ball.setColor(newColor);        
        nose.setColor(newColor); 
        
    }
    
    /**
     * This moves the object to a specific spot.
     */
    
    public void moveTo(double dx, double dy){
        
        nose.moveTo(dx, dy);
        can_ball.moveTo(dx - X_OFFSET, dy + Y_OFFSET);
        
    }
    
    /**
     * This moves the object to a specific distance.
     */
    
    public void move(double dx, double dy){
        
        nose.move(dx, dy);
        can_ball.move(dx, dy);
        
    }
    
    /**
     * This hides the object.
     */
    
    public void hide(){
        
        nose.hide();
        can_ball.hide();
        
    }
    
    /**
     * This removes the object from the canvas.
     */
    
    public void removeFromCanvas(){
        
        nose.removeFromCanvas();
        can_ball.removeFromCanvas();
        
    }
    
    /**
     * This adds the object to the canvas.
     */
    
    public void addToCanvas(DrawingCanvas canvas){
        
        nose.addToCanvas(canvas);
        can_ball.addToCanvas(canvas);
        
    }
    
    /**
     * This returns a canvas.
     */
    
    public DrawingCanvas getCanvas(){
        
        DrawingCanvas theCanvas = nose.getCanvas();
        
        return theCanvas;
        
    }
    
    /**
     * This returns a boolean to tell if the object is 
     * hidden or not. If it is, it returns true. If not,
     * false.
     */
    
    public boolean isHidden(){
        
        if (nose.isHidden() == true){
            
            if (can_ball.isHidden() == true){
                
                return true;
                
            }
            
        }
        
        else{
            
            return false;
            
        }
        
        return false;
        
    }
    
    /**
     * This makes it so the player can shoot by pressing the 
     * spacebar.
     */
    
    public void keyReleased(KeyEvent boop) {
        
        int colorValue1, colorValue2, colorValue3;
        
        colorValue1 = (int)(Math.random() * RGB_VALUE_PLUS_ONE);
        colorValue2 = (int)(Math.random() * RGB_VALUE_PLUS_ONE);
        colorValue3 = (int)(Math.random() * RGB_VALUE_PLUS_ONE);
        
        Color randomColor = new Color( colorValue1,
                                       colorValue2,
                                       colorValue3 );
        
        Color randomBlueColor = new Color(0, 0, colorValue3 );
        
        //////////////////////////////////////////////////////
        
        Lazer aLazer;
        
        if (nose.getCanvas() != null){
        if (boop.getKeyCode() == KeyEvent.VK_SPACE){
            
            if (globalX > GameWindow.CENTERFRAME_START &&
                globalX < GameWindow.CENTERFRAME_END){
               
               aLazer = new Lazer( (globalX + LAZER_XOFFSET * 2), 
                        GameWindow.PLAYER_Y, LAZER_WIDTH, 
                        LAZER_HEIGHT, canvasGlobal);
                        
               aLazer.setColor(randomColor);
               
               /**if (aLazer.overlaps(BlockUnitCreator.
                *                     defenderBlockA) ){
            
                   aLazer.removeFromCanvas();
               
                }**/
            
            }
            
        }
        } 
        
        //////////////////////////////////////////////////////
        
        if (boop.getKeyCode() == KeyEvent.VK_2 &&
            boop.getKeyCode() == KeyEvent.VK_7){
             
             GameWindow.playerWon();
             
             System.out.println("YOOO");
             
        }
        
    }
    
    /**
     * ignore this --am working on it--
     */
    
    public void keyTyped(KeyEvent boop) {
        
        boolean r = false;
        boolean a = false;
        boolean v = false;
        boolean e = false;
        boolean n = false;
        
        if (boop.getKeyCode() == KeyEvent.VK_R){  
         
         r = true;
            
         if (boop.getKeyCode() == KeyEvent.VK_A){
             
          a = true;
             
          if (boop.getKeyCode() == KeyEvent.VK_V){
              
           v = true;
              
           if (boop.getKeyCode() == KeyEvent.VK_E){
               
            e = true;
               
            if ( boop.getKeyCode() == KeyEvent.VK_N){
              
                n = true;
                
            }
           }
          }      
         }   
        }
        
        if (r == true && 
            a == true &&
            v == true &&
            e == true &&
            n == true){
                
            GameWindow.playerWon();
            
        }
        
    }
    
    /**
     * This makes it so that the player can move left and 
     * right via arrow keys.
     */
    
    public void keyPressed(KeyEvent boop){
        
        if (boop.getKeyCode() == KeyEvent.VK_LEFT){
            
            if (globalX >= 0 &&
                globalX <= GameWindow.FRAME_WIDTH){
                    
                 this.move(-MOVEMENT_DEFAULT, 0);
                 globalX = globalX - MOVEMENT_DEFAULT;
                    
            }
            
        }
        
        if (boop.getKeyCode() == KeyEvent.VK_RIGHT){
            
            if (globalX >= 0 &&
                globalX + widthGlobal <= GameWindow.FRAME_WIDTH){
                    
                 this.move(MOVEMENT_DEFAULT, 0);
                 globalX = globalX + MOVEMENT_DEFAULT;
                    
            }
            
        }
        
    }
    
    /**
     * This method checks whether or not the cannon overlaps
     * with another object. It returns either true or false.
     */
    
    public boolean overlapsCannon(Drawable2DInterface item){
        
        if(nose.overlaps(item) || can_ball.overlaps(item)){
            
            return true;
            
        }
        
        return false;
        
    }
    
}
