import java.util.ArrayList;

public class QuestionService
{
    private ArrayList<Question> questions = new ArrayList<>();

    //Add questions
    public void addQuestion(Question question)
    {
        questions.add(question);
    }
    //Return the questions
    public ArrayList<Question> getQuestions()
    {
        return questions;
    }
}
