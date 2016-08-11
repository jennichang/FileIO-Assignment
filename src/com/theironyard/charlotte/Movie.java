package com.theironyard.charlotte;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jenniferchang on 8/10/16.
 */
public class Movie {
     String name;
     String actor;
     String genre;
     int year;
     String like;

    public Movie() {

    } // needed to add this because of json parser.  it couldn't find a constructor to use.  by default it uses
    // a parameter less one.  because i have parameter-full constructors, i need a dummy constructor with no paramter.

    public Movie(String name, String actor, String genre, int year, String like) {  // this is a constructor that sets the fields we just created
        this.name = name;
        this.actor = actor;
        this.genre = genre;
        this.year = year;
        this.like = like;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public static Movie createNew(String name, String actor, String genre, int year, String like) {
        return new Movie(name, actor, genre, year, like);

    }

    public void saveData() throws IOException {
        JsonSerializer s = new JsonSerializer();
        String json = s.include("*").serialize(this); // this: serialize this current object.  this current object is the
        // "movie" in the main method of "movie.save();

//    public static void saveData(Movie input) throws IOException {
//        JsonSerializer s = new JsonSerializer();
//        String json = s.include("*").serialize(input); // this is what you need if you wanted to keep saveData static.
//

        File f = new File("movie.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public static void loadData() throws FileNotFoundException {
        File f = new File("movie.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();

        JsonParser p = new JsonParser();
        Movie m = p.parse(contents, Movie.class);
        System.out.println(m); // now how do i override toString


    }


    @Override
    public String toString() {
        return String.format("Name of movie: %s\n" +
                "Actor/Actress in movie: %s\n" +
                "Genre of movie: %s\n" +
                "Year of movie: %d\n" +
                "Liked the movie: %s\n", name, actor, genre, year, like);
}


//@Override
//    public String toString() {
//    return "Name of movie : " + name  +
//            "Actor/Actress in movie : " + actor  +
//            "Genre of movie : " + genre  +
//            "Year of movie : " + year  +
//            "Liked movie : " + like;
//}