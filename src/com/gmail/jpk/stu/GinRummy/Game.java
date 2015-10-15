package com.gmail.jpk.stu.GinRummy;

import java.util.Scanner;

import com.gmail.jpk.stu.GameData.Deck;
import com.gmail.jpk.stu.GameData.DiscardDeck;
import com.gmail.jpk.stu.GameData.Hand;

public class Game {
	
	private Scanner scan;
	private Hand player;
	private Hand computer;
	private Deck deck;
	private DiscardDeck discardDeck;
	private boolean runGame;
	
	public Game() {
		scan = new Scanner(System.in);
		player = new Hand();
		computer = new Hand();
		deck = new Deck();
		discardDeck = new DiscardDeck();
	}
	
	public void Start() {
		deck.Shuffle();
		for(int i = 1; i < 22; i++) { // Draw their first 10 cards and add card to discard deck
			if(i == 21) { // Adds last card to discard pile
				discardDeck.AddCard(deck.DrawTopCard());
			}
			else if(i % 2 == 0) { // Gives 1 to computer, then one to player. Alternates.
				computer.DrawCard(deck.DrawTopCard());
			}
			else {
				player.DrawCard(deck.DrawTopCard());
			}
		}
		runGame = true;
		player.setIsTurn(true);
		while(runGame) {
			if(player.getIsTurn()) {
				DisplayBoard();
				if(AcceptDrawCommand(scan)) {
				}
			}
			if(computer.getIsTurn()) {
				break;
			}
		}
	}
	
	private void DisplayBoard() {
		if(discardDeck.getLastCard() != null) {
			System.out.println(discardDeck.getLastCard().getFaceValue() + "\n\n");
		}
		for(int i = 0; i < player.getHeldCardLength(); i++) {
			System.out.print(player.getCard(i).getFaceValue() + " ");
		}
		System.out.println();
	}
	
	private boolean AcceptDrawCommand(Scanner scan) {
		String input = scan.nextLine();
		if(input.equalsIgnoreCase("deck draw") || input.equalsIgnoreCase("dd")) {
			player.DrawCard(deck.DrawTopCard());
			DisplayBoard();
			System.out.print("Type the card you want to discard: ");
			input = scan.next();
			if(player.getCard(input) != null) {
				discardDeck.AddCard(player.getCard(input));
				player.DiscardCard(player.getCard(input));
				return true;
			}
			return false;
		}
		return false;
	}
}
