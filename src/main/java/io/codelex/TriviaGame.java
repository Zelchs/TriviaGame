package io.codelex;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class TriviaGame {
    Random random = new Random();
    private final TriviaStringGenerator stringGenerator;
    private int correctGuesses;


    public TriviaGame(TriviaStringGenerator stringGenerator) {
        this.stringGenerator = stringGenerator;
        this.correctGuesses = 0;
    }

    public void play() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's play a Trivia game. You will be given a question and 4 possible choices for answer.");
        System.out.println("One of them is correct. Let's start!\n");


        String userAnswer;
        TriviaQuestion question;
        while (true) {
            String[] choices = new String[4];
            for (int i = 0; i < choices.length; i++) {
                choices[i] = String.valueOf(random.nextInt(500));
            }
            question = new TriviaQuestion(stringGenerator.generateTriviaString());
            choices[random.nextInt(4)] = question.getCorrectAnswer();
            System.out.println(question.getQuestion());
            System.out.print("Please choose one of the answers: ");
            for (String choice : choices) {
                System.out.print(choice + " ");
            }
            System.out.println();
            System.out.print("> ");
            userAnswer = scanner.nextLine();

            int maxQuestions = 20;
            if (!isCorrectAnswer(question, userAnswer) || correctGuesses == maxQuestions) {
                break;
            }
        }
        System.out.println("Game is over! You have successfully answered to " + correctGuesses + " questions.");
    }

    private boolean isCorrectAnswer(TriviaQuestion question, String userAnswer) {
        if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
            System.out.println("Correct!\n");
            correctGuesses++;
            return true;
        } else {
            System.out.println("Wrong!");
            System.out.println(question.getQuestion() + " Correct answer is " + question.getCorrectAnswer() + "\n");
            return false;
        }
    }
}