/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danya
 */
import java.util.ArrayList;
import java.util.Collections;
public class Hand implements Comparable<Hand> {
    private ArrayList<Card> hand;
    
    public Hand() {
        this.hand = new ArrayList<Card>();
    }
    
    public void add(Card card) {
        this.hand.add(card);
    }
    
    public void print() {
        for(Card card : this.hand) {
            System.out.println(card);
        }
    }
    
    public void sort() {
        Collections.sort(this.hand);
    }
    
    public int getTotalValue() {
        int totalValue = 0;
        for(Card card : this.hand) {
            totalValue += card.getValue();
        }
        return totalValue;
    }
    
    public void sortAgainstSuit() {
        Collections.sort(hand, new SortAgainstSuitAndValue() );
    }
    
    @Override
    public int compareTo(Hand hand2) {
        return this.getTotalValue() - hand2.getTotalValue();
    }
    
}
