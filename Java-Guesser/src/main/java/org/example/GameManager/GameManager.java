package org.example.GameManager;

import java.util.Scanner;

public class GameManager {
  //check if the player's guess is equal to the machine
  boolean hasFoundTheNumber = false;
  //player's guess
  int guess;
  //continue state
  boolean isContinue = true;
  int score = 0;
  //Player's input
  Scanner scanner = new Scanner(System.in);

  //Game loop
  public void startGame() {
    while(isContinue) {
      //Machine guesses a number from 1 to 20
      int randomNumber = (int) (Math.random() * 20);
      System.out.println("------------ Guessing game ------------");
      System.out.println("What's your guess between 1 to 20? ");
      guess = scanner.nextInt();
      guesses(guess, randomNumber);
      if(hasFoundTheNumber) {
        score++;
        System.out.println("You'd find the number: " + guess);
        tryAgain();
      } else {
        System.out.println("You didn't find the number");
        tryAgain();
      }
    }
    System.out.println("Your score was: " + score);
  }
  public void guesses(int guess, int randomNumber) {
    if(randomNumber == guess) {
      hasFoundTheNumber = true;
    } else {
      hasFoundTheNumber = false;
    }
  }
  public void tryAgain() {
    System.out.println("Try again press Y/N ? ");
    scanner.nextLine();
    char continueGame = scanner.nextLine().toUpperCase().charAt(0);
    isContinue = continueGame == 'Y';
  }
}
