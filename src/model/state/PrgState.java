package model.state;

import exceptions.ADTException;
import model.ADT.*;
import model.values.*;
import model.statements.*;

import java.io.BufferedReader;
import java.util.Map;
import java.util.Set;

public class PrgState
{
    private MyIStack<IStatement> exeStack;
    private MyIMap<String,IValue> symTbl;
    private MyIList<IValue> outList;
    private IStatement originalStatement;
    private MyIMap<StringValue, BufferedReader> fileTable;

    public MyIStack<IStatement> getExeStack() {
        return exeStack;
    }
    public MyIMap<String, IValue> getSymTbl() {
        return symTbl;
    }
    public MyIList<IValue> getOutList() {
        return outList;
    }

    public PrgState(IStatement originalStatement) {
        this.exeStack = new MyStack<IStatement>();
        this.symTbl = new MyMap<String,IValue>();
        this.outList = new MyList<IValue>();
        this.originalStatement=originalStatement.deepCopy();
        this.exeStack.push(originalStatement);
        this.fileTable = new MyMap<StringValue, BufferedReader>();
    }

    public MyIMap<StringValue, BufferedReader> getFileTable()
    {
        return this.fileTable;
    }
    public String fileTableToString()
    {
        StringBuilder s = new StringBuilder();
        s.append("File Table:\n");
        for(StringValue sv : fileTable.getKeys())
        {
            s.append(sv).append("\n");
        }
        return s.toString();
    }

    public String exestackToString() {
        StringBuilder s = new StringBuilder();
        s.append("ExeStack:\n");
        s.append(exeStack.toString());
        s.append("SymTable:\n");
        s.append(this.symTbl.toString());
        s.append("Out:\n");
        s.append(this.outList.toString());
        s.append("FileTable:\n");
        s.append(this.fileTable.toString());

        return s.toString();
    }

    public String toString()
    {
        return "PrgState : \n"+exeStack.toString()+"\n"+symTbl.toString()+"\n"+outList.toString()+"\n"+fileTableToString();

    }
}