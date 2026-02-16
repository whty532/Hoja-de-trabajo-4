package ht4;

public abstract class AbstractList<T> implements MyList<T>{
    protected int size = 0;

    @Override
    public boolean isEmpty(){

        return size == 0;
    }

    
    @Override
    public int size() {
        return size;
    }
}