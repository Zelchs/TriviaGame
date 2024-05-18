package io.codelex;

public class TriviaQuestion {
    private final String question;
    private final String correctAnswer;

    public TriviaQuestion(String triviaString) {
        if (triviaString != null && !triviaString.isEmpty()) {
            int indexOfSpace = triviaString.indexOf(" ");
            if (indexOfSpace != -1) {
                this.question = "What" + triviaString.substring(indexOfSpace) + "?";
                this.correctAnswer = triviaString.substring(0, indexOfSpace);
            } else {
                this.question = null;
                this.correctAnswer = null;
            }
        } else {
            this.question = null;
            this.correctAnswer = null;
        }
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
