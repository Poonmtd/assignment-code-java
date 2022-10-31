import java.util.*;

public class ass {

  public static void main(String[] args) {
    int max = 100010;
    long starttime, stoptime;
    double sorttime1, sorttime2, sorttime3;
    double selecttime1, selecttime2, selecttime3;
    double inserttime1, inserttime2, inserttime3;
    double bubbletime1, bubbletime2, bubbletime3;
    DataArray test = new DataArray(max);
    DataArray temp = new DataArray(max);
    if (test.Load_Data_File("test.csv") > 0) {
      System.out.println("file read = " + test.count);
      temp.data = Arrays.copyOf(test.data, 10010);
      starttime = System.nanoTime();
      temp.scansort1(0, 9999);
      stoptime = System.nanoTime();
      sorttime1 = (stoptime - starttime) / 1E6;
      //System.out.println(sorttime1);
      //temp.print_test();
      //System.out.println("\n");

      //temp.data = Arrays.copyOf(test.data, 10010);
      starttime = System.nanoTime();
      temp.scansort1(0, 10000);
      stoptime = System.nanoTime();
      sorttime2 = (stoptime - starttime) / 1E6;
      //temp.print_test();
      //System.out.println("\n");

      temp.data = Arrays.copyOf(test.data, 10010);
      starttime = System.nanoTime();
      temp.scansort2(0, 10000);
      stoptime = System.nanoTime();
      sorttime3 = (stoptime - starttime) / 1E6;
      //temp.print_test();
      //System.out.println("\n");

      temp.data = Arrays.copyOf(test.data, 10010);
      starttime = System.nanoTime();
      temp.selectsort1(0, 9999);
      stoptime = System.nanoTime();
      selecttime1 = (stoptime - starttime) / 1E6;
      //temp.print_test();
      //System.out.println("\n");

      //temp.data = Arrays.copyOf(test.data, 10010);
      starttime = System.nanoTime();
      temp.selectsort1(0, 10000);
      stoptime = System.nanoTime();
      selecttime2 = (stoptime - starttime) / 1E6;
      //temp.print_test();
      //System.out.println("\n");

      temp.data = Arrays.copyOf(test.data, 10010);
      starttime = System.nanoTime();
      temp.selectsort2(0, 10000);
      stoptime = System.nanoTime();
      selecttime3 = (stoptime - starttime) / 1E6;
      //temp.print_test();
      //System.out.println("\n");

      temp.data = Arrays.copyOf(test.data, 10010);
      starttime = System.nanoTime();
      temp.insertsort1(0, 9999);
      stoptime = System.nanoTime();
      inserttime1 = (stoptime - starttime) / 1E6;
      //temp.print_test();
      //System.out.println("\n");

      //temp.data = Arrays.copyOf(test.data, 10010);
      starttime = System.nanoTime();
      temp.insertsort1(0, 10000);
      stoptime = System.nanoTime();
      inserttime2 = (stoptime - starttime) / 1E6;
      //temp.print_test();
      //System.out.println("\n");

      temp.data = Arrays.copyOf(test.data, 10010);
      starttime = System.nanoTime();
      temp.insertsort2(0, 10000);
      stoptime = System.nanoTime();
      inserttime3 = (stoptime - starttime) / 1E6;
      //temp.print_test();
      //System.out.println("\n");

      temp.data = Arrays.copyOf(test.data, 10010);
      starttime = System.nanoTime();
      temp.bubblesort1(0, 9999);
      stoptime = System.nanoTime();
      bubbletime1 = (stoptime - starttime) / 1E6;
      //temp.print_test();
      //System.out.println("\n");

      //temp.data = Arrays.copyOf(test.data, 10010);
      starttime = System.nanoTime();
      temp.bubblesort1(0, 10000);
      stoptime = System.nanoTime();
      bubbletime2 = (stoptime - starttime) / 1E6;
      //temp.print_test();
      //System.out.println("\n");

      temp.data = Arrays.copyOf(test.data, 10010);
      starttime = System.nanoTime();
      temp.bubblesort2(0, 10000);
      stoptime = System.nanoTime();
      bubbletime3 = (stoptime - starttime) / 1E6;
      //temp.print_test();
      //System.out.println("\n");

      System.out.printf("__________________________________________________________________________________________________________\n"); 
      System.out.printf("|      Sort         |      Random data (n)      |      Insert data (n+1)      |      Descending (n+1)    |\n");  
      System.out.printf("|-------------------|---------------------------|-----------------------------|--------------------------|\n"); 
      System.out.printf("| Scan Sort         |      %3.6f ms.       |      %3.6f ms.         |      %3.6f ms.      |\n",sorttime1,sorttime2,sorttime3);
      System.out.printf("| Selection Sort    |      %3.6f ms.       |      %3.6f ms.         |      %3.6f ms.      |\n",selecttime1,selecttime2,selecttime3);
      System.out.printf("| Insertion Sort    |      %3.6f ms.       |      %3.6f   ms.         |      %3.6f ms.      |\n",inserttime1,inserttime2,inserttime3);
      System.out.printf("| Bubble Sort       |      %3.6f ms.       |      %3.6f ms.         |      %3.6f ms.      |\n",bubbletime1,bubbletime2,bubbletime3);
      System.out.printf("|___________________|___________________________|_____________________________|__________________________|\n"); 
      System.out.printf("Program writen by 63070501056 Ms.Monthida Arnuphapsamosorn\n");
      System.out.printf("                                                          \n");
    
    } else {
      System.out.println("Error");
    }
  }
}



