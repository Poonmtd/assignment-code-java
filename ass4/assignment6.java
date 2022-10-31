import java.io;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.ElementEdit;

class Dnode implements Comparable<Dnode>
{
    String word;
    String mean;
    String type;
    
    public Dnode()
    {
        word=" ";
        mean=" ";
        type=" ";
    }

    public Dnode(String buff)
    {
        buff = buff.trim().replaceAll("\\s+"," ");
        String[] str = buff.split(",");
        word = str[0];
        mean = str[1];
        type = str[2];
    }

    public int compareTo(Dnode x)
    {
        return(int)this.word.compareToIgnoreCase(x.word);
    }

    boolean compareAll(Dnode x)
    {
        if(this.word.equalsIgnoreCase(x.word) && this.mean.equalsIgnoreCase(x.mean) && this.type.equalsIgnoreCase(x.type))
         return true;
        else 
         return false;
    }

    public static void printDnode(Dnode x)
    {
        System.out.printf("%-15s %s(%s)\n",i,x.word,x.mean,x.type);
    }

    public static void printDnode(Dnode x,int i)
    {
        System.out.printf("%d)%-15a %s(%s)\n",i,x.word,x.mean,x.type); 
    }
}

class dicArray
{
    static ArrayList<Dnode> dict = new ArrayList<Dnode>();

    public int readFlie()
    {
        String str;
        int count = 0;
        try
        {
            FlieLnputStrea

        }
    }
}