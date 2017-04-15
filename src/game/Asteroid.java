/**
 * @author      Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version     1.0
 * @since       4-4-2017
*/


package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 * Asteroid  makes rocket lose lives
 * @author Esraadandash
 */
public class Asteroid extends DynamicBody {

    private static final Shape asteroidShape = new PolygonShape(-0.562f, 0.444f, -0.141f, 0.482f, 0.627f, -0.034f, 0.649f, -0.305f, 0.396f, -0.494f, -0.231f, -0.299f, -0.643f, -0.002f);
    private static final BodyImage asteroidImage = new BodyImage("data/asteroid.png", 3);

    /**
     * This initialises an asteroid in the game level.
     * @param w this the world in which the asteroid exists.
     */
    public Asteroid(World w) {
        super(w, asteroidShape);
        addImage(asteroidImage);
        this.setGravityScale(0);
        this.setPosition(new Vec2(0, -5));
    }

}
