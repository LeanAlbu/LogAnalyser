package LogAnalyser;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner Scn;
    private Reader Reader;
    private String fileName;


    public Menu(){
        this.Scn = new Scanner(System.in);
        this.Reader = new Reader();
        this.fileName = "Null";
    }
    public void show(){
        boolean flag = true;
        while(flag){
            System.out.println("Selected Document: " + this.fileName);
            System.out.println("1 - Search Document");
            System.out.println("2 - Read Document");
            System.out.println("3 - Exit");

            int opt = Scn.nextInt();
            Scn.nextLine();

            switch(opt){
                case 1 ->{
                    System.out.println("Searching...");
                    List<Path> paths = Reader.search();
                    this.fileName = Reader.picker(paths).toString();
                }

                case 2 ->{
                    System.out.println("Reading...");
                    Reader.Analyser(Path.of(this.fileName));
                }
                case 3 ->{
                    System.out.println("Exiting...");
                    flag = false;
                }
            }
        }
    }
}
