/**
 * @author      Esraa, Dandash, esraa.dandash@city.ac.uk
 * @version 1.0
 * @since 4-4-2017
 */
package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import java.awt.Color;
import java.awt.Font;

/**
 * User's view
 */
public class Background extends UserView {

    private Image img;
    private Rocket rocket;
    private static final Font myFont = new Font("Phosphate", Font.BOLD, 30);

    /**
     * Initialises a new background.
     *
     * @param world the game world
     * @param width width of the view
     * @param height height of the view
     * @param i variable that determines which background image to be displayed
     */
    public Background(World world, int width, int height, int i) {
        super(world, width, height);
        rocket = ((GameLevel) world).getPlayer();
        switch (i) {
            case 1:
                this.img = new ImageIcon("data/background2.jpg").getImage();
                break;
            case 2:
                this.img = new ImageIcon("data/background3.jpg").getImage();
                break;
            case 3:
                this.img = new ImageIcon("data/background6.png").getImage();
                break;

        }
    }

    /**
     * Displays background.
     *
     * @param g the 2D graphics controlling the background display
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(img, 0, 0, this);
    }

    /**
     * Displays lives and score.
     *
     * @param g the 2D graphics controlling the game score and lives display
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.cyan);
        g.setFont(myFont);
        g.drawString("Score: " + rocket.getScore(), 10, 30);
        g.drawString("Lives: " + rocket.getLives(), 880, 30);

    }
}
