package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTO.QuestionRequest;
import com.example.demo.Service.QuizService;
import com.example.demo.model.Question;
import com.example.demo.model.Quiz;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
public class QuestionController {

	@Autowired
	QuizService quizService;

	@Autowired
	public QuestionController(QuizService quizService) {
		this.quizService = quizService;
	}

	@GetMapping("/getAllQuestions")
	public List<Question> getAllQuestion() throws IOException {
		return quizService.getAllQuestions();
	}

	@PostMapping("/addQuestion")
	public ResponseEntity<String> createQuestion(@RequestBody QuestionRequest questionRequest) throws IOException {

		Question question = quizService.createQuestion(questionRequest);
		return ResponseEntity.ok("Question added successfully");
	}

	@PostMapping("/addQuiz")
	public ResponseEntity<String> createQuiz(@RequestBody Quiz quiz) throws IOException {

		Quiz quiz1 = quizService.createQuiz(quiz);
		return ResponseEntity.ok("Quizz added successfully");
	}
	
	@GetMapping("/getAllQuizzes")
	public List<Quiz> getAllQuizzes() throws IOException {
		return quizService.getAllQuizzes();
	}
	@GetMapping("/getQuiz/{Topic}")
	public Quiz getQuizByTopic(@PathVariable String Topic) throws IOException {
		return quizService.getQuizByTopic(Topic);
	}

}
