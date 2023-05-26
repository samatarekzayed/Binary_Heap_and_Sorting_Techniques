public class PriorityQueue {
    int l=0;
    int [] heap=new int[100000];
    public void swap(int arr[],int i1, int i2) {
        arr[i1] = arr[i1] ^ arr[i2];
        arr[i2] = arr[i1] ^ arr[i2];
        arr[i1] = arr[i1] ^ arr[i2];
    }
    ////////////////////////////////////////////////////////////////
    public int Heap_Extract_Max(){
        int max = heap[0]; //obviously maximum is the root
        heap[0] = heap[l-1];
        --l;
        heap ghost= new heap();
        ghost.maxHeapify(heap,l,0);
        return max;
    }
    ///////////////////////////////////////////////////////////////
    public void heapifyBottomUp(int z)
    {
        //mn t7t l fo2 tlama akbar mn zero w el child as8ar mn el parent swap w an2al 3la el parent
        while (z>0 && heap[(z-1)/2] < heap[z])
        {
            swap(heap,z,(z-1)/2);
            z=(z-1)/2;
        }
    }
    //////////////////////////////////////////////////////////////////
    public void max_heap_insert(int elem) {
        // h insert f ela5r b3dan h3ml heapify
        heap[l] = elem;
        heapifyBottomUp(l);
        l++;
    }
    ////////////////////////////////////////////////////////////////////

}
