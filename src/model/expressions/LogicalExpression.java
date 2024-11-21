package model.expressions;


import exceptions.ADTException;
import exceptions.ExpressionException;
import model.ADT.MyIMap;
import model.types.BoolType;
import model.values.BoolValue;
import model.values.IValue;

public class LogicalExpression implements IExpression {
    private IExpression left;
    private IExpression right;
    private LogicalOperator operator;

    public LogicalExpression(IExpression left, LogicalOperator operator, IExpression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public IValue eval(MyIMap<String, IValue> symTbl) throws ExpressionException, ADTException {
        IValue leftResult = this.left.eval(symTbl);
        IValue rightResult = this.right.eval(symTbl);

        if (!leftResult.getType().equals(new BoolType())) {
            throw new ExpressionException("Left " + leftResult.getType() + "is not a bool");
        }
        if (!rightResult.getType().equals(new BoolType())) {
            throw new ExpressionException("Right " + rightResult.getType() + "is not a bool");
        }
        BoolValue rightBool = (BoolValue) rightResult;
        BoolValue leftBool = (BoolValue) leftResult;

        switch (operator) {
            case AND:
                return new BoolValue(leftBool.getValue() && rightBool.getValue());
            case OR:
                return new BoolValue(rightBool.getValue() || leftBool.getValue());
            default:
                throw new ExpressionException("Unknown operator");
        }

    }

    @Override
    public String toString() {
        return left.toString() + operator.toString() + right.toString();
    }
    @Override
    public IExpression deepCopy(){
        return new LogicalExpression(left.deepCopy(),operator,right.deepCopy());
    }
}