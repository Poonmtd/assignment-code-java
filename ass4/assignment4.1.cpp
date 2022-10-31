#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

char *strlwr(char *buff)
{
    unsigned char *p = (unsigned char *)buff;
    while (*p)
    {
        *p = tolower((unsigned char)*p);
        p++;
    }
    return buff;
}

void read_(char *str, char cmd[][20], int *count)
{ char *token;
  char buff[100]={};
  printf("command>");
  gets(str);
  strcpy(buff, str);
  strlwr(buff);
  *count=0;
  token=strtok(buff, " ");
  while(token!=NULL)
  {
    strcpy(cmd[*count], token);
    *count=*count+1;
    token=strtok(NULL, " ");
  }
}

int check_element(char cmd[][20], int count)
{
  int i=0;
  char cmd_list[20][19]={"list", "end", "sort", "pop", "help", "sqrt" , "rec" , "neg" , "pow" , "+" , "-" , "*" , "/", "delete", "search", "peek" , "push", "add", "insert"};
  while((i<19) && (strcmp(cmd_list[i], cmd[0]) != 0))
  {
    i++;
  }
  if(i<13)
   return 1;
  else if(i>12 && i<17)
   return 2;
  else if(i>16 && i<19)
   return 3;
  return 0;
}

int parameter(char cmd[][20], int count, int *para)
{
 *para=1;
 int check_int;
 char check_char;
 while((*para<count) && (sscanf(cmd[*para], "%d%s",&check_int,&check_char)==1))// scanf -> sscanf
 {
   *para=*para+1;
 }
 *para=*para-1;
 if(*para != (count-1))
 {
   return 0;
 }
 else return  1;
}

void checkgroup(char cmd[][20], int group, int para)
{
  if(group==1 && para==0)
   printf("answer>ok\n");
  else if(group==2 && para==1)
   printf("answer>ok\n");
  else if(group==3 && para>=1)// [>1] -> [>=1]
   printf("answer>ok\n");
  else
   printf("answer>parameter error\n");
}

int main()
{ int count=0;
  int group=0;
  int para=0;
  char str[100]={};
  char cmd[10][20]={};
  do
  {
    read_(str, cmd, &count);
    group=check_element(cmd, count);
    if(group==0)
     printf("answer>syntax error\n");
    else if(parameter(cmd, count, &para)==0)
     printf("answer>parametor error\n");
    else
     checkgroup(cmd, group, para);
  }while (strcmp(str, "end"));
  printf("End program\n");
  printf("Program writen by 63070501056 Ms.Monthida Arnuphapsamosorn\n");
  return  0;
}
