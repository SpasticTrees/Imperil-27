
/**
 * This is the main game class. All the objects are created 
 * and called here.
 * 
 * It also contains random colors.
 * 
 * The code to end the game is here. This is where the loser and
 * winner text is created and deployed.
 * 
 * @author (Raven Dhillon) 
 * @version (31/3/15)
 */

import objectdraw.*;
import java.awt.*;

import javax.swing.ImageIcon;

public class GameWindow extends FrameWindowController{
    
    /** Screens **/
    
    
    /* Objects */
    
    public static FilledRect introBackground;
    
    public static Line tipsOutlineHori;
    public static Line tipsOutlineVerti;
    
    public static VisibleImage theTitle;
    public static VisibleImage theDescription;
    
    public static VisibleImage theWinStatus;
    public static VisibleImage theLoseStatus;
    
    public static VisibleImage startButton;
    public static VisibleImage resetButton;
    
    public static boolean gameStart;
    public static boolean gameEnd;
    
    
    /* Lines */
    
    // Hori
    
    private static final int HORI_XSTART = 240;
    private static final int HORI_XEND = 600;
    
    private static final int HORI_Y = 400;
    
    // Verti
    
    private static final int VERTI_X = 230;
    
    private static final int VERTI_YSTART = 500;
    private static final int VERTI_YEND = 660;
    
    // Win
    
    private static final int WIN_X = 115;
    private static final int WIN_Y = 55;
    
    // Lose
    
    private static final int LOSE_X = 115;
    private static final int LOSE_Y = 55;
    
    // Reset
    
    private static final int RESET_X = 300;
    private static final int RESET_Y = 450;
    
    
    /* Misc. */
    
    private static final int DESCRIPTION_XSTART = 200;
    
    
    /////////////////////////////////////////////////////////////
    
    /** Background **/
    
    
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 1000;
    
    public double SIDEBLOCK_WIDTH = FRAME_WIDTH/5.33;
    
    public static final double SIDEBLOCK1_START = FRAME_WIDTH/1.23;
    public static final int SIDEBLOCK2_START = 650;
    
    //-----
    
    public static final int CENTERFRAME_WIDTH = 500;
    public static final int CENTERFRAME_HEIGHT = 1000;
    
    public static final int CENTERFRAME_START = 150;
    public static final int CENTERFRAME_END = 650;
    
    //-----
    
    public static final int CLOUDAREA_SIZE = 380;
    public static final int CLOUDAREA_END = 380;
    
    public static final int BLOCKAREA_SIZE = 120;
    public static final int BLOCKAREA_END = 500;
    
    //---------------------
    
    
    /** Objects **/
    
    
    // Blocks
    
    public static BlockUnitCreator defenderBlocks;
    
    //------
    
    public static double blockersLeft;
    public static double blockersRight;
    
    
    // Clouds
    
    public static Cloud topCloA, topCloB, topCloC,
                  bottomCloA, bottomCloB,
                  middleCloA, middleCloB, middleCloC;
                  
    public static final int CLOUD_WIDTH = 50;
    public static final int cloudHeight = 40;
    
    //------
    
    public static double TOPCLO_Y = 26;
    
    public static double TOPCLO_A_X = (CENTERFRAME_WIDTH/2) + 10;
    public static double TOPCLO_B_X = CENTERFRAME_START + 
                                   (CENTERFRAME_WIDTH/2) + 60;
    
    //-----
    
    public static double MIDDLECLO_Y = CLOUDAREA_SIZE/2 - 60;
    
    public static double MIDDLECLO_A_X = CENTERFRAME_START + 25;
    public static double MIDDLECLO_B_X = CENTERFRAME_START + 
                                       210;
    public static double MIDDLECLO_C_X = (CENTERFRAME_WIDTH/2) + 290;
    
    //------
    
    public static double BOTTOMCLO_Y = 240;
    
    public static double BOTTOMCLO_A_X = (CENTERFRAME_WIDTH/2) + 10;
    public static double BOTTOMCLO_B_X = CENTERFRAME_START + 
                                      (CENTERFRAME_WIDTH/2) + 70;
    
