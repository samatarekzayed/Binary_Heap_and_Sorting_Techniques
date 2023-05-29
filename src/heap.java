import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class heap {
public void maxHeapify(ArrayList<Integer> arr,  int length, int index) {
    int left = 2*index+1;
    int right = 2*index+2;
    int max=index;
    if( left<=length-1 && arr.get(left)>arr.get(index) )
        max=left;
    if(right<=length-1 && arr.get(right)>arr.get(max) )
        max=right;
    if(max!=index){
        swap(arr,index,max);
        maxHeapify(arr,length,max);
    }
}
///////////////////////////////////////////////////////////////////////////////
    public void BuildMaxHeap(ArrayList<Integer> arr){
        for (int i= (arr.size()/2)-1;i>=0;i--)
        {
            maxHeapify(arr,arr.size(),i);
        }
    }
///////////////////////////////////////////////////////////////////////////////////

    public void HeapSort(ArrayList<Integer> arr, boolean flag){
        BuildMaxHeap(arr);
        for (int i=arr.size()-1; i>=0 ; i--){
          swap(arr,0,i);
            maxHeapify(arr,i,0);
            if(flag==true)
                printArray(arr);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////
public void HeapSortPQ(ArrayList<Integer> arr, boolean flag){
    PriorityQueue pq=new PriorityQueue();
    for(int i=0;i<arr.size();i++)
        pq.max_heap_insert(arr.get(i));
    int length=pq.l;
    int len=pq.l-1;
    for(int j = 0; j<length ; j++) {
        swap(arr, findIndex(arr, pq.Heap_Extract_Max()), len--);

        if(flag=true)
            printArray(arr);
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////
    public  int findIndex(ArrayList<Integer> arr, int t)
    {
        int len = arr.size();
        int i = 0;
        while (i < len) {
            if (arr.get(i) == t)
                return i;
            else
                i = i + 1;
        }
   return -1;
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////

    public void swap(ArrayList<Integer> arr,int i1, int i2)
    {
        int temp=arr.get(i1);
        arr.set(i1,arr.get(i2));
        arr.set(i2,temp);
    }
////////////////////////////////////////////////////////////////////////////////////////
void printArray(ArrayList<Integer> arr){
    for (int i = 0; i < arr.size(); i++)
        System.out.print(arr.get(i)+" ");
    System.out.println();
}

}
