/*
 The rocket is my main character for the game.
*/
package game;

//import city.cs.engine.Walker;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;


/**
 *
 * @author Esraadandash
 */
public class Rocket extends Walker {
    static int i =3;
    private static final Shape rocketShape = new PolygonShape(0.003f*i,0.489f*i, 0.199f*i,-0.106f*i, 0.073f*i,-0.372f*i, -0.079f*i,-0.372f*i, -0.199f*i,-0.101f*i);
    private static final BodyImage rocketImage= new BodyImage("data/rocket.png",5);
    private int rocketLives; 
    private int collisionsCount;
    public Rocket(World world){
    super(world, rocketShape);
    addImage(rocketImage);
    rocketLives=3; collisionsCount=0;
}
    //The following two methods are still not used, I will start using them soon to be able to enable the player to proceed to different levels or not.
    public void decrementLives(){
    rocketLives--;
    countLives();
    
    }
   public void countLives(){
    if(rocketLives>0)
        System.out.println("Oops! Lost a life! "+rocketLives+" left");
    else
            System.out.println("GAME OVER!");
            restartLives();
} 
   public void restartLives(){
   rocketLives=3;
   }
   public void setCollisionsCount(int i){
   collisionsCount=i;
   }
   //This method is invoked whenever the rocket collides with a planet.
   public void incrementCollisionsCount(){
   collisionsCount++; 
       
   }
   public void restartCollisionsCount(){
   setCollisionsCount(1);
   }
   
   /*This method is invoked pn the rocket whenever it collides with a planet, such that the returned int is passed into the compare method 
   in space class to indicate which planet in the pattern should the collision's other body be compared with.
    */
   public int getCollisionsCount(){
       if(collisionsCount>3)
       
       restartCollisionsCount();
       
       return collisionsCount;
   }

}
