
 
package jumong;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Mahsa1
 */
public class startMenuPanel  extends JPanel{
    
    public JButton single,multi;
    
  public  startMenuPanel(){

        setBackground(Color.red);
        setSize(1300, 1000);
        setLayout(null);
        
        single = new JButton(" Single Player");
        single.setBackground(Color.CYAN);
        single.setEnabled(true);
        single.setBounds(500, 500, 120, 20);
        single.setFocusable(false);
        add(single);
        
        multi = new JButton("Multi Player");
        multi.setBackground(Color.CYAN);
        multi.setEnabled(true);
        multi.setBounds(500, 700, 120, 20);
        multi.setFocusable(false);
        add(multi);
        
        setVisible(true);
}
    
    
}
