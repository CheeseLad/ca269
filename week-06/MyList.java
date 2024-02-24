interface MyList<E> {
    void add(E e);
    void add(E e, int pos);
    E remove();
    E remove(int pos);
    void clear();
    int size();
    int contains(E e);
}

class MyArrayList<E> implements MyList<E> {
    private E[] array = (E[])new Object[100]; // DANGEROUS!
    private int size = 0;

    public void add(E e) {
        this.array[size] = e;
        size += 1;
    }

    public String toString() {
        String output = "[";
        for(int i=0; i<size; i++) {
            output += array[i] + ",";
        }
        return output + "]";
    }

    // TODO: add
    // TODO: remove from end
    // TODO: remove at position
    // TODO: clear
    // TODO: size
    // TODO: contains
}