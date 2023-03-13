package RPS;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ROCKPAPERSCISSORS {
    public static void main(String[] args){

        //***************************Match checkers********************
        Scanner input = new Scanner(System.in);
        boolean matchLost = false;
        int matchesWon = 0;
        String userThrow = "";

        //*****************************Image Files*********************
        File userRock = new File("Rock.txt");
        File userPaper = new File(("Paper.txt"));
        File userScissor = new File("Scissor.txt");
        File vsRock = new File(("vsRock.txt"));
        File vsPaper = new File("vsPaper.txt");
        File vsScissor = new File(("vsScissor.txt"));
        File countDown1 = new File("Countdown1.txt");
        File countDown2 = new File("Countdown2.txt");
        File countDown3 = new File("Countdown3.txt");
        //******************************Introduction*******************
        System.out.println("Welcome to Rock, Paper, Scissors!\n");
        input.nextLine();
        System.out.println("You will play in a series of Best of 5 matches to see how many consecutive games you can win.\n");
        input.nextLine();
        System.out.println("Im sure you know how to play Rock, Paper, Scissors so lets begin.\n\n");
        input.nextLine();

        while(!matchLost){
            int roundsWon = 0;
            int roundsLost = 0;
            int round = 1;
            System.out.println("A new opponent approaches...");
            Opponent opponent = new Opponent();
            while(roundsLost < 3 && roundsWon < 3){
                System.out.println("Round " + round + "\n");
                System.out.println("What will you throw?\n\n\t1-Rock\n\t2-Paper\n\t3-Scissor\n(Enter the number of your choice)");
                userThrow = input.nextLine();
                opponent.setChoice(opponent.choose());
                if(userThrow.equals("1") || userThrow.equals("2") || userThrow.equals("3" +
                        "")) {
                    try {
                        printFile(countDown3);
                        input.nextLine();
                        printFile(countDown2);
                        input.nextLine();
                        printFile(countDown1);
                        input.nextLine();
                    } catch (FileNotFoundException ex) {
                        System.out.println("***No PIC FOUND***");
                    }
                }
                if(userThrow.equals("1")){
                    if (opponent.getChoice() == rpsChoice.ROCK){
                        try {
                            printTwoFiles(userRock, vsRock);
                        } catch (FileNotFoundException ex1){
                            System.out.println("***No PIC FOUND***");
                        }
                        round++;
                        System.out.println("Tie!");
                    } else if(opponent.getChoice() == rpsChoice.PAPER){
                        try {
                            printTwoFiles(userRock, vsPaper);
                        } catch (FileNotFoundException ex1){
                            System.out.println("***No PIC FOUND***");
                        }
                        roundsLost++;
                        round++;
                        System.out.println("The opponent won the round!");
                    } else {
                        try {
                            printTwoFiles(userRock, vsScissor);
                        } catch (FileNotFoundException ex1){
                            System.out.println("***No PIC FOUND***");
                        }
                        roundsWon++;
                        round++;
                        System.out.println("You won the round!");
                    }
                } else if(userThrow.equals("2")){
                    if (opponent.getChoice() == rpsChoice.PAPER){
                        try {
                            printTwoFiles(userPaper, vsPaper);
                        } catch (FileNotFoundException ex1){
                            System.out.println("***No PIC FOUND***");
                        }
                        round++;
                        System.out.println("Tie!");
                    } else if(opponent.getChoice() == rpsChoice.SCISSORS){
                        try {
                            printTwoFiles(userPaper, vsScissor);
                        } catch (FileNotFoundException ex1){
                            System.out.println("***No PIC FOUND***");
                        }
                        roundsLost++;
                        round++;
                        System.out.println("The opponent won the round!");
                    } else {
                        try {
                            printTwoFiles(userPaper, vsRock);
                        } catch (FileNotFoundException ex1){
                            System.out.println("***No PIC FOUND***");
                        }
                        roundsWon++;
                        round++;
                        System.out.println("You won the round!");
                    }
                } else if(userThrow.equals("3")){
                    if (opponent.getChoice() == rpsChoice.SCISSORS){
                        try {
                            printTwoFiles(userScissor, vsScissor);
                        } catch (FileNotFoundException ex1){
                            System.out.println("***No PIC FOUND***");
                        }
                        round++;
                        System.out.println("Tie!");
                    } else if(opponent.getChoice() == rpsChoice.ROCK){
                        try {
                            printTwoFiles(userScissor, vsRock);
                        } catch (FileNotFoundException ex1){
                            System.out.println("***No PIC FOUND***");
                        }
                        roundsLost++;
                        round++;
                        System.out.println("The opponent won the round!");
                    } else {
                        try {
                            printTwoFiles(userScissor, vsPaper);
                        } catch (FileNotFoundException ex1){
                            System.out.println("***No PIC FOUND***");
                        }
                        roundsWon++;
                        round++;
                        System.out.println("You won the round!");
                    }
                } else {
                    System.out.println("You have to enter a correct number");
                }
            }
            if(roundsLost >= 3){
                System.out.println("You lost the match, your run is over after winning " + matchesWon+ " matches\n\n\tTHANKS FOR PLAYING");
                matchLost = true;
            } else {
                System.out.println("You won the match");
                matchesWon++;
            }
        }

    }

    public static void printFile(File picFile) throws FileNotFoundException {
        Scanner in = new Scanner(picFile);
        while(in.hasNextLine()){
            System.out.println(in.nextLine());
        }
    }

    public static void printTwoFiles(File picFile1, File picFile2) throws FileNotFoundException {
        Scanner in1 = new Scanner(picFile1);
        Scanner in2 = new Scanner(picFile2);
        while(in1.hasNextLine()){
            System.out.print(in1.nextLine());
            System.out.print(in2.nextLine());
            System.out.println();
        }
    }
}
