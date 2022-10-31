import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class calculate
{
    static ArrayList<String> postfix = new ArrayList<String>();
    static Stack<String> oprstack = new Stack<String>();
    static Stack<Double> numstack = new Stack<Double>();

    static double ans = 0;
    
    public double valueOf(String str)
    {
        if(str.equalsIgnoreCase("pi"))
         return Math.PI;
        else if(str.equalsIgnoreCase("ans"))
         return ans;
        else 
         return Double.parseDouble(str);
    }

    public void Change_infix_to_postfix(String[] token)
    {
        int group,cur,prior = 0;
        int i;
        String buff;
        postfix.clear();
        oprstack.clear();
        for(i=0;i<token.length;i++)
        {
            group = checktoken.check_group(token[i]);
            if(group == 1)
             postfix.add(token[i]);
            else if(group>=2 && group<=6)
            {
                do
                {
                    cur  = checktoken.check_group(token[i]);
                    buff = oprstack.peek();
                    prior = checktoken.check_group(buff);
                    if(prior>=cur && prior<=6)
                    {
                        buff = oprstack.pop();
                        postfix.add(buff);
                    }
                }
                while(prior>=cur && prior<=6);
                oprstack.push(token[i]);
            }
            else if(group == 7)
            {
                oprstack.push(token[i]);
            }
            else if(group == 8)
            {
                do
                {
                    buff = oprstack.pop();
                    if(!buff.equals("("))
                     postfix.add(buff);
                }while(!buff.equals("("));
            }
            
        }
    }

    public double Calculate_postfix()
    {
        double ans=0,num,num1,num2;
        int i,group;
        String token = new String("");
        for(i=0;i<postfix.size();i++)
        {
            token = postfix.get(i);
            group = checktoken.check_group(token);
            if(group == 1)
            {
                num1 = valueOf(token);
                numstack.push(num1);
            }
            else if(group>=2 && group<=4)
            {
                num1 = numstack.pop();
                num2 = numstack.pop();
                if((group == 2) && token.equals("+"))
                 numstack.push(num2+num1);
                else if((group == 2) && token.equals("-"))
                 numstack.push(num2-num1);
                else if((group == 3) && token.equals("/"))
                 numstack.push(num2/num1);
                else if((group == 3) && token.equals("*"))
                 numstack.push(num2*num1);
                else if(group == 4)
                 numstack.push(Math.pow(num2,num1));
            }
            else if(group == 5)
            {
                num1 = numstack.pop();
                numstack.push(-num1);
            }
            else if(group == 6)
            {
                if(token.equalsIgnoreCase("sin"))
                {
                    num = Math.sin(numstack.pop()*Math.PI / 180);
                    numstack.push(num);
                }
                else if(token.equalsIgnoreCase("cos"))
                { 
                    num = Math.cos(numstack.pop()*Math.PI / 180);
                    numstack.push(num);
                }
                else if(token.equalsIgnoreCase("tan"))
                {
                    num = Math.tan(numstack.pop()*Math.PI / 180);
                    numstack.push(num);
                }
                else if(token.equalsIgnoreCase("asin"))
                {
                    num = Math.asin(numstack.pop())*180 / Math.PI;
                    numstack.push(num);
                }
                else if(token.equalsIgnoreCase("acos"))
                {
                    num = Math.acos(numstack.pop())*180 / Math.PI;
                    numstack.push(num);
                }
                else if(token.equalsIgnoreCase("atan"))
                {
                    num = Math.atan(numstack.pop())*180 / Math.PI;
                    numstack.push(num);
                }
                else if(token.equalsIgnoreCase("sqrt"))
                {
                    num = Math.sqrt(numstack.pop());
                    numstack.push(num);
                }
                else if(token.equalsIgnoreCase("log"))
                {
                    num = Math.log10(numstack.pop());
                    numstack.push(num);
                }
                else if(token.equalsIgnoreCase("abs"))
                {
                    num = Math.abs(numstack.pop());
                    numstack.push(num);
                }
                else if(token.equalsIgnoreCase("exp"))
                {
                    num = Math.exp(numstack.pop());
                    numstack.push(num);
                }

            }   
        }
        ans = numstack.pop();
        return ans;
    }

    public static void main(String[] args)
    {
        calculate calc = new calculate();
        Scanner in = new Scanner(System.in);
        String str;
        do
        {
            System.out.printf("expression >");
            str = in.nextLine();
            if(str.trim().equalsIgnoreCase("help"))
             System.out.printf("token = sin, cos, tan, asin, acos, atan, sqrt, log, exp, abs, +, -, *, /, ^, (, ), pi, ans\n");
            else
            {
                if(!str.equalsIgnoreCase("end"))
                {   //int i;
                    str = "("+str+")";
                    str = checktoken.transfoem(str);
                    //System.out.println("str--> "+str);
                    String[] token = str.trim().split("\\s+");
                    /*for(i=0;i<token.length;i++)
                    {
                        System.out.println(token[i]);
                    }*/
                    checktoken.change_sign_operator(token);
                    int state = checktoken.check_state(token);
                    if(state == 1 || state == 8)
                    {
                        //System.out.println("answer>OK");
                        calc.Change_infix_to_postfix(token);
                        //System.out.println("Print = "+postfix);
                        ans = calc.Calculate_postfix();
                        System.out.println("answer>"+ans);
                    }
                    else 
                     System.out.println("answer>error");
                }
            }
        }while(!str.equalsIgnoreCase("end"));
        System.out.println("END PROGRAM");
        System.out.println("Program writen by 63070501056 Ms.Monthida Arnuphapsamosorn");
        in.close();
    }
}


