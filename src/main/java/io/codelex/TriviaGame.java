package io.codelex;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TriviaGame {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    private static final String TRIVIA_API_URL = "http://numbersapi.com/random/trivia";


    public static void main(String[] args) throws IOException {
        Integer randomNum = random.nextInt(300);
        System.out.println(randomNum);
        TriviaStringGenerator generator = new TriviaStringGenerator(TRIVIA_API_URL);
        TriviaQuestion question = new TriviaQuestion(generator.generateTriviaString());
        System.out.println(question.getQuestion());
        System.out.println(question.getCorrectAnswer());
    }


}