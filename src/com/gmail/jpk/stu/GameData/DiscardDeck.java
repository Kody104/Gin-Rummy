package com.gmail.jpk.stu.GameData;

import java.util.ArrayList;
import java.util.List;

public class DiscardDeck {
	
	private List<Card> discards;
	
	public DiscardDeck() {
		discards = new ArrayList<Card>();
	}
	
	public void AddCard(Card c) {
		discards.add(c);
	}
	
	public void DrawLastCard() {
		if(!discards.isEmpty()) {
			discards.remove(discards.size()-1);
		}
	}
	
	public Card getLastCard() {
		if(discards.isEmpty()) {
			return null;
		}
		return discards.get(discards.size()-1);
	}
}
