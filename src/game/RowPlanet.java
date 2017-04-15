/**
 * @author      Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version     1.0
 * @since       1.0
*/


package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *Planets in the static pattern
 * @author Esraadandash
 */
public class RowPlanet extends StaticBody {

    private String name;
    private AttachedImage image;
    private static final Shape planetShape = new CircleShape(2.5f);

    /**
     * 
     * @param world
     */
    public RowPlanet(World world) {
        super(world, planetShape);

    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param i
     */
    public void setName(int i) {
        switch (i) {

            case -20:
                this.name = "mercury";
                break;
            case -15:
                this.name = "venus";
                break;
            case -10:
                this.name = "earth";
                break;
            case -5:
                this.name = "mars";
                break;
            case 0:
                this.name = "sun";
                break;
            case 5:
                this.name = "jupiter";
                break;
            case 10:
                this.name = "saturn";
                break;
            case 15:
                this.name = "uranus";
                break;
            case 20:
                this.name = "neptune";
                break;
            default:
                break;
        }
    }

    /**
     *
     * @return
     */
    public AttachedImage getImage() {
        return image;
    }

    /**
     *
     * @param i
     */
    public void setImage(int i) {
        switch (i) {
            case -20:
                this.image = addImage(new BodyImage("data/mercury.gif", 6));
                break;
            case -15:
                this.image = addImage(new BodyImage("data/venus.gif", 6));
                break;
            case -10:
                this.image = addImage(new BodyImage("data/earth.gif", 6));
                break;
            case -5:
                this.image = addImage(new BodyImage("data/mars.gif", 6));
                break;
            case 0:
                this.image = addImage(new BodyImage("data/sun.gif", 7));
                break;
            case 5:
                this.image = addImage(new BodyImage("data/jupiter.gif", 6));
                break;
            case 10:
                this.image = addImage(new BodyImage("data/saturn.gif", 6));
                break;
            case 15:
                this.image = addImage(new BodyImage("data/uranus.png", 7));
                break;
            case 20:
                this.image = addImage(new BodyImage("data/neptune.gif", 6));
                break;
            default:
                break;

        }
    }

}