    // Player
    
    public static Cannon thePlayer;
    
    public static double playerX;
    public static final int PLAYER_Y = BLOCKAREA_END + 150;
    
    public static final int PLAYER_WIDTHEIGHT = 30;
    
    public static boolean playerHidden;
    
    
    
    /** Rain **/
    
    
    // Rain
    
    private Rain aDrop1;
    private Rain aDrop2;
    
    
    // DROP
    
    public static final int DROP_HEIGHT = 15;
    
    
    /* Misc. */
    
    private static final int RGB_VALUE_PLUS_ONE = 256;
    
    public static boolean playerWon;
    public static boolean playerLost;
    
    public static DrawingCanvas canvasGlobal;
    
    
    // Background
    
    private static FilledRect background;
    
    private static Line dividerLeft;
    private static Line dividerRight;
    
    
    /**
     * This makes a color that randomizes itself.
     */
    
    public Color randomColor(){
        
        int colorValue1, colorValue2, colorValue3;
        
        colorValue1 = (int)(Math.random() * RGB_VALUE_PLUS_ONE);
        colorValue2 = (int)(Math.random() * RGB_VALUE_PLUS_ONE);
        colorValue3 = (int)(Math.random() * RGB_VALUE_PLUS_ONE);
        
        Color randomColor = new Color( colorValue1,
                                       colorValue2,
                                       colorValue3 );
        
        return randomColor;                           
                                       
    }
    
    /**
     * This makes a color with randomizing blue values.
     */
    
    public static Color randomBlueColor(){
        
        int colorValue1, colorValue2, colorValue3;
        
        colorValue1 = (int)(Math.random() * RGB_VALUE_PLUS_ONE);
        colorValue2 = (int)(Math.random() * RGB_VALUE_PLUS_ONE);
        colorValue3 = (int)(Math.random() * RGB_VALUE_PLUS_ONE);
        
        Color randomBlueColor = new Color(0, 0, colorValue3 );
        
        return randomBlueColor;                           
                                       
    }
    
    /**
     * This is where the background and the stationary objects
     * are created.
     */
    
