#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>

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
 double check_int;
 char check_char;
 while((*para<count) && (sscanf(cmd[*para], "%lf%s",&check_int,&check_char)==1))
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
   printf("answer>ok \n");
  else if(group==2 && para==1)
   printf("answer>ok \n");
  else if(group==3 && para>=1)
   printf("answer>ok\n");
  else
   printf("answer>parameter error\n");
}

typedef struct node //ใช้สร้าง linkedlist 1 ช่อง
{
    double info;
    struct node *next;
}linkedlist;
linkedlist *first,*last;

void add_data(double num)// ใช้สร้าง linkedist ช่องอื่นๆ
{
    linkedlist *ptr;
    ptr = (linkedlist*)malloc(sizeof(linkedlist));
    ptr->info = num;
    ptr->next = NULL;
    if(first == NULL)
    {
        first = last = ptr;
    }
    else
    {
        last->next = ptr;
        last = ptr;
    }
}

int sizelist ()// ใช้สำหรับนับจำนวนของ linkedlist
{
    linkedlist *ptr;
    int count = 0;
    ptr = first;
    while(ptr!=NULL)
    {
        count++;
        ptr=ptr->next;
    }
    return count;
}

void sortlist()// ใช้สำหรับเรียงข้อมูล linkedlist
{
    linkedlist *ptr_i,*ptr_j;
    double x;
    for(ptr_i = first;ptr_i->next!=NULL;ptr_i = ptr_i->next)
     for(ptr_j = ptr_i->next;ptr_j!=NULL;ptr_j = ptr_j->next)
      if(ptr_j->info < ptr_i->info)
      {
          x=ptr_i->info;
          ptr_i->info = ptr_j->info;
          ptr_j->info = x;
      }
}

void list()//ใช้สำหรับเเสดงข้อมูล
{
    linkedlist *ptr;
    int count = 0;
    ptr  = first;
    printf("list> ");
    while(ptr!=NULL)
    {
      count++;
      printf("%g ",ptr->info);
      ptr = ptr->next;
    }
    if(count==0)
    {
      printf("NULL");
    }
    printf("\n");
}


int checksort ()// ใช้สำหรับตรวจสอบว่าข้อมูลใน linkedlist เรียงหรือยัง?
{
    if(sizelist() == 0)
    {
        return 1;
    }
    linkedlist *ptr,*prev;
    prev = first;
    ptr = prev->next;
    while((ptr!=NULL) && (prev->info < ptr->info))
    {
        prev = ptr;
        ptr = prev->next;
    }
    if(ptr!=NULL)
    {
        return 0;
    }
    else
    {
        return 1;
    }
}

void push(double num)// ฟังก์ชัน push ใส่ข้อมูล linkedlist เพิ่มตัวหน้า
{
    linkedlist *ptr;
    ptr = (linkedlist*)malloc(sizeof(linkedlist));
    ptr->next = NULL;
    ptr->info = num;
    if(first == NULL)
    {
        first = last = ptr;
    }
    else
    {
        ptr->next = first;
        first = ptr;
    }
}

double pop()// ฟังก์ชั้น pop ดึงข้อมูลlinnkedlist ตัวเเรกออก
{
    double num;
    if(sizelist() == 0)
    {
        num = -1;
    }
    else
    {
        linkedlist *ptr;
        ptr = first;
        num = ptr->info;
        first = first->next;
        if(first == NULL)
        {
            last = NULL;
        }
    }
    return num;
}

void peek(int position)// ฟังก์ชัน peek เรียกดูข้อมูลตำเเหน่งที่ position
{
    linkedlist *ptr;
    int i=1;
    ptr = first;
    if(position == 0)
    {
        printf("answer> %g\n",first->info);
    }
    else if(position == -1)
    {
       printf("answer> %g\n",last->info);
    }
    else if(position >= sizelist())
    {
        printf("Maximum peek = %d\n",sizelist()-1);
    }
    else
    {
       while(i <= position)
       {
           ptr = ptr->next;
           i++;
       }
       printf("answer> %g\n",ptr->info);
    }
}

