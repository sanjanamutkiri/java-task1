import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static Timer timer = new Timer();
    private static int timeLimitInSeconds = 60;
    private static boolean timeIsUp = false;

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz Application!");

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                timeIsUp = true;
                timer.cancel();
                System.out.println("\nTime's up!");
            }
        };

        timer.schedule(timerTask, timeLimitInSeconds * 1000);

        // Quiz questions
        System.out.println("Question 1: What is the capital of India?");
        String answer1 = scanner.nextLine();

        System.out.println("Question 2: What is 2 + 2?");
        int answer2 = scanner.nextInt();


        // Checking answers
        checkAnswers(answer1, answer2);

        // Stop the timer if it's still running
        timer.cancel();
    }

    private static void checkAnswers(String answer1, int answer2 ) {
        if (!timeIsUp) {
            // Check answers
            if (answer1.equalsIgnoreCase("Delhi") && answer2 == 4 ) {
                System.out.println("Congratulations! You got all answers correct!");
            } else {
                System.out.println("Sorry,  incorrect answers ! TRY AGAIN ....");
            }
        } else {
            System.out.println("Sorry, you ran out of time!");
        }
    }
}

