package io.codelex;

public class TriviaQuestion {
    private final String question;
    private final String correctAnswer;

    public TriviaQuestion(String triviaString) {
        int indexOfSpace = triviaString.indexOf(" ");

        this.question = "What" + triviaString.substring(indexOfSpace, triviaString.length() - 1) + "?";
        this.correctAnswer = triviaString.substring(0, indexOfSpace);
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
