package view;

import java.util.ArrayList;

import javax.swing.JButton;

public class IconButtonsHelper<T extends Iconable> {
    
    private ArrayList<T> componentArray;
    private JButton[] iconButtons;

    public IconButtonsHelper(ArrayList<T> componentArray) {
        this.componentArray = componentArray;
    }

    public void setIconButtons() {
        for (int i = 0; i < componentArray.size(); i++) {
            iconButtons[i] = new JButton(componentArray.get(i).getIcon(i));
        }
    }

    
}
