package repository;

import exceptions.RepoException;
import model.state.PrgState;

public interface IRepo {
    PrgState getCrtPrg() throws RepoException;
    void add(PrgState state);
}
