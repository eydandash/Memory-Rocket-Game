/**
 * @author      Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version 1.0
 * @since 1.0
 */
package game;

import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;

/**
 * For moving, release pattern meteorites
 *
 * @author Esraadandash
 */
public class Meteorite extends DynamicBody {

    private String name;

    private AttachedImage image;
    private static final Shape meteoriteShape = new CircleShape(2.5f);

    /**
     * Initialises a new meteorite
     *
     * @param world game world
     */
    public Meteorite(World world) {
        super(world, meteoriteShape);

    }

    /**
     * returns the name of the meteorite
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
                this.name = "meteorite1";
                break;
            case -5:
                this.name = "meteorite2";
                break;
            case 0:
                this.name = "meteorite3";
                break;
            case 5:
                this.name = "meteorite4";
                break;
            case 10:
                this.name = "meteorite5";
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
                this.image = addImage(new BodyImage("data/meteorite1.png", 6));
                break;
            case -5:
                this.image = addImage(new BodyImage("data/meteorite2.png", 6));
                break;
            case 0:
                this.image = addImage(new BodyImage("data/meteorite3.png", 6));
                break;
            case 5:
                this.image = addImage(new BodyImage("data/meteorite4.gif", 6));
                break;
            case 10:
                this.image = addImage(new BodyImage("data/meteorite5.gif", 6));
                break;

            default:
                break;

        }
    }
}