    public void begin(){
        
        this.resize(FRAME_WIDTH, FRAME_HEIGHT);

        //////////////////////////////////////////////////////////
        
                            /** BACKGROUND **/
        
        canvasGlobal = canvas;
                            
        background = new FilledRect(0, 0, 
                                FRAME_WIDTH, FRAME_HEIGHT,
                                canvas);
                                
        background.setColor(ColorPalette.backgroundColor);
        
        Image centerFrame = new ImageIcon("test4.png").getImage();
        VisibleImage test3 = new VisibleImage(centerFrame, 
                                    CENTERFRAME_START,
                                    0, CENTERFRAME_WIDTH,
                                    CENTERFRAME_HEIGHT, canvas);
        
        //////////////////////////////////////////////////////
        
                           /** SIDEBAR **/

        FilledRect sideBlockLeft = new FilledRect(0, 0, 
                                   SIDEBLOCK_WIDTH, 
                                   FRAME_HEIGHT, canvas);
        
        FilledRect sideBlockRight = new FilledRect(
                                    SIDEBLOCK1_START,
                                    0, SIDEBLOCK_WIDTH,
                                    FRAME_HEIGHT, canvas);
        
        sideBlockLeft.setColor(ColorPalette.sideBlockNewColor);
        sideBlockRight.setColor(ColorPalette.sideBlockNewColor);
        
        dividerLeft = new Line(SIDEBLOCK_WIDTH, 0, 
                           SIDEBLOCK_WIDTH, FRAME_HEIGHT, canvas);
        
        dividerRight = new Line(SIDEBLOCK2_START, 0, 
                            SIDEBLOCK2_START, 
                            FRAME_HEIGHT, canvas);
        
        dividerLeft.setColor(Color.WHITE);
        dividerRight.setColor(Color.WHITE);
        
        dividerLeft.hide();
        dividerRight.hide();
        
        //////////////////////////////////////////////////////
        
                            /** CLOUDS **/
           
        topCloA = new Cloud(TOPCLO_A_X, TOPCLO_Y, CLOUD_WIDTH, 
                  cloudHeight, canvas);
        
        topCloB = new Cloud(TOPCLO_B_X, TOPCLO_Y, CLOUD_WIDTH, 
                  cloudHeight, canvas);

        topCloA.setColor(ColorPalette.defenderColor);
        topCloB.setColor(ColorPalette.defenderColor);
        
        topCloA.hide();
        topCloB.hide();
        
        //--------
                            
        middleCloA = new Cloud(MIDDLECLO_A_X, MIDDLECLO_Y, CLOUD_WIDTH, 
                  cloudHeight, canvas);
        
        middleCloB = new Cloud(MIDDLECLO_B_X, MIDDLECLO_Y, CLOUD_WIDTH, 
                  cloudHeight, canvas);
                 
        middleCloC = new Cloud(MIDDLECLO_C_X, MIDDLECLO_Y, CLOUD_WIDTH, 
                  cloudHeight, canvas);          
         
        middleCloA.setColor(Color.WHITE);
        middleCloB.setColor(Color.WHITE);
        middleCloC.setColor(Color.WHITE);          
        
        middleCloA.hide();
        middleCloB.hide();
        middleCloC.hide();
        
        //--------
        
        bottomCloA = new Cloud(BOTTOMCLO_A_X, BOTTOMCLO_Y, 
                     CLOUD_WIDTH, cloudHeight, canvas);
        
        bottomCloB = new Cloud(BOTTOMCLO_B_X, BOTTOMCLO_Y, 
                     CLOUD_WIDTH, cloudHeight, canvas);
         
        bottomCloA.setColor(Color.WHITE);
        bottomCloB.setColor(Color.WHITE); 
        
        bottomCloA.hide();
        bottomCloB.hide();
        
        //////////////////////////////////////////////////////
        
                            /** BLOCKS **/
                            
        defenderBlocks = new BlockUnitCreator(canvas);
        
        defenderBlocks.setColor(Color.WHITE);
        
        defenderBlocks.hide();
        
        //////////////////////////////////////////////////////
        
                           /** PLAYER **/
        
        thePlayer = new Cannon(FRAME_WIDTH/2, PLAYER_Y, 
                    PLAYER_WIDTHEIGHT, PLAYER_WIDTHEIGHT, canvas);
        
        //////////////////////////////////////////////////////
        
                          /** YOU WON! **/
                         
        Image winStatus = new ImageIcon("Win.png").getImage();
        theWinStatus = new VisibleImage(winStatus, WIN_X, WIN_Y, 
                    canvas); 
        
        theWinStatus.hide();
        
    
        //////////////////////////////////////////////////////
        
                          /** YOU LOSE! **/
                         
        Image loseStatus = new ImageIcon("Lose.png").getImage();
        theLoseStatus = new VisibleImage(loseStatus, LOSE_X, LOSE_Y, 
                    canvas); 
        
        theLoseStatus.hide();
        
        
        //////////////////////////////////////////////////////////
        
                             /** RESET BUTTON **/
        
        Image reset = new ImageIcon("Reset.png").getImage();
        resetButton = new VisibleImage(reset, RESET_X, RESET_Y, 
                      canvas);
                             
        resetButton.hide();        
        
        
        /////////////////////////////////////////////////////////
        
                          /** INTRO SCREEN **/
                          
        //////////////////////////////////////////////////////////
        
        introBackground = new FilledRect(0, 0, 
                                GameWindow.FRAME_WIDTH, 
                                GameWindow.FRAME_HEIGHT,
                                canvas);
                                
        introBackground.setColor(Color.BLACK);
       
        
                              /** TITLE **/
        
        Image title = new ImageIcon("title.png").getImage();
        theTitle = new VisibleImage(title, 0, 0,
                                                 canvas); 
                                  
                                                 
                            /** DESCRIPTION **/
                            
        Image description = new ImageIcon("tips.png").getImage();
        theDescription = new VisibleImage(description, 
                                      DESCRIPTION_XSTART, 
                                      GameWindow.FRAME_HEIGHT/4, 
                                      canvas); 
                                      
        tipsOutlineHori = new Line(HORI_XSTART, HORI_Y, 
                                        HORI_XEND, HORI_Y, 
                                        canvas);
        tipsOutlineHori.setColor(Color.WHITE);
        
        tipsOutlineVerti = new Line(VERTI_X, VERTI_YSTART, 
                                         VERTI_X, VERTI_YEND, 
                                         canvas);
        tipsOutlineVerti.setColor(Color.WHITE);
        
        
                             /** START BUTTON **/
                             
        Image go = new ImageIcon("go.png").getImage();
        startButton = new VisibleImage(go, 20, 600, canvas);
                          
        
        //////////////////////////////////////////////////////
        
        RainGenerator generator = new RainGenerator(canvas);
        
        ////////////////////////////////////////////////////////
        
        blockersLeft = BlockBlocker.getLeftX(
                      BlockUnitCreator.defenderBlockA);
        blockersRight = BlockBlocker.getRightX(
                      BlockUnitCreator.defenderBlockC);
                      
        ////////////////////////////////////////////////////////
        
        if (gameEnd() == true){
            
            introBackground.show();
        
            theTitle.show();
            
            resetButton.show();
            
            /////////////////////////
            
            background.hide();
           
            dividerLeft.hide();
            dividerRight.hide();
        
            topCloA.hide();
            topCloB.hide();
            
            middleCloA.hide();
            middleCloB.hide();
            middleCloC.hide();
           
            bottomCloA.hide();
            bottomCloB.hide();
            
            defenderBlocks.hide();
            
        }
        
        if (gameStart == true){
            
            introBackground.hide();
        
            theTitle.hide();
            
            resetButton.hide();
            
            /////////////////////////
            
            background.show();
           
            dividerLeft.show();
            dividerRight.show();
        
            topCloA.show();
            topCloB.show();
            
            middleCloA.show();
            middleCloB.show();
            middleCloC.show();
           
            bottomCloA.show();
            bottomCloB.show();
            
            defenderBlocks.show();
            
        }
        
        if (gameStart == true){
            
            gameEnd = false;
            
        }
        else if (gameEnd == true){
            
            gameStart = false;
            
        }
        
    }
    
