/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import GameMap.*;
/*import Client.*;*/
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;

/**
 *
 * @author Mahsa1
 */
public class Server {

    private ServerSocket serverSocket;
    private volatile boolean isAlive = true;//it will not be cashed.when it changes it would change soonly.
    ClientHandler handler = null;

    public Server(ServerSocket serverSocket) throws IOException {
        this.serverSocket = serverSocket;
        new ClientHandler(serverSocket.accept()).run();
    }

    private class ClientHandler implements Runnable {

        Socket socket;
        private InputStream input;
        private OutputStream output;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public byte[] readBytes(InputStream stream, int amount) throws IOException {
            byte[] result = new byte[amount];

            int read = stream.read(result, 0, amount);
            if (read < 0) {
                throw new IOException("Can't read from socket");
            }
            while (read < amount) {
                int remaining = amount - read;
                int newRead = stream.read(result, read, remaining);
                if (newRead < 0) {
                    throw new IOException("Can't read from socket");
                }
                read = read + newRead;
            }
            return result;
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
/* private Map gameMap;
 private int activeTurn , turn , clientNumb , port;
 private ServerSocket listener;
 private TextField clientNumbers;
 private JLabel cnum;
 private JButton start;
 private boolean startButtonPresed;
 private Player player;
 private ArrayList<Player> players;
   
 public Server() throws IOException{
 super(" Waiting for Clients to connect");
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setSize(1300, 1000);
 port = 8001;
 try {
 listener= new ServerSocket( port );
 } catch (IOException ex) {
 System.out.println(" Could not listen on the port" + port);
 Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
 }
 startButtonPresed = false;
 cnum = new JLabel(" Number of connected clients");
 cnum.setLocation(500, 500);
 add(cnum);
 clientNumb = 0;
 clientNumbers = new TextField();
 clientNumbers.setLocation(500, 600);
 add(clientNumbers);
 clientNumbers.setText("  " +clientNumb );
 start = new JButton("Start");
 start.addMouseListener(new MouseListener() {

 @Override
 public void mouseClicked(MouseEvent e) {        
               
 }

 @Override
 public void mousePressed(MouseEvent e) {
 startButtonPresed = true;
               
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
 turn = 2;
 while( ( turn<=4 ) && ( !startButtonPresed ) ){
 players.add( new Player( listener.accept(),turn ));
 turn++;
 clientNumb++;
 clientNumbers.setText("  " +clientNumb );
 }
 new Client("LocalHost",port);
 player= new Player(listener.accept(), 1);
 setVisible(true);      
 }
   
   
   
   
   
   
   
   
   
   
   
   
 class Player implements Runnable{
 int turn;
 Socket socket;
       
       
 public Player( Socket socket,int  turn){
 this.socket =  socket;
 this.turn = turn;
           
           
 }

 @Override
 public void run() {
           
            
 }
       
       
 }
    
 }*/
