import java.util.Scanner;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DictTreeSet 
{
    static TreeSet<Bnode> dict = new TreeSet<Bnode>();

    public static int FileReader()
    {
        String buff = null;
        int count = 0;
        try
        {
            FileInputStream fr = new FileInputStream("D:\\year1 term2\\Data struct\\code\\Assignment7\\utf8lexitron.csv");
            InputStreamReader csv = new InputStreamReader(fr,"UTF8");
            BufferedReader fsc = new BufferedReader(csv);
            fsc.read();
            while((buff = fsc.readLine()) != null)
            {
                Linkdictnode(buff);
                count++;
            }
            fsc.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            System.out.println("File not found");
        }
        catch(Exception e)
        {
            System.out.println("Error "+e.getMessage());
            System.out.println("Operation error");
        }
        return count;
    }

    public static void Linkdictnode(String buff)
    {
        Bnode x = new Bnode(buff);
        if(dict.contains(x))
        {
            TreeSet<Bnode> j = (TreeSet<Bnode>)dict.subSet(x,true,x,true);
            if(!j.first().mean.contains(x.mean.get(0)))
            {
                j.first().mean.add(x.mean.get(0));
            }
        }
        else
        {
            dict.add(x);
        }
    }

    public static void dictSearch(String str)
    {
        str = str.trim().replaceAll("\\s+","");
        Bnode key = new Bnode(str);
        if(dict.contains(key))
        {
            TreeSet<Bnode> j = (TreeSet<Bnode>)dict.subSet(key,true,key,true);
            System.out.printf("%s have %d meaning\n",str,j.first().mean.size());
            int i=0;
            for(String x:j.first().mean)
             System.out.printf("%d) %s\n",++i,x);
        }
        else
        {
            System.out.printf("%s not found\n",str);
        }
    }

    public static void printStat()
    {
        System.out.printf("Total word size %d words\n",dict.size());
        int sum = 0;
        int max = 0;
        Bnode j = new Bnode();
        for(Bnode itr:dict)
        {
            sum = sum + itr.mean.size();
            if(max < itr.mean.size())
            {
                max = itr.mean.size();
                j = itr;
            }
        }
        System.out.printf("Total meaning size %d words\n",sum);
        System.out.printf("%s have %d meaning\n",j.word,j.mean.size());
        int i = 0;
        for(String x:j.mean)
        {
            System.out.println((++i)+")"+x);
        }
    }

    public static void main(String[] args)
    {
        int count = 0;
        count = FileReader();
        System.out.printf("Total Read %d records.\n",count);
        printStat();
        Scanner in = new Scanner(System.in);
        String str = "";
        while(!str.equalsIgnoreCase("end"))
        {
            System.out.printf("Enter word :  \n");
            str = in.nextLine();
            dictSearch(str);
        }
        System.out.printf("END PROGRAM\n");
        System.out.printf("Program writen by 63070501056 Ms.Monthida Arnuphapsamosorn\n");
        in.close();
    }
}
