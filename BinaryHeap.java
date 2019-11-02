import java.util.*;

public class BinaryHeap {

    int size;
    int [] data;

    public BinaryHeap(){
        size = 0;
        data = new int[10];
    }

    public void add(int priority){
        if(size == data.length){
            growArray();
        }

        data[size++] = priority;
        int child = size - 1;
        int parent = (child - 1) / 2;

        while(parent >= 0 && (data[parent] > data[child])){
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public int remove(){
        if(size == 0){
            //System.out.println("Cannot remove item because the list is empty.");
            throw new IndexOutOfBoundsException();
        }
        int removed = data[0];
        data[0] = data[--size];
        siftdown(0);
        return removed;
    }

    void growArray(){
        int [] new_array = new int[data.length*2];
        for (int i = 0; i < data.length; i++){
            new_array[i] = data[i];
        }
        data = new_array;
    }

    private void siftdown(int parent){
        int child = 2 * parent + 1;
        if(child < size) {
            if (child + 1 < size && (data[child] > data[child + 1])) {
                child += 1;
            }
            if (data[parent] > data[child]) {
                swap(parent, child);
                siftdown(child);
            }
        }
    }

    void swap(int x, int y){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }
}
