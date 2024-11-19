import controller.Controller;
import repository.IRepo;
import repository.Repo;
import view.View;

public class Main {
    public static void main(String[] args) {
        IRepo repo = new Repo();
        Controller ctr = new Controller(repo);
        View view = new View(ctr);
        view.start();
    }
}