/*
 This is the game class where the game is implemented. It is a memory game that simply generates a random pattern of planets everytime the user 
presses the space bar, then the user has to shoot the same sequence of planetsq (right to left) with the rocket, which is moved using the up, right 
and left non-keypad arrows. For now the sun actually sits right in the middle of the 8 planets, but it is to be used later on such 
that if the rocket hits it, the rocket lives decrement.
There is a really crucial bit when running the game, the space bar has to be pressed at least once before any other button, otherwise the 
planetlist will not be initialised and when the space (the gameWorld) tries to compare different planets it is going to throw a NullPointerException. 
For every collision the user will see either a small tick or a cross as a result, the console will also print out the result.
 */
package game;

import city.cs.engine.DebugViewer;
import city.cs.engine.UserView;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Esraadandash
 */
public class Game {
private final Space space;
public UserView view;


public Game() {

        // make the world
        space= new Space();

        view = new Background(space, space.getPlayer(), 1000, 700);
        
                //view.setGridResolution(1);

        final JFrame frame = new JFrame("Memory Rocket");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.add(view);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        
        JFrame debugView = new DebugViewer(space, 1000, 700);
        space.start();        

        
        frame.addKeyListener(new Controller(space.getPlayer(),space));

   
        
        
    }

public static void main(String[] args){

new Game();        

}
}