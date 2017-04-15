/**
 * @author Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version 1.0
 * @since 4-4-2017
 */
package game;

import city.cs.engine.SoundClip;
import city.cs.engine.UserView;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 * This is the game class for implementing all other classes
 *
 * @author Esraadandash
 */
public class Game {

    /**
     * This is the game level.
     */
    protected GameLevel space;

    /**
     * This is the current user view.
     */
    public UserView view;

    /**
     * This handles all collisions in the game.
     */
    public Collided c;

    /**
     * This handles any actions that should be taken on pressing specific
     * keyboard buttons.
     */
    protected Controller controller;
    private GameOverWindow go;
    private SoundClip gameOver;

    /**
     * This is the user's window.
     */
    protected JFrame frame;
    private PauseResumeWindow pr;

    /**
     * This method starts the first Level of the game.
     */
    public Game() {

        space = new Level3(this);
        space.playBackgroundMusic();
        c = new Collided(space.getPlayer(), space);

        frame = new JFrame("Memory Rocket");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.add(view);

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        //JFrame debugView = new DebugViewer(space, 1000, 700);
        space.start();

        controller = new Controller(space.getPlayer(), space);
        frame.addKeyListener(controller);

    }

    /**
     * This method is invoked when the the user hits the P button on the
     * keyboard.
     */
    public void pauseResume() {

        pr = new PauseResumeWindow();
        pr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pr.pack();
        pr.setVisible(true);
    }

    /**
     * This method will stop the current version only in this version, in next
     * versions it is intended to move the game directly to the next level.
     */
    public void goNextLevel() {
        space.stop();
    }

    /**
     * This method is invoked when the rocket's lives equal 0.
     */
    public void gameOver() {
        space.gameMusic.stop();
        try {
            gameOver = new SoundClip("data/gameover.mp3");
            gameOver.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Sound file not found!");
        }
        space.stop();
        frame.setVisible(false);
        go = new GameOverWindow();
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.pack();
        go.setVisible(true);
    }

    /**
     * This is the main method for the game
     *
     * @param args
     */
    public static void main(String[] args) {

        new Game();

    }

}
