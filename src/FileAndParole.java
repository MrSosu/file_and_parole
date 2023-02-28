import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

public class FileAndParole {

    /**
     * questo metodo prende in input un oggetto della classe Path del package java.nio.file
     * rappresentante un file di testo e stampa riga per riga tutte le parole contenute nel testo.
     * Si supponga che ogni parola sia separata da spazio e non vi siano segni di punteggiatura.
     * @param file un oggetto di tipo path contenente il file da elaborare
     * @throws IOException
     */
        public void stampaParole(Path file) throws IOException {
            FileReader fileReader = new FileReader(file.toFile());
            BufferedReader br = new BufferedReader(fileReader);

            while (br.ready()) {
                String riga = br.readLine();
                String[] parole = riga.split(" ");
                for (String parola : parole) {
                    System.out.println(parola);
                }
            }
        }

    /**
     * questo metodo prende in input un oggetto della classe Path del package java.nio.file
     * rappresentante un file di testo e ritorna una HashMap dove le chiavi sono le parole e i
     * valori sono il numero di occorrenze delle parole stesse nel testo. Si supponga che ogni parola
     * sia separata da spazio, siano tutte minuscole e non vi siano segni di punteggiatura.
     * @param file un oggetto di tipo path contenente il file da elaborare
     * @return una mappa con chiavi le parole e valore il numero di occorrenze nel file
     * @throws IOException
     */
        public HashMap<String, Integer> occorrenzeParole(Path file) throws IOException {
            FileReader fileReader = new FileReader(file.toFile());
            BufferedReader br = new BufferedReader(fileReader);
            HashMap<String, Integer> result = new HashMap<>();

            while (br.ready()) {
                String riga = br.readLine();
                String[] parole = riga.split(" ");
                for (String parola : parole) {
                    // se quella parola la vedo per la prima volta, metto nella mappa quella parola associandogli il numero 1
                    if (!result.containsKey(parola)) {
                        result.put(parola, 1);
                    }
                    // altrimenti prendo il vecchio valore e metto nella mappa il vecchio valore + 1
                    else {
                        int oldValue = result.get(parola);
                        result.put(parola, ++oldValue);
                    }
                }
            }
            return result;
        }

    public HashMap<String, Integer> occorrenzeParoleTesto(Path file) throws IOException {
        FileReader fileReader = new FileReader(file.toFile());
        BufferedReader br = new BufferedReader(fileReader);
        HashMap<String, Integer> result = new HashMap<>();

        while (br.ready()) {
            String riga = br.readLine();
            riga = riga.toLowerCase();
            riga = riga.replaceAll("[^a-z\\s]", "").trim();
            String[] parole = riga.split(" ");
            for (String parola : parole) {
                // se quella parola la vedo per la prima volta, metto nella mappa quella parola associandogli il numero 1
                if (!result.containsKey(parola)) {
                    result.put(parola, 1);
                }
                // altrimenti prendo il vecchio valore e metto nella mappa il vecchio valore + 1
                else {
                    int oldValue = result.get(parola);
                    result.put(parola, ++oldValue);
                }
            }
        }
        return result;
    }

}
