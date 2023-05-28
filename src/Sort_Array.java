import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Sort_Array {

    int[] arr;
    //////////////////////////constructor
    Sort_Array(String path) throws FileNotFoundException {
        arr=readFromFile(path);
    }
    int[] readFromFile(String path) throws FileNotFoundException {
        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            String str = myReader.nextLine();
            String[] arrOfStr = str.split(",");
            int length=arrOfStr.length;
            int[] arr=new int[length];
            for (int i=0;i<length;i++) {
                arr[i]=Integer.parseInt(arrOfStr[i]);
            }
            myReader.close();
            return arr;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }

    }
    void printArray(int[] arr){
        for (int i = 0; i < arr.length ; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    ////////////////////////////////simple sort o(n^2)/////////////////////////////////////////
    public int[] bubble_sort(boolean flag){
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                    if(flag)
                        printArray(arr);
                }

        return arr;
    }

    ///////////////////////////efficient sort o(nlgn)/////////////////////////////////////////
    public void merge_sort_util(int[] arr)
    {
        if(arr.length<2)
            return;
        int middle= arr.length/2;
        int left[]=new int[middle];
        int right[]=new int[arr.length-middle];
        for(int i=0;i<middle;i++)
            left[i]=arr[i];
        for(int i=middle;i<arr.length;i++)
            right[i-middle]=arr[i];
        merge_sort_util(left);
        merge_sort_util(right);
        merge(left,right,arr);
    }
    public int[] merge_sort(boolean flag)
    {
        merge_sort_util(arr);
        if(flag==true)
            printArray(arr);
        return arr;
    }

    private void merge(int[] left,int[] right,int[] merged)
    {
        int i = 0;
        int j = 0;
        int z = 0;
        while (i < left.length && j < right.length)
        {
            if (left[i] <= right[j])
                merged[z++] = left[i++];
            else
                merged[z++] = right[j++];
        }
        while (i < left.length)
            merged[z++] = left[i++];
        while (j < right.length)
            merged[z++] = right[j++];
    }
    ////////////////////////////////non comparison sort o(n) radix sort/////////////////////////////
    void countingSort(int array[], int size, int place) {
        int[] output = new int[size + 1];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++; //tzwd 1 3la digit 8 msln law mwgod
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i]/ place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
            array[i] = output[i];
    }

    int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }
    int getMin(int array[], int n) {
        int min = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] < min)
                min = array[i];
        return min;
    }
    int[] radix_sort(boolean flag)
    {
        int size=arr.length;
        int min=getMin(arr,size);
        if(min<0) {
            for (int i = 0; i < size; i++) {
                arr[i]+=(-1*min);
            }
        }
        radix_sortutil(flag);
        for (int i = 0; i < size; i++)
            arr[i] = arr[i]+min;

        return arr;
    }

    int[] radix_sortutil(boolean flag)
    {
        int size=arr.length;
        int max = getMax(arr, size);
        for (int place = 1; abs(max / place) > 0; place *= 10) {
            countingSort(arr, size, place);
            if(flag==true)
                printArray(arr);
        }
        // countingSort(arr,size,-1);
        return arr;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public void swap(int arr[],int i1, int i2) {
        int temp=arr[i1];
        arr[i1]=arr[i2];
        arr[i2]=temp;
    }

}
