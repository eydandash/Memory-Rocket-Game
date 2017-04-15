/**
 * @author      Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version     1.0
 * @since       1.0
*/


package game;

import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *Moons in the static pattern
 * @author Esraadandash
 */
public class RowMoon extends StaticBody {

    private String name;
    private AttachedImage image;
    private static final Shape moonShape = new CircleShape(3f);

    /**
     * 
     * @param world
     */
    public RowMoon(World world) {
        super(world, moonShape);

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

            case -10:
                this.name = "moon1";
                break;
            case -5:
                this.name = "moon2";
                break;
            case 0:
                this.name = "moon3";
                break;
            case 5:
                this.name = "moon4";
                break;
            case 10:
                this.name = "moon5";
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

            case -10:
                this.image = addImage(new BodyImage("data/moon1.png", 6));
                break;
            case -5:
                this.image = addImage(new BodyImage("data/moon2.png", 6));
                break;
            case 0:
                this.image = addImage(new BodyImage("data/moon3.png", 6));
                break;
            case 5:
                this.image = addImage(new BodyImage("data/moon4.png", 6));
                break;
            case 10:
                this.image = addImage(new BodyImage("data/moon5.gif", 6));
                break;

            default:
                break;

        }
    }
}
