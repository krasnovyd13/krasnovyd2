package com.example.myapplication;

public class WordCharCounter {
    // Method to count words in the input text
    public int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        // Words are separated by spaces, commas, or dots
        String[] words = input.trim().split("[\\s,\\.]+");
        return words.length;
    }

    // Method to count characters in the input text
    public int countCharacters(String input) {
        if (input == null) {
            return 0;
        }
        return input.length();
    }
}
