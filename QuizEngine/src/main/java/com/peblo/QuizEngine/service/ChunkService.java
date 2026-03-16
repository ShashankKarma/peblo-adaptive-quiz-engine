package com.peblo.QuizEngine.service;

import com.peblo.QuizEngine.model.Chunk;
import com.peblo.QuizEngine.repository.ChunkRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChunkService {

    private final ChunkRepo chunkRepository;

    public ChunkService(ChunkRepo chunkRepository) {
        this.chunkRepository = chunkRepository;
    }

    public List<Chunk> processAndStoreChunks(String text,
                                             String sourceId,
                                             int grade,
                                             String subject,
                                             String topic) {

        text = cleanText(text);

        int chunkSize = 500;

        List<Chunk> savedChunks = new ArrayList<>();

        int chunkCounter = 1;

        for (int i = 0; i < text.length(); i += chunkSize) {

            int end = Math.min(i + chunkSize, text.length());

            String chunkText = text.substring(i, end);

            Chunk chunk = new Chunk();

            chunk.setSourceId(sourceId);
            chunk.setChunkId(sourceId + "_CH_" + chunkCounter);
            chunk.setGrade(grade);
            chunk.setSubject(subject);
            chunk.setTopic(topic);
            chunk.setText(chunkText);

            savedChunks.add(chunkRepository.save(chunk));

            chunkCounter++;
        }

        return savedChunks;
    }

    private String cleanText(String text) {

        text = text.replaceAll("\\s+", " ");
        text = text.replaceAll("[^a-zA-Z0-9.,!? ]", "");

        return text;
    }
}