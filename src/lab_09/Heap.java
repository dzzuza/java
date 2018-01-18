package lab_09;

import java.util.ArrayList;

import static java.util.Collections.swap;

public class Heap {

    private int heapSize = 0;
    private ArrayList<Double> tab = new ArrayList<>();

    public void insert(double value) {
        int currentIndex = heapSize;
        int parentIndex = parentIndex(currentIndex);
        tab.add(value);
        while (isChildGreaterThanParent(currentIndex, parentIndex)) {
            swapElements(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = parentIndex(currentIndex);
        }
        heapSize++;
    }

    public boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
        return tab.get(currentIndex) > tab.get(parentIndex);
    }

    public void swapElements(int currentIndex, int parentIndex) {
        Double parentValue = parentValue(currentIndex);
        Double currentValue = tab.get(currentIndex);
        tab.set(parentIndex, currentValue);
        tab.set(currentIndex, parentValue);
    }

    public Double parentValue(int currentIndex) {
        Double parentValue = tab.get(parentIndex(currentIndex));
        return parentValue;
    }

    public int parentIndex(int currentIndex) {
        return currentIndex / 2;
    }

    public int size() {
        return heapSize;
    }

    public double top() {
        return tab.get(0);
    }

    public double extractMax() {
        double max = tab.get(0);
        tab.set(0, tab.get(tab.size() - 1));
        tab.remove(tab.size() - 1);
        heapSize--;
        heapify(0);
        return max;
    }


    public void deleteMax() {
        double tmp;
        tmp=tab.get(0);
        tab.set(0, tab.get(tab.size() - 1));
        tab.set(tab.size() - 1,tmp);
        tab.remove(heapSize - 1);
        heapSize--;
        heapify(0);
    }

    public void replace() {
        double k =10;
        tab.set(0, k);
        heapify(0);
    }
    public void heapify(int i) {
        int left = i * 2+1;
        int right = 2*i+ 2;
        int max = i;

        if (left < heapSize && tab.get(left).compareTo(tab.get(i)) > 0) {
            max = left;
        }
        if (right < heapSize && tab.get(right).compareTo(tab.get(max)) > 0) {
            max = right;
        }
        if (max != i) {
            double tmp=tab.get(i);
            tab.set(i, tab.get(max));
            tab.set(max, tmp);
            heapify(max);
        }
    }

    public void meld(Heap heap2){
        heapSize+=heap2.heapSize;
        this.tab.addAll(heap2.tab);
        heapify(0);
    }

    public Heap merge(Heap heap2){
        Heap heapout = new Heap();
        heapout.heapSize=this.heapSize+ heap2.heapSize;
        if(this.top()>heap2.top()){
            heapout.tab.addAll(this.tab);
            heapout.tab.addAll(heap2.tab);
        }
        else {
            heapout.tab.addAll(heap2.tab);
            heapout.tab.addAll(this.tab);
        }
        return heapout;
    }


}