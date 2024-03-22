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
            character.hairColor = record.get("hairColor");
            character.skinColor = record.get("skinColor");
            character.eyeColor = record.get("eyeColor");
            character.birthYear = record.get("birthYear");
            character.gender = record.get("gender");
            character.homeworld = record.get("homeworld");
            character.species = record.get("species");
        }

        Writer out = new FileWriter("characters.json");
        Gson gson = new Gson();
        gson.toJson(charactersList, out);
        out.close();

        return "Done";
    } catch (Exception e) {
        // TODO: handle exception
    }
        return "Done";
    }
}

public class JarJarBinks {
    public static void main(String[] args) {
        StarWarsCharacter sw = new StarWarsCharacter();
        System.out.println(sw);
    }
}