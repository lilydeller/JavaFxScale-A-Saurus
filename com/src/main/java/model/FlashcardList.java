package model;
import java.util.ArrayList;
import java.util.UUID;
public class FlashcardList {
    private static FlashcardList instance;
    private ArrayList<Flashcard> flashcards;

    private FlashcardList() {
        flashcards = new ArrayList<>();
    }

    public static FlashcardList getInstance() {
        if (instance == null) {
            instance = new FlashcardList();
        }
        return instance;
    }

    public void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

    public ArrayList<Flashcard> getFlashcards() {
        return flashcards;
    }

    public boolean removeFlashcard(UUID flashcardID) {
        for (int i = 0; i < flashcards.size(); i++) {
            if (flashcards.get(i).getFlashcardID().equals(flashcardID)) {
                flashcards.remove(i);
                return true; //removed without error
            }
        }
        return false; //flashcard not found 
    }
    
}
