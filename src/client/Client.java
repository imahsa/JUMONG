/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import singlePlayer.myPanel;


import GameMap.*;
import Item.*;
import Player.*;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Mahsa1
 */
public class Client  {


}
/*  private Map map;
 private Player player;
 //  private int[][] playerMap;
 private boolean gameIsOn;
 private BufferedImage unr, wall, groundiamge, playerimage;
 private myPanel panel;
 private Ground ground;
 private JMenu use;
 private JMenuItem ha, st, sh;
 private JMenuBar fr;
 String sx, sy;
 private int x, y;
 //bayad seraddres o port ra begirad
 public Client() {
 super("My Lovely Game :X");
 player = new Player();
 map = new Map();
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
 pack();
 setVisible(true);
 setResizable(false);
 panel = new myPanel();
 add(panel);
 panel.repaint();
 repaint();
 repaint();
 validate();
 addKeyListener(this);
 fr = new JMenuBar();
 setJMenuBar(fr);
 use = new JMenu(" Use ");
 ha = new JMenuItem(" Hawk ");
 ha.addMouseListener(new MouseListener() {
 @Override
 public void mouseClicked(MouseEvent e) {
 }

 @Override
 public void mousePressed(MouseEvent e) {
 if (player.playerItemesHaveThisName("Hawk")) {
 player.drop("Hawk");
 if (player.getx() > 0) {
 if (map.groundOrWall(player.getx() - 1, player.gety()) == 1) {
 JOptionPane.showMessageDialog(panel, " Tile Left is Ground");
 JOptionPane.showMessageDialog(panel, map.getGround(player.getx() - 1, player.gety()).printItemes());
 } else {
 JOptionPane.showMessageDialog(panel, " Tile Left is a Wall");
 }
 }
 if (player.getx() < 19) {
 if (map.groundOrWall(player.getx() + 1, player.gety()) == 1) {
 JOptionPane.showMessageDialog(panel, " Tile Right is Ground");
 JOptionPane.showMessageDialog(panel, map.getGround(player.getx() + 1, player.gety()).printItemes());
 } else {
 JOptionPane.showMessageDialog(panel, " Tile Right is a Wall");
 }
 }
 if (player.gety() > 0) {
 if (map.groundOrWall(player.getx(), player.gety() - 1) == 1) {
 JOptionPane.showMessageDialog(panel, " Tile Up is Ground");
 JOptionPane.showMessageDialog(panel, map.getGround(player.getx(), player.gety() - 1).printItemes());
 } else {
 JOptionPane.showMessageDialog(panel, " Tile Up is a Wall");
 }
 }
 if (player.gety() < 17) {
 if (map.groundOrWall(player.getx(), player.gety() + 1) == 1) {
 JOptionPane.showMessageDialog(panel, " Tile Down is Ground");
 JOptionPane.showMessageDialog(panel, map.getGround(player.getx(), player.gety() + 1).printItemes());
 } else {
 JOptionPane.showMessageDialog(panel, " Tile Dawn is a Wall");
 }
 }

 } else {
 JOptionPane.showMessageDialog(panel, " You do not have this item to use it:(");

 }
 }

 @Override
 public void mouseReleased(MouseEvent e) {
 }

 @Override
 public void mouseEntered(MouseEvent e) {
 }

 @Override
 public void mouseExited(MouseEvent e) {
 }
 });
 use.add(ha);
 sh = new JMenuItem(" Shovel ");
 sh.addMouseListener(new MouseListener() {
 @Override
 public void mouseClicked(MouseEvent e) {
 }

 @Override
 public void mousePressed(MouseEvent e) {
 if (player.playerItemesHaveThisName("Shovel")) {
 player.drop("Shovel");
 sx = JOptionPane.showInputDialog(" Enter the X of the tile you want to reach PLz");
 sy = JOptionPane.showInputDialog(" Enter the Y of the tile you want to reach PLz");
 x = Integer.parseInt(sx);
 y = Integer.parseInt(sy);
 if (((Math.abs(player.getx() - x)) + (Math.abs(player.gety() - y))) <= 5) {
 if (map.groundOrWall(x, y) == 0) {
 JOptionPane.showMessageDialog(panel, " This tile is a wall:(");
 panel.setPlayerMap(x, y, 1);
 panel.repaint();
 } else if (map.groundOrWall(x, y) == 1) {
 player.setX(x);
 player.setY(y);
 for (int i = 0; i < ((Math.abs(player.getx() - x)) + (Math.abs(player.gety() - y))); i++) {
 player.move();
 }
 {
 player.move();
 }
 panel.setPlayerMap(player.getx(), player.gety(), 2);
 panel.setPlayerPos(x, y);
 ground = map.getGround(player.getx(), player.gety());
 ground.setPlayerHere(player);
 ground.setJMen();
 ground.showGround();
 }

 } else {
 JOptionPane.showMessageDialog(panel, " This tile you wanted to reach is more than 5 tile far away from you ");
 }
 } else {
 JOptionPane.showMessageDialog(panel, " You do not have shovel to use it:(");

 }
 }

 @Override
 public void mouseReleased(MouseEvent e) {
 }

 @Override
 public void mouseEntered(MouseEvent e) {
 }

 @Override
 public void mouseExited(MouseEvent e) {
 }
 });
 use.add(sh);
 st = new JMenuItem(" Stone Breaker ");
 st.addMouseListener(new MouseListener() {
 private FileInputStream in;
 private AudioStream as;
 @Override
 public void mouseClicked(MouseEvent e) {
 }

 @Override
 public void mousePressed(MouseEvent e) {
 if (player.playerItemesHaveThisName("StoneBreaker")) {
 player.drop("StoneBreaker");
 //tabdil tamame divar haye atraf b zamin khali
 try {
 in = new FileInputStream(new File("Bomb.wav"));
 as = new AudioStream(in);
 AudioPlayer.player.start(as);
 } catch (FileNotFoundException ex) {
 Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
 } catch (IOException ex) {
 Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
 }
 if (player.getx() > 0) {
 if (map.groundOrWall(player.getx() - 1, player.gety()) == 0) {
 map.mapAddGround(player.getx() - 1, player.gety(), new Ground(player.getx() - 1, player.gety(), 0, 0, 0, false));
 panel.setPlayerMap(player.getx() - 1, player.gety(), 2);
 panel.repaint();
 }
 }
 if (player.getx() < 19) {
 if (map.groundOrWall(player.getx() + 1, player.gety()) == 0) {
 map.mapAddGround(player.getx() + 1, player.gety(), new Ground(player.getx() + 1, player.gety(), 0, 0, 0, false));
 panel.setPlayerMap(player.getx() + 1, player.gety(), 2);
 panel.repaint();
 }
 }
 if (player.gety() > 0) {
 if (map.groundOrWall(player.getx(), player.gety() - 1) == 0) {
 map.mapAddGround(player.getx(), player.gety() - 1, new Ground(player.getx(), player.gety() - 1, 0, 0, 0, false));
 panel.setPlayerMap(player.getx(), player.gety() - 1, 2);
 panel.repaint();
 }
 }
 if (player.gety() < 17) {
 if (map.groundOrWall(player.getx(), player.gety() + 1) == 0) {
 map.mapAddGround(player.getx(), player.gety() + 1, new Ground(player.getx(), player.gety() + 1, 0, 0, 0, false));
 panel.setPlayerMap(player.getx(), player.gety() + 1, 2);
 panel.repaint();
 }
 }
 } else {
 JOptionPane.showMessageDialog(panel, " You do not have this item to use it:(");
 }
 }

 @Override
 public void mouseReleased(MouseEvent e) {
 try {
 in.close();
 } catch (IOException ex) {
 Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
 }
 }

 @Override
 public void mouseEntered(MouseEvent e) {
 }

 @Override
 public void mouseExited(MouseEvent e) {
 }
 });
 use.add(st);
 fr.add(use);
 validate();
 revalidate();
 new Thread(this).start();
 }

 public static void main(String[] args) {
 new singlePlayer.SinglePlayerGame();
 }

 public boolean isPlayerAlive() {
 if (player.getHit_points() > 0 && player.getEnergy() > 0) {
 return true;
 } else {
 return false;
 }
 }

 @Override
 public void keyTyped(KeyEvent e) {
 }

 @Override
 public void keyPressed(KeyEvent e) {
 if (e.getKeyCode() == 37) {
 //move left x--
 if (player.getx() > 0) {
 if ((player.getx() - 1 == 6) && (player.gety() == 17)) {
 JOptionPane.showMessageDialog(this, "you wiin:)");
 System.exit(-1);
 }
 if ((map.groundOrWall((player.getx() - 1), player.gety())) == 1) {
 panel.setPlayerMap(player.getx() - 1, player.gety(), 2);
 player.setX(player.getx() - 1);
 player.move();
 panel.setPlayerPos(player.getx(), player.gety());
 panel.repaint();
 ground = map.getGround(player.getx(), player.gety());
 ground.setPlayerHere(player);
 if (isPlayerAlive()) {
 ground.setJMen();
 ground.showGround();
 panel.repaint();
 validate();
 } else {
 int n = JOptionPane.showConfirmDialog(
 this,
 "You loose:(\n do you want to use Revive Scroll to back?",
 "loose:P",
 JOptionPane.YES_NO_OPTION);
 if (n == 1) {
 JOptionPane.showMessageDialog(this, "Good Bye");
 System.exit(-1);
 } else {
 if (player.playerItemesHaveThisName("ReviveScroll")) {
 JOptionPane.showMessageDialog(this, "Hoooooraaaa You had a Revive Scroll now you'll come back:)");
 player.setHit_points(50);
 ground.setJMen();
 ground.showGround();
 panel.repaint();
 validate();

 } else {
 JOptionPane.showMessageDialog(this, " You didn't have any REvive Scroll:( Good Bye");
 System.exit(-1);
 }
 }
 }

 } else if (map.groundOrWall((player.getx() - 1), player.gety()) == 0) {
 // JOptionPane.showMessageDialog(this, map, null, WIDTH);
 panel.setPlayerMap(player.getx() - 1, player.gety(), 1);
 player.move();
 panel.repaint();
 JOptionPane.showMessageDialog(this, " It is a Wall:(");
 }
 }
 }
 if (e.getKeyCode() == 38) {
 //move up y--
 if (player.gety() > 0) {
 if ((player.getx() == 6) && (player.gety() - 1 == 17)) {
 JOptionPane.showMessageDialog(this, "you wiin:)");
 System.exit(-1);
 }
 if (map.groundOrWall((player.getx()), (player.gety() - 1)) == 1) {

 panel.setPlayerMap(player.getx(), player.gety() - 1, 2);
 player.setY(player.gety() - 1);
 player.move();
 panel.setPlayerPos(player.getx(), player.gety());
 panel.repaint();
 validate();
 ground = map.getGround(player.getx(), player.gety());
 ground.setPlayerHere(player);
 if (isPlayerAlive()) {
 ground.setJMen();
 ground.showGround();
 panel.repaint();
 validate();
 } else {
 int n = JOptionPane.showConfirmDialog(
 this,
 "You loose:(\n do you want to use Revive Scroll to back?",
 "loose:P",
 JOptionPane.YES_NO_OPTION);
 if (n == 1) {
 JOptionPane.showMessageDialog(this, "Good Bye");
 System.exit(-1);
 } else {
 if (player.playerItemesHaveThisName("ReviveScroll")) {
 JOptionPane.showMessageDialog(this, "Hoooooraaaa You had a Revive Scroll now you'll come back:)");
 player.setHit_points(50);
 ground.setJMen();
 ground.showGround();
 panel.repaint();
 validate();

 } else {
 JOptionPane.showMessageDialog(this, " You didn't have any REvive Scroll:( Good Bye");
 System.exit(-1);
 }
 }
 }

 } else if (map.groundOrWall((player.getx()), (player.gety() - 1)) == 0) {
 player.move();
 panel.setPlayerMap(player.getx(), player.gety() - 1, 1);
 panel.repaint();
 JOptionPane.showMessageDialog(this, " It is a Wall:(");
 panel.repaint();
 validate();
 }
 }


 }
 if (e.getKeyCode() == 39) {
 // move right x++
 if (player.getx() < 19) {
 if ((player.getx() + 1 == 6) && (player.gety() == 17)) {
 JOptionPane.showMessageDialog(this, "you wiin:)");
 System.exit(-1);
 }
 if (map.groundOrWall((player.getx() + 1), player.gety()) == 1) {

 panel.setPlayerMap((player.getx() + 1), player.gety(), 2);
 player.setX(player.getx() + 1);
 player.move();
 panel.setPlayerPos(player.getx(), player.gety());
 panel.repaint();
 ground = map.getGround(player.getx(), player.gety());
 ground.setPlayerHere(player);
 if (isPlayerAlive()) {
 ground.setJMen();
 ground.showGround();
 panel.repaint();
 validate();
 } else {
 int n = JOptionPane.showConfirmDialog(
 this,
 "You loose:(\n do you want to use Revive Scroll to back?",
 "loose:P",
 JOptionPane.YES_NO_OPTION);
 if (n == 1) {
 JOptionPane.showMessageDialog(this, "Good Bye");
 System.exit(-1);
 } else {
 if (player.playerItemesHaveThisName("ReviveScroll")) {
 JOptionPane.showMessageDialog(this, "Hoooooraaaa You had a Revive Scroll now you'll come back:)");
 player.setHit_points(50);
 ground.setJMen();
 ground.showGround();
 panel.repaint();
 validate();

 } else {
 JOptionPane.showMessageDialog(this, " You didn't have any REvive Scroll:( Good Bye");
 System.exit(-1);
 }
 }
 }

 } else if (map.groundOrWall((player.getx() + 1), player.gety()) == 0) {
 panel.setPlayerMap(player.getx() + 1, player.gety(), 1);
 player.move();
 panel.repaint();
 JOptionPane.showMessageDialog(this, " It is a Wall:(");
 validate();
 }
 }

 }
 if (e.getKeyCode() == 40) {
 //move dawn y++
 if (player.gety() < 17) {
 if ((player.getx() == 6) && (player.gety() + 1 == 17)) {
 JOptionPane.showMessageDialog(this, "you wiin:)");
 System.exit(-1);
 }
 if (map.groundOrWall((player.getx()), player.gety() + 1) == 1) {
 panel.setPlayerMap(player.getx(), player.gety() + 1, 2);
 player.move();
 player.setY(player.gety() + 1);
 panel.setPlayerPos(player.getx(), player.gety());
 panel.repaint();
 ground = map.getGround(player.getx(), player.gety());
 ground.setPlayerHere(player);
 if (isPlayerAlive()) {
 ground.setJMen();
 ground.showGround();
 panel.repaint();
 validate();
 } else {
 int n = JOptionPane.showConfirmDialog(
 this,
 "You loose:(\n do you want to use Revive Scroll to back?",
 "loose:P",
 JOptionPane.YES_NO_OPTION);
 if (n == 1) {
 JOptionPane.showMessageDialog(this, "Good Bye");
 System.exit(-1);
 } else {
 if (player.playerItemesHaveThisName("ReviveScroll")) {
 JOptionPane.showMessageDialog(this, "Hoooooraaaa You had a Revive Scroll now you'll come back:)");
 player.setHit_points(50);
 ground.setJMen();
 ground.showGround();
 panel.repaint();
 validate();

 } else {
 JOptionPane.showMessageDialog(this, " You didn't have any REvive Scroll:( Good Bye");
 System.exit(-1);
 }
 }
 }

 } else if (map.groundOrWall((player.getx()), player.gety() + 1) == 0) {
 panel.setPlayerMap(player.getx(), player.gety() + 1, 1);
 player.move();
 panel.repaint();
 JOptionPane.showMessageDialog(this, " It is a Wall:(");
 validate();
 }
 }
 }
 }

 @Override
 public void keyReleased(KeyEvent e) {
 }

 @Override
 public void run() {
       
 while (true) {            
 if(player.getisFireAUsed()){
 //me3le stone breaker
 if (player.getx() > 0) {
 if (map.groundOrWall(player.getx() - 1, player.gety()) == 0) {
 map.mapAddGround(player.getx() - 1, player.gety(), new Ground(player.getx() - 1, player.gety(), 0, 0, 0, false));
 panel.setPlayerMap(player.getx() - 1, player.gety(), 2);
 panel.repaint();
 }
 }
 if (player.getx() < 19) {
 if (map.groundOrWall(player.getx() + 1, player.gety()) == 0) {
 map.mapAddGround(player.getx() + 1, player.gety(), new Ground(player.getx() + 1, player.gety(), 0, 0, 0, false));
 panel.setPlayerMap(player.getx() + 1, player.gety(), 2);
 panel.repaint();
 }
 }
 if (player.gety() > 0) {
 if (map.groundOrWall(player.getx(), player.gety() - 1) == 0) {
 map.mapAddGround(player.getx(), player.gety() - 1, new Ground(player.getx(), player.gety() - 1, 0, 0, 0, false));
 panel.setPlayerMap(player.getx(), player.gety() - 1, 2);
 panel.repaint();
 }
 }
 if (player.gety() < 17) {
 if (map.groundOrWall(player.getx(), player.gety() + 1) == 0) {
 map.mapAddGround(player.getx(), player.gety() + 1, new Ground(player.getx(), player.gety() + 1, 0, 0, 0, false));
 panel.setPlayerMap(player.getx(), player.gety() + 1, 2);
 panel.repaint();
 }
 }         
 }
 try {
 Thread.sleep(300);
 } catch (InterruptedException ex) {
 Logger.getLogger(singlePlayer.SinglePlayerGame.class.getName()).log(Level.SEVERE, null, ex);
 }
 }
 }
 }











































 /*import java.awt.Graphics;
 import java.io.IOException;
 import java.net.Socket;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import javax.swing.JFrame;

 /**
 *
 * @author Mahsa1
 */
/*public class Client  extends JFrame{
    
 /*  Socket socket;

    
    
    
    
    
 class GroundHandler  {
 }*/
//}