    /**
     * In this method, the active objects are created.
     * The raindrops and lazers are created in this method.
     * 
     * It is also where the condition (the player object
     * getting hit by a raindrop) for losing is created.
     */
    
    public void onMousePress(Location point){
        
        Color randomColor = randomColor();
        
        Color randomBlueColor = randomBlueColor();
        
        //////////////////////////////////////////////////////////
        
        playerX = point.getX();
        
        //////////////////////////////////////////////////////////
        
        if (startButton.contains (point) ){
            
            gameStart = true;
            gameStart();
            
        }
        
        if (theWinStatus.isHidden() != true ||
            theLoseStatus.isHidden() != true){
        if (resetButton.contains(point) ){
            
            gameStart = true;
            gameStart();
            
            //------------------
            
            resetButton.hide();
            
            theWinStatus.hide();
            theLoseStatus.hide();
            
        }
        }
        
    }
    
    /**
     * If the mouse leaves the game window, then the help screen
     * is shown.
     */
    
    public void onMouseExit(Location point){
        
        if (theWinStatus.isHidden() == true || 
            theLoseStatus.isHidden() == true){
             
            introBackground.show();
        
            theTitle.show();
            theDescription.show();
            
            tipsOutlineHori.show();
            tipsOutlineVerti.show();
             
        }
        
        /**else if (theWinStatus.isHidden() != true){
            
            introBackground.hide();
            
            theDescription.hide();
            
            tipsOutlineHori.hide();
            tipsOutlineVerti.hide();
            
            theWinStatus.hide();
            
        }
        
        else if (theLoseStatus.isHidden() != true){
            
            introBackground.hide();
            
            theDescription.hide();
            
            tipsOutlineHori.hide();
            tipsOutlineVerti.hide();
            
            theLoseStatus.hide();
            
        }**/
        
    }
    
    /**
     * If the mouse comes back into the window, then the help
     * screen is hidden.
     */
    
