package model.statements;

import exceptions.ADTException;
import exceptions.ExpressionException;
import exceptions.StatementException;
import model.state.PrgState;

public class CompStmt implements IStatement{
    private IStatement statement1;
    private IStatement statement2;
    public CompStmt(IStatement statement1, IStatement statement2) {
        this.statement1 = statement1;
        this.statement2 = statement2;
    }
    @Override
    public PrgState execute(PrgState p) throws StatementException, ADTException, ExpressionException {
        p.getExeStack().push(statement2);
        p.getExeStack().push(statement1);
        return p;
    }

    @Override
    public IStatement deepCopy() {
        return new CompStmt(statement1.deepCopy(), statement2.deepCopy());
    }
    @Override
    public String toString() {
        return "("+statement1.toString()+" ; "+statement2.toString()+")";
    }
}