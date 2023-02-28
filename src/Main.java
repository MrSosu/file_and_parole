import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        FileAndParole fileAndParole = new FileAndParole();
        // fileAndParole.stampaParole(Path.of("resources/prova.txt"));
        HashMap<String, Integer> mappa = fileAndParole.occorrenzeParole(Path.of("resources/prova.txt"));
        System.out.println(mappa);
        HashMap<String, Integer> secondaMappa = fileAndParole.occorrenzeParoleTesto(Path.of("resources/alice_in_wonderland.txt"));
        System.out.println(secondaMappa);
    }

}
