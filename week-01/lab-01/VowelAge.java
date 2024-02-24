import java.util.Scanner;

public class VowelAge {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        int vowelCount = 0;

        String name = input.nextLine();
        int age = input.nextInt();

        for(char s : name.toCharArray()) {
          switch(s) {
            case 'a':
              vowelCount = vowelCount + 1;
              break;
            case 'e':
              vowelCount = vowelCount + 1;
              break;
            case 'i':
              vowelCount = vowelCount + 1;
              break;
            case 'o':
              vowelCount = vowelCount + 1;
              break;
            case 'u':
              vowelCount = vowelCount + 1;
              break;
            case 'A':
              vowelCount = vowelCount + 1;
              break;
            case 'E':
              vowelCount = vowelCount + 1;
              break;
            case 'I':
              vowelCount = vowelCount + 1;
              break;
            case 'O':
              vowelCount = vowelCount + 1;
              break;
            case 'U':
              vowelCount = vowelCount + 1;
              break;
          }
        }
        if(age >= 18) {
          System.out.println("Hello " + name + ", you have " + vowelCount + " vowels, and you are an adult");
        } else {
          System.out.println("Hello " + name + ", you have " + vowelCount + " vowels, and you are a minor");
        }
        
      }
    }