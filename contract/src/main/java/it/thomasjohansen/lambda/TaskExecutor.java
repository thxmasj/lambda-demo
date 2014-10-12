package it.thomasjohansen.lambda;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.function.Function;

/**
 * Created by thomas on 11/10/14.
 */
public interface TaskExecutor extends Remote {

    <T, R> List<R> executeTask(TaskFunction<T, R> function, List<T> data) throws RemoteException;

}
