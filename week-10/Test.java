import java.io.File;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner input = new Scanner(new File("./characters.csv"));
    input.useDelimiter(",");
    while(input.hasNext()) {
      String token = input.next();
    }
    input.close();
  }

}
