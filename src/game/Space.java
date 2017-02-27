/*
 This is the game world.
 */
package game;

import city.cs.engine.*;
import java.awt.Color;
import java.util.Random;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Esraadandash
 */
public class Space extends World {
    public Rocket rocket;
    public Background background;
    private Planet planet1;
    
    Planet[] planetList= new Planet[3];
    public StaticBody resultBox;
    public Space() {
        super();
        
        
        // make the ground for the rocket to move on (it is invisible!)
        Shape groundShape = new BoxShape(200, 0);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -14));
        
        
        
        //That is the rocket (main character)
        rocket = new Rocket(this);
        rocket.setPosition(new Vec2(0, -13));
        rocket.setGravityScale(4);
        
      
        
        //Make all the row planets line up 
        for(int i=-20;i<=20;i+=5){
        RowPlanet planet2= new RowPlanet(this);
        planet2.setImage(i);
        planet2.setName(i);
        planet2.setPosition(new Vec2(i,-1));
        planet2.addCollisionListener(new Collided(rocket,this));
        
        }
          //This is the resultBox used to show either a tick or a cross depending on the user's interaction. I tried making it absolutely invisible.
          resultBox= new StaticBody(this,new BoxShape(3,3));
          resultBox.setPosition(new Vec2(18,7));
          resultBox.setFillColor(new Color(0,0,0,0));
          resultBox.setLineColor(new Color(0,0,0,0));
    }
    /*This method is invoked when the user presses the space bar to give a random arrangement of the planets every time it is pressed and 
    populate the planet list that should be used to compare the names of each planet in it with each planet that the rocket collides with.
    */
    public void releasePattern(){
        Random r= new Random();
        
        for(int i=0;i<3;i++){
        planet1= new Planet(this);
        int randomInteger = r.nextInt(8)-3;
        int l=5*randomInteger;
        planet1.setImage(l);
        planet1.setName(l);
        planet1.setPosition(new Vec2(-40-(i*8),14));
        planet1.setGravityScale(0);
        planet1.setLinearVelocity(new Vec2(45,0));
        planetList[i]=planet1;
        }
        
    }
    //This method is invoked whenever the rocket collides with a planet.
    public Boolean compare(String name, int i){
    if((planetList[i].getName()).equalsIgnoreCase(name))
    { System.out.println("Correct");
    return true;
    
    }
    else{
            System.out.println("Oops! That shoud have been "+planetList[i].getName());
            return false;
    }            
    }
    
    
    
    public Rocket getPlayer() {
        return rocket;
    }
    //This method gives a small tick or cross to the right of the screen depending on the user's interaction.
    public void addResultingShape(Boolean x)  {
        this.resultBox.removeAllImages();
    if(x)
        this.resultBox.addImage(new BodyImage("data/right.png"));
    else
        this.resultBox.addImage(new BodyImage("data/wrong.png"));

        
    }  
       
        
}