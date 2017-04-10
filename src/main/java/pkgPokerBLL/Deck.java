package pkgPokerBLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import PkgException.DeckException;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class Deck {

	private UUID DeckID;
	private ArrayList<Card> DeckCards = new ArrayList<Card>();
	
	public Deck() {

		super();
		int iCardNbr = 0;
		for (eSuit suit : eSuit.values()) {
			for (eRank rank : eRank.values()) {
				//if ((suit != eSuit.JOKER) && (rank != eRank.JOKER)) {
					DeckCards.add(new Card(rank, suit, ++iCardNbr));
				//}
			}
		}
		Collections.shuffle(DeckCards);
	}
	
	public Deck(Card card) {
		if ((card.geteSuit() != eSuit.JOKER) && (card.geteRank() != eRank.JOKER)) {
			DeckCards.add(new Card(card.geteRank(), card.geteSuit(), DeckCards.size()));
		}
		
	}

	public Card DrawCard() {
		if(DeckCards.size() < 1){
			try {
				throw new DeckException("No more cards!");
			} catch (DeckException e) {
				e.printStackTrace();
				return null;
			}
			
		}
		return DeckCards.remove(0);
	}
}