    public void onMouseEnter(Location point){
        
        if (theWinStatus.isHidden() == true || 
            theLoseStatus.isHidden() == true){
             
            introBackground.hide();
        
            theTitle.hide();
            theDescription.hide();
            
            tipsOutlineHori.hide();
            tipsOutlineVerti.hide();
             
        }
        
        /**else if (theLoseStatus.isHidden() != true){
            
            introBackground.hide();
            
            theDescription.hide();
            
            tipsOutlineHori.hide();
            tipsOutlineVerti.hide();
            
            theLoseStatus.hide();
            
        }
        
        else if (theWinStatus.isHidden() != true){
            
            introBackground.hide();
            
            theDescription.hide();
            
            tipsOutlineHori.hide();
            tipsOutlineVerti.hide();
            
            theWinStatus.hide();
            
        }**/
        
    }
    
    /**
     * When gameStart == true, then it resets the game.
     */
    
    public static void gameStart(){
        
        introBackground.hide();
            
        theTitle.hide();
        theDescription.hide();
            
        tipsOutlineHori.hide();
        tipsOutlineVerti.hide();
            
        startButton.hide();
            
        /////////////////////////
            
        background.show();
            
        dividerLeft.show();
        dividerRight.show();
            
        topCloA.show();
        topCloB.show();
            
        middleCloA.show();
        middleCloB.show();
        middleCloC.show();
            
        bottomCloA.show();
        bottomCloB.show();
            
        defenderBlocks.show();
        
        /////////////////////////
        
        if (thePlayer.getCanvas() == null){
            
            thePlayer.addToCanvas(canvasGlobal);
            
        }
        
        /////////////////////////
        
        resetCloudStatus();
        
    }
    
    /**
     * If the player wins, the winning screen is shown.
     */
    
    public static void playerWon(){
        
        if (gameStart == true){
        if (Lazer.allCloudsHidden == true){
                
            theWinStatus.show();
            theWinStatus.sendToFront();
            
            /////////////////////////////////////////////////////
        
            theTitle.show();
            
            resetButton.show();
            
            /////////////////////////
            
            background.hide();
           
            dividerLeft.hide();
            dividerRight.hide();
        
            topCloA.hide();
            topCloB.hide();
            
            middleCloA.hide();
            middleCloB.hide();
            middleCloC.hide();
           
            bottomCloA.hide();
            bottomCloB.hide();
            
            defenderBlocks.hide();
            
            /////////////////////////////////////////////////////
            
            /**if (thePlayer.getCanvas() != null){
                
                thePlayer.removeFromCanvas();
                
            }**/
        
        }
        }
        
    }
    
    /**
     * If the player loses, the losing screen is shown.
     */
    
    public static void playerLost(){
        
        if (gameStart == true){
        if (playerHidden == true){

            theLoseStatus.show();
            theLoseStatus.sendToFront();
            
            /////////////////////////////////////////////////////
        
            theTitle.show();
            
            resetButton.show();
            
            /////////////////////////
            
            background.hide();
           
            dividerLeft.hide();
            dividerRight.hide();
        
            topCloA.hide();
            topCloB.hide();
            
            middleCloA.hide();
            middleCloB.hide();
            middleCloC.hide();
           
            bottomCloA.hide();
            bottomCloB.hide();
            
            defenderBlocks.hide();
            
        }
        }
        
    }
    
    /**
     * This checks whether the game is over by checking 
     * if the player won / lost.
     */
    
    public static boolean gameEnd(){
        
        if (playerLost == true || playerWon == true){
            
            return true;
            
        }
        
        return false;
        
    }
    
    /**
     * This method is needed because killing the clouds wins the
     * game. If you replay the game and the hidden booleans
     * are not reset, then the game thinks that you still won.
     * 
     * This cannot happen for obvious reasons.
     */
    
    public static void resetCloudStatus(){
        
        Lazer.mCloAHidden = false;
        Lazer.mCloBHidden = false;
        Lazer.mCloCHidden = false;
            
        Lazer.bCloAHidden = false;
        Lazer.bCloBHidden = false;
        
    }
    
}
