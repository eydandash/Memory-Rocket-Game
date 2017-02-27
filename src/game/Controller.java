/*
This is a key handler moving the mouse sideways, launching it and releasing the planet pattern.
*/
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Controller extends KeyAdapter {
    private static final Vec2 launching_speed = new Vec2(0,12);
    private static final float walking_speed = 8;
    
    private Rocket rocket;
    private Space space;
    public Controller(Rocket rocket,Space space) {
        this.rocket = rocket;
        this.space=space;
    }
    
    
    @Override
    public void keyPressed(KeyEvent e) {
                     
   
        //space.background.destroy();
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { //up arrow (non-keypad) = Launch rocket
            Vec2 v = rocket.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                rocket.move(launching_speed);
            }
        } else if (code == KeyEvent.VK_LEFT) {
            rocket.startWalking(-walking_speed); // left arrow (non-keypad)= Walk left
        } else if (code == KeyEvent.VK_RIGHT) {
            rocket.startWalking(walking_speed); // right arrow (non-keypad) = Walk right
        } else if (code == KeyEvent.VK_SPACE){
            space.releasePattern();
            
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
