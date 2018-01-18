package lab_09;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTest {

    @Test
    public void insert0intoNewHeap_topIs0() {

        Heap heap = new Heap();
        heap.insert(0);

        assertEquals("size should be 1", 1, heap.size());
        assertEquals(0, heap.top(), 0.001);
        assertEquals(1, heap.size());
    }

    @Test
    public void insert0AndThen2intoNewHeap_topIs2() {

        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);

        assertEquals("size should be 2", 2, heap.size());
        assertEquals(2, heap.top(), 0.001);
    }


    @Test
    public void insert0And2And3And5And6intoNewHeap_topIs6() {

        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(6);

        assertEquals(6, heap.top(), 0.001);
    }

    @Test
    public void instert4elements() {
        Heap heap = new Heap();
        heap.insert(1);
        heap.insert(2);
        heap.insert(0);
        heap.insert(5);
        assertEquals("size should be 4", 4, heap.size());
    }

    @Test
    public void extractMaxTest() {
        Heap heap = new Heap();
        heap.insert(1);
        heap.insert(2);
        heap.insert(20);

        assertEquals(20, heap.extractMax(), 0);
        assertEquals("size should be 2", 2, heap.size());

    }

    @Test
    public void heapifyTest() {
        Heap heap = new Heap();
        heap.insert(1);
        heap.insert(2);
        heap.insert(20);
        heap.insert(4);
        heap.extractMax();
        heap.heapify(0);

        assertEquals(4, heap.top(), 0.001);
        //assertEquals("size should be 3", 3, heap.size());
    }

    @Test
    public void deleteMaxTest() {
        Heap heap = new Heap();
        heap.insert(1);
        heap.insert(2);
        heap.insert(20);
        heap.insert(13);
        heap.deleteMax();

        assertEquals(13, heap.top(), 0.001);
        assertEquals("size should be 3", 3, heap.size());
    }

    @Test
    public void replacetest() {
        Heap heap = new Heap();
        heap.insert(1);
        heap.insert(2);
        heap.replace();

        assertEquals(10, heap.top(), 0.001);
    }

    @Test
    public void mergetest() {
        Heap heap = new Heap();
        heap.insert(1);
        heap.insert(22);
        Heap heap2 = new Heap();
        heap2.insert(12);
        heap2.insert(20);

        assertEquals(4, heap.merge(heap2).size(), 0.001);
        assertEquals(22, heap.merge(heap2).top(), 0.001);
    }

    @Test
    public void meldtest() {
        Heap heap = new Heap();
        heap.insert(1);
        heap.insert(20);
        Heap heap2 = new Heap();
        heap2.insert(10);
        heap2.insert(2);
        heap.meld(heap2);

        assertEquals(4, heap.size(), 0.001);
        assertEquals(20, heap.top(), 0.001);
    }

}
