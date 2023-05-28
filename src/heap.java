import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class heap {
public void maxHeapify(int arr[],  int length, int index) {
    int left = 2*index+1;
    int right = 2*index+2;
    int max=index;
    if( left<=length-1 && arr[left]>arr[index] )
        max=left;
    if(right<=length-1 && arr[right]>arr[max] )
        max=right;
    if(max!=index){
        swap(arr,index,max);
        maxHeapify(arr,length,max);
    }
}
    ///////////////////////////////////////////////////////////////////////////////
    public void BuildMaxHeap(int arr[]){
        for (int i= (arr.length/2)-1;i>=0;i--)
        {
            maxHeapify(arr,arr.length,i);
        }
    }
///////////////////////////////////////////////////////////////////////////////////

    public void HeapSort(int []arr, boolean flag){
        BuildMaxHeap(arr);
        for (int i=arr.length-1; i>=0 ; i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            maxHeapify(arr,i,0);
            if(flag==true)
                printArray(arr);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////
public void HeapSortPQ(int []arr, boolean flag){
    PriorityQueue pq=new PriorityQueue();
    for(int i=0;i<arr.length;i++)
        pq.max_heap_insert(arr[i]);
    int length=pq.l;
    int len=pq.l-1;
    for(int j = 0; j<length && pq.l!=0; j++) {
        swap(arr, findIndex(arr, pq.Heap_Extract_Max()), len--);
        if(flag=true)
            printArray(arr);
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////
    public  int findIndex(int arr[], int t)
    {
        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (arr[i] == t)
                return i;
            else
                i = i + 1;
        }
   return -1;
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////

    public void swap(int arr[],int i1, int i2) {
        int temp=arr[i1];
        arr[i1]=arr[i2];
        arr[i2]=temp;
    }
////////////////////////////////////////////////////////////////////////////////////////
void printArray(int[] arr){
    for (int i = 0; i < arr.length ; i++)
        System.out.print(arr[i]+" ");
    System.out.println();
}

}
