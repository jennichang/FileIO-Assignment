package com.theironyard.charlotte;

/*
added json library
 */

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); // local variables

        while (true) {

        try {
            System.out.println("Loaded saved data.");
            System.out.println("The current saved data shows:\n");
            Movie.loadData();
        } catch (Exception e) {
            System.out.println("This is a friendly error.  The error is " + e.getMessage()); // if parse or
            // load doesn't work show error, and also exception message.
        }

        System.out.println("Do you want to update the information? [y/n]");

        String updateInfo = sc.nextLine();

        if(updateInfo.equalsIgnoreCase("y")) {

            // ask all my questions
            System.out.println("Please answer the following questions about the movie");

            System.out.println("What was the title?");

            String name = sc.nextLine();

            System.out.println("Who is the main actor/actress?");

            String actor = sc.nextLine();

            System.out.println("What is the genre?");

            String genre = sc.nextLine();

            System.out.println("In what year was it made?");

            int year = Integer.valueOf(sc.nextLine());

            System.out.println("Did you like it?");

            String like = sc.nextLine();


            //create new movie object with my scanner inputs
            Movie movie = Movie.createNew(name, actor, genre, year, like);


            //save data to json - method is in Movie class...calling method from movie class here
            movie.saveData(); // the this in Movie save is referencing this object ("movie")
            System.out.println("Data has been saved.");

            // below is what would be needed if saveData method was static
//            Movie.saveData(movie);

        }
        }

    }
    }




