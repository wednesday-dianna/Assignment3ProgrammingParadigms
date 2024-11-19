package view;

import controller.Controller;
import exceptions.ADTException;
import exceptions.ExpressionException;
import exceptions.StatementException;
import model.expressions.ArithmeticalExpression;
import model.expressions.VarExpression;
import model.expressions.ValueExpression;
import model.state.PrgState;
import model.statements.*;
import model.types.BoolType;
import model.types.IntType;
import model.values.BoolValue;
import model.values.IntValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static model.expressions.ArithmeticalOperator.MULTIPLY;
import static model.expressions.ArithmeticalOperator.PLUS;

public class View {
    private Controller ctr;
    private List<IStatement> stm;
    private void setUp(){
        stm = new ArrayList<>();
        IStatement i1 = new CompStmt(new VarDeclStatement("v",new BoolType()),new CompStmt(new AssignmentStatement("v",new ValueExpression(new IntValue(2))),new PrintStatement(new VarExpression("v"))));
        IStatement i2 = new CompStmt(new VarDeclStatement("a", new IntType()),new CompStmt(new VarDeclStatement("b",new IntType()),new CompStmt(new AssignmentStatement("a",new ArithmeticalExpression(new ValueExpression(new IntValue(2)),PLUS,new ArithmeticalExpression(new ValueExpression(new IntValue(3)),MULTIPLY,new ValueExpression(new IntValue(5))))),new CompStmt(new AssignmentStatement("b",new ArithmeticalExpression(new VarExpression("a"),PLUS,new ValueExpression(new IntValue(1)))),new PrintStatement(new VarExpression("b"))))));
        IStatement i3 = new CompStmt(new VarDeclStatement("a", new BoolType()),new CompStmt(new VarDeclStatement("v",new IntType()),new CompStmt(new AssignmentStatement("a",new ValueExpression(new BoolValue(true))),new CompStmt(new IfStatement(new VarExpression("a"),new AssignmentStatement("v",new ValueExpression(new IntValue(2))),new AssignmentStatement("v",new ValueExpression(new IntValue(3)))),new PrintStatement(new VarExpression("v"))))));
        stm.add(i1);
        stm.add(i2);
        stm.add(i3);
    }
    public View(Controller ctr) {
        this.ctr = ctr;
        setUp();

    }
    public void display(){
        System.out.println("Options:");
        System.out.println("1. Input a program");
        System.out.println("2. Complete execution of a program");
        System.out.println("Choose:");
    }
    public void start() {
        boolean on=true;
        while(on){
            display();
            int option = 0;
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            if(option==1){
                input();
            }
            if(option==2){
                on = false;
            }
            if (option!=1 && option!=2){
                System.out.println("Please enter a valid option");
            }
        }
    }
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a program:");
        for(int i=0;i<stm.size();i++){
            System.out.println((i+1)+": "+stm.get(i).toString());
        }
        int choice = sc.nextInt()-1;
        if(choice<0 || choice>stm.size()){
            System.out.println("Please enter a valid option");
        }
        IStatement st = stm.get(choice);
        PrgState prg = new PrgState(st);
        try{
            ctr.addPrgState(prg);
            ctr.allSteps();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

}