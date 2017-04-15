/**
 * @author      Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version 1.0
 * @since 1.0
 */
package game;

import city.cs.engine.*;

/**
 * For moving, release pattern moons
 *
 * @author Esraadandash
 */
public class Moon extends DynamicBody {

    private String name;
    public AttachedImage image;
    private static final Shape moonShape = new CircleShape(2);

    /**
     * Initialises a new moon
     *
     * @param world game world
     */
    public Moon(World world) {
        super(world, moonShape);

    }

    /**
     * returns the name of the moon
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the object
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
     * returns image of the object
     *
     * @return image of the object
     */
    public AttachedImage getImage() {
        return image;
    }

    /**
     * sets image of the object
     *
     * @param i variable to determine image
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
