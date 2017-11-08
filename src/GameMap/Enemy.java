package GameMap;

public class Enemy {
    
    private Ground firstG, afterMoveG;
    private Map emap;
    
    public Enemy(Map map) {
        emap = map;
    }
    
    public void setGround(Ground ground) {
        
        firstG = ground;
    }
    
    public void move() {
        
        int index = emap.map.indexOf(firstG);
        if (index < emap.map.size() - 1) {
            afterMoveG = emap.map.get(index + 1);
            if(afterMoveG.getEnemyNum()<3){
            firstG.removeEnemy(this);            
            afterMoveG.setEnemyNum(1);
             afterMoveG.setGr_Enemy(this);
            }
        }   
    }
}
