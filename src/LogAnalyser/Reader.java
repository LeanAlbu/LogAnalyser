package LogAnalyser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
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
            throw new RuntimeException("ERROR: FAILED TO OPEN FILE");
        }
    }

    public Path picker(List<Path> paths){
        for (Path path : paths) {
            System.out.println(path);
        }
        System.out.println("Insert index of file: ");
        int idx = Snc.nextInt();
        return paths.get(idx-1);
    }

    public void Analyser (Path pathToFile){
        try(Stream<String> lineStream = Files.lines(pathToFile)){
            Set<String> cleanLines = lineStream
                    .filter(linha -> linha.startsWith("http") || linha.startsWith("ftp"))
                    .collect(Collectors.toSet());
                for(int i = 0; i < cleanLines.size(); i++){
                    if(cleanLines.get(i) )
                    System.out.println(line);

                }

        }catch(IOException e){
            throw new RuntimeException("ERROR: FAILED TO READ FILE");
        }

    }

}



