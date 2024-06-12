package libs;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

/**
 *
 * @author nn
 */
public class Escritorio extends JDesktopPane {

    private BufferedImage img;

    public Escritorio() {
        try {
            
            img = ImageIO.read(getClass().getResourceAsStream("/resources/fondo/fondo2.png"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //imagen posicopn x,y y tamaño
        // g.drawImage(img, 0, 0,600,800,null);
        g.drawImage(img, 0, 0,null);
    }
    
    
    

}
