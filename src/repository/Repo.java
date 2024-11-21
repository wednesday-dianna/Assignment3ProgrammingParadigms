package repository;

import exceptions.LogFileException;
import exceptions.RepoException;
import model.state.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repo implements IRepo{
    private List<PrgState> stateList;
    private int currentStatePos;
    private String logFilePath; //numele fisierului

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

    public void logPrgStateExec(String log) throws LogFileException {
        PrintWriter logFile;
        try {
            logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
        } catch (IOException e) {
            throw new LogFileException("The file doesn't exist");
        }

        for (PrgState state : this.stateList) {
            String stateStr = state.exestackToString();
            logFile.println(stateStr);
        }
    }

}
