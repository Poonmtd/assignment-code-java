import java.util.Arrays;

public class ass3 {
    public static void main(String[] args) {
        int max = 100010;
        long starttime, stoptime;
        double timearraynum, timearraystr;
        double timeqsnumparttition, timeqsstrparttition;
        double timeqsnumpivot, timeqsstrpivot;
        double timemergenum, timemergestr;
        dataarray test = new dataarray(max);
        dataarray temp = new dataarray(100000);
        if (test.Load_Data_File("test.csv") > 0) {
            System.out.println("file read = " + test.count);

            temp.data = Arrays.copyOf(test.data, test.count);
            System.out.println("Before Sort");
            temp.Print_testcase();
            System.out.println();
            temp.count = test.count;
            starttime = System.nanoTime();
            Arrays.sort(temp.data, new Cmpnum());
            stoptime = System.nanoTime();
            timearraynum = (stoptime - starttime) / 1E6;
            System.out.println("Array sort Number");
            temp.Print_testcase();
            System.out.println();

            temp.data = Arrays.copyOf(test.data, test.count);
            temp.count = test.count;
            starttime = System.nanoTime();
            Arrays.sort(temp.data, new Cmpstr2());
            stoptime = System.nanoTime();
            timearraystr = (stoptime - starttime) / 1E6;
            System.out.println("Array sort String");
            temp.Print_testcase();
            System.out.println();

            temp.data = Arrays.copyOf(test.data, test.count);
            temp.count = test.count;
            starttime = System.nanoTime();
            temp.QuickSortNumParttition(0, test.count - 1);
            stoptime = System.nanoTime();
            timeqsnumparttition = (stoptime - starttime) / 1E6;
            System.out.println("Quick sort Parttition number");
            temp.Print_testcase();
            System.out.println();

            temp.data = Arrays.copyOf(test.data, test.count);
            temp.count = test.count;
            starttime = System.nanoTime();
            temp.QuickSortStrParttition(0, test.count - 1);
            stoptime = System.nanoTime();
            timeqsstrparttition = (stoptime - starttime) / 1E6;
            System.out.println("Quick sort Parttition string");
            temp.Print_testcase();
            System.out.println();

            temp.data = Arrays.copyOf(test.data, test.count);
            temp.count = test.count;
            starttime = System.nanoTime();
            temp.QuickSortNumPivot(0, test.count - 1);
            stoptime = System.nanoTime();
            timeqsnumpivot = (stoptime - starttime) / 1E6;
            System.out.println("Quick sort Pivot number");
            temp.Print_testcase();
            System.out.println();

            temp.data = Arrays.copyOf(test.data, test.count);
            temp.count = test.count;
            starttime = System.nanoTime();
            temp.QuickSortStrPivot(0, test.count - 1);
            stoptime = System.nanoTime();
            timeqsstrpivot = (stoptime - starttime) / 1E6;
            System.out.println("Quick sort Pivot String");
            temp.Print_testcase();
            System.out.println();

            temp.data = Arrays.copyOf(test.data, test.count);
            temp.count = test.count;
            starttime = System.nanoTime();
            temp.mergeSortNum(0, test.count - 1);
            stoptime = System.nanoTime();
            timemergenum = (stoptime - starttime) / 1E6;
            System.out.println("Merge sort Number");
            temp.Print_testcase();
            System.out.println();

            temp.data = Arrays.copyOf(test.data, test.count);
            temp.count = test.count;
            starttime = System.nanoTime();
            temp.mergeSortString(0, test.count - 1);
            stoptime = System.nanoTime();
            timemergestr = (stoptime - starttime) / 1E6;
            System.out.println("Merge sort String");
            temp.Print_testcase();
            System.out.println();

            System.out.printf("__________________________________________________________________________________\n");
            System.out.printf("|                      |      Nunber (ms)          |       String (ms)           |\n");
            System.out.printf("|----------------------|---------------------------|-----------------------------|\n");
            System.out.printf("| Binary Sort          |      %3.6f  ms.       |      %3.6f ms.         |      \n",
                    timearraynum, timearraystr);
            System.out.printf("| Quick Sort partition |      %3.6f  ms.       |      %3.6f ms.         |      \n",
                    timeqsnumparttition, timeqsstrparttition);
            System.out.printf("| Quick Sort pivot     |      %3.6f  ms.       |      %3.6f ms.         |      \n",
                    timeqsnumpivot, timeqsstrpivot);
            System.out.printf("| Merge Sort           |      %3.6f  ms.       |      %3.6f ms.         |      \n",
                    timemergenum, timemergestr);
            System.out.printf("|______________________|___________________________|_____________________________|\n");
            System.out.printf("Program writen by 63070501056 Ms.Monthida Arnuphapsamosorn\n");
            System.out.printf("                                                          \n");

        } else {
            System.out.println("ERROR");
        }

    }

}
