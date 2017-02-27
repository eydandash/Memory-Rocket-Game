/*
 This class handles collision events between the planets in the row and the rocket.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Esraadandash
 */
public class Collided implements CollisionListener {
    Rocket rocket; Space space;
    public Collided(Rocket rocket,Space space){
    this.rocket=rocket;
    this.space=space;
    
    }
    @Override
    public void collide(CollisionEvent e){
                    
        
        if(e.getOtherBody() instanceof Rocket){
            
          rocket.incrementCollisionsCount();
            System.out.println("no of collisions = "+rocket.getCollisionsCount());
         (e.getOtherBody()).setPosition(new Vec2(0, -13));
         space.addResultingShape(space.compare(((RowPlanet)e.getReportingBody()).getName(), rocket.getCollisionsCount()-1));
         //space.resultBox.destroy();

    }
    
    }
    
}
