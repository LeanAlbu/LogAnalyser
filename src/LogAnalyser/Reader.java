package LogAnalyser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Reader {
    Scanner Snc;
    Path dirPath;

    public Reader() {
        this.Snc = new Scanner(System.in);
    }


    //Read repositories and return list of archives inside it
    public List<Path> search(){
        System.out.println("Insert Path:");
        Path dirPath = Path.of(Snc.next());

        try(Stream<Path> stream = Files.list(dirPath)){
            return stream.filter(Files::isRegularFile)
                                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException("Error");
        }
    }

    public Path picker(List<Path> paths){
        for (Path path : paths) {
            System.out.println(path);
        }
        System.out.println("Insert index of file: ");
        int idx = Snc.nextInt();
        Path picked = paths.get(idx-1);
        return picked;
    }

}



