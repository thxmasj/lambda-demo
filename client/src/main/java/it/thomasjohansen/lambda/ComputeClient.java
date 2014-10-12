package it.thomasjohansen.lambda;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by thomas on 11/10/14.
 */
public class ComputeClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        Registry registry = LocateRegistry.getRegistry(1099);
        TaskExecutor compute = (TaskExecutor)registry.lookup("TaskExecutor");
        List<Long> result = compute.executeTask((Long x) -> x*x, Arrays.asList(new Long(24), new Long(31), new Long(42)));
        result.forEach(System.out::println);
    }

}
