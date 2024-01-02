package model.enemies;

import java.util.ArrayList;
import java.util.Random;

/*
 *  EnemyFactory handles the creation, categorization and storage of enemies
 */
public class EnemyFactory {
    public static final ArrayList<EnemyModel> enemiesATier = new ArrayList<>();
    public static final ArrayList<EnemyModel> enemiesBTier = new ArrayList<>();
    public static final ArrayList<EnemyModel> enemiesCTier = new ArrayList<>();

    static {
        add(new MrBlobModel());
        add(new MrSlimeModel());
        add(new MrSnakeModel());
    }

    public static void add(EnemyModel enemy){
        switch (enemy.getTier()){
            case A:
                enemiesATier.add(enemy);
                break;
            case B:
                enemiesBTier.add(enemy);
                break;
            case C:
                enemiesCTier.add(enemy);
                break;
        }
    }

    public static EnemyModel createRandomCTierEnemy(){
        Random rand = new Random();
        return enemiesCTier.get(rand.nextInt(enemiesCTier.size())).newInstance();
    }  

    public static EnemyModel createRandomBTierEnemy(){
        Random rand = new Random();
        return enemiesBTier.get(rand.nextInt(enemiesBTier.size())).newInstance();
    }

    public static EnemyModel createRandomATierEnemy(){
        Random rand = new Random();
        return enemiesATier.get(rand.nextInt(enemiesATier.size())).newInstance();
    }
    
}
