public class ArrayDeque<T> {

    T[] item = (T[]) new Object[8];
    int size;
    int nextFirst;
    int nextLast;

    public void ArrayDeque() {
        item = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void resize() {
        int factor = 2;
        T[] newItem = (T[]) new Object[size * factor];
        System.arraycopy(item, 0, newItem, 0, size);
        item = newItem;
    }

    public void addFirst(T i) {
        item[nextFirst] = i;
        nextFirst -= 1;
        size += 1;
        if (nextFirst == nextLast) {
            resize();
        }
    }

    public void addLast(T i) {
        item[nextLast] = i;
        nextLast += 1;
        size += 1;
        if (nextLast == nextFirst) {
            resize();
        }
    }

    public T get(int index){
        return item[index];
    }

    public void printDeque(){

        while(nextFirst != nextLast+1) {
            System.out.println(item[nextFirst]);
            nextFirst += 1;
        }
    }


}

