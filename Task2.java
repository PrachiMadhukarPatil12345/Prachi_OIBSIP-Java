import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.*;
class bankaccount{
    static void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Enter your name :");
        Task2.name=sc.nextLine();
        System.out.println("Enter username :");
        String user=sc.nextLine();
        System.out.println("Enter password :");
        String pass=sc.nextLine();
        System.out.println("Enter your Account number :");
        Task2.accnumber=sc.nextLine();
        System.out.println("USER LOGGED-IN SUCCESSFULLY!");
        System.out.println("------------------------------------------------------------------------");
        Task2.prompt();
        while(true){
            display(Task2.name);
            int choice=sc.nextInt();
            if(choice==1){
                login(user,pass);
                break;
            }
            else {
                if(choice==2){
                    System.exit(0);
                }
                else{
                    System.out.println(" Username or Password is incorrect!!");
                }
            }
        }
    }
    static void display(String name){}
    static void login(String user,String pass){}
}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Enter amount to withdraw :");
        int wcash=sc.nextInt();
        if(wcash<=Task2.balance){
            Task2.balance=Task2.balance-wcash;
            Task2.history.add(Integer.toString(wcash));
            Task2.history.add("Withdraw");
            System.out.println("Amount Rs"+wcash+"/-withdraw successfully");
            System.out.println("--------------------------------------------------------------------------------");
        }
        else{
            System.out.println("insufficient balance to withdraw the cash");
            System.out.println("-----------------------------------------------------------------------------------");
        }
        Task2.prompt();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.print("Enter amount to deposit :");
        int dcash=sc.nextInt();
        Task2.updatebalance(dcash);
        Task2.history.add(Integer.toString(dcash));
        Task2.history.add("Deposit");
        System.out.println("Amount Rs."+dcash+"/- deposit successful!");
        System.out.println("---------------------------------------------------------------------------------------------");
        Task2.prompt();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Name of receiver:");
        String s=sc.nextLine();
        System.out.println("Enter the account number of the receiver");
        int num=sc.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int tcash=sc.nextInt();
        if(tcash<=Task2.balance){
            Task2.balance=Task2.balance-tcash;
            Task2.history.add(Integer.toString(tcash));
            Task2.history.add("transferred");
            System.out.println("Amount Rs."+tcash+"/- transferred successfully");
            System.out.println("---------------------------------------------------------------------------------------------");
        }
        else{
            System.out.println("insufficient balance to transfer the cash");
            System.out.println("-------------------------------------------------------------------------------------------------");
        }
    }
}





class his{
    static void transactionhistory(){
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Transaction History :");
            int k=0;
            if(Task2.balance>0){
            for(int i=0;i<(Task2.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(Task2.history.get(k)+" ");
                    k++;
                }
                System.out.println("--------------------------------------------------------------------------------------");
            }
            }
            else {
                System.out.println("your account is empty");
            }
            Task2.prompt();
    }
}
public class Task2 {
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void dashboard(){
        //System.out.println("\033[H\033[2J");
        Scanner sc=new Scanner(System.in);
        System.out.println("--------------------------------------WELCOME TO OASIS-INFOBYTE ONLINE ATM SERVICE PROJECT------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("choose option :");
        System.out.println("1. LOG-IN");
        System.out.println("2. QUIT");
        System.out.println("Enter choice");
        int choice =sc.nextInt();
        if (choice==1){
                bankaccount.register();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println(" Please Select the correct options :");
                dashboard();
            }
        }
    }
    static void prompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+Task2.name+"! TO ATM SYSTEM");
        System.out.println("---------------------");
		System.out.println("---------------------");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        // System.out.println("4. Check balance");
        System.out.println("4. Transaction History");
        System.out.println("5. Quit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
			     his.transactionhistory();
                //check.checkbalance();
            case 5:
			System.exit(0);
                
               
        }
    }

    public static void main(String[] args) {
        dashboard();
    }
}
