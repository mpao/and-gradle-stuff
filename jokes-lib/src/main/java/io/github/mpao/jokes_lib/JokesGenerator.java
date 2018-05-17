package io.github.mpao.jokes_lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokesGenerator {

    private List<String> list = new ArrayList<>();

    /*
     * Costructor: put here new jokes, adding them to the list
     */
    public JokesGenerator(){

        list.add("You know you're ugly when you get handed the camera every time they make a group photo.");
        list.add("Tombstone engraving: I TOLD you I was sick!");
        list.add("Cremation. My final hope for a smokin’ hot body!");
        list.add("My Grandfather has the heart of a lion and a lifetime ban from the Atlanta Zoo.");
        list.add("There is nothing more depressing than a failed suicide attempt.");

    }

    /*
     * retrieve joke from list
     */
    public String getJoke(){

        Random random = new Random();
        int index = random.nextInt( list.size() );
        return list.get(index);

    }

}
