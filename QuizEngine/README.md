Peblo Adaptive Quiz Engine

An AI-powered backend service that generates adaptive quizzes from uploaded PDF learning material.

This project ingests PDF documents, extracts text, generates quiz questions using Gemini AI, and evaluates student answers with adaptive difficulty.

⸻

Features

• PDF ingestion and text extraction
• Document chunking for AI processing
• AI-generated quiz questions
• Adaptive quiz difficulty
• Student answer evaluation
• REST API for quiz interaction
• H2 in-memory database for development

⸻

Tech Stack

Backend
• Java 21
• Spring Boot
• Spring Data JPA

AI
• Google Gemini API

Database
• H2 Database

Libraries
• Apache PDFBox (PDF processing)
• Lombok
• Spring Security

⸻

Project Structure

src/main/java/com/peblo/QuizEngine

Config
SecurityConfig.java

Controller
QuizController.java
DocumentController.java

Service
QuizService.java
DocumentService.java
AIService.java

Model
Question.java
StudentAnswer.java
Document.java

Repository
QuestionRepository.java
StudentAnswerRepository.java
DocumentRepository.java

⸻

Setup Instructions

1 Clone the Repository

git clone https://github.com/YOUR_USERNAME/peblo-adaptive-quiz-engine.git

cd peblo-adaptive-quiz-engine

⸻

2 Configure Environment Variables

Create an .env file and add:

GEMINI_API_KEY=your_api_key_here

⸻

3 Run the Application

Using Maven

./mvnw spring-boot:run

Application will start on

http://localhost:8080

⸻

H2 Database Console

Open:

http://localhost:8080/h2-console

JDBC URL

jdbc:h2:mem:quizdb

Username

sa

Password

(blank)

⸻

API Endpoints

Upload PDF

POST /api/documents/upload

Uploads a PDF document and processes it.

⸻

Generate Quiz

POST /api/quiz/generate

Generates quiz questions from ingested document content.

⸻

Submit Answer

POST /api/quiz/answer

Evaluates student answer and adapts difficulty.

⸻

Sample Flow

1 Upload PDF
2 Extract text and chunk document
3 Generate quiz questions using Gemini AI
4 Student answers question
5 AI evaluates answer and adjusts difficulty

Future Improvements

• Persistent database (PostgreSQL)
• Frontend UI for quiz interaction
• Question difficulty calibration
• Student performance analytics

⸻

Author

Shashank
:::
