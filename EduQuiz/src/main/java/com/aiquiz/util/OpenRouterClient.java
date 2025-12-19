package com.aiquiz.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenRouterClient {

    private static final String API_URL =
        "https://openrouter.ai/api/v1/chat/completions";

    private static final String API_KEY = "OPENROUTER_API_KEY";

    private static final String MODEL =
        "openai/gpt-3.5-turbo";

    public static String generateQuestions(String topic, String difficulty)
            throws Exception {

        
        String prompt =
            "Generate 10 multiple-choice questions on " + topic +
            " with " + difficulty + " difficulty. " +
            "Each question must have 4 options and one correct answer. " +
            "Return result in JSON format.";

        
        String requestBody = "{"
            + "\"model\":\"" + MODEL + "\","
            + "\"messages\":["
            + "{ \"role\":\"user\", \"content\":\"" + prompt + "\" }"
            + "]"
            + "}";

        
        URL url = new URL(API_URL);
        HttpURLConnection con =
            (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization",
            "Bearer " + API_KEY);
        con.setRequestProperty("Content-Type",
            "application/json");
        con.setDoOutput(true);

        
        try (OutputStream os = con.getOutputStream()) {
            os.write(requestBody.getBytes());
        }

        
        BufferedReader br = new BufferedReader(
            new InputStreamReader(con.getInputStream()));

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line);
        }

        return response.toString(); // JSON from AI
    }
}
