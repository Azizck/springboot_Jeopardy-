package ca.sheridancollege;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.dao.DAO;

@Controller
public class homeController {

	@GetMapping("/")
	public String home(HttpSession session) {
		String returnPage = "gameBoard.html";
		// if it's a new session create display login page
		if (session.isNew()) {
			returnPage = "login.html";
		}
		return returnPage;
	}

	/*
	 * gets the param user, create an object of player with and stores it in session
	 */
	@GetMapping("/gameBoard")
	public String login(HttpServletRequest request, HttpSession session) {
		String name = request.getParameter("user");
		Player player = new Player(name, 0);
		session.setAttribute("player", player);
		return "gameBoard.html";
	}

	@GetMapping("/evaluteAnswer")
	public String correct(HttpServletRequest request, HttpSession session) {
		// the selected answer
		String chosen = request.getParameter("chosen").toString();
		// correct answer
		String correctChoice = ((Question) session.getAttribute("question")).getCorrectAnswer();
		// value of the question
		double value = Double.valueOf(session.getAttribute("value").toString());
		// create a temp object of player
		Player p = ((Player) session.getAttribute("player"));
		// check if the selected answer is equal to the correct answer
		if (correctChoice.equalsIgnoreCase(chosen)) {
			// System.out.print("correct ! ");
			p.setScore(p.getScore() + value);
			// System.out.println(p.getScore());
		} else {
			p.setScore(p.getScore() - value);
		}

		session.setAttribute("player", p);
		return "gameBoard.html";
	}

	// add questions to the database
	@GetMapping("/add")
	public String addQuestion(@RequestParam String category, @RequestParam int value, @RequestParam String question,
			@RequestParam String answer1, @RequestParam String answer2, @RequestParam String answer3,
			@RequestParam String answer4, @RequestParam int chosen, Model model) {
		String correctAnswer = "";
		if (chosen == 1)
			correctAnswer = answer1;
		else if (chosen == 2)
			correctAnswer = answer2;
		else if (chosen == 3)
			correctAnswer = answer3;
		else if (chosen == 4)
			correctAnswer = answer4;

		Question q = new Question(category, value, question, answer1, answer2, answer3, answer4, correctAnswer);
		// add the question to database
		DAO.addQuestion(q);
		return "add.html";
	}

	@GetMapping("showAdd")
	public String add() {
		return "add.html";
	}

	/// view all the questions in a table
	@GetMapping("/view")
	public String viewQuestions(Model model) {
		model.addAttribute("questions", DAO.getQuestion());
		return "view.html";

	}

	// gets the user chosen question from database
	@GetMapping("/cANDv")
	public String cANDv(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// get parameter
		String value = request.getParameter("value");
		int value2 = Integer.valueOf(request.getParameter("value").toString());
		String category = request.getParameter("category");
		// get question from database
		Question question = DAO.getQuestionbyCandV(category, value2);
		 session.setAttribute("value", value);
		 session.setAttribute("category", category);
		session.setAttribute("question", question);
		return "_question.html";

	}

}
