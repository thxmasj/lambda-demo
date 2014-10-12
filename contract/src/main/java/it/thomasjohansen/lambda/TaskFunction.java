package it.thomasjohansen.lambda;

import java.io.Serializable;

public interface TaskFunction<T, R> extends Serializable {

    R apply(T value);

}
