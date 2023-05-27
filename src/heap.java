import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    public void swap(int arr[],int i1, int i2) {
        arr[i1] = arr[i1] ^ arr[i2];
        arr[i2] = arr[i1] ^ arr[i2];
        arr[i1] = arr[i1] ^ arr[i2];
    }
////////////////////////////////////////////////////////////////////////////////////////
void printArray(int[] arr){
    for (int i = 0; i < arr.length ; i++)
        System.out.print(arr[i]+" ");
    System.out.println();
}

}
