
import java.util.Scanner;
import java.io.*;

public class DataArray {
  CSVnode[] data;
  int count;

  public DataArray(int max) {
    data = new CSVnode[max];
    count = 0;
  }

  public void addData(int a, long b, String c, String d) {
    CSVnode x = new CSVnode(a, b, c, d);
    data[count++] = x;
  }

  public void swap(int i, int j) {
    CSVnode x = new CSVnode();
    x = data[i];
    data[i] = data[j];
    data[j] = x;
  }

  public void scansort1(int start, int stop) {
    int i, j;
    for (i = start; i <= stop - 1; i++)
      for (j = i + 1; j <= stop; j++)
        if (data[j].num < data[i].num)
          swap(i, j);
  }

  public void scansort2(int start, int stop) {
    int i, j;
    for (i = start; i <= stop - 1; i++)
      for (j = i + 1; j <= stop; j++)
        if (data[j].num > data[i].num)
          swap(i, j);
  }

  public void selectsort1(int start, int stop) {
    int i, j, min;
    for (i = start; i < stop; i++) {
      min = i;
      for (j = i + 1; j <= stop; j++) {
        if (data[j].num < data[min].num)
          min = j;
      }
      swap(i, min);
    }
  }

  public void selectsort2(int start, int stop) {
    int i, j, min;
    for (i = start; i < stop; i++) {
      min = i;
      for (j = i + 1; j <= stop; j++) {
        if (data[j].num > data[min].num)
          min = j;
      }
      swap(i, min);
    }
  }

  public void insertsort1(int start, int stop) {
    int i, j;
    CSVnode x = new CSVnode();
    for (i = start + 1; i <= stop; i++)
    {
      x = data[i];
      for (j = i; ((j > start) && (x.num < data[j - 1].num)); j--)
        data[j] = data[j - 1];
      data[j] = x;
    }
  }

  public void insertsort2(int start, int stop) {
    int i, j;
    CSVnode x = new CSVnode();
    for (i = start + 1; i <= stop; i++)
    {
      x = data[i];
      for (j = i; ((j > start) && (x.num > data[j - 1].num)); j--)
        data[j] = data[j - 1];
      data[j] = x;
    }
  }

  public void bubblesort1(int start, int stop) {
    int i, j;
    for (i = start; i <= stop - 1; i++) {
      for (j = stop; j > i; j--)
        if (data[j].num < data[j - 1].num) {
          swap(j, j - 1);
        }
    }
  }

  public void bubblesort2(int start, int stop) {
    int i, j;
    for (i = start; i <= stop - 1; i++) {
      for (j = stop; j > i; j--)
        if (data[j].num > data[j - 1].num) {
          swap(j, j - 1);
        }
    }
  }

  public boolean testsort(int start, int stop) {
    int i, j;
    for (i = 0; i < count - 1; i++) {
      if (data[i].num > data[i + 1].num) {
        return true;
      }
    }
    return true;
  }

  public void print_test() {
    for (int i = 0; i <= 9; i++) {
      data[i].printData();
    }
  }

  public int Load_Data_File(String filename) {
    int count = 0;
    try {
      File fr = new File(filename);
      var sc = new Scanner(fr);
      int a;
      long b;
      String c, d;
      sc.useDelimiter(",|\n"); // เจอ ,
      while (sc.hasNext()) {
        a = sc.nextInt();
        b = sc.nextLong();
        c = sc.next();
        d = sc.next();
        addData(a, b, c, d);
        count++;
      }
      sc.close();
    } catch (Exception e) {
      System.out.println("Error cann't open" + filename);
      return 0;
    }
    return count;
  }

}






