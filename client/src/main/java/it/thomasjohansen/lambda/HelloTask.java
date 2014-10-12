package it.thomasjohansen.lambda;

import java.io.Serializable;

/**
 * Created by thomas on 11/10/14.
 */
public class HelloTask implements TaskFunction<String, String> {

    @Override
    public String apply(String value) {
        System.out.println(value);
        return "I said: " + value;
    }
}
