package model.towers;

import java.util.ArrayList;

public class TowerFactory {
    public static final ArrayList<TowerModel> allTowers = new ArrayList<TowerModel>();

    static {
        allTowers.add(new ElGatoModel());
        allTowers.add(new GoesBrrrrrrrModel());
        allTowers.add(new SteveModel());
    }

    public static int getNumberOfTowers(){
        return allTowers.size();
    }

    public static TowerModel getTowerByIndex(int index){
        return allTowers.get(index);
    }
}
