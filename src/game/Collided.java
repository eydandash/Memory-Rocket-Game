/*
 This class handles collision events between the planets in the row and the rocket.
 *//**
 * @author      Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version 1.0
 * @since 4-4-2017
 */
package game;

import city.cs.engine.*;

/**
 * A class for handling collisions between different game bodies.
 *
 * @author Esraadandash
 */
public class Collided implements CollisionListener {

    private Rocket rocket;
    private World space;
    private int s;
    private Game game;

    /**
     * Initialises a new class for handling collisions.
     *
     * @param rocket main game character
     * @param space game level
     */
    public Collided(Rocket rocket, GameLevel space) {
        this.rocket = rocket;
        this.space = space;

    }

    /**
     * This method handles all the possible collisions in the game.
     *
     * @param e any collision event including a body that had this attached to
     * it as a collisionListener
     */
    @Override
    public void collide(CollisionEvent e) {

        if (e.getReportingBody() instanceof RowPlanet && e.getOtherBody() instanceof RocketFire) {

            rocket.setComparisonIndex(rocket.getComparisonIndex() + 1);
            e.getOtherBody().destroy();

            ((GameLevel) space).compare(((RowPlanet) e.getReportingBody()).getName(), rocket.getComparisonIndex() - 1, "planet");

        } else if (e.getReportingBody() instanceof RowMoon && e.getOtherBody() instanceof RocketFire) {
            rocket.setComparisonIndex(rocket.getComparisonIndex() + 1);
            e.getOtherBody().destroy();

            ((GameLevel) space).compare(((RowMoon) e.getReportingBody()).getName(), rocket.getComparisonIndex() - 1, "moon");

        } else if (e.getReportingBody() instanceof RowMeteorite && e.getOtherBody() instanceof RocketFire) {
            rocket.setComparisonIndex(rocket.getComparisonIndex() + 1);
            e.getOtherBody().destroy();

            ((GameLevel) space).compare(((RowMeteorite) e.getReportingBody()).getName(), rocket.getComparisonIndex() - 1, "meteorite");

        } else if (e.getReportingBody() instanceof Asteroid && e.getOtherBody() instanceof Rocket) {
            e.getReportingBody().destroy();
            ((Rocket) e.getOtherBody()).setLives(((Rocket) e.getOtherBody()).getLives() - 1);
            ((GameLevel) space).playTimedBodyMusic("asteroid");
        } else if (e.getReportingBody() instanceof RocketFire && e.getOtherBody() instanceof Rocket) {
            e.getReportingBody().destroy();
            ((Rocket) e.getOtherBody()).setLives(((Rocket) e.getOtherBody()).getLives() + 1);
            ((GameLevel) space).playTimedBodyMusic("fire");
        }

    }

}
