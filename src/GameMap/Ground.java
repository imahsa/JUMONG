package GameMap;

import java.util.ArrayList;
import Item.*;
import Player.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Mahsa1
 */
public class Ground extends JPanel {

    private int x, y;
    private int gold_number;
    private int enemy_num;
    private int timedrached;
    private int mousex;
    private int mousey;
    private ArrayList<Item> gr_itemes;
    private ArrayList<Item> gr_chest;
    private ArrayList<myButton> itemes_buttons;
    private ArrayList<myButton> removable_buttons;
    private ArrayList<JButton> enemyButtons;
    private ArrayList<Enemy> gr_enemies;
    private boolean chest = false;
    private Component Ground;
    private FileInputStream in1;
    private AudioStream as1;
    private boolean fireArrowIsused = false;
    chest chestt;
    Player player;
    JFrame frame;
    BufferedImage img, black;
    JMenuBar menueBar;
    JMenu Exit;
    JMenuItem all, sa, fa, ba, shp, bhp, ep, ha, sho, sb, rs, bb, k, hit, energy, gold, bag;
    JCheckBoxMenuItem dba, dbb, dbhp, dep, dfa, dh, drs, ds, dsa, dshp, dsb, ushp, ubhp, uep, ubb;
    private FileInputStream in2;
    private AudioStream as2;

