package contanier.Interfaces;

public interface Task3Methods<E> {
    void pushBack(E obj);

    void popFront();

    void pushFront(E obj);

    void insert(E obj, int position);

    void removeAt(int position);

    boolean remove(E obj);

    void removeAll(E obj);

    void popBack();

    void clear();
}
