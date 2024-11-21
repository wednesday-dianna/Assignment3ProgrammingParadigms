package model.expressions;

import exceptions.ExpressionException;
import model.ADT.MyIMap;
import model.values.IValue;

public class ValueExpression implements IExpression
{
    private IValue value;

    public ValueExpression(IValue value)
    {
        this.value = value;
    }

    @Override
    public IValue eval(MyIMap<String, IValue> symTbl) throws ExpressionException
    {
        return value;
    }

    @Override
    public IExpression deepCopy()
    {
        return new ValueExpression(value);
    }

    @Override
    public String toString()
    {
        return "" + value;
    }
}
