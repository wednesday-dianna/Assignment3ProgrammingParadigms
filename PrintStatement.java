package model.statements;

import exceptions.ADTException;
import exceptions.ExpressionException;
import model.expressions.IExpression;
import model.state.PrgState;
import model.values.IValue;

public class PrintStatement implements IStatement{
    private final IExpression expression;
    public PrintStatement(IExpression expression){
        this.expression = expression;
    }
    public PrgState execute(PrgState p) throws ExpressionException, ADTException {
        IValue v = expression.eval(p.getSymTbl());
        p.getOutList().add(v);
        return p;
    }
    public String toString(){
        return "print("+expression+")";
    }

    public IStatement deepCopy()
    {
        return new PrintStatement(expression);
    }
}