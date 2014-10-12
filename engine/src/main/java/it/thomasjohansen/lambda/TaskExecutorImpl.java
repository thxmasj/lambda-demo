package it.thomasjohansen.lambda;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TaskExecutorImpl implements TaskExecutor {

    public TaskExecutorImpl() {
        super();
    }

    @Override
    public <T, R> List<R> executeTask(TaskFunction<T, R> function, List<T> data) throws RemoteException {
        List<R> result = new ArrayList<>(data.size());
        for (T value : data)
            result.add(function.apply(value));
        return result;
    }

    public static void main(String[] args) throws RemoteException {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        TaskExecutor engine = new TaskExecutorImpl();
        TaskExecutor stub = (TaskExecutor)UnicastRemoteObject.exportObject(engine, 33000);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("TaskExecutor", stub);
    }

}
