package com.udacity.gradle.builditbigger.jokes;

public class getJokes {

    public String getAJoke()
    {
        JokeSmith jokeObj = new JokeSmith();
        return jokeObj.tellAJoke();
    }
}
