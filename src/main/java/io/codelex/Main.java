package io.codelex;

import java.io.IOException;

public class Main {
    private static final String TRIVIA_API_URL = "http://numbersapi.com/random/trivia";

    public static void main(String[] args) {
        try {
            TriviaGame game = new TriviaGame(new TriviaStringGenerator(TRIVIA_API_URL));
            game.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
