import java.util.ArrayList;

public class PriorityQueue {
    int l=0;
    ArrayList<Integer> heap= new ArrayList<Integer>();
    public void swap(ArrayList<Integer> arr,int i1, int i2)
    {
        int temp=arr.get(i1);
        arr.set(i1,arr.get(i2));
        arr.set(i2,temp);
    }
    ////////////////////////////////////////////////////////////////
    public int Heap_Extract_Max(){
        int max = heap.get(0); //obviously maximum is the root
        heap.set(0,heap.get(l-1));
        --l;
        heap ghost= new heap();
        ghost.maxHeapify(heap,l,0); //////
        return max;
    }
    ///////////////////////////////////////////////////////////////
    public void heapifyBottomUp(int z)
    {
        //mn t7t l fo2 tlama akbar mn zero w el child as8ar mn el parent swap w an2al 3la el parent
        while (z>0 && heap.get((z-1)/2) < heap.get(z))
        {
            swap(heap,z,(z-1)/2);
            z=(z-1)/2;
        }
    }
    //////////////////////////////////////////////////////////////////
    public void max_heap_insert(int elem) {
        // h insert f ela5r b3dan h3ml heapify
        heap.add(elem);
        heapifyBottomUp(l);
        l++;
    }
    ////////////////////////////////////////////////////////////////////

}
