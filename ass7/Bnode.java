import java.util.ArrayList;

public class Bnode implements Comparable<Bnode>
{
    String word;
    ArrayList<String> mean;
    
    public Bnode()
    {
        word = "";
        mean = new ArrayList<String>();
        mean.add("");
    }

    public Bnode(String buff)
    {
        buff = buff.trim().replaceAll("\\s+","");
        String[] str = buff.split(",");
        word = str[0];
        String meaning;
        if(str.length == 1)
        {
            meaning ="";
        }
        else if(str.length == 2)
        {
            meaning = str[1];
        }
        else 
        {
            meaning = str[1]+"("+str[2]+")";
        }
        mean = new ArrayList<String>();
        mean.add(meaning);
    }

    public int compareTo(Bnode x)
    {
        return(int)this.word.compareToIgnoreCase(x.word);
    }
}
