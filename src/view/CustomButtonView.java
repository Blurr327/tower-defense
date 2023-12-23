package view;

import javax.swing.JButton;

/*
 * this class is used to create a custom button that we can reuse everywhere in the application
 *
 */

public class CustomButtonView extends JButton{
    JButton button;

    public CustomButtonView(String s){
        super(s);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
    }
}
