package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
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
        return flashcards.removeIf(f -> f.getFlashcardID().equals(flashcardID));
    }

    public void loadFlashcards() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("json/flashcard.json")) {
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray flashcardArray = (JSONArray) root.get("flashcards");

            for (Object obj : flashcardArray) {
                JSONObject card = (JSONObject) obj;
                UUID id = UUID.fromString((String) card.get("flashcardID"));
                String question = (String) card.get("question");
                String answer = (String) card.get("answer");

                Flashcard flashcard = new Flashcard(question, answer);
             
                flashcards.add(flashcard);
            }

            System.out.println("Flashcards loaded: " + flashcards.size());
        } catch (IOException | ParseException e) {
            System.out.println(" Error loading flashcards: " + e.getMessage());
        }
    }
}
