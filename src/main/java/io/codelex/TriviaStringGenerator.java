package io.codelex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

public class TriviaStringGenerator {
    private final String triviaApiUrl;

    public TriviaStringGenerator(String triviaApiUrl) {
        this.triviaApiUrl = triviaApiUrl;
    }

    public Optional<String> generateTriviaString() {
        try {
            URL url = new URI(triviaApiUrl).toURL();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                return Optional.ofNullable(reader.readLine());
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
