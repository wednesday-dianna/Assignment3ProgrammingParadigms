package repository;

import exceptions.RepoException;
import model.state.PrgState;
import java.util.ArrayList;
import java.util.List;

public class Repo implements IRepo{
    private List<PrgState> stateList;
    private int currentStatePos;

    public Repo() {
        stateList = new ArrayList<>();
        currentStatePos = 0;
    }


    public PrgState getCrtPrg() throws RepoException {
        if(this.currentStatePos < 0 || this.currentStatePos > this.stateList.size()){
            throw new RepoException("Invalid state");
        }
        return this.stateList.get(currentStatePos);
    }

    public void add(PrgState state){
        this.stateList.clear();
        this.stateList.add(state);
    }
}