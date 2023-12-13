package view;

import javax.swing.JButton;

public class CustomButtonView extends JButton{
    JButton button;

    public CustomButtonView(String s){
        super(s);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
    }
}
