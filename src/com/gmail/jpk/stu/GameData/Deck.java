package com.gmail.jpk.stu.GameData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gmail.jpk.stu.GameData.Card.Rank;
import com.gmail.jpk.stu.GameData.Card.Suit;


public class Deck {
	
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
		for(int i = 0; i < 52; i++) {
			Card c = new Card(Suit.values()[i / 13], Rank.values()[i % 13]); // Divides by 13 because 13 ranks to each suit.
			cards.add(c);
		}
	}
	
	public void Shuffle() {
		Random r = new Random();
		List<Card> temp = new ArrayList<Card>(); // Temporary shuffled deck
		while(!cards.isEmpty()) {
			int rand = r.nextInt(cards.size());
			temp.add(cards.get(rand)); // Adding cards to shuffled deck
			cards.remove(rand); // Removing cards from current deck
		}
		cards = temp; // Current deck becomes the shuffled deck
	}
	
	public Card DrawTopCard() {
		Card out = cards.get(0);
		cards.remove(0);
		return out;
	}
}
