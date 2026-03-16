package com.peblo.QuizEngine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peblo.QuizEngine.model.Chunk;

public interface ChunkRepo extends JpaRepository<Chunk, Long> {
    
}
