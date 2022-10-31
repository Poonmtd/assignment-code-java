import java.io.*;
import java.text.CollationKey;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import javax.imageio.stream.ImageInputStreamImpl;

public class DictArray 
{
    static ArrayList<Dnode> dict = new ArrayList<Dnode>();

    public static int ReadFile()
    {
        String str = null;
        int count = 0;
        try 
        {   InputStream fcsv = new FileInputStream("D:\\year1 term2\\Data struct\\code\\Assignment6\\utf8lexitron.csv");
            InputStreamReader  utf = new InputStreamReader(fcsv,"UTF-8");
            BufferedReader fbuff = new BufferedReader(utf);
            //System.out.printf("BOM = %X\n",fbuff.read());
            fbuff.read();
            while((str = fbuff.readLine()) != null)
            {
                Dnode x = new Dnode(str);
                dict.add(x);
                count++;
            }
            fbuff.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error can't open utf8lexitron.csv");
        }
        catch(Exception e)
        {
            System.out.printf("Reading file error\n");
        }
        return count;
    }

    static void removesamedata()
    {
        int count = 0,i = 0;
        for(i=0;i<dict.size()-1;i++)
         while(dict.get(i).compareAll(dict.get(i+1)))
         {
             dict.remove(i+1);
             count++;
         }
         System.out.printf("Total same data found %d\n",count);
    }

    static int countmaxmean()
    {
        int j=1,max=0,index=0;
        for(int i=0;i<dict.size()-1;i++)
         if(dict.get(i).compareTo(dict.get(i+1))==0)
         { j++;
           if(max<j)
             {
                 max = j;
                 index = i;
             }
         }
         else
          j = 1;
         System.out.printf("Maximum Meaning word %d\n",max);
         return index;
    }
    
    public static void dictlist(int start,int stop)
    {
        for(int i=start;i<=stop;i++)
         dict.get(i).printDnode(i-start+1);
    }

    public static int dictSceach(String str)
    {
        Dnode key = new Dnode();
        int start = 0,stop = 0;
        key.word = str;
        int j = Collections.binarySearch(dict,key);
        if(j>=0)
        {
            for(start = j;start>0 && (dict.get(start-1).compareTo(key)==0);start--);
            for(stop = j;(stop<dict.size()-1) && (dict.get(stop+1).compareTo(key) == 0);stop++);
        }
        if(j>=0)
        {
            System.out.printf("found %s %d token at  %d - %d\n",str,stop-start+1,start,stop);
            dictlist(start,stop);
        }
        else
        {
            System.out.printf("%s Not found\n",str);
        }
            return start;
    }

    public static void printatat()
    {
        System.out.printf("Total remaining size %d\n",dict.size());
        int j = countmaxmean();
        Dnode x = new Dnode();
        x = dict.get(j);
        j = dictSceach(x.word);
    }

    public static void main(String[] args)
    {
        ReadFile();
        System.out.printf("Total eremaining read %d\n",dict.size());
        Collections.sort(dict);
        removesamedata();
        printatat();
        Scanner in = new Scanner(System.in);
        String str = "";
        while (!str.equalsIgnoreCase("end"))
        {
            System.out.printf("Enter word");
            str = in.nextLine();
            str = str.trim().replaceAll("\\s+"," ");
            dictSceach(str);
        }
        in.close();
        System.out.printf("END PROGRAM\n");
        System.out.printf("Program writen by 63070501056 Ms.Monthida Arnuphapsamosorn\n");
    }
}
