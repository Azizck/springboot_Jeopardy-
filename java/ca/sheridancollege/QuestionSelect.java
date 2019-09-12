package ca.sheridancollege;


public class QuestionSelect {

	/**
	 * method compares the requested category and value of the question to the array
	 * of question
	 * 
	 * @param qCatg category of the question as a string
	 * @param qVal  question value as integer
	 * @return question that meets the required condition
	 */
	public Question getSQuestion(String qCatg, String qValString) {
		Question question = new Question();
		int qVal = Integer.parseInt(qValString);
		int size = RunQuestion.questions.size();
		for (int i = 0; i < size; i++) {
			if (RunQuestion.questions.get(i).getCategory().equalsIgnoreCase(qCatg)
					&& RunQuestion.questions.get(i).getValue() == qVal) {
				question = RunQuestion.questions.get(i);
			}
		}
		return question;
	}
	


}