int search(double num)// ฟังก์ชัน search เรียกดูตำเเหน่งของตัวเลขที่ n
{
    linkedlist *ptr;
    int n=0;
    ptr = first;
    while(ptr!=NULL && ptr->info!=num)
    {
        ptr = ptr->next;
        n++;
    }
    if(ptr!=NULL)
    {
        return n;
    }
    else
    {
        return -1;
    }
}

void insert(double num)// ฟังก์ชัน ใส่ข้อมูลเพิ่มโดยที่ linkedlist ต้องเรียงก่อน
{
    int i=0,pos=0;
    linkedlist *ptr,*prev,*ins;
    ptr = prev = first;
    while(ptr!=NULL && num > ptr->info)
    {
        ptr = ptr->next;
        pos++;
    }
    if(pos == 0)
    {
        push(num);
    }
    else if(pos == sizelist())
    {
        add_data(num);
    }
    else
    {
        while(i != pos-1)
        {
            prev = prev->next;
            i++;
        }
        ins = (linkedlist*)malloc(sizeof(linkedlist));
        ins->next = NULL;
        ins->info = num;
        ins->next = prev->next;
        prev->next = ins;
    }
}

linkedlist *delete_node(int position)//ลบ node ที่ต้องการจะลบ
{
    linkedlist *ptr,*prev;
    prev = first;
    int i = 0;
    if((position == 0)& sizelist() == 1)
    {
        ptr = first;
        first = last = NULL;
    }
    else if(position == 0)
    {
        ptr = first;
        first = first->next;
    }
    else
    {
        while(i!=position-1)
        {
            prev = prev->next;
            i++;
        }
        if(position == sizelist())
        {
            ptr = last;
            last = prev;
            last->next = NULL;
        }
        else
        {
            ptr = prev->next;
            prev->next = ptr->next;
        }
    }
    return ptr;
}

