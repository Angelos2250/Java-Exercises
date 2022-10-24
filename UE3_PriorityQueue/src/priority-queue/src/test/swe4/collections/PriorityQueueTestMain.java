package swe4.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTestMain {
    //Constructor Tests
    @Test
    @DisplayName("Create New and empty PQ")
    void newEmptyPQ(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println("size: " + pq.size());
    }

    @Test
    @DisplayName("Create New PQ with a String list of size 11")
    void newPQFromIntList(){
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
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        assertEquals(11,pq.size());
    }

    @Test
    @DisplayName("Create New PQ with a String list of size 11")
    void newPQFromStringList(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("3");
        list.add("5");
        list.add("4");
        list.add("6");
        list.add("13");
        list.add("10");
        list.add("9");
        list.add("8");
        list.add("15");
        list.add("17");
        PriorityQueue<String> pq = new PriorityQueue<>(list);
        assertEquals(11,pq.size());
    }

    //Iterator Tests
    @Test
    @DisplayName("Create Iterator on empty PQ")
    void newItOnEmptyPQ(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Iterator i = pq.iterator();
    }

    @Test
    @DisplayName("Create Iterator on filled PQ")
    void newItOnFilledPQ(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(22);
        pq.add(45);
        Iterator i = pq.iterator();
    }

    @Test
    @DisplayName("Create Iterator, iterate and return every Item in PQ until the last one (sorted)")
    void newItOnFilledPQSortedOutput(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(22);
        pq.add(45);
        Iterator i = pq.iterator();
        assertEquals(45,i.next());
        assertEquals(22,i.next());
        assertEquals(10,i.next());
    }

    @Test
    @DisplayName("Create Iterator on empty PQ iterate through it, Exception expected")
    void newItOnEmptyPQIterate(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Iterator i = pq.iterator();
        assertThrows(InvalidIteratorException.class,() -> { i.next(); });
    }

    @Test
    @DisplayName("Create Iterator, Check if iterates through duplicate values")
    void newItOnFilledPQIterateDuplicates(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(10);
        pq.add(10);
        Iterator i = pq.iterator();
        assertEquals(10,i.next());
        assertEquals(10,i.next());
        assertEquals(10,i.next());
    }

    @Test
    @DisplayName("Create Iterator, Has no next on empty PQ")
    void newItOnEmptyPQHasNoNext(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Iterator i = pq.iterator();
        assertEquals(false,i.hasNext());
    }

    //add() Tests
    @Test
    @DisplayName("Create PQ, add Interger, Test toString")
    void addIntPQ(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        assertEquals("[10]",pq.toString());
    }

    @Test
    @DisplayName("Create PQ, add String, Test toString and heap properties")
    void addStringPQ(){
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Erster String");
        pq.add("Zweiter String");
        assertEquals("Zweiter String",pq.max());
    }

    @Test
    @DisplayName("Create PQ, add String List, Test toString and heap properties")
    void addStringListPQ(){
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Erster String");
        pq.add("Zweiter String");
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("3");
        list.add("5");
        list.add("4");
        pq.add(list);
        assertEquals("Zweiter String",pq.max());
    }

    //removeAll() Tests
    @Test
    @DisplayName("Create PQ, Remove all occurances of String")
    void RemoveStringPQ(){
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Erster String");
        pq.add("Zweiter String");
        pq.add("Zweiter String");
        pq.add("Zweiter String");
        pq.add("Zweiter String");
        List<String> list = new ArrayList<String>();
        list.add("4");
        list.add("3");
        list.add("4");
        list.add("4");
        pq.add(list);
        pq.removeAll("Zweiter String");
        assertEquals("Erster String",pq.max());
    }

    @Test
    @DisplayName("Create PQ, Remove all occurances of Int also check size")
    void RemoveIntPQCheckSize(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(3);
        pq.add(3);
        pq.add(3);
        pq.add(2);
        pq.add(3);
        pq.removeAll(3);
        assertEquals(2,pq.size());
        assertEquals(2,pq.max());
    }

    //Heapify() Tests
    @Test
    @DisplayName("Create PQ, Heapify Int PQ")
    void HeapifyIntPQ(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(2);
        pq.add(2);
        pq.add(3);
        pq.add(2);
        pq.buildHeap();
        assertEquals(3,pq.max());
    }

    @Test
    @DisplayName("Create PQ, Heapify String PQ")
    void HeapifyStringPQ(){
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Erster String");
        pq.add("Zweiter String");
        List<String> list = new ArrayList<String>();
        list.add("4");
        list.add("3");
        list.add("4");
        list.add("4");
        pq.add(list);
        assertEquals("Zweiter String",pq.max());
    }

    //removeMax() Tests
    @Test
    @DisplayName("Create PQ, remove max Int from PQ")
    void removeMaxIntPQ(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(2);
        pq.add(2);
        pq.add(3);
        pq.add(2);
        int prevSize = pq.size();
        pq.removeMax();
        assertEquals(2,pq.max());
        assertEquals(prevSize-1,pq.size());
    }

    @Test
    @DisplayName("Create PQ, remove max String from PQ")
    void removeMaxStringPQ(){
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Erster String");
        pq.add("Zweiter String");
        List<String> list = new ArrayList<String>();
        list.add("4");
        list.add("3");
        list.add("4");
        list.add("4");
        pq.add(list);
        int prevSize = pq.size();
        pq.removeMax();
        assertEquals("Erster String",pq.max());
        assertEquals(prevSize-1,pq.size());
    }

    @Test
    @DisplayName("Create PQ, remove max String 2x from PQ")
    void removeMaxString2xPQ(){
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Erster String");
        pq.add("Zweiter String");
        List<String> list = new ArrayList<String>();
        list.add("4");
        list.add("3");
        list.add("4");
        list.add("4");
        pq.add(list);
        int prevSize = pq.size();
        pq.removeMax();
        pq.removeMax();
        assertEquals("[4, 4, 4, 3]",pq.toString());
        assertEquals(prevSize-2,pq.size());
    }

    //Other Tests

    //size when empty
    @Test
    @DisplayName("Create empty PQ, get size 0 Expected")
    void emptyPQSize(){
        PriorityQueue<String> pq = new PriorityQueue<>();
        assertEquals(0,pq.size());
    }
    //size before and after deleting
    @Test
    @DisplayName("Create PQ, get size add get size")
    void PQSize(){
        PriorityQueue<String> pq = new PriorityQueue<>();
        assertEquals(0,pq.size());
        pq.add("12");
        pq.add("asdae");
        assertEquals(2,pq.size());
    }
    //ToString LocalDate
    @Test
    @DisplayName("Create PQ, LocalDate ToString")
    void PQLocalDate(){
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        assertEquals(0,pq.size());
        pq.add(LocalDate.parse("2007-12-03"));
        pq.add(LocalDate.parse("2008-12-03"));
        assertEquals(2,pq.size());
        assertEquals("[2008-12-03, 2007-12-03]",pq.toString());
    }

    //max when empty
    @Test
    @DisplayName("Create empty PQ, try max error expected")
    void PQMaxLocalDate(){
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> { pq.max(); });
    }

}
