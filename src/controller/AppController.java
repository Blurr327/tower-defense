package controller;

import model.AppModel;
import model.gamelogic.GameModel;
import view.AppView;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * this class is responsible for switching between the menu, settings and game modes
 */
public class AppController {
    private AppModel model;
    private AppView view;

    public AppController(AppModel model){
        this.model = model;
    }

    public void switchTo(AppModel.AppMode g){
        AppModel.setAppMode(g);
        view.updateCard();
        view.getAppContainer().getGameView().requestFocusInWindow();
        if(g == AppModel.AppMode.MENU || g == AppModel.AppMode.SETTINGS)
            GameController.stopUpdateLoop();
        //else if(g == AppModel.AppMode.GAME)
        // if the game is switched to, show a temporary message to the user telling them how to un/pause the game
           // showTemporaryMessage();


    }

    public void runRenderLoop(){
        int delay = ((int) (1000/AppView.getFPS())); // delay for 120 frames per second
        // Set up Timer for rendering (120 frames per second)
        Timer renderTimer = new Timer(delay, e -> view.getAppContainer().repaint());
        renderTimer.start();
    }
    
    public void showTemporaryMessage() {
        final JOptionPane optionPane = new JOptionPane("Press esc to un/pause", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);

        final JDialog dialog = new JDialog();
        dialog.setTitle("Message");
        dialog.setModal(true);

        dialog.setContentPane(optionPane);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();

        // Set timer to hide dialog after 2.5 seconds
        Timer timer = new Timer(2500, e -> dialog.setVisible(false));
        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);
    }


    public void runLoops(){
        runRenderLoop();

    }

    public void setModel(AppModel model) {
        this.model = model;
    }

    public void setView(AppView view) {
        this.view = view;
    }

    

}
