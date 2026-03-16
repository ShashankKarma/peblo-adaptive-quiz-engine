package com.peblo.QuizEngine.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIservice {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String generateQuestions(String chunkText) {

        String prompt = """
Generate quiz questions from the following educational text.

Create:
1 MCQ
1 True/False
1 Fill in the blank

Return JSON format:

{
 "question": "",
 "type": "",
 "options": [],
 "answer": "",
 "difficulty": "easy"
}

Text:
""" + chunkText;

        String requestBody = """
{
 "contents":[
   {
     "parts":[
       {"text":"%s"}
     ]
   }
 ]
}
""".formatted(prompt);

        String url =
        "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key="
        + apiKey;

        return restTemplate.postForObject(url, requestBody, String.class);
    }
}