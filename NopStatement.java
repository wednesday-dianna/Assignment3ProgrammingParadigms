package model.statements;

import exceptions.ADTException;
import exceptions.ExpressionException;
import exceptions.StatementException;
import model.state.PrgState;

public class NopStatement implements IStatement
{
    @Override
    public PrgState execute(PrgState p) throws StatementException, ADTException, ExpressionException {
        return null;
    }

    @Override
    public IStatement deepCopy() {
        return null;
    }
}
