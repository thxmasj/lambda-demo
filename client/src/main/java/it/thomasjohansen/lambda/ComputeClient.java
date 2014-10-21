package it.thomasjohansen.lambda;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.List;

public class ComputeClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        Registry registry = LocateRegistry.getRegistry(1099);
        TaskExecutor executor = (TaskExecutor)registry.lookup("TaskExecutor");
        List<Long> result = executor.executeTask((Long x) -> x*x, Arrays.asList(24L, 42L, 2048L));
        result.forEach(System.out::println);
    }

}
