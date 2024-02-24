import java.util.Scanner;

public class AlarmClock {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int alarm_hh = input.nextInt();
        int alarm_mm = input.nextInt();
        int false_count = 0;
        int stop = 0;

        while (stop == 0) {
          int hh = input.nextInt();
          int mm = input.nextInt();
          if (hh <= alarm_hh) {
            false_count++;
          } 
          if (hh >= alarm_hh) {
            stop = 1;
          }
        }
        
        System.out.println("false alarms: " + false_count);         
  }
}