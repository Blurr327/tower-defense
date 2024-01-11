package model.towers;

import java.util.ArrayList;
import java.util.Iterator;

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

    public static Iterator<TowerModel> getTowerIterator(){
        return allTowers.iterator();
    }

    public static void resetStats(){
        allTowers.forEach(tower -> tower.resetStats());
    }
    
}
