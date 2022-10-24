package swe4.collections;
import swe4.collections.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PriorityQueueMain {
    public static void main(String[] args) {
        System.out.println("PriorityQueueTest");

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(6);
        list.add(13);
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(15);
        list.add(17);
        PriorityQueue queue = new PriorityQueue(list);
        System.out.println("heap = " + queue/*.toString()*/);
        /*System.out.println("delete all 20 = " + queue.removeAll(20));
        System.out.println("heap = " + queue);*/
        //queue.heapify();
        queue.buildHeap();
        System.out.println("heapified heap = " + queue/*.toString()*/);
        queue.removeMax();
        System.out.println("dele heap = " + queue/*.toString()*/);
        Iterator i = queue.iterator();

        while ( i.hasNext() )
            System.out.println( "Eintrag: " + i.next() );
    }
}
//[232, 20, 233, 2, 20, 20]
//