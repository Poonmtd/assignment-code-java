import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashMap;

public class dicMap 
{
    static HashMap<String, Dictnode> dict = new HashMap<String, Dictnode>();

    public static int FlieReader()
    {
        String buff = null;
        int count = 0;
        try
        {
            FileInputStream fr = new FileInputStream("D:\\year1 term2\\Data struct\\code\\Assignment8\\utf8lexitron.csv");
            InputStreamReader csv = new InputStreamReader(fr, "UTF8");
            BufferedReader fsc = new BufferedReader(csv);
            fsc.read();
            while((buff = fsc.readLine()) != null)
            {
                Dictnode x = new Dictnode(buff);
                if(dict.containsKey(x.word))
                {
                    Dictnode j = dict.get(x.word);
                    if(!j.mean.contains(x.mean.get(0)))
                    {
                        j.mean.addAll(x.mean);
                        dict.put(x.word, j);
                    }
                }
                else
                {
                    dict.put(x.word, x);
                }
                count++;
            }
            fsc.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Flie not found");
        }
        catch(Exception e)
        {
            System.out.println("Error"+e.getMessage());
            System.out.println("Operation error");
        }
        return count;
    }

    public static void dictSearch(String str)
    {
        if(dict.containsKey(str))
        {
            Dictnode j = dict.get(str);
            System.out.printf("%s have %d meaning\n",str,j.mean.size());
            for(int i=0;i<j.mean.size();i++)
            {
                System.out.println(i+1+")"+j.mean.get(i));
            }
        }
        else
        {
            System.out.printf("%s not found\n",str);
        }
    }

    public static void printStat()
    {
        System.out.printf("Total word size %d words\n",dict.size());
        int sum = 0, max = 0;
        Dictnode p = new Dictnode();
        for(String itr : dict.keySet())
        {
            Dictnode j = dict.get(itr);
            sum = sum + j.mean.size();
            if(max<j.mean.size())
            {
                max = j.mean.size();
                p = j;
            }
        }
        System.out.printf("Total meaning size %d words\n",sum);
        System.out.printf("%s have %d meaning\n",p.word,p.mean.size());
        for(int i=0;i<p.mean.size();i++)
        {
            System.out.println(i+1+")"+p.mean.get(i));
        }
    }

    public static void main(String[] args)
    {
        int count = 0;
        count = FlieReader();
        System.out.printf("Total Read %d records.\n",count);
        printStat();
        Scanner in = new Scanner(System.in);
        String str = "";
        while(!str.equalsIgnoreCase("end"))
        {
            System.out.print("Enter word : ");
            str = in.nextLine();
            str = str.trim().replaceAll("\\s+", " ");
            dictSearch(str.toLowerCase());
        }
        System.out.println("END PROGRAM");
        System.out.println("Program writen by 63070501056 Ms.Monthida Arnuphapsamosorn");
        in.close();
    }
}
