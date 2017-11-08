package jumong;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Mahsa1
 */
public class multiPlayerPanel extends JPanel {

    public JButton join, host;

    public multiPlayerPanel() {
        setSize(1300, 1000);
        setBackground(Color.GREEN);
        setLayout(null);

        join = new JButton(" Join ");
        join.setBounds(500, 500, 120, 20);
        join.setBackground(Color.BLUE);
        join.setEnabled(true);
        join.setFocusable(false);
        add(join);

        host = new JButton(" Host");
        host.setBounds(500, 700, 120, 20);
        host.setBackground(Color.BLUE);
        host.setEnabled(true);
        host.setFocusable(false);
        add(host);

        setVisible(true);

    }
}
