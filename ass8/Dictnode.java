import java.util.ArrayList;
public class Dictnode 
{
    String word;
    ArrayList<String> mean;

    public Dictnode()
    {
        word = "";
        mean = new ArrayList<String>();
        mean.add("");  
    }

    public Dictnode(String buff)
    {
        buff = buff.trim().replaceAll("\\s+"," ");
        String[] str = buff.split(",");
        word = str[0].toLowerCase();
        String meaning;
        if(str.length == 1)
        {
            meaning = "";
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
    
}

