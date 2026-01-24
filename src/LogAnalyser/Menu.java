package LogAnalyser;

import java.util.Scanner;

public class Menu {
    private Scanner Scn;
    private Reader Reader;


    public Menu(){
        this.Scn = new Scanner(System.in);
    }
    public void show(){
        boolean flag = true;
        while(flag){
            System.out.println("Welcome");
            System.out.println("1 - Search Document");
            System.out.println("2 - Read Document");
            System.out.println("3 - Exit");

            int opt = Scn.nextInt();
            Scn.nextLine();

            switch(opt){
                case 1 -> System.out.println("Searching...");
                case 2 -> System.out.println("Reading...");
                case 3 ->{
                    System.out.println("Exiting...");
                    flag = false;
                }
            }
        }
    }


}
