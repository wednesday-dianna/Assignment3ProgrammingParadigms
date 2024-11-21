package model.expressions;

import model.ADT.MyIMap;
import exceptions.ADTException;
import exceptions.ExpressionException;
import model.values.IValue;

public class VarExpression implements IExpression
{
    private String id;

    public VarExpression(String id)
    {
        this.id = id;
    }

    @Override
    public IValue eval(MyIMap<String, IValue> symTbl) throws ExpressionException, ADTException {
        return symTbl.getValue(id);
    }

    @Override
    public IExpression deepCopy()
    {
        return new VarExpression(id);
    }

    @Override
    public String toString()
    {
        return id;
    }
}
