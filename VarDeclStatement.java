package model.statements;

import exceptions.StatementException;
import model.state.PrgState;
import model.types.IType;

public class VarDeclStatement implements IStatement
{
    String name;
    IType type;

    public VarDeclStatement(String name, IType type)
    {
        this.name = name;
        this.type = type;
    }

    @Override
    public PrgState execute(PrgState p) throws StatementException
    {
        if(p.getSymTbl().containsKey(name))
        {
            throw new StatementException("Variable '" + this.name + "' already exists");
        }
        p.getSymTbl().put(name,type.getDefaultValue());
        return p;
    }

    @Override
    public IStatement deepCopy() {
        return new VarDeclStatement(name,type);
    }

    public String toString()
    {
        return "Variable '" + name + "'";
    }
}

