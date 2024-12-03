import java.util.ArrayList;
import java.util.Scanner;

public class Quiz
{
    private ArrayList<Question> questions;
    //Start score at 0
    private int score = 0;

    //Create new quiz object
    public Quiz(ArrayList<Question> questions)
    {
        this.questions = questions;
    }

    public void start()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz Game!");
        System.out.println("Answer the following questions:\n");

        for (Question question : questions)
        {
            //Print question text
            System.out.println(question.getQuestionText());
            //Loop thru question options array
            for (String option : question.getOptions())
            {
                //Print option
                System.out.println(option);
            }
            //Get user input
            System.out.print("Your answer: ");
            char userAnswer = scanner.nextLine().toUpperCase().charAt(0);

            //Validate user input
            if (validateAnswer(userAnswer, question.getCorrectAnswer()))
            {
                //If correct print out and add 1 to score
                System.out.println("Correct!\n");
                score++;
            } else
            {
                //If not then print out wrong with the correct answer
                System.out.println("Wrong. The correct answer is " + question.getCorrectAnswer() + ".\n");
            }
        }
        //Print out the final score
        System.out.println("Quiz Over! Your final score is: " + score + "/" + questions.size());
        scanner.close();
    }
    //Method for validating user answer against actual answer
    private boolean validateAnswer(char userAnswer, char correctAnswer)
    {
        return userAnswer == correctAnswer;
    }
}
