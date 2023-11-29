package controller;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class CardController {
    private final JPanel cardContainer;
    private final CardLayout cardLayout;

    public CardController(JPanel cardContainer) {
        this.cardContainer = cardContainer;
        this.cardLayout = (CardLayout) cardContainer.getLayout();
    }

    public void addCard(JPanel card, String name) {
        cardContainer.add(card, name);
    }

    public void showCard(String name) {
        cardLayout.show(cardContainer, name);
    }
}