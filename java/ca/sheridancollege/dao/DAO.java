package ca.sheridancollege.dao;
import java.sql.*;
import java.util.ArrayList;

import ca.sheridancollege.Question;

public class DAO {


	public static void addQuestion(Question q) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/jeopardy", "root", "root");
//			String command = "INSERT INTO easy_drink VALUES('" + b.getName() + "'," + "'" + b.getMain() + "',"
//					+ b.getAmount1() + ",'" + b.getSecond() + "'," + b.getAmount2() + ",'" + b.getDescription() + "')";

			String command = "INSERT INTO questions VALUES(?,?,?,?,?,?,?,?) ";
			PreparedStatement ps = conn.prepareStatement(command);
			ps.setString(1, q.getCategory());
			ps.setInt(2, q.getValue());
			ps.setString(3, q.getQuestion());
			ps.setString(4, q.getAnswer1());
			ps.setString(5, q.getAnswer2());
			ps.setString(6, q.getAnswer3());
			ps.setString(7, q.getAnswer4());
			ps.setString(8, q.getCorrectAnswer());

			ps.executeUpdate();
			/**
			 * String sql = "SHOW DATABASES LIKE drinks"; Statement test =
			 * conn.createStatement(); System.out.println("If Databases Exist or Not: "+
			 * test.execute(sql));
			 * 
			 */
			// Statement str = conn.createStatement();
			// str.executeUpdate(command);
			conn.close();
			System.out.println("Connection Success");
		} catch (Exception e) {
			System.out.println("Connection Failed");
			System.out.println(e);
		}
	}

	public static ArrayList<Question> getQuestion() {
		ArrayList<Question> questions = new ArrayList<Question>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/jeopardy", "root", "root");
			String command = "SELECT * FROM questions";
			Statement str = conn.createStatement();
			ResultSet rs = str.executeQuery(command);
			ResultSetMetaData rmd = rs.getMetaData();

			while (rs.next()) {
				Question question;
				String category = rs.getString(1);
				int value = rs.getInt(2);
				String questionV = rs.getString(3);
				String answer1 = rs.getString(4);
				String answer2 = rs.getString(5);
				String answer3 = rs.getString(6);
				String answer4 = rs.getString(7);
				String correctAnswer = rs.getString(8);
				question = new Question(category, value, questionV, answer1, answer2, answer3, answer4, correctAnswer);
				questions.add(question);
			}
			conn.close();
			System.out.println("Connection Success");
		} catch (Exception e) {

			System.out.println("Connection Failed");
			System.out.println(e);

		}
		return questions;
	}

	public static Question getQuestionbyCandV(String c, int value2) {
		Question question = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/jeopardy", "root", "root");
			String command = "SELECT * FROM questions WHERE category='" + c + "'AND value='" + value2 + "'";
			Statement str = conn.createStatement();
			ResultSet rs = str.executeQuery(command);
			ResultSetMetaData rmd = rs.getMetaData();
			while (rs.next()) {
				String category = rs.getString(1);
				int value = rs.getInt(2);
				String questionV = rs.getString(3);
				String answer1 = rs.getString(4);
				String answer2 = rs.getString(5);
				String answer3 = rs.getString(6);
				String answer4 = rs.getString(7);
				String correctAnswer = rs.getString(8);
				question = new Question(category, value, questionV, answer1, answer2, answer3, answer4, correctAnswer);
			}
			conn.close();
			System.out.println("Connection Success");
		} catch (Exception e) {

			System.out.println("Connection Failed");
			System.out.println(e);

		}
		return question;
	}

}