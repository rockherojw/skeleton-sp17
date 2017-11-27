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
            if(nextFirst == item.length - 1) {
                System.out.println(item[nextFirst]);
                nextFirst = 0;
            } else {
                System.out.println(item[nextFirst]);
            }
            nextFirst += 1;
        }
    }
// STOP HERE at 11/28/17

    public T removeFirst(){
        T firstReturn = item[nextInQue(nextFirst,size)];
        item[nextInQue(nextFirst,size)] = null;
        nextFirst = nextInQue(nextFirst,size);
        size -= 1;
        halve();
        return firstReturn;
    }

    public T removeLast(){
        T lastReturn = item[preInQue(nextLast,size)];
        item[preInQue(nextLast,size)] = null;
        nextFirst = preInQue(nextLast,size);
        size -= 1;
        halve();
        return lastReturn;
    }

    private int nextInQue(int i, int size){
        if (i ==size){
            return 0;
        }
        else {return i+1;}
    }

    private int preInQue(int i, int size){
        if (i == 0){
            return size;
        }
        else {return i-1;}
    }

    private void halve(){
        double R = 0.25;
        double usageRatio = size / item.length;
        if (usageRatio < R && size > 16){
            int factor = 2;
            T[] newItem = (T[]) new Object[size % factor];
            System.arraycopy(item, 0, newItem, 0, size);
            item = newItem;
        }
    }

}

