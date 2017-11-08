package GameMap;

import java.util.ArrayList;
import Item.*;

/**
 *
 * @author Mahsa1
 */
public class Map {

    public ArrayList<Ground> map;
    private Ground ground;
    int[][] wg;

    public Map() {
        map = new ArrayList<Ground>();
        wg = new int[20][19];
        wg[0][1] = 1;
        Ground g01 = new Ground(0, 1, 0, 2, 4, false);
        g01.setGr_itemes(new FireArrow());
        g01.setGr_itemes(new BigArrow());
        g01.setGr_itemes(new BigHealthPotion());
        g01.setGr_itemes(new ReviveScroll());
        map.add(g01);
        wg[1][1] = 1;
        Ground g00 = new Ground(1, 1, 0, 2, 0, false);
        map.add(g00);
        wg[1][2] = 1;
        map.add(new Ground(1, 2, 1, 0, 1, false));
        wg[1][3] = 1;
        Ground g1 = new Ground(1, 3, 1, 0, 3, false);
        g1.setGr_itemes(new Key(2));
        g1.setGr_itemes(new EnergyPotion());
        g1.setGr_itemes(new SmallArrow());
        map.add(g1);
        wg[1][4] = 1;
        Ground g2 = new Ground(1, 4, 1, 2, 0, false);
        map.add(g2);
        wg[1][5] = 1;
        Ground g3 = new Ground(1, 5, 1, 0, 3, false);
        g3.setGr_itemes(new BigHealthPotion());
        g3.setGr_itemes(new SmallHealthPotion());
        g3.setGr_itemes(new Hawk());
        map.add(g3);
        wg[1][6] = 1;
        Ground g4 = new Ground(1, 6, 2, 1, 2, false);
        g4.setGr_itemes(new FireArrow());
        g4.setGr_itemes(new Shovel());
        map.add(g4);
        wg[2][6] = 1;
        Ground g5 = new Ground(2, 6, 2, 1, 2, false);
        g5.setGr_itemes(new BigArrow());
        g5.setGr_itemes(new BigHealthPotion());
        map.add(g5);
        wg[3][6] = 1;
        Ground g6 = new Ground(3, 6, 2, 0, 2, false);
        g6.setGr_itemes(new SmallHealthPotion());
        g6.setGr_itemes(new StoneBreaker());
        map.add(g6);
        wg[4][6] = 1;
        Ground g7 = new Ground(4, 6, 2, 0, 2, false);
        g7.setGr_itemes(new BigHealthPotion());
        g7.setGr_itemes(new BigBag());
        map.add(g7);
        wg[5][6] = 1;
        Ground g8 = new Ground(5, 6, 2, 0, 1, false);
        g8.setGr_itemes(new SmallArrow());
        map.add(g8);
        wg[6][6] = 1;
        Ground g9 = new Ground(6, 6, 2, 1, 0, true);
        g9.setGr_chestNum(3);
        g9.setGr_chest(new FireArrow());
        map.add(g9);
        wg[7][6] = 1;
        Ground g10 = new Ground(7, 6, 2, 0, 2, false);
        g10.setGr_itemes(new EnergyPotion());
        g10.setGr_itemes(new FireArrow());
        map.add(g10);
        wg[8][6] = 1;
        Ground g11 = new Ground(8, 6, 2, 1, 1, false);
        g11.setGr_itemes(new BigHealthPotion());
        map.add(g11);
        wg[9][6] = 1;
        Ground g12 = new Ground(9, 6, 2, 2, 3, false);
        g12.setGr_itemes(new Hawk());
        g12.setGr_itemes(new Shovel());
        g12.setGr_itemes(new StoneBreaker());
        map.add(g12);
        wg[10][6] = 1;
        Ground g13 = new Ground(10, 6, 3, 0, 3, false);
        g13.setGr_itemes(new BigHealthPotion());
        g13.setGr_itemes(new ReviveScroll());
        g13.setGr_itemes(new Key(1));
        map.add(g13);
        wg[10][7] = 1;
        Ground g14 = new Ground(10, 7, 3, 0, 2, false);
        g14.setGr_itemes(new BigArrow());
        g14.setGr_itemes(new Hawk());
        map.add(g14);
        wg[10][8] = 1;
        Ground g15 = new Ground(10, 8, 3, 1, 1, false);
        g15.setGr_itemes(new SmallArrow());
        map.add(g15);
        wg[10][9] = 1;
        Ground g16 = new Ground(10, 9, 3, 0, 1, false);
        g16.setGr_itemes(new StoneBreaker());
        map.add(g16);
        wg[10][10] = 1;
        Ground g17 = new Ground(10, 10, 3, 0, 2, false);
        g17.setGr_itemes(new EnergyPotion());
        g17.setGr_itemes(new BigArrow());
        map.add(g17);
        wg[10][11] = 1;
        Ground g18 = new Ground(10, 11, 3, 3, 0, true);
        g18.setGr_itemes(new EnergyPotion());
        g18.setGr_chestNum(1);
        g18.setGr_chest(new BigBag());
        g18.setGr_chest(new SmallHealthPotion());
        map.add(g18);
        wg[10][12] = 1;
        Ground g19 = new Ground(10, 12, 4, 0, 1, false);
        g19.setGr_itemes(new Hawk());
        map.add(g19);
        wg[11][12] = 1;
        Ground g20 = new Ground(11, 12, 4, 0, 3, false);
        g20.setGr_itemes(new SmallArrow());
        g20.setGr_itemes(new FireArrow());
        g20.setGr_itemes(new Shovel());
        map.add(g20);
        wg[12][12] = 1;
        Ground g21 = new Ground(12, 12, 5, 2, 2, false);
        g21.setGr_itemes(new SmallHealthPotion());
        g21.setGr_itemes(new StoneBreaker());
        map.add(g21);
        wg[12][13] = 1;
        Ground g22 = new Ground(12, 13, 5, 2, 1, true);
        g22.setGr_itemes(new EnergyPotion());
        g22.setGr_chestNum(2);
        g22.setGr_chest(new Hawk());
        g22.setGr_chest(new StoneBreaker());
        map.add(g22);
        wg[12][14] = 1;
        Ground g23 = new Ground(12, 14, 6, 0, 3, false);
        g23.setGr_itemes(new BigHealthPotion());
        g23.setGr_itemes(new BigArrow());
        g23.setGr_itemes(new ReviveScroll());
        map.add(g23);
        wg[11][14] = 1;
        Ground g24 = new Ground(11, 14, 6, 0, 2, false);
        g24.setGr_itemes(new Shovel());
        g24.setGr_itemes(new BigBag());
        map.add(g24);
        wg[10][14] = 1;
        Ground g25 = new Ground(10, 14, 6, 0, 2, false);
        g25.setGr_itemes(new EnergyPotion());
        g25.setGr_itemes(new FireArrow());
        map.add(g25);
        wg[9][14] = 1;
        Ground g26 = new Ground(9, 14, 7, 1, 0, false);
        map.add(g26);
        wg[9][15] = 1;
        Ground g27 = new Ground(9, 15, 8, 0, 1, false);
        g27.setGr_itemes(new SmallArrow());
        map.add(g27);
        wg[8][15] = 1;
        Ground g28 = new Ground(8, 15, 8, 0, 2, false);
        g28.setGr_itemes(new SmallHealthPotion());
        g28.setGr_itemes(new Key(3));
        map.add(g28);
        wg[7][15] = 1;
        Ground g29 = new Ground(7, 15, 8, 1, 0, false);
        map.add(g29);
        wg[6][15] = 1;
        Ground g30 = new Ground(6, 15, 9, 0, 1, false);
        g30.setGr_itemes(new Hawk());
        map.add(g30);
        wg[6][16] = 1;
        Ground g31 = new Ground(6, 16, 9, 3, 0, false);
        map.add(g31);
        //setting enemies
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).getEnemyNum(); j++) {
                map.get(i).setGr_Enemy(new Enemy(this));
            }
        }
    }

    public int groundOrWall(int x, int y) {
        if (wg[x][y] == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public Ground getGround(int x, int y) {
        if (groundOrWall(x, y) == 1) {
            for (Ground ground : map) {
                if ((ground.getX() == x) && (ground.getY() == y)) {
                    return ground;
                }
            }
        } else {
            System.out.println("Wall");
        }
        return null;
    }

    public void mapAddGround(int x, int y, Ground ground) {
        wg[x][y] = 1;
        map.add(ground);
    }

    public ArrayList<Ground> get_map() {
        return map;
    }
}
