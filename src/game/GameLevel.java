/**
 * @author      Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version 1.0
 * @since 4-4-2017
 */
package game;

import city.cs.engine.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 * This the game level currently played
 *
 * @author Esraadandash
 */
public abstract class GameLevel extends World implements ActionListener {

    /**
     * This is the main character in the game
     */
    protected Rocket rocket;

    /**
     * This is the level background
     */
    public Background background;

    /**
     * A timer used to trigger fire and the asteroid
     */
    protected Timer t1;

    /**
     * An arraylist to add the released pattern of planets to to make it easy to
     * compare with the users choices.
     */
    protected ArrayList<Planet> planetList = new ArrayList();

    /**
     * An arraylist to add the released pattern of moons to to make it easy to
     * compare with the users choices.
     */
    protected ArrayList<Moon> moonList = new ArrayList();

    /**
     * An arraylist to add the released pattern of meteorites to to make it easy
     * to compare with the users choices.
     */
    protected ArrayList<Meteorite> meteoriteList = new ArrayList();

    /**
     * An arraylist to add the row pattern of planets to to make it easy to
     * destroy them and build new ones.
     */
    protected ArrayList<RowPlanet> rowPlanetList = new ArrayList();

    /**
     * An arraylist to add the row pattern of moons to to make it easy to
     * destroy them and build new ones.
     */
    protected ArrayList<RowMoon> rowMoonList = new ArrayList();

    /**
     * An arraylist to add the row pattern of meteorites to to make it easy to
     * destroy them and build new ones.
     */
    protected ArrayList<RowMeteorite> rowMeteoriteList = new ArrayList();

    /**
     * The number of correct guesses per pattern release
     */
    protected int correctGuesses = 0;

    /**
     * The asteroid released
     */
    protected Asteroid asteroid;

    /**
     * This game implementing this level
     */
    public Game game;
    Controller controller;

    /**
     * the background music
     */
    public SoundClip gameMusic;

    /**
     * the collision sound effect
     */
    protected SoundClip collisionSound;

    /**
     * The GUI for pausing
     */
    protected GameOverWindow g;

