package ru.evgkit.Hangman;

import java.util.Arrays;
import java.util.Date;

public class Treet implements Comparable {
    private String mAuthor;
    private String mDescription;
    private Date mCreationDate;

    public Treet(String author, String description, Date creationDate) {
        mAuthor = author;
        mDescription = description;
        mCreationDate = creationDate;
    }

    public Treet(String author, String description) {
        mAuthor = author;
        mDescription = description;
        mCreationDate = new Date();
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDescription() {
        return mDescription;
    }

    public Date getCreationDate() {
        return mCreationDate;
    }

    @Override
    public String toString() {
        return "@" + getAuthor() + ": \"" + getDescription() + "\"\n" + getCreationDate() + "\n";
    }

    public String[] getWords() {
        return mDescription.toLowerCase().split("[^\\w@#']+");
    }

    @Override
    public int compareTo(Object o) {
        Treet t = (Treet) o;

        if (equals(t)) {
            return 0;
        }

        if (-1 == mCreationDate.compareTo(t.getCreationDate())) {
            return -1;
        }

        return 1;
    }

    public static void main(String[] args) {
        Treet firstTreet = new Treet("Listener", "\"Want to be famous? Simply tweet about Java and use \" +\n" +
                "      \"the hashtag #treet. I'll use your tweet in a new \" +\n" +
                "      \"@treehouse course about data structures.\"");

        Treet secondTreet = new Treet(
                "journeytocode",
                "@treehouse makes learning Java sooooo fun! #treet",
                new Date(1421878767000L)
        );

        System.out.printf("This is a new Treet:  %s %n", firstTreet);
        System.out.println("The words are:");

        for (String word : firstTreet.getWords()) {
            System.out.println(word);
        }

        Treet[] treets = {firstTreet, secondTreet};
        Arrays.sort(treets);

        for (Treet treet : treets) {
            System.out.println(treet);
        }
    }


}
