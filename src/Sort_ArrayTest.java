import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


class Sort_ArrayTest {
    heap heap = new heap();

@Test
    void size_10() throws FileNotFoundException {
    Sort_Array bubble=new Sort_Array("src/10");
    long start = System.nanoTime();
    int[] arr=bubble.bubble_sort();
    long end= System.nanoTime();
    assertArrayEquals(arr, new int[]{0, 1, 2, 10, 15, 20, 30, 30, 40, 50});
    System.out.println("\nexecution time for  bubble Sort: " + (end- start) + " nanosecond\n");
    System.out.println("after bubble sort : " + Arrays.toString(arr));
    System.out.println("------------------------------------------------------------------");

    Sort_Array merge=new Sort_Array("src/10");
    long start2 = System.nanoTime();
    int[] arr2=merge.merge_sort();
    long end2= System.nanoTime();
    assertArrayEquals(arr2, new int[]{0, 1, 2, 10, 15, 20, 30, 30, 40, 50});
    System.out.println("\nexecution time for  merge Sort: " + (end2- start2) + " nanosecond\n");
    System.out.println("after bubble sort : " + Arrays.toString(arr2));
    System.out.println("------------------------------------------------------------------");

    Sort_Array radix=new Sort_Array("src/10");
    long start3 = System.nanoTime();
    int[] arr3=radix.radix_sort();
    long end3= System.nanoTime();
    assertArrayEquals(arr3, new int[]{0, 1, 2, 10, 15, 20, 30, 30, 40, 50});
    System.out.println("\nexecution time for radix Sort: " + (end3- start3) + " nanosecond\n");
    System.out.println("after bubble sort : " + Arrays.toString(arr3));
    System.out.println("------------------------------------------------------------------");

        heap heap=new heap();
        File file = new File("src/10");
        Scanner myReader = new Scanner(file);
        String str = myReader.nextLine();
        String[] arrOfStr = str.split(",");
        int length=arrOfStr.length;
        int[] arr4 =new int[length];
        for (int i=0;i<length;i++) {
            arr4[i]=Integer.parseInt(arrOfStr[i]);
        }
        myReader.close();
        long start4= System.nanoTime();
        heap.HeapSort(arr4);
        long end4= System.nanoTime();
        assertArrayEquals(arr4, new int[]{0, 1, 2, 10, 15, 20, 30, 30, 40, 50});
        System.out.println("\nexecution time for heap Sort: " + (end4- start4) + " nanosecond\n");
        System.out.println("after heap sort : " + Arrays.toString(arr4));
        System.out.println("------------------------------------------------------------------");
    }


}