package model.statements;

import exceptions.ADTException;
import exceptions.ExpressionException;
import exceptions.StatementException;
import model.expressions.*;
import model.state.PrgState;
import model.values.IValue;

public class AssignmentStatement implements IStatement {
    private String variable;
    private IExpression expression;

    public AssignmentStatement(String variable, IExpression expression) {
        this.variable = variable;
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState p) throws StatementException, ADTException, ExpressionException {
        if (!p.getSymTbl().containsKey(variable)) {
            throw new StatementException("Variable " + variable + " not found");
        }
        IValue value = null;
        try {
            value = expression.eval(p.getSymTbl());
        } catch (ExpressionException e) {
            throw new RuntimeException(e);
        }
        if (!value.getType().equals(p.getSymTbl().getValue(variable).getType())) {
            throw new StatementException("The types do not correspond");
        }
        p.getSymTbl().put(variable, value);
        return p;
    }

    @Override
    public String toString() {
        return variable + " = " + expression;
    }
    @Override
    public IStatement deepCopy(){
        return new AssignmentStatement(variable,expression.deepCopy());
    }
}

