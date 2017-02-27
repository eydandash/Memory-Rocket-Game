package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;

/**
 * extended view
 */
public class Background extends UserView {
    Rocket rocket;
    
    private Image background;
    
    public Background(World world, Rocket rocket, int width, int height) {
        super(world, width, height);
        this.rocket = rocket;
        this.background = new ImageIcon("data/background.jpg").getImage();
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
    }


}
