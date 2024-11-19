package controller;

import model.state.PrgState;
import model.statements.IStatement;
import repository.IRepo;
import exceptions.*;

public class Controller
{
    private IRepo repo;
    private boolean displayFlag;

    public void setDisplayFlag(boolean displayFlag)
    {
        this.displayFlag = displayFlag;
    }

    public Controller(IRepo repo)
    {
        this.repo = repo;
    }

    public void addPrgState(PrgState p)
    {
        repo.add(p);
    }

//    public PrgState getCrtState()
//    {
//        return repo.getCrtPrg();
//    }

    public void displayCrtPrgState(PrgState p)
    {
        System.out.println(p.toString());
    }

    public PrgState oneStp(PrgState state) throws StatementException, ADTException, ExpressionException {
        if (state.getExeStack().isEmpty()) {
            throw new StatementException("Execution stack is empty");
        }

        IStatement currentStmt = state.getExeStack().pop();

        return currentStmt.execute(state);
    }


    public void allSteps() throws StatementException, ADTException, ExpressionException, RepoException {
        PrgState prg = repo.getCrtPrg();

        if(displayFlag)
            displayCrtPrgState(prg);
        while(!prg.getExeStack().isEmpty())
        {
            oneStp(prg);
            if(displayFlag)
                displayCrtPrgState(prg);
        }
        if(!displayFlag)
        {
            displayCrtPrgState(prg);
        }
    }
}
