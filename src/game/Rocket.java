/**
 * @author      Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version     1.0
 * @since       1.0
*/


package game;

//import city.cs.engine.Walker;
import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 * This is the main character in the game
 * @author Esraadandash
 */
public class Rocket extends Walker {

    static int i = 3;
    private static final Shape rocketShape = new PolygonShape(0.003f * i, 0.489f * i, 0.199f * i, -0.106f * i, 0.073f * i, -0.372f * i, -0.079f * i, -0.372f * i, -0.199f * i, -0.101f * i);
    private static final BodyImage rocketImage = new BodyImage("data/rocket.png", 5);
    private int lives;

    /**
     *This is the total no of correct guesses for the level
     */
    public int numberOfCorrectGuesses = 0;
    private RocketFire rocketFire;
    private int comparisonIndex;
    private int score;

    /**
     * Initialises a new rocket
     * @param world the game level
     */
    public Rocket(World world) {
        super(world, rocketShape);
        addImage(rocketImage);
        comparisonIndex = 0;
        lives = 3;
        numberOfCorrectGuesses = 0;

    }


    /**
     * this is to make rocket fire
     */
    public void fire() {
        rocketFire = new RocketFire(this.getWorld());

        rocketFire.setPosition(new Vec2(this.getPosition().x, this.getPosition().y + 2));
        rocketFire.setLinearVelocity(new Vec2(0, 50));
    }

    /**
     * this is to get the rocket fire
     * @return fire
     */
    public RocketFire getRocketFire() {
        return rocketFire;
    }

    /**
     * returns comparison index to enter arraylists
     * @return index
     */
    public int getComparisonIndex() {
        return comparisonIndex;
    }

    /**
     * sets the index
     * @param comparisonIndex 
     */
    public void setComparisonIndex(int comparisonIndex) {
        this.comparisonIndex = comparisonIndex;
    }

    /**
     *gets the number of lives of the rocket
     * @return lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * sets the number of lives of the rocket
     * @param lives
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     *returns number of correct guesses of the level
     * @return number of correct guesses
     */
    public int getNumberOfCorrectGuesses() {
        return numberOfCorrectGuesses;
    }

    /**
     *sets number of correct guesses of the level
     * @param numberOfCorrectGuesses
     */
    public void setNumberOfCorrectGuesses(int numberOfCorrectGuesses) {
        this.numberOfCorrectGuesses = numberOfCorrectGuesses;
    }

    /**
     * returns the overall score of the level
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     *sets the overall score
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

}
