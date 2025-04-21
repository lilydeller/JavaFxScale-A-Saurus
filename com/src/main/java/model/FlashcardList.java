package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/*
 * list of flashcards 
 */
public class FlashcardList {
    private static FlashcardList instance;
    private ArrayList<Flashcard> flashcards;

    /*
     * creates singlton FlashcardList
     */
    private FlashcardList() {
        flashcards = new ArrayList<>();
    }

    /*
     * gets instance of singleton FlashcardList
     * @return instance
     */
    public static FlashcardList getInstance() {
        if (instance == null) {
            instance = new FlashcardList();
        }
        return instance;
    }

    /*
     * adds flashcard to flashcards list
     * @param flashcard
     */
    public void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

    /*
     * getter method
     * @return flashcards
     */
    public ArrayList<Flashcard> getFlashcards() {
        return flashcards;
    }


    /*
     * removes flashcard
     * @param flashcardID
     * @return flashcard.remove if flashcard exists
     */
    public boolean removeFlashcard(UUID flashcardID) {
        return flashcards.removeIf(f -> f.getFlashcardID().equals(flashcardID));
    }

    /*
     * load flashcards from json 
     */
    public void loadFlashcards() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("json/flashcard.json")) {
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray chaptersArray = (JSONArray) root.get("chapters");

            for (Object chapterObj : chaptersArray) {
                JSONObject chapterJson = (JSONObject) chapterObj;
                String chapterID = (String) chapterJson.get("chapterID");
                JSONArray flashcardArray = (JSONArray) chapterJson.get("flashcards");
    
                for (Object flashcardObj : flashcardArray) {
                    JSONObject flashcardJson = (JSONObject) flashcardObj;
    
                    UUID id = UUID.fromString((String) flashcardJson.get("flashcardID"));
                    String question = (String) flashcardJson.get("question");
                    String answer = (String) flashcardJson.get("answer");
    
                    Flashcard flashcard = new Flashcard(id, question, answer, chapterID);
                    FlashcardList.getInstance().addFlashcard(flashcard);
                }
            }
    
            System.out.println("Flashcards Loaded: " + FlashcardList.getInstance().getFlashcards().size());
    
        } catch (IOException | ParseException e) {
            System.out.println("Error loading flashcards");
            e.printStackTrace();
        }
    }
}
    