void delete(double x)//ฟังก์ชันลบ node ที่ต้งการออกจาก linkedlist
{
    linkedlist *ptr,*prev;
    prev = first;
    int i=0,j=0;
    char ch,r[30];
    ptr = first;
    while(ptr!=NULL)
    {
        if(x == ptr->info)
        {
            j = 1;
            printf("answer> %g found enter y to confirm",x);
            scanf(" %c",&ch);
            if(ch == 'y')
            {
                delete_node(i);
                i--;
            }
            gets(r);
        }
        ptr = ptr->next;
        i++;
    }
    if(j == 0)
    {
        printf("answer> %g not found\n",x);
    }
}
int main()
{ int count=0;
  int group=0;
  int para=0;
  char str[100]={};
  char cmd[10][20]={};
  first = last = NULL;
  do
  {
    list();
    int pr;
    read_(str, cmd, &count);
    group=check_element(cmd, count);
    pr=parameter(cmd, count, &para);
    if(group==0)
     printf("answer>syntax error\n");
    else if(pr==0)
     printf("answer>parameter error\n");
    else
    {
     checkgroup(cmd, group, para);

    if(pr!=0)
    {
     if(group==1&&para==0)
     {
        if(strcmp("pop",cmd[0])==0)
        {
            double p=pop();
            if(p == -1)
            {
                printf("answer>no data\n");
            }
            else
            {
                printf("answer> %g\n",p);
            }
        }
        else if(strcmp("sort",cmd[0])==0)
        {
            if(sizelist()==0)
            {
               printf("answer> no data\n");
            }
            else
            {
               sortlist();
            }
        }
        else if(strcmp("sqrt",cmd[0])==0)//เเบบดึงออกมาตัวเดียวเเล้วทำ
        {
            if(sizelist()==0)
            {
                printf("answer> no data\n");
            }
            else
            {
                double p;
                p = pop();
                p = sqrt(p);
                push(p);
                printf("answer> %g\n",p);
            }
        }
        else if(strcmp("rec",cmd[0])==0)
        {
            if(sizelist()==0)
            {
                printf("answer> no data\n");
            }
            else
            {
                double p;
                p = pop();
                p = 1/p;
                push(p);
                printf("answer> %g\n",p);
            }
        }
        else if(strcmp("neg",cmd[0])==0)
        {
            if(sizelist()==0)
            {
                printf("answer> no data\n");
            }
            else
            {
                double p;
                p = pop();
                p = (-1)*p;
                push(p);
                printf("answer> %g\n",p);
            }
        }
        else if(strcmp("+",cmd[0])==0)//แแบบดึงออกมา 2 ตัว
        {
            if(sizelist()==0)
            {
                printf("answer> no data\n");
            }
            else if(sizelist()==1)
            {
                printf("answer> can't operation\n");
            }
            else
            {
                double p1,p2,ans;
                p1 = pop();
                p2 = pop();
                ans = p1+p2;
                push(ans);
                printf("answer> %g\n",ans);
            }
        }
        else if(strcmp("-",cmd[0])==0)
        {
            if(sizelist()==0)
            {
                printf("answer> no data\n");
            }
            else if(sizelist()==1)
            {
                printf("answer> can't operation\n");
            }
            else
            {
                double p1,p2,ans;
                p1 = pop();
                p2 = pop();
                ans = p2-p1;
                push(ans);
                printf("answer> %g\n",ans);
            }
        }
        else if(strcmp("*",cmd[0])==0)
        {
            if(sizelist()==0)
            {
                printf("answer> no data\n");
            }
            else if(sizelist()==1)
            {
                printf("answer> can't operation\n");
            }
            else
            {
                double p1,p2,ans;
                p1 = pop();
                p2 = pop();
                ans = p1*p2;
                push(ans);
                printf("answer> %g\n",ans);
            }
        }
        else if(strcmp("/",cmd[0])==0)
        {
            if(sizelist()==0)
            {
                printf("answer> no data\n");
            }
            else if(sizelist()==1)
            {
                printf("answer> can't operation\n");
            }
            else
            {
                double p1,p2,ans;
                p1 = pop();
                p2 = pop();
                ans = p2/p1;
                push(ans);
                printf("answer> %g\n",ans);
            }
        }
        else if(strcmp("pow",cmd[0])==0)
        {
            if(sizelist()==0)
            {
                printf("answer> no data\n");
            }
            if(sizelist()==1)
            {
                printf("answer> can't operation\n");
            }
            else
            {
                double p1,p2,ans;
                p1 = pop();
                p2 = pop();
                ans = pow(p2,p1);
                push(ans);
                printf("answer> %g\n",ans);
            }
        }
        else if(strcmp("help",cmd[0])==0)
        {
            printf("answer> list of command\n");
            printf("- add(list)\n");
            printf("- insert(list)\n");
            printf("- push (n)\n");
            printf("- peek (n)\n");
            printf("- delete (n)\n");
            printf("- search (n)\n");
            printf("- sqrt\n");
            printf("- rec\n");
            printf("- neg\n");
            printf("- +, -, *, /\n");
            printf("- list\n");
            printf("- sort\n");
            printf("- pop\n");
            printf("- end\n");
        }
    }
    else if(group==2 && para==1)
    {   double r;
        r = atof(cmd[1]);
        if(strcmp("push",cmd[0])==0)
        {
          push(r);
        }
        if(strcmp("peek",cmd[0])==0)
        {
          peek(r);
        }
        if(strcmp("search",cmd[0])==0)
        { int p = search(r);
          if(p == -1)
          {
              printf("answer> %g not found\n",r);
          }
          else
          {
              printf("answer> found %g at[%d]\n",r,p);
          }
        }
        if(strcmp("delete",cmd[0])==0)
        {
            if(sizelist()==0)
            {
               printf("answer> no data\n");
            }
            else
            {
               delete(r);
            }
        }
    }
    else if(group==3 && para>=1)
    {
        if(strcmp("add",cmd[0])==0)
        {
            int i;
            for(i=1;i<count;i++)
            {
              add_data(atof(cmd[i]));
            }
        }
        else if(strcmp("insert",cmd[0])==0)
        {
            if(checksort() == 0)
            {
                printf("answer> can't insert please sorted before\n");
            }
            else
            {
                int i;
                for(i=1;i<count;i++)
                {
                  insert(atof(cmd[i]));
                }
            }
        }
    }
   }
   }
  }while (strcmp(str, "end")!=0);
  printf("End program\n");
  printf("Program writen by 63070501056 Ms.Monthida Arnuphapsamosorn\n");
  return  0;
}
