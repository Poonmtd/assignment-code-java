import java.io.File;
import java.util.Scanner;
public class dataarray {
    csvnode[] data;
    int count;

    public dataarray(int max) {
        data = new csvnode[max];
        count = 0;
    }

    public void Print_testcase() {
        data[0].printData();
        data[49999].printData();
        data[99999].printData();
    }

    void Print_test(int start, int stop) {
        int i;
        for (i = start; i <= stop; i++) {
            data[i].printData();
        }
    }

    public void swap(int i, int j) {
        csvnode x = new csvnode ();
        x = data[i];
        data[i] = data[j];
        data[j] = x;
    }

    public void addData(int a, long b, String c, String d) {
        csvnode x = new csvnode(a, b, c, d);
        data[count++] = x;
    }

    public void QuickSortNumParttition(int first, int last) {
        int i = first, j = last;
        if (first < last) {
            do {
                while ((data[i].num <= data[j].num) && (i < j)) {
                    j--;
                }
                if (data[i].num > data[j].num) {
                    swap(i, j);
                    j--;
                }
                while ((data[i].num < data[j].num) && (i<j)) 
                {
                    i++;
                }
               }while(i<j);
            if (first < j - 1)
                QuickSortNumParttition(first, j - 1);
            if (i + 1 < last)
                QuickSortNumParttition(i + 1, last);
        }
    }

    public void QuickSortStrParttition(int first, int last) {
        int i = first, j = last;
        if (first < last) {
            do {
                while ((data[i].str2.compareToIgnoreCase(data[j].str2) <= 0) && (i < j)) {
                    j--;
                }
                if (data[i].str2.compareToIgnoreCase(data[j].str2) > 0) {
                    swap(i, j);
                    j--;
                }
                while ((data[i].str2.compareToIgnoreCase(data[j].str2) <= 0) && (i < j)) {
                    i++;
                }
                if (data[i].str2.compareToIgnoreCase(data[j].str2) > 0) {
                    swap(i, j);
                    j--;
                }
            } while (i < j);
            if (first < j - 1)
                QuickSortStrParttition(first, j - 1);
            if (i + 1 < last)
                QuickSortStrParttition(i + 1, last);
        }
    }

    public void QuickSortNumPivot(int first, int last) {
        int i = first, j = last;
        long pivot;
        if (first < last) {
            pivot = data[(first + last) / 2].num;
            while (i < j) {
                while (data[i].num < pivot)
                    i++;
                while (data[j].num > pivot)
                    j--;
                if (i <= j) {
                    swap(i++, j--);
                }
            }
            if (first < j)
                QuickSortNumPivot(first, j);
            if (i < last)
                QuickSortNumPivot(i, last);
        }
    }

    public void QuickSortStrPivot(int first, int last) {
        int i = first, j = last;
        String pivot;
        if (first < last) {
            pivot = data[(first + last) / 2].str2;
            while (i < j) {
                while (data[i].str2.compareToIgnoreCase(pivot) < 0)
                    i++;
                while (data[j].str2.compareToIgnoreCase(pivot) > 0)
                    j--;
                if (i <= j) {
                    swap(i++, j--);
                }
            }
            if (first < j)
                QuickSortStrPivot(first, j);
            if (i < last)
                QuickSortStrPivot(i, last);
        }
    }

   public void mergeSortNum(int first, int last) {
        int mid=0;
        if (first < last) {
            mid = (first + last) / 2;
            mergeSortNum(first, mid);
            mergeSortNum(mid + 1, last);
            mergeDataNum(first, mid, last);
        }
    }

    public void mergeDataNum(int first, int mid, int last) {
        int i, i1, i2;
        csvnode[] temp = new csvnode[last - first + 1];
        i1 = first;
        i2 = mid + 1;
        for (i = 0; i <= last - first; i++) {
            if (i1 <= mid && i2 <= last) {
                if (data[i1].num < data[i2].num) {
                    temp[i] = data[i1++];
                } else {
                    temp[i] = data[i2++];
                }
            } else if (i1 > mid) {
                temp[i] = data[i2++];
            } else if (i2 > last) {
                temp[i] = data[i1++];
            }
        }
        for (i = 0; i <= last - first; i++) {
            data[first + i] = temp[i];
        }
    } 

    public void mergeSortString(int first, int last) {
        int mid;
        if (first < last) {
            mid = (first + last) / 2;
            mergeSortString(first, mid);
            mergeSortString(mid + 1, last);
            mergeDataString(first, mid, last);
        }
    }

    public void mergeDataString(int first, int mid, int last) {
        int i, i1, i2;
        csvnode[] temp = new csvnode[last - first + 1];
        i1 = first;
        i2 = mid + 1;
        for (i = 0; i <= last - first; i++) {
            if (i1 <= mid && i2 <= last) {
                if (data[i1].str2.compareToIgnoreCase(data[i2].str2) < 0) {
                    temp[i] = data[i1++];
                } else {
                    temp[i] = data[i2++];
                }
            } else if (i1 > mid) {
                temp[i] = data[i2++];
            } else if (i2 > last) {
                temp[i] = data[i1++];
            }
        }
        for (i = 0; i <= last - first; i++) {
            data[first + i] = temp[i];
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



