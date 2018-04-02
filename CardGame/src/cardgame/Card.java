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
public class Card {
    private Face face; // 2, 3, 4, 5..., Jack, Queen, King, Ace
    private Suit suit; // Hearts, Diamonds, Clubs, Spades

    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }
    
    
}
