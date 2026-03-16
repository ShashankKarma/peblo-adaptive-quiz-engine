package com.peblo.QuizEngine.controller;

import com.peblo.QuizEngine.model.Chunk;
import com.peblo.QuizEngine.service.ChunkService;
import com.peblo.QuizEngine.utility.PdfExtractor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IngestController {

    private final ChunkService chunkService;

    public IngestController(ChunkService chunkService) {
        this.chunkService = chunkService;
    }

    @PostMapping("/ingest")
    public List<Chunk> ingestPdf(@RequestParam String path,
                                 @RequestParam int grade,
                                 @RequestParam String subject,
                                 @RequestParam String topic) {

        String text = PdfExtractor.extractText(path);

        return chunkService.processAndStoreChunks(
                text,
                "SRC_" + System.currentTimeMillis(),
                grade,
                subject,
                topic
        );
    }
}