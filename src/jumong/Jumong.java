package jumong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*import Client.*;
import Server.*;*/
import GameMap.*;
import singlePlayer.*;
import java.awt.Toolkit;

/**
 *
 * @author Mahsa1
 */
public class Jumong extends JFrame {

    private startMenuPanel startPanel;
    private multiPlayerPanel multiPanel;
    /*private Client client;
    private Server server;*/

    public static void main(String[] args) {
        new Jumong();
    }

    public Jumong() {
        super(" Welcome Dear User");
        getContentPane().setPreferredSize( Toolkit.getDefaultToolkit().getScreenSize());
    pack();
    setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setSize(1300, 1000);
        
        startPanel = new startMenuPanel();
        add(startPanel);
        
        startPanel.single.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SinglePlayerGame();
               //  new Thread(new SingleGameManeger()).start();
            }
        });
        
    /*    startPanel.multi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startPanel.setVisible(false);
                multiPanel = new multiPlayerPanel();
                add(multiPanel);
                
                multiPanel.join.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       //  String serverAddress = JOptionPane.showInputDialog(
          //  this,
           // "Enter IP Address of the Server:",
           // "Welcome to the Capitalization Program",
           // JOptionPane.QUESTION_MESSAGE);
                   String serverAddress = JOptionPane.showInputDialog("Hello Plz enter the Server IP");
                   String Sport = JOptionPane.showInputDialog("Hello Plz enter the Server port");
                   int port =  Integer.parseInt(Sport);
                  // client = new Client( serverAddress , port );
                       // new Thread( new joinPanel()).start();
                    }
                });
                
                multiPanel.host.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       // server = new Server();
                        //new Thread(new hostPanel()).start();
                    }
                });
            }
        });
        
        setVisible(true);
    }*/
}
}
