package ca.sheridancollege;

import java.util.ArrayList;

public class RunQuestion {
	public class questions {

	}

	// declare a static arrayList to store the questions
	public static ArrayList<Question> questions = null;

	public static void main(String args[]) {
		/**
		questions.size();
		addQuestions();
		for(Question q : questions) {
		System.out.println(q.toString());	
		}
		*/
	//System.out.println(QuestionSelect.getSQuestion("cities", "200"));
	
	}

	// creating questions and adding to the Array
	public void addQuestions() {
		questions = new ArrayList<Question>();
		questions.add(new Question("Cities", 100, "The United Kingdom is comprised of how many countries?", "Four",
				"Five", "Three", "Two", "Four"));
		questions.add(new Question("Cities", 200, "What is the largest city in USA ?", "New York", "Los Anglese",
				"Manhattan", "Chicago", "New York"));
		questions.add(new Question("Cities", 300, "What is the capital of Singapore?", "Singapore", "Glam",
				"Jurong East", "Tampines", "Singapore"));
		questions.add(new Question("Cities", 400, "Between which two countries/states is the Bering Strait located?",
				"France and England", "Finland and Sweden", "Alaska and Russia", "Qata and Iran", "Alaska and Russia"));
		questions.add(new Question("Cities", 500, "Which of the following countries do not border France?",
				"Netherlands", "Italy", "Germany", "Spain", "Netherlands"));

		questions.add(new Question("Science", 100, "Roger Bacon is associated with the invention or discovery of what?",
				"Bacteria", "Magnifying glass", "Wireless remote control", "Aspirin", "Magnifyingu glass"));
		questions.add(new Question("Science", 200, "study of the heart in science is called:", "podology", "anatomy",
				"cardiology", "anthropology", "cardiology"));
		questions.add(new Question("Science", 300, "Ithology is the study of:", "study of rocks", "study of bones",
				"study of flags", "study of mountains", "study of rocks"));
		questions.add(new Question("Science", 400, "Taxidermy is the study of:", "moon", "muscles", "children",
				"curing and animals", "curing and animals"));
		questions.add(new Question("Science", 500, "Samuel Morse is associated with the discovery of :", "Blue Jeans",
				"Telegraph", "Automatic handgun", "AK-47 assault rifle", "Telegraph"));

		questions.add(
				new Question("History",100, "Which US president declared that NASA must bring a man to the moon?",
						"John F. Kennedy", "Theodore Roosevelt", "Ronald Raegan", "George Walker Bush", "John F. Kennedy"));

		questions.add(
				new Question("History", 200, "Which German Count invented the zeppelin?", "Zeppelin", "Rudolf",
				"Michel", "Arthur", "Zeppelin"));
		questions.add(new Question("History", 300, "Who was the first president of the USA?", "Trump", "Obama",
				"George Washington", "Saddam Hussin", "George Washington"));
		questions.add(new Question("History", 400, "In which city was the Titanic built?", "Belfast", "London",
				"Newyork", "Paris", "Belfast"));
		questions.add(new Question("History", 500, "On which island was Napoleon born?", "Sylt", "Corsica", "Juist",
				"Paris", "Corsica"));

		questions.add(new Question("General", 100, "What was Nostradamus' first name?", "George", "Rudolf", "Michel",
				"Arthur", "Michel"));
		questions.add(new Question("General", 200, "Which is the correct definition of the word abbattoir?",
				"To reduce in amount degree, or intensity; lessen", "someone that feels the pain of others",
				"The superior of a monastery", "a slaughterhouse", "a slaughterhouse"));
		questions.add(new Question("General", 300, "What is Stockholm Syndrome?",
				"  When a hostage  begin to feel sympathy  for their captor",
				"A learning disability.", "A virus from eating Swedish fish", "Type of Cofee", "When a hostage  begin to feel sympathy  for their captor"));
		questions.add(
				new Question("General", 400, "What is the right way to use the word too?", "Would you like a too dance",
						"The proplem is too Hard", "Too be Or not", "I want too Spain", "The proplem is too Hard"));
		questions.add(new Question("General", 500, "Who wrote The Story of Juliette?", " William Shakspere",
				"Robert Barclay", "Dante Alighieri", "Marquis De Sade", "William Shakspere"));

		questions.add(new Question("Canada", 100, "what is the most educated country in the world according to OECD",
				"Canada ", "Brazil", "France", "UK", "Canada"));
		questions.add(new Question("Canada", 200, "what is the loweset temperature recorded in Canada ", "-63", "-62",
				"-65", "-80", "-63"));
		questions.add(new Question("Canada", 300, "which country has the most lakes out in the world", "Russia",
				"Canada", "Turkey", "Germany", "Canada"));
		questions.add(new Question("Canada", 400, "Canada gets its name from ", "Kanata", "Canata", "Candy", "Kantoun",
				"Kanata"));
		questions.add(new Question("Canada", 500, "which country is the largest in the world ", "Canada", "Russia",
				"India", "Germany", "Russia"));
	}

}
