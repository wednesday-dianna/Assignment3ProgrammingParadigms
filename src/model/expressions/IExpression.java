package model.expressions;

import exceptions.ADTException;
import exceptions.ExpressionException;
import model.ADT.MyIMap;
import model.values.IValue;

public interface IExpression {
    IValue eval(MyIMap<String, IValue> symTbl) throws ExpressionException, ADTException;
    public IExpression deepCopy();
}