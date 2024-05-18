package io.codelex;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class TriviaGame {
    Random random = new Random();
    private final TriviaStringGenerator stringGenerator;

    public TriviaGame(TriviaStringGenerator stringGenerator) {
        this.stringGenerator = stringGenerator;
    }

    public void play() {
        int correctGuesses = 0;

        System.out.println("Let's play a Trivia game. You will be given a question and 4 possible choices for answer.");
        System.out.println("One of them is correct. Let's start!\n");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            final int MAX_QUESTIONS = 20;
            Optional<String> triviaStringOptional = stringGenerator.generateTriviaString();
            TriviaQuestion question = new TriviaQuestion(triviaStringOptional.orElse(null));

            printQuestion(question);
            String[] choices = getChoices(question);
            printChoices(choices);
            String userAnswer = scanner.nextLine();

            if (isCorrectAnswer(question, userAnswer)) {
                correctGuesses++;
            } else {
                System.out.println("Wrong!");
                System.out.println(question.getQuestion());
                System.out.println("Correct answer is " + question.getCorrectAnswer());
                break;
            }
            if (correctGuesses == MAX_QUESTIONS) {
                break;
            }
        }
        System.out.println("Game is over! You have successfully answered to " + correctGuesses + " questions.");
    }

    private void printQuestion(TriviaQuestion question) {
        System.out.println(question.getQuestion());
        System.out.print("Please choose one of the answers: ");
    }

    private String[] getChoices(TriviaQuestion question) {
        String[] choices = new String[4];
        for (int i = 0; i < choices.length; i++) {
            choices[i] = String.valueOf(random.nextInt(500));
        }
        choices[random.nextInt(4)] = question.getCorrectAnswer();
        return choices;
    }

    private void printChoices(String[] choices) {
        for (String choice : choices) {
            System.out.print(choice + " ");
        }
        System.out.println();
        System.out.print("> ");
    }

    private boolean isCorrectAnswer(TriviaQuestion question, String userAnswer) {
        return userAnswer.equalsIgnoreCase(question.getCorrectAnswer());
    }
}