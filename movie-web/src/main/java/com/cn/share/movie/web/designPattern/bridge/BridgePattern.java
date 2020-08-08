package com.cn.share.movie.web.designPattern.bridge;

// 实现化角色
interface Implementor{
    public void OperationImpl();
}
//具体实现化角色
class ConcreteImplementor1 implements Implementor{

    @Override
    public void OperationImpl() {
        System.out.println("ConcreteImplementor1");
    }
}
//具体实现化角色
class ConcreteImplementor2 implements Implementor{

    @Override
    public void OperationImpl() {
        System.out.println("ConcreteImplementor2");
    }
}
//抽象化角色
abstract class Abstraction{

    protected Implementor implementor;

    public Abstraction(Implementor implementor){
        this.implementor = implementor;
    }

    public abstract void OperationImpl();
}
//扩展抽象化角色
class RefineAbstraction extends Abstraction{

    public RefineAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void OperationImpl() {
        System.out.println("RefineAbstraction");
        // 调用Implementor接口的方法
        implementor.OperationImpl();
    }
}

public class BridgePattern {

    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementor1();
        Abstraction abstraction = new RefineAbstraction(implementor);
        abstraction.OperationImpl();
    }
}
