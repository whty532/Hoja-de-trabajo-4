package main.java;

public abstract class AbstractList<T> implements MyList<T>{
    protected int size = 0;

    public boolean IsEmpty(){
        return size == 0;
    }

    public int size() {
        return size;
    }
}