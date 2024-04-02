package io.codelex;

public class Main {
    private static final String TRIVIA_API_URL = "http://numbersapi.com/random/trivia";

    public static void main(String[] args) {

        TriviaGame game = new TriviaGame(new TriviaStringGenerator(TRIVIA_API_URL));
        game.play();

    }
}
