package singlePlayer;

import GameMap.*;
import Item.*;
import Player.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Mahsa1
 */
public class myPanel extends JPanel  implements Runnable{

    public int[][] playerMap;
    private BufferedImage unr, wall, ground, playerimage;
    private int px, py;
    public myPanel() {
       // playerMap = map;
        setVisible(true);
        playerMap = new int[20][19];
        px = 0;
        py = 0;

        try {
            unr = ImageIO.read(new File("unreach.jpg"));
            wall = ImageIO.read(new File("wall.jpg"));
            ground = ImageIO.read(new File("Dibujo.jpg"));
            playerimage = ImageIO.read(new File("player.png"));
        } catch (IOException ex) {
            Logger.getLogger(SinglePlayerGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread(this).start();
    }

    @Override
    public void paint(Graphics g) {

        for (int j = 0; j <= 18; j++) {
            for (int i = 0; i <= 19; i++) {
                if (playerMap[i][j] == 0) {
                    g.drawImage(unr, i * 96, j * 54, 96, 54, this);
                } else if (playerMap[i][j] == 1) {
                    g.drawImage(wall, i * 96, j * 54, 96, 54, this);
                } else if (playerMap[i][j] == 2) {
                    g.drawImage(ground, i * 96, j * 54, 96, 54, this);
                } //else if (playerMap[i][j] == 3) {
                   // g.drawImage(playerimage, i * 96, j * 54, 96, 54, this);
               // }
                g.drawImage(playerimage, px * 96, py * 54, 96, 54, this);
            }
        }
    }

    public void setPlayerMap(int x, int y, int n) {
        playerMap[x][y] = n;
    }
    public void setPlayerPos( int x, int y ){
        px = x;
        py = y;
        
        
        
    }

    @Override
    public void run() {
        while(true){
       repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(myPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }
}
