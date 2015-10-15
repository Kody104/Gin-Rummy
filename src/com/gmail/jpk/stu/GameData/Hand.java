package com.gmail.jpk.stu.GameData;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	private List<Card> heldCards;
	private boolean isTurn;
	
	public Hand() {
		heldCards = new ArrayList<Card>();
	}
	
	public void DrawCard(Card c) {
		heldCards.add(c);
	}
	
	public void DiscardCard(Card c) {
		heldCards.remove(c);
	}
	
	public Card getCard(int i) {
		if(!(i > (heldCards.size()-1) && !(i < 0))) {
			return heldCards.get(i);
		}
		else {
			return null;
		}
	}
	
	public Card getCard(String facevalue) {
		for(Card c : heldCards) {
			if(c.getFaceValue().equalsIgnoreCase(facevalue)) {
				return c;
			}
		}
		return null;
	}
	
	public int getHeldCardLength() {
		return heldCards.size();
	}
	
	public void setIsTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}
	
	public boolean getIsTurn() {
		return isTurn;
	}
}
