package com.example.demo.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.QuestionRequest;
import com.example.demo.DTO.QuizDetailsDTO;
import com.example.demo.Exception.QuizNotFoundException;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Repository.QuizRepository;
import com.example.demo.Utility.ImageUtil;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionOption;
import com.example.demo.model.Quiz;

@Service
public class QuizService {

	private final QuestionRepository questionRepository;
	private final QuizRepository quizRepository;
	private final ImageUtil imageUtil;
	private final Logger log = LoggerFactory.getLogger(QuizService.class);

	public QuizService(QuestionRepository questionRepository, ImageUtil imageUtil, QuizRepository quizRepository) {
		this.questionRepository = questionRepository;
		this.quizRepository = quizRepository;
		this.imageUtil = imageUtil;
	}

	public List<Question> getAllQuestions() throws IOException {
		log.info("Getting all questions...");
		List<Question> questions = questionRepository.findAll();
		Collections.shuffle(questions); // Shuffle the questions
		questions.forEach(this::processQuestionImages);
		log.info("Successfully retrieved all questions.");
		return questions;
	}

	public List<QuizDetailsDTO> getAllQuizTopics() {
		log.info("Getting all quiz Basic Data.....");
		List<Quiz> quizzes = quizRepository.findAll();

		List<QuizDetailsDTO> qData = quizzes.stream().filter(Objects::nonNull) // Null check
				.map(q -> new QuizDetailsDTO(q.getTopic(), q.getqDescription(), q.isqActive()))
				.collect(Collectors.toList());

		log.info("Successfully retrieved all quiz Basic Data.");
		return qData;
	}

	public List<Quiz> getAllQuizzes() throws IOException {
		log.info("Getting all quizzes...");
		List<Quiz> quizzes = quizRepository.findAll();
		log.info("Successfully retrieved all quizzes. Quiz data: {}", quizzes);
		return quizzes;
	}

	public Quiz createQuiz(Quiz quiz) throws IOException {
		log.info("Creating a new quiz. Quiz data: {}", quiz);
		Quiz quizData = new Quiz();
		quizData.setTopic(quiz.getTopic());
		quizData.setqDescription(quiz.getqDescription());
		quizData.setqActive(quiz.isqActive());
		quiz.getQuestions().forEach(this::createQuestion);
		quizData.setQuestions(quiz.getQuestions());
		quizData.setTotalScore(quiz.getTotalScore());
		quizData.setDifficultyLevel(quiz.getDifficultyLevel());
		quizRepository.save(quizData);
		log.info("Quiz created and saved in the database.");
		return quizData;
	}

	public Question createQuestion(QuestionRequest questionRequest) {
		log.info("Creating a new question. Question data: {}", questionRequest);
		Question question = new Question();
		question.setqName(questionRequest.getqName());
		question.setCorrectAns(questionRequest.getCorrectAns());
		question.setDifficultyLevel(questionRequest.getDifficultyLevel());

		processQuestionImage(questionRequest.getqImage(), question::setqImage);

		List<QuestionOption> options = questionRequest.getqOptions().stream().map(optionRequest -> {
			QuestionOption option = new QuestionOption();
			option.setOption(optionRequest.getOption());
			option.setPriority(optionRequest.getPriority());
			processQuestionImage(optionRequest.getoImage(), option::setoImage);
			return option;
		}).collect(Collectors.toList());

		question.setqOptions(options);
		Question savedQuestion = questionRepository.save(question);
		log.info("Question created: {}", savedQuestion.getId());
		return savedQuestion;
	}

	private void processQuestionImages(Question question) {
		processQuestionImage(question.getqImage(), question::setqImage);
		question.getqOptions().forEach(option -> processQuestionImage(option.getoImage(), option::setoImage));
	}

	private void processQuestionImage(String imagePath, ImageConsumer imageConsumer) {
		log.info("Processing question image. Image path: {}", imagePath);
		if (imagePath != null && !imagePath.isEmpty()) {
			try {
				String base64Image = imageUtil.saveImage(imagePath);
				imageConsumer.setImage(base64Image);
			} catch (IOException e) {
				log.error("Error occurred while processing question image: {}", e.getMessage());
			}
		} else {
			imageConsumer.setImage("");
		}
	}

	public Quiz getQuizByTopic(String topic) {
		log.info("Getting quiz by topic: {}", topic);
		List<Quiz> quizzes = quizRepository.findAll();
		Quiz resultQuiz = null;
		for (Quiz q : quizzes) {
			if (q.getTopic().equalsIgnoreCase(topic)) {
				resultQuiz = q;
				break;
			}
		}
		if (resultQuiz == null) {
			throw new QuizNotFoundException("Quiz not found with topic: " + topic);
		}
		List<QuestionRequest> shuffledQuestions = new ArrayList<>(resultQuiz.getQuestions());
		shuffleList(shuffledQuestions);
		resultQuiz.setQuestions(shuffledQuestions);
		return resultQuiz;
	}

	private static <T> void shuffleList(List<T> list) {
		Random random = new Random();
		for (int i = list.size() - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			T temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
	}

	@FunctionalInterface
	interface ImageConsumer {
		void setImage(String base64Image);
	}
}
