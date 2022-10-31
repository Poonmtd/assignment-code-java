import java.util.Scanner;

public class p 
{
  static int getint(String msg, int min, int max) 
  {
    int a = 0;
    boolean success = false;
    Scanner poon = new Scanner(System.in);
    while (!success) {
      System.out.print(msg);
      try 
      {
        a = poon.nextInt();
        if (a >= min && a <= max) {
          success = true;
        } else {
          System.out.printf("Input error,please enter between %d - %d\n", min, max);
        }
      } catch (Exception err)
       {
        System.out.printf("Input error,please enter between %d - %d\n", min, max);
        poon.nextLine();
       }
    }
    return a;
  }

  public static long factorial(int n) 
  {
    long x;
    if (n == 0) {
      System.out.printf("%d! is base case return answer of %d! = 1\n", n, n);
      return 1;
    } else {
      System.out.printf("%d! is recursive case.Answer = %d * recursion of %d!\n", n, n, (n - 1));
      System.out.printf("   Recursion to calculate %d!\n", (n - 1));
      x = n * factorial(n - 1);
    }
    System.out.printf("Calculate %d! complete.\n", n - 1);
    System.out.printf("   Return answer from %d! = %d to calculate %d! = [%d * %d] = %d * %d = %d\n", n - 1, (x / n), n,n, n - 1, n, (x / n),(n*(x/n)));
    return x;
  }

  public static void main(String[] args) 
  {
    int n;
    char ch = 0;
    long ans;
    Scanner poon = new Scanner(System.in);
    do {
      System.out.printf("My Recursion Programs.\n");
      System.out.printf("Program calculate n! by recursion (n<=15)\n");
      n = getint("Enter n=", 0, 15);
      ans = factorial(n);
      System.out.printf("Complete calculation of %d! , answer = %d\n", n, ans);
      System.out.printf("press[y] to continue, other to exit.\n");
      if (poon.hasNext()) {
        ch = poon.next().charAt(0);
      }
    } while (ch == 'y' || ch == 'Y');
    System.out.printf("End Program.\n");
    System.out.printf("Program writen by 63070501056 Ms.Monthida Arnuphapsamosorn\n");
  }
}
