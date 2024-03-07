import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

interface Day {
  int getAvgTemp();
}

interface SunnyDay extends Day {
  int getSunshine();
}

interface RainyDay extends Day {
  double getRainfall();
  boolean isSporadic();
}

interface RainbowDay extends SunnyDay, RainyDay {}

class PicnicHoliday implements Day {
  int avgTemp;
  public String accessories;

  public int getAvgTemp() {
    return avgTemp;
  }

  public static List<Day> getOutdoorDays(List<Day> days) {
    List<Day> filtered = new ArrayList<Day>();
    for (Day day: days) {
      if (day instanceof SunnyDay) {
        if (day instanceof RainyDay) {
          if (day instanceof RainyDay) {
            if (((RainyDay) day).getRainfall() < 2) {
              filtered.add(day);
            }
          }
        } else {
          filtered.add(day);
        }
      } 
    }
    return filtered;
  }

  public static List<Day> prioritiseDays(List<Day> days) {
    Collections.sort(days, (a, b) -> compare(a, b));
    return days;

  }

  static int compare(Day a, Day b) {
    return b.getAvgTemp() - a.getAvgTemp();
  }
}

class IndoorHoliday extends PicnicHoliday implements RainbowDay {

  int sunshine;
  double rainfall;
  boolean sporadicRainfall;

  IndoorHoliday(int avgTemp, int sunshine, double rainfall, boolean sporadicRainfall, String accessories) {
    this.avgTemp = avgTemp;
    this.sunshine = sunshine;
    this.rainfall = rainfall;
    this.sporadicRainfall = sporadicRainfall;
    this.accessories = accessories;
  }

  public int getSunshine() {
    return sunshine;
  }

  public boolean isSporadic() {
    return true;
  }

  public double getRainfall() {
    return rainfall;
  }
}