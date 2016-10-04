package task;

//The Task interface (interaction contract) between clients and the server
public interface Task {

    public void executeTask();

    public Object getResult();
}
