package io.codelex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class TriviaStringGenerator {

    private final String triviaApiUrl;

    public TriviaStringGenerator(String triviaApiUrl) {
        this.triviaApiUrl = triviaApiUrl;
    }

    public String generateTriviaString() throws IOException {
        URL url = URI.create(triviaApiUrl).toURL();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.readLine();
        }

    }
}
