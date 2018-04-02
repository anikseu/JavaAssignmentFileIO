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
public class PokerHand {
    // https://www.partypoker.com/how-to-play/hand-rankings.html
    private Card[] cards;

    public PokerHand() {
        cards = new Card[5];
    }
    
    public void addCard(Card card, int index) {
        cards[index] = card;
    }
    
    public HandType getHandType() {
        // ADD YOUR CODE HERE
        // Here is an example of how you can detect
        // four of a kind
        int[] counter = new int[Face.values().length];
        
        for (int i = 0; i < cards.length; i++) {
            Face face = cards[i].getFace();
            int index = face.ordinal();
            counter[index]++;
        }
        
        for (int i = 0; i < counter.length; i++)
            if (counter[i] == 4)
                return HandType.FOUR_OF_A_KIND;
        
        return null;
    }
    
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < cards.length; i++)
            output = output + cards[i] + "\n";
        return output;
    }
}
