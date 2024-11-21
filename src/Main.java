import controller.Controller;
import repository.IRepo;
import repository.Repo;
import view.View;

public class Main {
    public static void main(String[] args) {
        IRepo repo = new Repo(); // Instanțiază o clasă care implementează IRepo
        Controller ctr = new Controller(repo); // Creează controller-ul
        View view = new View(ctr); // Creează view-ul
        view.start(); // Pornește aplicația
    }
}
