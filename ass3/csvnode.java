import java.util.Comparator;
public class csvnode 
{
    int id;
    long num;
    String str1;
    String str2;
     
    public csvnode()
    {

    }

    public csvnode(int a,long b,String c,String d)
    {
        id=a;
        num=b;
        str1=c;
        str2=d;
    }

    public void printData()
    {
        System.out.printf("%6d %d %s %s\n",id,num,str1,str2);
    }
}

class Cmpnum implements Comparator <csvnode>{
    public int compare(csvnode x, csvnode y)
    {
        if(x.num == y.num)
         return 0;
        else if(x.num > y.num)
         return 1;
        else 
        return -1;           
    }
}

class Cmpstr1 implements Comparator <csvnode>{
    public int compare(csvnode x, csvnode y)
    {
        return(int) x.str1.compareToIgnoreCase(y.str1);
    }
}

class Cmpstr2 implements Comparator <csvnode>{
    public int compare(csvnode x, csvnode y)
    {
        return(int) x.str2.compareToIgnoreCase(y.str2);
    }
}








