public class LinkedListDeque<T> {
    public class Node<T> {
        public Node<T> prev;
        public T item;
        public Node<T> next;

        public Node(Node prev, T i, Node next){
            prev = null;
            item = i;
            next = null;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private Node<T> sentFront;
    private Node<T> sentBack;
    private int size;

    public LinkedListDeque() {
        sentFront = new Node<>(null, null, sentBack);
        sentBack = new Node<>(sentFront, null, null);
        size = 0;
    }


    public void addFirst(T i) {
        Node<T> toadd = new Node<>(null, i, null);
        sentFront.next = toadd;
        toadd.next = sentBack;
        toadd.prev = sentFront;
        sentBack.prev = toadd;
        size += 1;
    }

    public void addLast(T i) {
        Node<T> toadd = new Node<>(null, i, null);
        toadd.prev = sentBack.prev;
        sentBack.prev = toadd;
        toadd.next = sentBack;
        toadd.prev.next = toadd;
        size += 1;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int pindex = size;
        Node start = sentFront.next;
        while(pindex != 0) {
            System.out.println(start.item);
            pindex -= 1;
            start = start.next;
        }
    }

    public T removeFirst() {
        T rmFirst = sentFront.next.item;
        sentFront.next = sentFront.next.next;
        sentFront.next.prev = sentFront;
        size -= 1;
        return rmFirst;
    }

    public T removeLast() {
        T rmLast = sentBack.prev.item;
        sentBack.prev = sentBack.prev.prev;
        sentBack.prev.next = sentBack;
        size -= 1;
        return rmLast;
    }

    public T get(int index) {
        int p = 0;
        Node<T> g = sentFront.next;
        while(p != index){
            g = g.next;
            p += 1;
        }
        return g.item;
    }

    public T getRecursive(int index) {
        Node<T> g = sentFront.next;
        if (index == 0) {
            return g.item;
        }
        g = g.next;
        return getRecursive(index - 1);
    }
}
