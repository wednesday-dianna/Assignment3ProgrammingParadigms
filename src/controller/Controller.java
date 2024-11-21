package controller;

import model.ADT.MyIStack;
import model.state.PrgState;
import model.statements.IStatement;
import repository.*;
import exceptions.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller
{
    private final IRepo repo;
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


    public void allSteps(String logFileName) throws StatementException, ADTException, ExpressionException, RepoException {
        PrgState prg = repo.getCrtPrg();
        repo.logPrgStateExec(logFileName);
        while (!prg.getExeStack().isEmpty()) {
            oneStp(prg);
            repo.logPrgStateExec(logFileName);

            if (displayFlag)
                displayCrtPrgState(prg);
            while (!prg.getExeStack().isEmpty()) {
                oneStp(prg);
                if (displayFlag)
                    displayCrtPrgState(prg);
            }
            if (!displayFlag) {
                displayCrtPrgState(prg);
            }
        }
    }

    public void writeInLogFileCtr(String logFilePath) {
        //MyIStack<IStatement> exeStack = getExeStack();

        try {
            repo.logPrgStateExec(logFilePath);
        } catch (LogFileException e) {
            throw new RuntimeException(e);
        }

    }
}