    /**
     * This generates new game bodies
     *
     * @param game the game implementing this level
     */
    public void populate(Game game) {

        Shape groundShape = new BoxShape(200, 0);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -14));
        this.game = game;

        rocket = new Rocket(this);
        rocket.setPosition(new Vec2(0, -13));
        rocket.setGravityScale(4);

        controller = new Controller(this.getPlayer(), this);
        //Make all the row planets line up 
        for (int i = -20; i <= 20; i += 5) {
            RowPlanet planet2 = new RowPlanet(this);
            rowPlanetList.add(planet2);
            planet2.setImage(i);
            planet2.setName(i);
            planet2.setPosition(new Vec2(i, 2));
            planet2.addCollisionListener(new Collided(rocket, this));

        }

        t1 = new Timer(15000, this);
        t1.setInitialDelay(10000);
        t1.start();
        g = new GameOverWindow();
    }

    /**
     *
     */
    public void addRowMoons() {
        for (int i = -10; i <= 10; i += 5) {
            RowMoon a = new RowMoon(this);
            rowMoonList.add(a);
            a.setImage(i);
            a.setName(i);
            a.setPosition(new Vec2(i, 2));
            a.addCollisionListener(new Collided(rocket, this));
        }
    }

    /**
     *
     */
    public void addRowMeteorites() {
        for (int i = -10; i <= 10; i += 5) {
            RowMeteorite a = new RowMeteorite(this);
            rowMeteoriteList.add(a);
            a.setImage(i);
            a.setName(i);
            a.setPosition(new Vec2(i, 2));
            a.addCollisionListener(new Collided(rocket, this));
        }
    }

    /**
     * this returns game implementing this level
     *
     * @return this is the game implementing this level
     */
    public Game getGame() {
        return game;
    }

    /**
     * plays background sound track.
     */
    public abstract void playBackgroundMusic();

    /**
     * This is invoked when a rocket hits an asteroid or a fire
     *
     * @param type variable to decide which sound to play
     */
    public void playTimedBodyMusic(String type) {
        if (type.equals("asteroid")) {
            try {
                this.collisionSound = new SoundClip("data/crash.wav");
                collisionSound.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println("file not found!");
            }
        } else {
            try {
                this.collisionSound = new SoundClip("data/newLife.wav");
                collisionSound.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println("file not found!");
            }
        }
    }

    /**
     * This is invoked when a rocket fire collides
     *
     * @param result variable that decides which sound effect to play based on
     * user's choice.
     */
    public void playCollisionMusic(boolean result) {
        if (result) {
            try {
                this.collisionSound = new SoundClip("data/correct.wav");
                collisionSound.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println("file not found!");
            }
        } else {
            try {
                this.collisionSound = new SoundClip("data/wrong.mp3");
                collisionSound.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println("file not found!");
            }
        }
    }

    /**
     * Invoked when user presses z
     */
    public void releasePlanetPattern() {

        rocket.setComparisonIndex(0);
        if (!planetList.isEmpty()) {
            planetList.clear();
        }
        Random r = new Random();
        Planet planet1;
        for (int i = 0; i < 3; i++) {
            planet1 = new Planet(this);
            int randomInteger = r.nextInt(8) - 3;
            int l = 5 * randomInteger;
            planetList.add(planet1);
            planet1.setImage(l);
            planet1.setName(l);
            planet1.setPosition(new Vec2(-40 - (i * 8), 11));
            planet1.setGravityScale(0);
            planet1.setLinearVelocity(new Vec2(45, 0));
        }
    }

    /**
     * Invoked when user presses x
     */
    public void releaseMoonPattern() {
        rocket.setComparisonIndex(0);
        if (!moonList.isEmpty()) {
            moonList.clear();
        }
        Random r2 = new Random();
        Moon moon1;
        for (int i = 0; i < 3; i++) {
            moon1 = new Moon(this);
            int randomInteger2 = r2.nextInt(5) - 2;
            int l2 = 5 * randomInteger2;
            moonList.add(moon1);
            moon1.setImage(l2);
            moon1.setName(l2);
            moon1.setPosition(new Vec2(-40 - (i * 8), 11));
            moon1.setGravityScale(0);
            moon1.setLinearVelocity(new Vec2(45, 0));

        }
    }

    /**
     * invoked when user presses c
     */
    public void releaseMeteoritePattern() {
        rocket.setComparisonIndex(0);

        if (!meteoriteList.isEmpty()) {
            meteoriteList.clear();
        }
        Random r2 = new Random();
        Meteorite meteorite1;
        for (int i = 0; i < 3; i++) {
            meteorite1 = new Meteorite(this);
            int randomInteger2 = r2.nextInt(5) - 2;
            int l2 = 5 * randomInteger2;
            meteoriteList.add(meteorite1);
            meteorite1.setImage(l2);
            meteorite1.setName(l2);
            meteorite1.setPosition(new Vec2(-40 - (i * 8), 11));
            meteorite1.setGravityScale(0);
            meteorite1.setLinearVelocity(new Vec2(45, 0));

        }
    }

    //This method is invoked whenever the rocketfire collides with a planet.
    /**
     * invoked when game wants to display moon planets
     */
    public void destroyRowPlanets() {
        for (RowPlanet p : rowPlanetList) {
            p.destroy();
        }
        rowPlanetList.clear();
    }

    /**
     * invoked when game wants to display moon planets
     */
    public void destroyRowMoons() {
        for (RowMoon m : rowMoonList) {
            m.destroy();
        }
        rowMoonList.clear();
    }

    /**
     * invoked when game wants to end
     */
    public void destroyRowMeteorites() {
        for (RowMeteorite n : rowMeteoriteList) {
            n.destroy();
        }
        rowMeteoriteList.clear();
    }

    /**
     * return the main character
     *
     * @return
     */
    public Rocket getPlayer() {
        return rocket;
    }

    /**
     * invoked when a collision happens involving rocketfire
     *
     * @param name name of the collided object
     * @param comparisonIndex which index in the arraylist
     * @param type type of compared object
     */
    public abstract void compare(String name, int comparisonIndex, String type);

    /**
     *
     * @return
     */
    public abstract boolean isCompleted();

    @Override
    public void actionPerformed(ActionEvent ae) {

        this.releaseTimedBody();
        System.out.println("Action event!");
    }

    /**
     * This releases either an asteroid or fire
     */
    public void releaseTimedBody() {
        Random a = new Random();
        int r = a.nextInt(2);
        if (r == 0) {
            RocketFire rf = new RocketFire(this);
            rf.setPosition(new Vec2(-40, -13));
            rf.setGravityScale(0);
            rf.setLinearVelocity(new Vec2(25, 0));
            rf.addCollisionListener(new Collided(rocket, this));
        } else {
            Asteroid as = new Asteroid(this);
            as.setPosition(new Vec2(-40, -13));
            as.setGravityScale(0);
            as.setLinearVelocity(new Vec2(25, 0));
            as.addCollisionListener(new Collided(rocket, this));

        }
    }
}
