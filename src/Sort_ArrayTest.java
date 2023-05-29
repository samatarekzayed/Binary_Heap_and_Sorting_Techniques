import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;



class Sort_ArrayTest {
    heap heap = new heap();

    @Test
    void size_10() throws FileNotFoundException {
        String path="src/testFiles/10.txt";
        Sort_Array bubble=new Sort_Array(path);
        long start = System.nanoTime();
        int[] arr=bubble.bubble_sort(false);
        long end= System.nanoTime();
        int[] sorted={-10,-20,-30,15,-30,40,-50,-2,-1};
        Arrays.sort(sorted);
        assertArrayEquals(arr, sorted);
        System.out.println("\nexecution time for  bubble Sort: " + (end- start) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr));
        System.out.println("------------------------------------------------------------------");

        Sort_Array merge=new Sort_Array(path);
        long start2 = System.nanoTime();
        int[] arr2=merge.merge_sort(false);
        long end2= System.nanoTime();
        assertArrayEquals(arr2, sorted);
        System.out.println("\nexecution time for  merge Sort: " + (end2- start2) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr2));
        System.out.println("------------------------------------------------------------------");

        Sort_Array radix=new Sort_Array(path);
        long start3 = System.nanoTime();
        int[] arr3=radix.radix_sort(false);
        long end3= System.nanoTime();
        assertArrayEquals(arr3,sorted);
        System.out.println("\nexecution time for radix Sort: " + (end3- start3) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr3));
        System.out.println("------------------------------------------------------------------");

        heap heap=new heap();
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
        long start4= System.nanoTime();
        heap.HeapSort(arr4,false);
        long end4= System.nanoTime();
        assertArrayEquals(arr4, sorted);
        System.out.println("\nexecution time for heap Sort: " + (end4- start4) + " nanosecond\n");
        System.out.println("after heap sort : " + Arrays.toString(arr4));
        System.out.println("------------------------------------------------------------------");
    }
    /////////////////////////////////////////radix tests///////////////////////////////////////////////////////////////////
    @Test
    void radix_effect_of_numOfDigits() throws FileNotFoundException {

        int[]sorted1={35,55,-21,78,96,22,-95,-82,-7,47,-97,-43,-82,7,-39,40,-20,56,-46,23,-29,52,65,60,13,96,-6,78,69,9,11,-86,-34,67,78,-42,-28,16,-16,-71,-42,-76,-34,-52,-10,10,-23,3,65,-97,75,54,25,5,-62,14,32,-26,-22,53,-21,-34,31,38,-96,43,34,-63,-35,84,81,4,59,-9,26,-39,41,91,74,11,87,-10,-36,-62,53,32,-89,61,28,45,-27,10,-7,-52,-81,-52,85,46,65,76,-28,-44,34,-28,-17,65,-25,-63,62,9,31,-27,-30,84,-33,58,56,45,-34,-88,29,-9,0,-48,2,-7,71,37,99};
        Arrays.sort(sorted1);
        Sort_Array twoDigits=new Sort_Array("src/radix_test/two_digits.txt");
        long start1 = System.nanoTime();
        int[] arr1=twoDigits.radix_sort(false);
        long end1= System.nanoTime();
        assertArrayEquals(arr1,sorted1);
        System.out.println("\nexecution time for radix Sort: " + (end1- start1) + " nanosecond\n");
        System.out.println("after radix sort 2 digits: " + Arrays.toString(arr1));
        System.out.println("------------------------------------------------------------------");

        int[]sorted2={-3488,-4885,-2926,6778,-8050,-5502,2666,2631,-366,7594,-298,-3438,1960,-55,9847,-6092,-9047,4987,-693,-6252,662,-5769,4776,-4177,59,9063,4367,-8590,-4109,3797,8897,-1652,7561,9825,-2311,-531,6122,4765,-405,-6055,-5633,-4042,-9579,-5868,3373,274,-3197,8748,-4437,3516,2191,245,1981,-6564,6271,1864,2576,1917,4617,-2911,-829,-6778,6079,-5350,5971,7115,9988,8347,7066,-2143,9940,290,-6664,-2684,7713,-2316,7082,5220,8667,-1420,9929,-8965,-8308,-3524,7034,155,8276,825,-4625,5879,-7453,-9967,5434,2916,2118,-6734,-6730,-5883,8313,100};
        Arrays.sort(sorted2);
        Sort_Array fourDigits=new Sort_Array("src/radix_test/four_digits.txt");
        long start2 = System.nanoTime();
        int[] arr2=fourDigits.radix_sort(false);
        long end2= System.nanoTime();
        assertArrayEquals(arr2,sorted2);
        System.out.println("\nexecution time for radix Sort: " + (end2- start2) + " nanosecond\n");
        System.out.println("after radix sort 4 digits: " + Arrays.toString(arr2));
        System.out.println("------------------------------------------------------------------");


        int[] sorted3={-4631151,68606973,28604866,-37583177,-70931654,26304541,33813780,-49699446,79143643,-99634215,-39620891,-48373747,-45539399,29159419,-28118239,-45443583,41462449,99832091,44915640,-93703645,64180819,-44669038,66244865,15790188,-49641143,10334816,-82893262,-52080351,62853879,83742763,-23486255,-83322102,27700213,-76913296,88870788,-98837520,69072185,15009921,17804017,-17328570,30527395,-30273819,-28849579,80165855,-71854889,99935865,30065479,-50303837,-80335808,-41553471,-49935381,53574976,-95227700,10231555,28334002,33206047,-93590637,-61205452,-57495842,30909548,-79715782,74901849,77019096,73330716,-11375181,-32298512,33201881,-70712850,-33059651,-34244531,73720592,23748071,95043183,-38526827,-28581638,-61681806,61611254,-89122467,66830620,72746198,38942895,41726741,-6535850,93439792,-49825310,77915102,-11264958,2557241,-62617162,46820332,93579355,-9102089,-65892854,-39354286,30622626,50758641,-61620526,75653129,-93664294,85470601};
        Arrays.sort(sorted3);
        Sort_Array eightDigits=new Sort_Array("src/radix_test/eight_digits.txt");
        long start3 = System.nanoTime();
        int[] arr3=eightDigits.bubble_sort(false);
        long end3= System.nanoTime();
        assertArrayEquals(arr3,sorted3);
        System.out.println("\nexecution time for radix Sort: " + (end3- start3) + " nanosecond\n");
        System.out.println("after radix sort 8 digits : " + Arrays.toString(arr3));
        System.out.println("------------------------------------------------------------------");
    }
    @Test
    void allOneDigitExcept1() throws FileNotFoundException {;

        int[] sorted1={5,3,4,9,7,1,6,8,2};
        Arrays.sort(sorted1);
        Sort_Array twoDigits=new Sort_Array("src/radix_test/oneDigit.txt");
        long start1 = System.nanoTime();
        int[] arr1=twoDigits.radix_sort(false);
        long end1= System.nanoTime();
        assertArrayEquals(arr1,sorted1);
        System.out.println("\nexecution time for radix Sort: " + (end1- start1) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr1));
        System.out.println("------------------------------------------------------------------");

        int[] sorted2={5,3,4,9,7,1,6,8,25487};
        Arrays.sort(sorted2);
        Sort_Array fourDigits=new Sort_Array("src/radix_test/oneDigitWithOne5Digits.txt");
        long start2 = System.nanoTime();
        int[] arr2=fourDigits.radix_sort(false);
        long end2= System.nanoTime();
        assertArrayEquals(arr2,sorted2);
        System.out.println("\nexecution time for radix Sort: " + (end2- start2) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr2));
        System.out.println("------------------------------------------------------------------");
    }
    ///////////////////////////////////////end radix /////////////////////////////////////////////////////

    @Test
    void size_100() throws FileNotFoundException {
        String path="src/testFiles/100 normal case.txt";
        Sort_Array bubble=new Sort_Array(path);
        long start = System.nanoTime();
        int[] arr=bubble.bubble_sort(false);
        long end= System.nanoTime();
        int[] sorted={1734,-3923,-6285,-5978,-1394,-3702,-3382,-9058,-9383,-9730,-4727,1145,-1952,-6401,6115,-588,-9070,7659,-737,2337,-709,7043,6754,-7116,8971,-4633,5150,7981,-7590,1095,960,9316,-3168,2352,8657,-8111,7947,-1852,-3437,4121,-727,-8480,-8353,9594,-694,-7478,3214,3253,5618,-3684,-3512,201,4715,-840,5208,-6691,-8199,-3799,-3877,3919,8662,-5269,-4856,3370,-4553,2217,-477,4019,-1650,9235,-789,6917,-2091,675,-2208,-4775,-7994,514,132,5583,9886,1956,8940,6839,5035,-8965,-329,4991,5604,2310,-2823,8949,607,-2486,684,-4317,-9032,-194,6921,-3703,0};
        Arrays.sort(sorted);
        assertArrayEquals(arr, sorted);
        System.out.println("\nexecution time for  bubble Sort: " + (end- start) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr));
        System.out.println("------------------------------------------------------------------");

        Sort_Array merge=new Sort_Array(path);
        long start2 = System.nanoTime();
        int[] arr2=merge.merge_sort(false);
        long end2= System.nanoTime();
        assertArrayEquals(arr2, sorted);
        System.out.println("\nexecution time for  merge Sort: " + (end2- start2) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr2));
        System.out.println("------------------------------------------------------------------");

        Sort_Array radix=new Sort_Array(path);
        long start3 = System.nanoTime();
        int[] arr3=radix.radix_sort(false);
        long end3= System.nanoTime();
        assertArrayEquals(arr3,sorted);
        System.out.println("\nexecution time for radix Sort: " + (end3- start3) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr3));
        System.out.println("------------------------------------------------------------------");

        heap heap=new heap();
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
        long start4= System.nanoTime();
        heap.HeapSort(arr4,false);
        long end4= System.nanoTime();
        assertArrayEquals(arr4, sorted);
        System.out.println("\nexecution time for heap Sort: " + (end4- start4) + " nanosecond\n");
        System.out.println("after heap sort : " + Arrays.toString(arr4));
        System.out.println("------------------------------------------------------------------");
    }
    @Test
    void size_100_best() throws FileNotFoundException {
        String path="src/testFiles/100 bestcase.txt";
        Sort_Array bubble=new Sort_Array(path);
        long start = System.nanoTime();
        int[] arr=bubble.bubble_sort(false);
        long end= System.nanoTime();
        int[] sorted={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
        Arrays.sort(sorted);
        assertArrayEquals(arr, sorted);
        System.out.println("\nexecution time for  bubble Sort: " + (end- start) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr));
        System.out.println("------------------------------------------------------------------");

        Sort_Array merge=new Sort_Array(path);
        long start2 = System.nanoTime();
        int[] arr2=merge.merge_sort(false);
        long end2= System.nanoTime();
        assertArrayEquals(arr2, sorted);
        System.out.println("\nexecution time for  merge Sort: " + (end2- start2) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr2));
        System.out.println("------------------------------------------------------------------");

        Sort_Array radix=new Sort_Array(path);
        long start3 = System.nanoTime();
        int[] arr3=radix.radix_sort(false);
        long end3= System.nanoTime();
        assertArrayEquals(arr3,sorted);
        System.out.println("\nexecution time for radix Sort: " + (end3- start3) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr3));
        System.out.println("------------------------------------------------------------------");

        heap heap=new heap();
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
        long start4= System.nanoTime();
        heap.HeapSort(arr4,false);
        long end4= System.nanoTime();
        assertArrayEquals(arr4, sorted);
        System.out.println("\nexecution time for heap Sort: " + (end4- start4) + " nanosecond\n");
        System.out.println("after heap sort : " + Arrays.toString(arr4));
        System.out.println("------------------------------------------------------------------");
    }
    @Test
    void size_worst() throws FileNotFoundException {
        String path="src/testFiles/100 worst case.txt";
        Sort_Array bubble=new Sort_Array(path);
        long start = System.nanoTime();
        int[] arr=bubble.bubble_sort(false);
        long end= System.nanoTime();
        int[] sorted={100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
        Arrays.sort(sorted);
        assertArrayEquals(arr, sorted);
        System.out.println("\nexecution time for  bubble Sort: " + (end- start) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr));
        System.out.println("------------------------------------------------------------------");

        Sort_Array merge=new Sort_Array(path);
        long start2 = System.nanoTime();
        int[] arr2=merge.merge_sort(false);
        long end2= System.nanoTime();
        assertArrayEquals(arr2, sorted);
        System.out.println("\nexecution time for  merge Sort: " + (end2- start2) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr2));
        System.out.println("------------------------------------------------------------------");

        Sort_Array radix=new Sort_Array(path);
        long start3 = System.nanoTime();
        int[] arr3=radix.radix_sort(false);
        long end3= System.nanoTime();
        assertArrayEquals(arr3,sorted);
        System.out.println("\nexecution time for radix Sort: " + (end3- start3) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr3));
        System.out.println("------------------------------------------------------------------");

        heap heap=new heap();
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
        long start4= System.nanoTime();
        heap.HeapSort(arr4,false);
        long end4= System.nanoTime();
        assertArrayEquals(arr4, sorted);
        System.out.println("\nexecution time for heap Sort: " + (end4- start4) + " nanosecond\n");
        System.out.println("after heap sort : " + Arrays.toString(arr4));
        System.out.println("------------------------------------------------------------------");
    }
    @Test
    void size_1k() throws FileNotFoundException {
        String path="src/testFiles/1k.txt";
        Sort_Array bubble=new Sort_Array(path);
        long start = System.nanoTime();
        int[] arr=bubble.bubble_sort(false);
        long end= System.nanoTime();
        int[] sorted={7113,-8145,1916,992,9630,-3791,4724,-2919,5116,6187,-570,-6574,1741,-945,-8925,-4246,7633,-1133,-487,3726,-6973,-1091,3938,4996,-7449,2845,3351,-9921,3821,-9639,7282,-7250,-5509,6941,9567,-7751,563,1773,8322,8560,-9424,8684,-9156,9514,-3494,1535,-1565,7319,-9029,-5812,5238,-4966,-979,-9792,8697,-7923,4259,-7133,-1212,-7097,-9961,4676,-9625,-2437,-2729,-4573,-8315,4707,366,69,-8534,2814,-1220,5590,882,5333,-8768,6244,9611,3863,8798,-7524,-6319,-6138,-6792,-9005,-5999,9689,5132,-8145,4085,179,2500,-5282,9683,-4702,7379,-3142,-5803,4707,0};
        Arrays.sort(sorted);
        assertArrayEquals(arr, sorted);
        System.out.println("\nexecution time for  bubble Sort: " + (end- start) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr));
        System.out.println("------------------------------------------------------------------");

        Sort_Array merge=new Sort_Array(path);
        long start2 = System.nanoTime();
        int[] arr2=merge.merge_sort(false);
        long end2= System.nanoTime();
        assertArrayEquals(arr2, sorted);
        System.out.println("\nexecution time for  merge Sort: " + (end2- start2) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr2));
        System.out.println("------------------------------------------------------------------");

        Sort_Array radix=new Sort_Array(path);
        long start3 = System.nanoTime();
        int[] arr3=radix.radix_sort(false);
        long end3= System.nanoTime();
        assertArrayEquals(arr3,sorted);
        System.out.println("\nexecution time for radix Sort: " + (end3- start3) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr3));
        System.out.println("------------------------------------------------------------------");

        heap heap=new heap();
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
        long start4= System.nanoTime();
        heap.HeapSort(arr4,false);
        long end4= System.nanoTime();
        assertArrayEquals(arr4, sorted);
        System.out.println("\nexecution time for heap Sort: " + (end4- start4) + " nanosecond\n");
        System.out.println("after heap sort : " + Arrays.toString(arr4));
        System.out.println("------------------------------------------------------------------");
    }
    @Test
    void size_10k() throws FileNotFoundException {
        String path="src/testFiles/10k.txt";
        Sort_Array bubble=new Sort_Array(path);
        long start = System.nanoTime();
        int[] arr=bubble.bubble_sort(false);
        long end= System.nanoTime();
        int[] sorted={7113,-8145,1916,992,9630,-3791,4724,-2919,5116,6187,-570,-6574,1741,-945,-8925,-4246,7633,-1133,-487,3726,-6973,-1091,3938,4996,-7449,2845,3351,-9921,3821,-9639,7282,-7250,-5509,6941,9567,-7751,563,1773,8322,8560,-9424,8684,-9156,9514,-3494,1535,-1565,7319,-9029,-5812,5238,-4966,-979,-9792,8697,-7923,4259,-7133,-1212,-7097,-9961,4676,-9625,-2437,-2729,-4573,-8315,4707,366,69,-8534,2814,-1220,5590,882,5333,-8768,6244,9611,3863,8798,-7524,-6319,-6138,-6792,-9005,-5999,9689,5132,-8145,4085,179,2500,-5282,9683,-4702,7379,-3142,-5803,4707,0};
        Arrays.sort(sorted);
        assertArrayEquals(arr, sorted);
        System.out.println("\nexecution time for  bubble Sort: " + (end- start) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr));
        System.out.println("------------------------------------------------------------------");

        Sort_Array merge=new Sort_Array(path);
        long start2 = System.nanoTime();
        int[] arr2=merge.merge_sort(false);
        long end2= System.nanoTime();
        assertArrayEquals(arr2, sorted);
        System.out.println("\nexecution time for  merge Sort: " + (end2- start2) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr2));
        System.out.println("------------------------------------------------------------------");

        Sort_Array radix=new Sort_Array(path);
        long start3 = System.nanoTime();
        int[] arr3=radix.radix_sort(false);
        long end3= System.nanoTime();
        assertArrayEquals(arr3,sorted);
        System.out.println("\nexecution time for radix Sort: " + (end3- start3) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr3));
        System.out.println("------------------------------------------------------------------");

        heap heap=new heap();
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
        long start4= System.nanoTime();
        heap.HeapSort(arr4,false);
        long end4= System.nanoTime();
        assertArrayEquals(arr4, sorted);
        System.out.println("\nexecution time for heap Sort: " + (end4- start4) + " nanosecond\n");
        System.out.println("after heap sort : " + Arrays.toString(arr4));
        System.out.println("------------------------------------------------------------------");
    }
    @Test
    void size_100k() throws FileNotFoundException {
        String path="src/testFiles/100k.txt";
        Sort_Array bubble=new Sort_Array(path);
        long start = System.nanoTime();
        int[] arr=bubble.bubble_sort(false);
        long end= System.nanoTime();
        int[] sorted=bubble.readFromFile(path);
        Arrays.sort(sorted);
        assertArrayEquals(arr, sorted);
        System.out.println("\nexecution time for  bubble Sort: " + (end- start) + " nanosecond\n");
        //System.out.println("after bubble sort : " + Arrays.toString(arr));
        System.out.println("------------------------------------------------------------------");

        Sort_Array merge=new Sort_Array(path);
        long start2 = System.nanoTime();
        int[] arr2=merge.merge_sort(false);
        long end2= System.nanoTime();
        assertArrayEquals(arr2, sorted);
        System.out.println("\nexecution time for  merge Sort: " + (end2- start2) + " nanosecond\n");
        //System.out.println("after bubble sort : " + Arrays.toString(arr2));
        System.out.println("------------------------------------------------------------------");

        Sort_Array radix=new Sort_Array(path);
        long start3 = System.nanoTime();
        int[] arr3=radix.radix_sort(false);
        long end3= System.nanoTime();
        assertArrayEquals(arr3,sorted);
        System.out.println("\nexecution time for radix Sort: " + (end3- start3) + " nanosecond\n");
        //System.out.println("after bubble sort : " + Arrays.toString(arr3));
        System.out.println("------------------------------------------------------------------");

        heap heap=new heap();
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
        long start4= System.nanoTime();
        heap.HeapSort(arr4,false);
        long end4= System.nanoTime();
        assertArrayEquals(arr4, sorted);
        System.out.println("\nexecution time for heap Sort: " + (end4- start4) + " nanosecond\n");
        //System.out.println("after heap sort : " + Arrays.toString(arr4));
        System.out.println("------------------------------------------------------------------");
    }
    @Test
    void size_1M() throws FileNotFoundException {
        String path="src/testFiles/1M.txt";
        Sort_Array bubble=new Sort_Array(path);
        long start = System.nanoTime();
        int[] arr=bubble.bubble_sort(false);
        long end= System.nanoTime();
        int[] sorted=bubble.readFromFile(path);
        Arrays.sort(sorted);
        assertArrayEquals(arr, sorted);
        System.out.println("\nexecution time for  bubble Sort: " + (end- start) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr));
        System.out.println("------------------------------------------------------------------");

        Sort_Array merge=new Sort_Array(path);
        long start2 = System.nanoTime();
        int[] arr2=merge.merge_sort(false);
        long end2= System.nanoTime();
        assertArrayEquals(arr2, sorted);
        System.out.println("\nexecution time for  merge Sort: " + (end2- start2) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr2));
        System.out.println("------------------------------------------------------------------");

        Sort_Array radix=new Sort_Array(path);
        long start3 = System.nanoTime();
        int[] arr3=radix.radix_sort(false);
        long end3= System.nanoTime();
        assertArrayEquals(arr3,sorted);
        System.out.println("\nexecution time for radix Sort: " + (end3- start3) + " nanosecond\n");
        System.out.println("after bubble sort : " + Arrays.toString(arr3));
        System.out.println("------------------------------------------------------------------");

        heap heap=new heap();
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
        long start4= System.nanoTime();
        heap.HeapSort(arr4,false);
        long end4= System.nanoTime();
        assertArrayEquals(arr4, sorted);
        System.out.println("\nexecution time for heap Sort: " + (end4- start4) + " nanosecond\n");
        System.out.println("after heap sort : " + Arrays.toString(arr4));
        System.out.println("------------------------------------------------------------------");
    }


}