package com.peblo.QuizEngine.service;

import com.peblo.QuizEngine.model.Question;
import com.peblo.QuizEngine.model.StudentAnswer;
import com.peblo.QuizEngine.repository.QuestionRepository;
import com.peblo.QuizEngine.repository.StudentAnswerRepository;
import com.peblo.QuizEngine.model.Chunk;
import com.peblo.QuizEngine.repository.ChunkRepo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuestionRepository questionRepository;
    private final StudentAnswerRepository studentAnswerRepository;

    private final ChunkRepo chunkrepository;
    private final AIservice aiService;

    public QuizService(
            QuestionRepository questionRepository,
            StudentAnswerRepository studentAnswerRepository,
            ChunkRepo chunkrepository, AIservice aiService) {

        this.questionRepository = questionRepository;
        this.studentAnswerRepository = studentAnswerRepository;
        this.chunkrepository = chunkrepository;
        this.aiService = aiService;
    }

  

    public void generateQuizQuestions() {

        List<Chunk> chunks = chunkrepository.findAll();
    
        for (Chunk chunk : chunks) {
    
            String aiResponse =
                    aiService.generateQuestions(chunk.getText());
    
            Question question = new Question();
    
            question.setQuestion(aiResponse);
            question.setType("MCQ");
            question.setDifficulty("easy");
            question.setSourceChunkId(chunk.getChunkId());
    
            questionRepository.save(question);
        }
    
        System.out.println("Quiz questions generated from chunks");
    }

  

    public StudentAnswer submitAnswer(String studentId,Long questionId,String selectedAnswer) {

        Question question =
                questionRepository.findById(questionId).orElseThrow();

        boolean correct =
                question.getAnswer().equalsIgnoreCase(selectedAnswer);

        StudentAnswer answer = new StudentAnswer();

        answer.setStudentId(studentId);
        answer.setQuestionId(questionId);
        answer.setSelectedAnswer(selectedAnswer);
        answer.setCorrect(correct);

        studentAnswerRepository.save(answer);

        return answer;
    }
}