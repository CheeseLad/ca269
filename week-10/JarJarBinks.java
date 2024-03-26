import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

class StarWarsCharacter {
    String name = "";
    String height = "";
    String mass = "";
    String hairColor = "";
    String skinColor = "";
    String eyeColor = "";
    String birthYear = "";
    String gender = "";
    String homeworld = "";
    String species = "";

    StarWarsCharacter() { }

    // additional constructors go here

    // getters and setters go here

    // toString to print character info.
    public String toString() {
        return this.name;
    }
}

public class JarJarBinks {
    public static void main(String[] args) {
        try {
            List<StarWarsCharacter> charactersList = new ArrayList<>();
            Reader in = new FileReader("characters.csv");
    
            CSVFormat CSVparser = CSVFormat.Builder.create().setHeader().build();
    
            Iterable<CSVRecord> records = CSVparser.parse(in);
            for (CSVRecord record : records) {
                StarWarsCharacter character = new StarWarsCharacter();
                character.name = record.get("name");
                character.height = record.get("height");
                character.mass = record.get("mass");
                character.hairColor = record.get("hair_color");
                character.skinColor = record.get("skin_color");
                character.eyeColor = record.get("eye_color");
                character.birthYear = record.get("birth_year");
                character.gender = record.get("gender");
                character.homeworld = record.get("homeworld");
                character.species = record.get("species");
                charactersList.add(character);
            }
    
            Writer out = new FileWriter("characters.json");
            Gson gson = new Gson();
            gson.toJson(charactersList, out);
            out.close();
        } catch (Exception FileNotFoundException) {
            System.err.println(FileNotFoundException);
        }
           
    
    }
}
