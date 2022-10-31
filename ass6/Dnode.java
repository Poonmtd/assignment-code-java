import java.util.Comparator;
import java.util.ArrayList;

public class Dnode implements Comparable<Dnode>
{
    String word;
    String mean;
    String type;
    
    public Dnode()
    {
        word="";
        mean="";
        type="";
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

    public void printDnode(Dnode x)
    {
        System.out.printf("%-15s %s(%s)\n",word,mean,type);
    }

    public void printDnode(int i)
    {
        System.out.printf("%d)%-15s %s(%s)\n",i,word,mean,type); 
    }
}

