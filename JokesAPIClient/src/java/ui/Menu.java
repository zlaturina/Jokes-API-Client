package ui;

import java.util.Scanner;
import service.JokeClient;

/**
 *
 * @author Ida Maria Solli
 */
public class Menu {

    static JokeClient jokeClient = new JokeClient();
    static boolean isRunning;
    static Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        isRunning = true;
        while (isRunning) {
            System.out.println("Welcome to 'Jokes'\n");
            System.out.println("1. View random jokes");
            System.out.println("0. Exit");
            System.out.print("Enter: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    subMenu();
                    break;
                case 0:
                    exitGame();
                    break;
                default:
                    System.out.println("Not a valid input!\n");
                    break;
            }
        }
    }

    public void subMenu() {
        boolean innerLoop = true;
        while (innerLoop) {
            System.out.println("1. Do you want to recive one random joke");
            System.out.println("2. Do you want to recive 10 random jokes");
            System.out.println("0. Return to mainmenu");
            System.out.print("Enter: ");
            int joke = scanner.nextInt();

            switch (joke) {
                case 1:
                    jokeClient.getRandomJoke();
                    break;
                case 2:
                    jokeClient.getTenRandomJokes();
                    break;
                case 0:
                    innerLoop = false;
                    break;
                default:
                    System.out.println("Not a valid input!\n");
                    break;
            }
        }
    }

    public void exitGame() {
        System.out.println("Do you really want to exit the game?");
        System.out.println("YES \nNO");
        System.out.print("Enter: ");
        String input = scanner.next();

        if (input.equalsIgnoreCase("YES")) {
            System.out.println("See you next time!");
            isRunning = false;
        }
        if (input.equalsIgnoreCase("NO")) {
            System.out.println("Thank you for staying!\n");
            mainMenu();
        }
        else {
            System.out.println("Not a valid input, please try again!\n");
            exitGame();
        }
    }

}