    public Ground(int x, int y, int gold_number, int enemy_number, int item_number, boolean chest) {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            frame = new JFrame(" ground ");
            removeMinMaxClose(frame);
            frame.getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
            frame.pack();
            frame.setResizable(false);
            frame.setVisible(false);
            img = ImageIO.read(new File("Greens-Grass-1800x2880.jpg"));
            this.x = x;
            this.y = y;
            this.gold_number = gold_number;
            enemy_num = enemy_number;
            if (enemy_number >= 0) {
                gr_enemies = new ArrayList();
            }
            gr_itemes = new ArrayList<Item>();
            itemes_buttons = new ArrayList<myButton>();
            removable_buttons = new ArrayList<myButton>();
            enemyButtons = new ArrayList<JButton>();
            this.chest = chest;
            if (chest) {
                gr_chest = new ArrayList<Item>();
                chestt = new chest();
            }
            dba = new JCheckBoxMenuItem(" Big Arrow ");
            dbb = new JCheckBoxMenuItem(" Big Bag ");
            dbhp = new JCheckBoxMenuItem(" Big Health Potion ");
            dep = new JCheckBoxMenuItem(" Energy Potion ");
            dfa = new JCheckBoxMenuItem(" Fire Arrow ");
            dh = new JCheckBoxMenuItem(" Hawk ");
            drs = new JCheckBoxMenuItem(" Revive Scroll ");
            ds = new JCheckBoxMenuItem(" Shovel ");
            dsa = new JCheckBoxMenuItem(" Small Arrow");
            dshp = new JCheckBoxMenuItem(" Small Health Potion");
            dsb = new JCheckBoxMenuItem(" Stone Breaker");
            all = new JMenuItem(" All  ");
            sa = new JMenuItem(" Small Arrow ");
            fa = new JMenuItem(" Fire Arrow ");
            ba = new JMenuItem(" Big Arrow ");
            shp = new JMenuItem(" Small Health Potion ");
            bhp = new JMenuItem(" Big Health Potion ");
            ep = new JMenuItem(" Energy Potion ");
            ha = new JMenuItem(" Hawk ");
            sho = new JMenuItem(" Shovel ");
            sb = new JMenuItem(" Stone Breaker ");
            rs = new JMenuItem(" Revive Scroll ");
            bb = new JMenuItem(" Big Bag ");
            k = new JMenuItem(" Key ");
            ushp = new JCheckBoxMenuItem(" Small Health Potion ");
            ubhp = new JCheckBoxMenuItem(" Big Health Potion ");
            uep = new JCheckBoxMenuItem(" Energy Potion ");
            ubb = new JCheckBoxMenuItem(" Big Bag ");
            hit = new JMenuItem(" Hit points ");
            energy = new JMenuItem(" Energy ");
            gold = new JMenuItem(" Golds ");
            bag = new JMenuItem(" Is my bag heavy??!! ");
            timedrached = 0;
            validate();
            setVisible(false);
            frame.add(this);
        } catch (IOException ex) {
            Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeMinMaxClose(Component comp) {
        if (comp instanceof AbstractButton) {
            comp.getParent().remove(comp);
        }
        if (comp instanceof Container) {
            Component[] comps = ((Container) comp).getComponents();
            for (int x = 0, y = comps.length; x < y; x++) {
                removeMinMaxClose(comps[x]);
            }
        }
    }

    public void showGround() {
        setEnemyButton();
        frame.setVisible(true);
        setVisible(true);
        try {
            in1 = new FileInputStream(new File("ground.wav"));
            as1 = new AudioStream(in1);
            AudioPlayer.player.start(as1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (gr_enemies.size() > 0) {
            int n = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want that your enemy kill atumatically",
                    "Atumatically kill",
                    JOptionPane.YES_NO_OPTION);
            if (n == 1) {
                setEnemyButton();
                repaint();
            } else {
                if (player.inventory(1) >= gr_enemies.size()) {
                    for (int i = 0; i < gr_enemies.size(); i++) {
                        player.drop("SmallArrow");
                    }
                    for (int i = 0; i < enemyButtons.size(); i++) {
                       
                        remove(enemyButtons.get(i));
                    }
                  /*   try {
                             in2 = new FileInputStream(new File("small arrow.wav"));
                             as2 = new AudioStream(in2);
                                    AudioPlayer.player.start(as2);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                                }*/
                     
                    enemyButtons.clear();
                    enemy_num = 0;
                    gr_enemies.clear();
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(Ground, " your Small arrows is not enough");
                    setEnemyButton();

                }
            }
        }
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public int getGolds() {
        return gold_number;
    }

    public int getEnemyNum() {
        return enemy_num;
    }

    public void setEnemyNum(int n) {
        enemy_num += n;
    }

    public void setGr_Enemy(Enemy enemy) {
        gr_enemies.add(enemy);
        enemy.setGround(this);
    }

    public void setEnemyButton() {
        for (int i = 0; i < gr_enemies.size(); i++) {
            EnemyButton ebut;
            ebut = new EnemyButton();
            JButton enmbut = ebut.getButt();
            enemyButtons.add(enmbut);
            add(ebut.getButt());
        }
    }

    public void setGr_itemes(Item item) {
        gr_itemes.add(item);
        myButton but = new myButton(item);
        add(but.getButton());
        repaint();
        validate();
    }

    public void setGr_chestNum(int chest_number) {
        chestt.setNum(chest_number);

    }

    public void setGr_chest(Item item) {
        gr_chest.add(item);
    }

    public void setJMen() {
        menueBar = getJMenueBarOfDropUseInventory();
        frame.setJMenuBar(menueBar);
        validate();
    }

    public void setPlayerHere(Player player) {
        this.player = player;
        player.setX(x);
        player.setY(y);
        player.setGolds(gold_number);
        gold_number = 0;
        player.hit(gr_enemies.size());
        player.setisFireAUsed(false);
        timedrached++;
    }

    public void removeEnemy(Enemy enemy) {
        if (gr_enemies.size() > 0) {
            gr_enemies.remove(enemy);
            if (enemy_num > 0) {
                enemy_num--;
            }
            if (enemyButtons.size() > 0) {
                remove(enemyButtons.get(0));
                repaint();
                revalidate();
                enemyButtons.remove(0);
            }
        }
    }

    public boolean isPlayerAlive() {
        return false;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }

    public String printItemes() {
        String s = "";
        s += "Enemy number:" + getEnemyNum();
        s += "\n";
        if (gr_itemes.size() == 0) {
            return s += " No Item.\nGolds:" + gold_number;
        } else {
            s += "Itemes:\n";
            for (Item item : gr_itemes) {
                s += item.ItemName() + "   ";
            }
            return s += "\nGolds:" + gold_number;


        }
    }

    class myButton {

        private JButton button;
        private final Item item;
        private BufferedImage buttonIcon;

        public myButton(Item item) {
            this.item = item;

// firs we set an image icon for our button
            if (item.ItemName().equalsIgnoreCase("smallArrow")) {
                try {
                    buttonIcon = ImageIO.read(new File("small ar_clipped_rev_1 (1).png"));
                    button = new JButton(new ImageIcon(buttonIcon));
                    button.setToolTipText("Small Arrow");
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (item.ItemName().equalsIgnoreCase("fireArrow")) {
                try {
                    buttonIcon = ImageIO.read(new File("fire ar_clipped_rev_1_clipped_rev_1.png"));
                    button = new JButton(new ImageIcon(buttonIcon));
                    button.setToolTipText("Fire Arrow");
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (item.ItemName().equalsIgnoreCase("bigArrow")) {
                try {
                    buttonIcon = ImageIO.read(new File("big ar_clipped_rev_1.png"));
                    button = new JButton(new ImageIcon(buttonIcon));
                    button.setToolTipText("Big Arrow");
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (item.ItemName().equalsIgnoreCase("stoneBreaker")) {
                try {
                    buttonIcon = ImageIO.read(new File("bomb.png"));
                    button = new JButton(new ImageIcon(buttonIcon));
                    button.setToolTipText("Stone Breaker");
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (item.ItemName().equalsIgnoreCase("smallHealthPotion")) {
                try {
                    buttonIcon = ImageIO.read(new File("sa hp_clipped_rev_1.png"));
                    button = new JButton(new ImageIcon(buttonIcon));
                    button.setToolTipText("Small Health Potion");
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (item.ItemName().equalsIgnoreCase("bigHealthPotion")) {
                try {
                    buttonIcon = ImageIO.read(new File("small hp_clipped_rev_1.png"));
                    button = new JButton(new ImageIcon(buttonIcon));
                    button.setToolTipText("Big Health Potion");
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (item.ItemName().equalsIgnoreCase("EnergyPotion")) {
                try {
                    buttonIcon = ImageIO.read(new File("energy po_clipped_rev_1.png"));
                    button = new JButton(new ImageIcon(buttonIcon));
                    button.setToolTipText("Energy Potion");
                    button.setLocation(800, 400);
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (item.ItemName().equalsIgnoreCase("reviveScroll")) {
                try {
                    buttonIcon = ImageIO.read(new File("revisc_clipped_rev_1.png"));
                    button = new JButton(new ImageIcon(buttonIcon));
                    button.setToolTipText("Revive Scroll");
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (item.ItemName().equalsIgnoreCase("hawk")) {
                try {
                    buttonIcon = ImageIO.read(new File("hawk.png"));
                    button = new JButton(new ImageIcon(buttonIcon));
                    button.setToolTipText("Hawk");
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (item.ItemName().equalsIgnoreCase("shovel")) {
                try {
                    buttonIcon = ImageIO.read(new File("shovel.png"));
                    button = new JButton(new ImageIcon(buttonIcon));
                    button.setToolTipText("Shovel");
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (item.ItemName().equalsIgnoreCase("bigBag")) {
                try {
                    buttonIcon = ImageIO.read(new File("bigbag.png"));
                    button = new JButton(new ImageIcon(buttonIcon));
                    button.setToolTipText("Big Bag");
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (item.ItemName().equalsIgnoreCase("key")) {
                try {
                    buttonIcon = ImageIO.read(new File("key_clipped_rev_1.png"));
                    button = new JButton(new ImageIcon(buttonIcon));
                    button.setToolTipText("Key");
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            button.setBorder(BorderFactory.createEmptyBorder());
            button.setContentAreaFilled(false);
            button.setFocusable(false);

            button.addMouseListener(new MouseListener() {
                private FileInputStream in;
                private AudioStream as;

                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    gr_itemes.remove(getItem());
                    if (getItem().equals("Key")) {
                        player.setKey((Key) getItem());
                    } else {
                        player.pick(getItem());
                    }
                    try {
                        in = new FileInputStream(new File("bag.wav"));
                        as = new AudioStream(in);
                        AudioPlayer.player.start(as);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    remove(button);
                    repaint();
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
        }
        /*
         *  gr_itemes.remove( getItem() );
         player.pick( getItem() );
         player.inventory();
         remove(button);
         revalidate();  
         validate();  
         repaint();
         * */

        public JButton getButton() {
            return button;
        }

        public Item getItem() {
            return item;
        }
    }

    class EnemyButton {

        JButton ebut;
        BufferedImage buttonIcon;
        private Component Ground;
        private FileInputStream in;
        private AudioStream as;

        public EnemyButton() {
            try {
                buttonIcon = ImageIO.read(new File("imageedit_17_3085767894.gif"));
                ebut = new JButton(new ImageIcon(buttonIcon));
                ebut.setToolTipText(" Your Enemy ");
            } catch (IOException ex) {
                Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
            }
            ebut.setBorder(BorderFactory.createEmptyBorder());
            ebut.setContentAreaFilled(false);
            ebut.setFocusable(false);
            ebut.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    Object[] possibilities = {"Small Arrow", "Fire Arrow", "Big Arrow"};
                    String s = (String) JOptionPane.showInputDialog(
                            frame,
                            "PlZ choose a waepon to kill the enemy with",
                            "Choose a Weapon",
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            possibilities,
                            "SmallArrow");
                    if ((s != null) && (s.length() > 0)) {
                        if (s.equalsIgnoreCase("Small Arrow")) {
                            String w = "SmallArrow";
                            if (player.playerItemesHaveThisName(w)) {
                                player.drop(w);
                                if (enemy_num > 0) {
                                    enemy_num--;
                                }
                                try {
                                    in = new FileInputStream(new File("small arrow.wav"));
                                    as = new AudioStream(in);
                                    AudioPlayer.player.start(as);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                remove(ebut);
                                if (gr_enemies.size() > 0) {
                                    gr_enemies.remove(0);
                                }
                                repaint();
                            } else {
                                JOptionPane.showMessageDialog(Ground, " You don't have: " + w + " to use it:(");
                            }
                        } else if (s.equalsIgnoreCase("Fire Arrow")) {
                            String w = "FireArrow";
                            if (player.playerItemesHaveThisName(w)) {
                                player.drop(w);
                                // fireArrowIsused = true;
                                player.setisFireAUsed(true);
                                if (enemy_num > 0) {
                                    enemy_num--;
                                }
                                try {
                                    in = new FileInputStream(new File("stone b.wav"));
                                    as = new AudioStream(in);
                                    AudioPlayer.player.start(as);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                remove(ebut);
                                if (gr_enemies.size() > 0) {
                                    gr_enemies.remove(0);
                                }

                                repaint();
                            } else {
                                JOptionPane.showMessageDialog(Ground, " You don't have: " + w + " to use it:(");
                            }

                        } else if (s.equalsIgnoreCase("Big Arrow")) {
                            String w = "BigArrow";
                            if (player.playerItemesHaveThisName(w)) {
                                for (int i = 0; i < enemyButtons.size(); i++) {
                                    remove(enemyButtons.get(i));
                                }
                                try {
                                    in = new FileInputStream(new File("big arow.wav"));
                                    as = new AudioStream(in);
                                    AudioPlayer.player.start(as);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                enemyButtons.clear();
                                enemy_num = 0;
                                gr_enemies.clear();
                                repaint();
                            } else {
                                JOptionPane.showMessageDialog(Ground, " You don't have: " + w + " to use it:(");
                            }
                        }
                        return;
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
                    //   mousex = e.getX();
                    //  mousey = e.getY();
                    //  System.out.println("X" + mousex + "Y" + mousey );
                    // beRedCross = true;
                    // repaint();
                    //
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });

        }

        public JButton getButt() {
            return ebut;
        }
    }

    class chest {

        JButton chest_button;
        private BufferedImage chest_buttonIcon;
        private ArrayList<Key> keyes;
        int num;

        public void setNum(int n) {
            num = n;

        }

        public chest() {
            if (chest) {
                try {
                    chest_buttonIcon = ImageIO.read(new File("chest_clipped_rev_1.png"));
                    chest_button = new JButton(new ImageIcon(chest_buttonIcon));
                    // int n = chest_number;
                    chest_button.setToolTipText("Chest" + num);
                } catch (IOException ex) {
                    Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
                }
                chest_button.setBorder(BorderFactory.createEmptyBorder());
                chest_button.setContentAreaFilled(false);
                chest_button.setFocusable(false);
                chest_button.addMouseListener(new MouseListener() {
                    private Component Ground;

                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (gr_chest.size() > 0) {
                            keyes = player.getKeyes();

                            for (int i = 0; i < keyes.size(); i++) {
                                if (num == keyes.get(i).getKeyNum()) {
                                    JOptionPane.showMessageDialog(Ground, " You have the key number: " + num + " so chest's itemes will be added to y"
                                            + "our bag :)");
                                    for (int j = 0; j < gr_chest.size(); j++) {
                                        JOptionPane.showMessageDialog(Ground, " Item : " + gr_chest.get(j).ItemName() + " added to your bag:)");

                                    }
                                    keyes.remove(keyes.get(i));
                                    for (int j = 0; j < gr_chest.size(); j++) {
                                        player.pick(gr_chest.get(j));
                                    }
                                    gr_chest.clear();
                                }

                            }

                        } else {
                            JOptionPane.showMessageDialog(Ground, " this chest has been opened before ");
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        chest_button.setToolTipText("Chest" + num);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });

                add(chest_button);
            }
        }
    }

    public JMenuBar getJMenueBarOfDropUseInventory() {
        JMenuBar menuBar;
        JMenu menu, inventoryMenue, use, playersta;
        JMenuItem menuItem;
        menuBar = new JMenuBar();
        menu = new JMenu("Drop");
        menu.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menu);
        menu.addSeparator();
        dba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dba.isSelected()) {
                    Item item = new BigArrow();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        setGr_itemes(item);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to drop it ");
                    }
                }
            }
        });

        menu.add(dba);
        dbb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dbb.isSelected()) {
                    Item item = new BigBag();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        setGr_itemes(item);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to drop it ");
                    }
                }

            }
        });
        menu.add(dbb);
        dbhp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dbhp.isSelected()) {
                    Item item = new BigHealthPotion();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        setGr_itemes(item);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to drop it ");
                    }
                }

            }
        });
        menu.add(dbhp);
        dep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dep.isSelected()) {
                    Item item = new EnergyPotion();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        setGr_itemes(item);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to drop it ");
                    }
                }
            }
        });
        menu.add(dep);
        dfa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dfa.isSelected()) {
                    Item item = new FireArrow();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        setGr_itemes(item);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to drop it ");
                    }
                }
            }
        });
        menu.add(dfa);
        dh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dh.isSelected()) {
                    Item item = new Hawk();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        setGr_itemes(item);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to drop it ");
                    }
                }
            }
        });
        menu.add(dh);
        drs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (drs.isSelected()) {
                    Item item = new ReviveScroll();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        setGr_itemes(item);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to drop it ");
                    }
                }
            }
        });
        menu.add(drs);
        ds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ds.isSelected()) {
                    Item item = new Shovel();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        setGr_itemes(item);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to drop it ");
                    }
                }
            }
        });
        menu.add(ds);
        dsa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dsa.isSelected()) {
                    Item item = new SmallArrow();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        setGr_itemes(item);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to drop it ");
                    }
                }
            }
        });
        menu.add(dsa);
        dshp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dshp.isSelected()) {
                    Item item = new SmallHealthPotion();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        setGr_itemes(item);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to drop it ");
                    }
                }
            }
        });
        menu.add(dshp);
        dsb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dsb.isSelected()) {
                    Item item = new StoneBreaker();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        setGr_itemes(item);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to drop it ");
                    }
                }
            }
        });
        menu.add(dsb);

        inventoryMenue = new JMenu("Inventory");
        inventoryMenue.setMnemonic(KeyEvent.VK_I);;
        all.setToolTipText(" by clicking on it you will see number of all of your itemes ");
        all.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, " you have :\n" + player.inventory(1) + " Small Arrow\n"
                        + player.inventory(2) + " Fire Arrow\n" + player.inventory(3) + " Big Arrow\n"
                        + player.inventory(4) + " Small Health Potion\n" + player.inventory(5) + " Big Health Potion\n"
                        + player.inventory(6) + " Energy Potion\n" + player.inventory(7) + " Hawk\n"
                        + player.inventory(8) + " Shovel\n" + player.inventory(9) + " Stone Breaker\n"
                        + player.inventory(10) + " Revive Scroll\n" + player.inventory(11) + " Big Bag\n"
                        + player.getKeyes().size() + " Key\n" + " in your bag");
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
        inventoryMenue.add(all);
        sa.setToolTipText("" + player.inventory(1));
        sa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.inventory(1) + " Small Arrows");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                sa.setToolTipText("" + player.inventory(1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inventoryMenue.add(sa);
        fa.setToolTipText("" + player.inventory(2));
        fa.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.inventory(2) + " Fire Arrows");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                fa.setToolTipText("" + player.inventory(2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inventoryMenue.add(fa);
        ba.setToolTipText("" + player.inventory(3));
        ba.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.inventory(3) + " Big Arrows");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ba.setToolTipText("" + player.inventory(3));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inventoryMenue.add(ba);
        shp.setToolTipText("" + player.inventory(4));
        shp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.inventory(4) + " Small Health Potion ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                shp.setToolTipText("" + player.inventory(4));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inventoryMenue.add(shp);
        bhp.setToolTipText("" + player.inventory(5));
        bhp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.inventory(5) + " Big Health Potion ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bhp.setToolTipText("" + player.inventory(5));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inventoryMenue.add(bhp);
        ep.setToolTipText("" + player.inventory(6));
        ep.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.inventory(6) + " Energy Potion ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ep.setToolTipText("" + player.inventory(6));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inventoryMenue.add(ep);
        ha.setToolTipText("" + player.inventory(7));
        ha.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.inventory(7) + " Hawk ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ha.setToolTipText("" + player.inventory(7));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inventoryMenue.add(ha);
        sho.setToolTipText("" + player.inventory(8));
        sho.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.inventory(8) + " Shovel ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                sho.setToolTipText("" + player.inventory(8));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inventoryMenue.add(sho);
        sb.setToolTipText("" + player.inventory(9));
        sb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.inventory(9) + " Stone Breaker ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                sb.setToolTipText("" + player.inventory(9));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inventoryMenue.add(sb);
        rs.setToolTipText("" + player.inventory(10));
        rs.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.inventory(10) + " Revive Scroll ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                rs.setToolTipText("" + player.inventory(10));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inventoryMenue.add(rs);

        bb.setToolTipText("" + player.inventory(11));
        bb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.inventory(11) + " Big Bag ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bb.setToolTipText("" + player.inventory(11));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inventoryMenue.add(bb);
        k.setToolTipText("" + player.getKeyes().size());
        k.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.getKeyes().size() + " Key ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                k.setToolTipText("" + player.getKeyes().size());
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inventoryMenue.add(k);
        menuBar.add(inventoryMenue);

        use = new JMenu("Use");
        use.setMnemonic(KeyEvent.VK_U);
        menuBar.add(use);
        ushp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ushp.isSelected()) {
                    Item item = new SmallHealthPotion();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        player.setHit_points(20);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to use it ");
                    }
                }
            }
        });

        use.add(ushp);
        ubhp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ubhp.isSelected()) {
                    Item item = new BigHealthPotion();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        player.setHit_points(50);
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to use it ");
                    }
                }
            }
        });

        use.add(ubhp);
        uep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (uep.isSelected()) {
                    Item item = new EnergyPotion();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        // setGr_itemes(item);
                        player.setEnergy();
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to use it ");
                    }
                }
            }
        });

        use.add(uep);
        ubb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ubb.isSelected()) {
                    Item item = new BigBag();
                    if (player.playerItemesHaveThisName(item.ItemName())) {
                        // setGr_itemes(item);
                        player.bigBagSize();
                        player.drop(item.ItemName());
                    } else {
                        JOptionPane.showMessageDialog(frame, " You don't have this item to use it ");
                    }
                }
            }
        });

        use.add(ubb);

        playersta = new JMenu(" My Status");
        playersta.setMnemonic(KeyEvent.VK_M);
        menuBar.add(playersta);
        hit.setToolTipText(" " + player.getHit_points() + " ");
        hit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.getHit_points() + " hit points ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hit.setToolTipText(" " + player.getHit_points() + " ");
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        playersta.add(hit);
        energy.setToolTipText(" " + player.getEnergy() + " ");
        energy.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.getEnergy() + " energy ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                energy.setToolTipText(" " + player.getEnergy() + " ");
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        playersta.add(energy);
        gold.setToolTipText(" " + player.getGolds() + " ");
        gold.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "  you have : " + player.getGolds() + " golds ");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                gold.setToolTipText(" " + player.getGolds() + " ");
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        playersta.add(gold);
        bag.setToolTipText(" By clicking on this you will see if your bag is heavy or not!!");
        bag.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (player.getBagSize() < 37) {

                    JOptionPane.showMessageDialog(frame, " Your bag is not so heavy you don't need to drop your itemes");
                } else if (player.getBagSize() >= 37) {

                    JOptionPane.showMessageDialog(frame, " Your bag is heavy you'd better drop some itemes");
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bag.setToolTipText("By clicking on this you will see if your bag is heavy or not!!");
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        playersta.add(bag);
        Exit = new JMenu(" Back to main page ");
        Exit.setMnemonic(KeyEvent.VK_B);
        Exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if ((timedrached == 1) && (gr_enemies.size() > 0)) {
                    gr_enemies.get(0).move();
                }
                for (int i = 0; i < enemyButtons.size(); i++) {
                    remove(enemyButtons.get(i));
                    repaint();

                }
                repaint();
                enemyButtons.clear();
                repaint();
                try {
                    in1.close();


                } catch (IOException ex) {
                    Logger.getLogger(Ground.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                frame.setVisible(false);
                setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Exit.setToolTipText(" By clicking on this you will back to main page ");
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        menuBar.add(Exit);
        return menuBar;

    }
}