import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        heap heap = new heap();
        PriorityQueue prioque = new PriorityQueue();
        System.out.println("1-Build Max Heap");
        System.out.println("2-Max Heap Insert");
        System.out.println("3-Heap Extract Max");
        System.out.println("4-Heap Sort");
        System.out.println("5-Bubble Sort");
        System.out.println("6-Merge Sort");
        System.out.println("7-Radix Sort");
        System.out.println("8-EXIT");
        //
        boolean sama=true;
        while(sama)
        {
            System.out.println();
            System.out.println("Enter the number of your choice:");
        int op;
        Scanner sc=new Scanner(System.in);
        op = sc.nextInt();
        sc.nextLine();
            switch (op) {
                case 1: {
                    System.out.println("Enter the array: ");
                    String str = sc.nextLine();
                    String[] ss = str.split(",");
                    int[] arr = new int[ss.length];
                    for (int i = 0; i < ss.length; i++) {
                        arr[i] = Integer.valueOf(ss[i]);
                    }
                    heap.BuildMaxHeap(arr);
                    System.out.println("Array after building:");
                    for (int i = 0; i < arr.length; ++i) {
                        System.out.print(" " + arr[i]);
                    }
                    break;
                }

                ////////////////////////////////////////////////////////
                case 2: {
                    System.out.println("Enter the numbers to be inserted:"); //benhom ,
                    String str = sc.nextLine();
                    String[] strr = str.split(",");
                    for (int i = 0; i < strr.length; i++) {
                        prioque.max_heap_insert(Integer.valueOf(strr[i]));
                    }
                    System.out.println("After insertion:");
                    for (int i = 0; i < prioque.l; ++i) { // l is the length in priority queue class
                        System.out.print(prioque.heap[i]);
                        System.out.print(" ");
                    }
                    break;
                }
                ////////////////////////////////////////////////////////
                case 3: {
                    if (prioque.l > 0)
                        System.out.println("Maximum: " + prioque.Heap_Extract_Max());
                    else
                        System.out.println("You have not inserted any element,heap is empty");
                 break;
                }
                ////////////////////////////////////////////////////////
                case 4: {
                    System.out.println("enter the file path:");
                    String path = s.nextLine();
                    File file = new File(path);
                    Scanner myReader = new Scanner(file);
                    String str = myReader.nextLine();
                    String[] arrOfStr = str.split(",");
                    int length=arrOfStr.length;
                    int[] arr4 =new int[length];
                    for (int i=0;i<length;i++) {
                        arr4[i]=Integer.parseInt(arrOfStr[i]);
                    }
                    myReader.close();
                    System.out.println("Array after heap sorting:");
                    heap.HeapSort(arr4);
                    for (int i = 0; i < arr4.length; ++i) {
                        System.out.print(" " + arr4[i]);
                    }
                    break;
                }
                ////////////////////////////////////////////////////////
                case 5: {
                    System.out.println("enter the file path:");
                    String path = s.nextLine();
                    Sort_Array sort=new Sort_Array(path);
                    System.out.println("Array after bubble sorting:");
                    int[] arr=sort.bubble_sort();
                    for (int i = 0; i < arr.length; ++i) {
                        System.out.print(" " + arr[i]);
                    }
                    break;
                }
                ////////////////////////////////////////////////////////

                case 6: {
                    System.out.println("enter the file path:");
                    String path = s.nextLine();
                    Sort_Array sort=new Sort_Array(path);
                    System.out.println("Array after bubble sorting:");
                    int[] arr=sort.merge_sort();
                    for (int i = 0; i < arr.length; ++i) {
                        System.out.print(" " + arr[i]);
                    }
                    break;
                }
                ////////////////////////////////////////////////////////

                case 7: {
                    System.out.println("enter the file path:");
                    String path = s.nextLine();
                    Sort_Array sort=new Sort_Array(path);
                    System.out.println("Array after bubble sorting:");
                    int[] arr=sort.radix_sort();
                    for (int i = 0; i < arr.length; ++i) {
                        System.out.print(" " + arr[i]);
                    }
                    break;
                }
                ////////////////////////////////////////////////////////
                case 8: {
                    sama = false;  💔💔💔💔💔💔💔💔💔💔💔
                    break;
                }
            }
        }
}
}