package model.towers;

import java.util.ArrayList;

public class TowerFactory {
    public static final ArrayList<TowerModel> allTowers = new ArrayList<TowerModel>();

    static {
        allTowers.add(new ElGatoModel());
    }

    public static ArrayList<TowerModel> getTowersByCost(int cost){
        ArrayList<TowerModel> towers = new ArrayList<TowerModel>();
        for(TowerModel tower : allTowers){
            if(tower.getCost() <= cost){
                towers.add(tower);
            }
        }
        return towers;
    }

    public static int getNumberOfTowers(){
        return allTowers.size();
    }

    public static TowerModel getTowerByIndex(int index){
        return allTowers.get(index);
    }
}
