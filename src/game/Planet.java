/*
 This is the Planet class to be used in in initialising only the planets that move accross the window when a pattern is realeased.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


/**
 *
 * @author Esraadandash
 */
public class Planet extends DynamicBody {
    private String name;
    private AttachedImage image;
    private static final Shape planetShape= new CircleShape(3);
    public Planet(World world) {
        super(world, planetShape);
       
    }

    public String getName() {
        return name;
    }
//This method sets the name depending on the passed parameter since each Planet has a unique position.
    public void setName(int i) {
        switch (i){
       
            case -20: this.name= "mercury";break;
            case -15: this.name= "venus";break;
            case -10: this.name="earth";break;
            case -5: this.name= "mars";break;
            case 0: this.name= "sun";break;
            case 5: this.name= "jupiter";break;
            case 10: this.name= "saturn";break;
            case 15: this.name= "uranus";break;
            case 20: this.name= "neptune";break;
            default: break;        
        }
    }

    public AttachedImage getImage() {
        return image;
    }

    
    //This method sets the planet image depending on the passed parameter since each Planet has a unique position.
    public void setImage(int i) {
        switch (i){
            case -20: this.image= addImage(new BodyImage("data/mercury.gif",6));break;
            case -15: this.image= addImage(new BodyImage("data/venus.gif",6));break;
            case -10: this.image= addImage(new BodyImage("data/earth.gif",6));break;
            case -5: this.image= addImage(new BodyImage("data/mars.gif",6));break;
            case 0: this.image= addImage(new BodyImage("data/sun.gif",7));break;
            case 5: this.image= addImage(new BodyImage("data/jupiter.gif",6));break;
            case 10: this.image= addImage(new BodyImage("data/saturn.gif",6));break;
            case 15: this.image= addImage(new BodyImage("data/uranus.png",7));break;
            case 20: this.image= addImage(new BodyImage("data/neptune.gif",6));break;
            default: break;

        
        }
    }
    
    
        }    
    

