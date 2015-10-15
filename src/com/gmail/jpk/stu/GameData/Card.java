package com.gmail.jpk.stu.GameData;

public class Card {
	
	public enum Suit {
		Hearts, Diamonds, Clubs, Spades;  // The card's suit
	}
	
	public enum Rank {
		Ace("a"), Two("2"), Three("3"), Four("4"), Five("5"), Six("6"), Seven("7"), Eight("8"), Nine("9"), Ten("10"), Jack("j"), Queen("q"), King("k"); // The card's rank
		
		private String face;
		
		Rank(String face) {
			this.face = face;
		}
	}
	
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public String getFaceValue() {
		String out = "";
		out += rank.face;
		switch(suit) {
		case Hearts:
			out += "H";
			break;
		case Diamonds:
			out += "D";
			break;
		case Clubs:
			out += "C";
			break;
		case Spades:
			out += "S";
			break;
		}
		return out;
	}
	
	public boolean CompareTo(Card c) {
		if(this == c) {
			return false;
		}
		if(rank == c.getRank()) {
			return true;
		}
		return false;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Rank getRank() {
		return rank;
	}
}
