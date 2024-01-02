package view.mapviewstates;

import java.awt.Graphics;
import java.util.Iterator;

import model.enemies.EnemyModel;
import model.gamelogic.BaseModel;
import model.map.MapModel;
import model.towers.TowerManagerModel;
import view.AppView;
import view.BaseView;
import view.EnemyView;
import view.TowerView;
import view.helperclasses.MessagesView;
import model.gamelogic.WaveModel;

public class PlayStateView implements MapViewState{
    private static final MessagesView pauseMessage = new MessagesView("Pressing escape will pause/unpause the game");

    @Override
    public void renderState(Graphics g){
        if(pauseMessage.allowedToBeDrawn()) pauseMessage.drawDisappearingMessage(g);
        renderPlayMap(g);
    }

    public void renderPlayMap(Graphics g){
        Iterator<EnemyModel> enemyIterator = WaveModel.getEnemyIterator();
        while(enemyIterator.hasNext()){
            EnemyModel enemy = enemyIterator.next();
            EnemyView.renderEnemy(g, enemy);
            EnemyView.renderEnemyHealth(g, enemy);
        }

        BaseView.renderBase(g, BaseModel.getX(), BaseModel.getY());
        BaseView.renderBaseHealth(g, ((MapModel.WIDTH-1)*AppView.UNIT_SIZE)-75, 10);
        
        renderProjectiles(g);
    }

    public void renderProjectiles(Graphics g){
        for(int i=0;i<TowerManagerModel.getNumberOfTowers();i++){
            TowerView.renderProjectilesOf(g, TowerManagerModel.getTowerByIndex(i));
        }
    }

}
