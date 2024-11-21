package model.ADT;

import exceptions.ADTException;
import exceptions.EmptyStackException;

import java.util.Stack;

public class MyStack<T> implements MyIStack<T>
{
    private Stack<T> stack;

    //Constructor Default
    public MyStack()
    {
        this.stack = new Stack<>();
    }

    //Constructor explicit
    public MyStack(Stack<T> stack)
    {
        this.stack = stack;
    }

    @Override
    public T pop() throws ADTException
    {
        if (stack.isEmpty())
        {
            throw new EmptyStackException();
        }
        return stack.pop(); //Afiseaza elementul pe care il sterge
    }

    @Override
    public void push(T value)
    {
        stack.push(value);
    }

    @Override
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Exec stack:\n");
        for (T t : stack) {
            str.append(t).append("\n");
        }
        return str.toString();
    }
}
