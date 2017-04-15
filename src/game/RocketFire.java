/**
 * @author      Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version 1.0
 * @since 1.0
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;

/**
 * This is the fire shot by the rocket
 *
 * @author Esraadandash
 */
public class RocketFire extends DynamicBody {

    static int i = 4;
    private static final Shape fireShape = new PolygonShape(0.04f * i, -0.431f * i, 0.199f * i, -0.071f * i, 0.153f * i, 0.365f * i, -0.103f * i, 0.365f * i, -0.105f * i, -0.04f * i);

    private static final BodyImage fireImage = new BodyImage("data/fire.png", 5);

    /**
     * initialises a rocket fire
     *
     * @param w
     */
    public RocketFire(World w) {
        super(w, fireShape);
        addImage(fireImage);
    }

    /**
     * returns the image
     *
     * @return
     */
    public static BodyImage getFireImage() {
        return fireImage;
    }

}
