/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Joke;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author Ida Maria Solli
 */
public class JokeClient {

    static Client client = ClientBuilder.newClient();    


    public Joke getRandomJoke() {
        WebTarget target = client.target("https://official-joke-api.appspot.com/random_joke");
        Joke joke = target.request().get(Joke.class);
        return joke;
    }

    public Joke[] getTenRandomJokes() {

        WebTarget target = client.target("https://official-joke-api.appspot.com/random_ten");
        Joke[] jokes = target.request().get(Joke[].class);
        for (Joke joke : jokes) {
            System.out.println(joke);
        }
        return jokes;
    }
    

}
