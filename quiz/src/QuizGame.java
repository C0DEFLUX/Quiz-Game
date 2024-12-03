import java.util.Scanner;

public class QuizGame
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //Create a question bank
        QuestionService questionService = new QuestionService();

        System.out.println("Welcome to the Quiz Game!");

        System.out.println("Please add your questions to start the quiz. Type 'done' to finish adding questions.");

        addCustomQuestions(questionService, scanner);

        if (questionService.getQuestions().isEmpty())
        {
            System.out.println("No questions were added. Exiting the quiz.");
            return;
        }

        //Start the quiz
        Quiz quiz = new Quiz(questionService.getQuestions());
        quiz.start();

        scanner.close();
    }

    //Method to add questions
    private static void addCustomQuestions(QuestionService questionService, Scanner scanner)
    {
        while (true)
        {
            System.out.println("\nEnter the question text:");
            String questionText = scanner.nextLine();

            //if user input is 'done' exit the method
            if (questionText.equalsIgnoreCase("done"))
            {
                break;
            }

            System.out.println("Enter the options (comma-separated, e.g., A) Option1, B) Option2):");
            String[] options = scanner.nextLine().split(",");

            System.out.println("Enter the correct answer (e.g., A, B, C, or D):");
            char correctAnswer = scanner.nextLine().trim().toUpperCase().charAt(0);

            //Add the question to the bank
            questionService.addQuestion(new Question(questionText, options, correctAnswer));

            System.out.println("Question added successfully!");
        }
    }
}
