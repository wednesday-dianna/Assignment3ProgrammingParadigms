package model.state;

import model.ADT.*;
import model.values.*;
import model.statements.*;

import java.io.BufferedReader;

public class PrgState {
    public MyIStack<IStatement> getExeStack() {
        return exeStack;
    }

    public MyIMap<String, IValue> getSymTbl() {
        return symTbl;
    }

    public MyIList<IValue> getOutList() {
        return outList;
    }



    private MyIStack<IStatement> exeStack;
    private MyIMap<String,IValue> symTbl;
    private MyIList<IValue> outList;
    private IStatement originalStatement;
    private MyIMap<StringValue, BufferedReader> fileTable;
    public PrgState(IStatement originalStatement) {
        this.exeStack = new MyStack<IStatement>();
        this.symTbl = new MyMap<String,IValue>();
        this.outList = new MyList<IValue>();
        this.originalStatement=originalStatement.deepCopy();
        this.exeStack.push(originalStatement);
        this.fileTable = new MyMap<StringValue, BufferedReader>();
    }

    public MyIMap<StringValue, BufferedReader> getFileTable(){
        return this.fileTable;
    }
    public String fileTableToString(){
        StringBuilder s = new StringBuilder();
        s.append("File Table:\n");
        for(StringValue sv : fileTable.getKeys()){
            s.append(sv).append("\n");
        }
        return s.toString();

    }
    public String toString(){
        return "PrgState : \n"+exeStack.toString()+"\n"+symTbl.toString()+"\n"+outList.toString()+"\n"+fileTableToString();

    }
}