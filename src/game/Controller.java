/**
 * @author      Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version 1.0
 * @since 4-4-2017
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * A class for handling any key presses by the user.
 *
 * @author Esraadandash
 */
public class Controller extends KeyAdapter {

    private static final Vec2 launching_speed = new Vec2(0, 12);
    private static final float walking_speed = 8;

    private Rocket rocket;
    private GameLevel space;

    /**
     * Initialises a new controller.
     *
     * @param rocket this is the main game character
     * @param space this is the game level
     */
    public Controller(Rocket rocket, GameLevel space) {
        this.rocket = rocket;
        this.space = space;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) {
            Vec2 v = rocket.getLinearVelocity();
            if (Math.abs(v.y) < 0.01f) {
                rocket.fire();
            }
        } else if (code == KeyEvent.VK_LEFT) {
            rocket.startWalking(-walking_speed);
        } else if (code == KeyEvent.VK_RIGHT) {
            rocket.startWalking(walking_speed);
        } else if (code == KeyEvent.VK_Z) {
            space.releasePlanetPattern();

        } else if (code == KeyEvent.VK_X) {
            space.releaseMoonPattern();

        } else if (code == KeyEvent.VK_C) {
            space.releaseMeteoritePattern();

        } else if (code == KeyEvent.VK_SPACE) {
            Vec2 v = rocket.getLinearVelocity();

            if (Math.abs(v.y) < 0.01f) {
                rocket.jump(27);
            }
        } else if (code == KeyEvent.VK_P) {
            space.getGame().pauseResume();

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            rocket.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            rocket.stopWalking();
        }

    }

}
