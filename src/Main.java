import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        heap heap = new heap();
        PriorityQueue prioque = new PriorityQueue();
        System.out.println("1-Build Max Heap");
        System.out.println("2-Max Heap Insert");
        System.out.println("3-Heap Extract Max");
        System.out.println("4-Heap Sort");
        System.out.println("5-Heap Sort using priority queue");
        System.out.println("6-Bubble Sort");
        System.out.println("7-Merge Sort");
        System.out.println("8-Radix Sort");
        System.out.println("9-EXIT");

        boolean sama=true;
        while(sama)
        {
            int op=0;
            System.out.println();
            System.out.println("Enter the number of your choice:");
            while(op==0)
            op= s.nextInt();


            switch (op) {
                case 1: {
                    System.out.println("Enter the array: ");
                    String str ="";
                    while(str=="")
                      str = s.nextLine();
                    String[] ss = str.split(",");
                    ArrayList<Integer> arr  = new ArrayList<>(ss.length);
                    for (int i = 0; i < ss.length; i++) {
                        arr.add(parseInt(ss[i]));
                    }
                    heap.BuildMaxHeap(arr);
                    System.out.println("Array after building:");
                    for (int i = 0; i < arr.size(); ++i) {
                        System.out.print(" " + arr.get(i));
                    }
                    break;
                }

                ////////////////////////////////////////////////////////
                case 2: {
                    System.out.println("Enter the numbers to be inserted:"); //benhom ,
                    String str ="";
                    while(str=="")
                        str = s.nextLine();
                    String[] strr = str.split(",");
                    for (int i = 0; i < strr.length; i++) {
                        prioque.max_heap_insert(Integer.valueOf(strr[i]));
                    }
                    System.out.println("After insertion:");
                    for (int i = 0; i < prioque.l; ++i) { // l is the length in priority queue class
                        System.out.print(prioque.heap.get(i));
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
                    String path="";
                    while(path=="") {
                        path = s.nextLine();
                    }
                    File file = new File(path);
                    Scanner myReader = new Scanner(file);
                    String str = myReader.nextLine();
                    String[] arrOfStr = str.split(",");
                    int length=arrOfStr.length;
                    ArrayList<Integer> arr4 =new ArrayList<Integer>(length);
                    for (int i=0;i<length;i++) {
                        arr4.add(parseInt(arrOfStr[i]));
                    }
                    myReader.close();
                    System.out.println("If you want to print intermediate arrays type true:");
                    boolean flag = s.nextBoolean();
                    System.out.println("Array after heap sorting:");
                    heap.HeapSort(arr4,flag);
                    for (int i = 0; i < arr4.size(); ++i) {
                        System.out.print(arr4.get(i)+" ");
                    }
                    break;
                }
                ////////////////////////////////////////////////////////
                case 5: {
                    System.out.println("enter the file path:");
                    String path="";
                    while(path=="") {
                        path = s.nextLine();
                    }
                    File file = new File(path);
                    Scanner myReader = new Scanner(file);
                    String str = myReader.nextLine();
                    String[] arrOfStr = str.split(",");
                    int length=arrOfStr.length;
                    ArrayList<Integer> arr4 =new ArrayList<Integer>(length);
                    for (int i=0;i<length;i++) {
                        arr4.add(parseInt(arrOfStr[i]));
                    }
                    myReader.close();
                    System.out.println("If you want to print intermediate arrays type true:");
                    boolean flag = s.nextBoolean();
                    System.out.println("Array after heap sorting using priority queue:");
                    heap.HeapSortPQ(arr4,flag);
                    for (int i = 0; i < arr4.size(); ++i) {
                        System.out.print(arr4.get(i)+" ");
                    }
                    break;
                }
                    //////////////////////////////////////////////////////////
                case 6: {
                    System.out.println("enter the file path:");
                    String path="";
                    while(path=="") {
                        path = s.nextLine();
                    }
                    System.out.println("If you want to print intermediate arrays type true:");
                    boolean flag = s.nextBoolean();
                    Sort_Array sort=new Sort_Array(path);
                    System.out.println("Array(s) after bubble sorting:");
                    int[] arr=sort.bubble_sort(flag);
                    for (int i = 0; i < arr.length; ++i) {
                        System.out.print( arr[i] +" " );
                    }
                    break;
                }
                ////////////////////////////////////////////////////////

                case 7: {
                    System.out.println("enter the file path:");
                    String path="";
                    while(path=="") {
                        path = s.nextLine();
                    }
                    System.out.println("If you want to print intermediate arrays type true:");
                    boolean flag = s.nextBoolean();
                    Sort_Array sort=new Sort_Array(path);
                    System.out.println("Array after merge sorting:");
                    int[] arr=sort.merge_sort(flag);
                    for (int i = 0; i < arr.length; ++i) {
                        System.out.print( arr[i]+" " );
                    }
                    break;
                }
                ////////////////////////////////////////////////////////

                case 8: {
                    System.out.println("enter the file path:");
                    String path="";
                    while(path=="") {
                        path = s.nextLine();
                    }
                    System.out.println("If you want to print intermediate arrays type true:");
                    boolean flag = s.nextBoolean();
                    Sort_Array sort=new Sort_Array(path);
                    System.out.println("Array after radix sorting:");
                    int[] arr=sort.radix_sort(flag);
                    for (int i = 0; i < arr.length; ++i) {
                        System.out.print(arr[i]+" " );
                    }
                    break;
                }
                ////////////////////////////////////////////////////////
                case 9: {
                    sama = false;
                    /// 💔💔💔💔💔💔💔💔💔💔💔///
                    break;
                }
            }
        }
    }
}