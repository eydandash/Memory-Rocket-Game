/**
 * @author      Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version 1.0
 * @since 4-4-2017
 */
package game;

import city.cs.engine.SoundClip;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 * First level
 *
 * @author Esraadandash
 */
public class Level1 extends GameLevel {

    /**
     * Initialises new Level1
     *
     * @param game game implementing this level
     */
    public Level1(Game game) {
        super.populate(game);
        game.view = new Background(this, 1000, 700, 1);
        rocket.setScore(0);
    }

    @Override
    public void compare(String name, int comparisonIndex, String type) {

        if (type.equals("planet")) {
            if (!(this.planetList.get(comparisonIndex).getName()).equalsIgnoreCase(name)) {
                playCollisionMusic(false);
                System.out.println("Oops! That shoud have been " + this.planetList.get(comparisonIndex).getName());
                correctGuesses = 0;
                if (rocket.getLives() == 1) {
                    this.getGame().gameOver();
                }
                rocket.setLives(rocket.getLives() - 1);
            } else {
                playCollisionMusic(true);
                System.out.println("Correct");
                correctGuesses++;
                rocket.setScore(rocket.getScore() + 5);
            }
            if (correctGuesses == 3) {
                rocket.numberOfCorrectGuesses++;
                System.out.println("number of correct guesses " + rocket.numberOfCorrectGuesses);
                if (rocket.numberOfCorrectGuesses == 2) {
                    this.destroyRowPlanets();
                    this.getGame().goNextLevel();

                }
                correctGuesses = 0;
            }

        }
        if (rocket.getComparisonIndex() == 3) {
            rocket.setComparisonIndex(0);

        }
    }

    @Override
    public void playBackgroundMusic() {
        try {
            gameMusic = new SoundClip("data/1stlevelmusic.mp3");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Sound file not found!");
        }
    }

    @Override
    public boolean isCompleted() {

        return this.getPlayer().numberOfCorrectGuesses == 2;
    }

}
