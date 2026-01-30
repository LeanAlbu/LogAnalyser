package LogAnalyser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
            List<String> cleanLines = lineStream
                    .filter(linha -> linha.startsWith("http") || linha.startsWith("ftp"))
                    .toList();
                for(int i = 0; i < cleanLines.size(); i++){
                    System.out.println(cleanLines.get(i));
                }
                Statistics(cleanLines);
        }catch(IOException e){
            throw new RuntimeException("ERROR: FAILED TO READ FILE");
        }

    }

    public void Statistics (List<String> urls){
        Map<String, Long> statsTable = urls.stream()
                .map(url -> {
                    try{
                        String host = new URI(url).getHost();
                        return host;
                    }catch (URISyntaxException e){
                        return null;
                    }
                })
                .filter(domain -> domain != null && !domain.isEmpty())
                .collect(Collectors.groupingBy(
                        domain -> domain,
                        Collectors.counting()
                ));
        statsTable.forEach((domain, occurrences) -> {
            System.out.println("Domain: "+ domain + "| Occurrences: "+ occurrences);
        });

    }
}



