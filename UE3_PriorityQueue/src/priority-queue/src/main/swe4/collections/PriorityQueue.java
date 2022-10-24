package swe4.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public final class PriorityQueue<T> implements Iterable <T> {
    public static Object[] heap = null;
    private static int size = 0;
    private static int left(int i) {  //static = Klassenmethode
        return 2*i+1;
    }

    private static int right(int i) {
        return 2*i+2;
    }

    private static int parent(int i) {
        return (i-1) / 2;
    }
    public PriorityQueue(){
        heap = new Object[11];
    }

    public PriorityQueue(Iterable<T> collection){
        heap = new Object[11];
        for (T element : collection){
            add(element);
        }
    }

    private void upHeap(int k) {
        if(size <= 1) return;

        Object e = heap[k];
        int comp = (((Comparable<T>) heap[parent(k)]).compareTo((T) e));
        while(k > 0 && comp < 0) {
            heap[k] = heap[parent(k)];
            k = parent(k);
        }

        heap[k] = e;
    }

    public void add(T element){
        size++;
        if (size == heap.length) increaseCapacity();
        heap[size-1] = element;
        upHeap(size-1);
    }

    public void add (Iterable<T> collection){
        for (T element : collection){
            size++;
            if (size == heap.length) increaseCapacity();
            heap[size-1] = element;
        }
        buildHeap();
    }

    public int removeAll(T element){
        int count = 0;
        for (int i =0; i < size; i++){
            if (heap[i] == element){
                System.arraycopy(heap, i + 1, heap, i, heap.length - i - 1);
                count++;
                i--;
                size--;
            }
        }
        return count;
    }

    private void downHeap(int k) {
        Object e = heap[k];

        while(k <= parent(size-1)) {
            int j = left(k);
            int comp = (((Comparable<T>) heap[j]).compareTo((T) heap[j+1]));
            if (j < size-1 && comp < 0) j++;
            int comp2 = (((Comparable<T>) e).compareTo((T) heap[j]));
            if (comp2 >= 0) //Element muss nicht mehr nach unten
                break;

            heap[k] = heap[j];  //siehe Zeichnung
            k = j;
        }

        heap[k] = e;
    }

    public boolean removeMax(){
        if (size == 0) return false;
        heap[0] = heap[size-1]; //schiebe letztes Element nach ganz oben
        size--;
        downHeap(0);
        return true;
    }

    public T max(){
        if (size == 0) throw new ArrayIndexOutOfBoundsException("Empty Array");
        return (T)heap[0];
    }

    public int size(){
        return size;
    }

    private void heapify(Object arr[], int n, int i)
    {
        int largest = i;
        int l = (2 * i) + 1;
        int r = (2 * i) + 2;

        if (l < n) {
            int comp = (((Comparable<T>) heap[l]).compareTo((T) arr[largest]));
            if (comp > 0) {
                largest = l;
            }
        }

        if (r < n){
            int comp2 = (((Comparable<T>)heap[r]).compareTo((T) arr[largest]));
            if (comp2 > 0) {
                largest = r;
            }
        }

        if (largest != i) {
            Object swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public void buildHeap()
    {
        
        int startIdx = (size / 2) - 1;

        for (int i = startIdx; i >= 0; i--) {
            heapify(heap, size, i);
        }
    }

    private void increaseCapacity(){
        System.out.println("Length of initial array = " + heap.length);
        int len = heap.length;
        Object newHeap[] = new Object[len*2];
        System.arraycopy(heap, 0, newHeap, 0, len);
        heap = newHeap;
        System.out.println("Length of new array = "+heap.length);
    }

    private final class ArrayIterator <T> implements Iterator <T>
    {
        private Object array[];
        private int    pos = 0;

        public ArrayIterator()
        {
            array = heap;
            Arrays.sort(array,0,size(),Collections.reverseOrder());
        }

        private void updateArray(){
            array = heap;
            Arrays.sort(array,Collections.reverseOrder());
        }

        public boolean hasNext()
        {
            return pos < size;
        }

        public T next() throws InvalidIteratorException
        {
            if ( hasNext() )
                return (T) array[pos++];
            else
                throw new InvalidIteratorException("No next");
        }
    }

    @Override
    public Iterator<T> iterator() {
            return new ArrayIterator();
    }

    @Override //Annotation
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i=0; i<size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(heap[i]);
        }
        sb.append("]");
        return sb.toString();
    }

}
