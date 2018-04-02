/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

/**
 *
 * @author kmhasan
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PokerHand hand1 = new PokerHand();
        
        hand1.addCard(new Card(Face.FIVE, Suit.DIAMONDS), 0);
        hand1.addCard(new Card(Face.SIX, Suit.DIAMONDS), 1);
        hand1.addCard(new Card(Face.FIVE, Suit.HEARTS), 2);
        hand1.addCard(new Card(Face.FIVE, Suit.CLUBS), 3);
        hand1.addCard(new Card(Face.FIVE, Suit.SPADES), 4);
        
        System.out.println(hand1);
        
        System.out.println(hand1.getHandType());
    }
    
}
