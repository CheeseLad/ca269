import java.util.List;
import java.util.ArrayList;

interface Weather {
  int getMinTemp();
  int getMaxTemp();
}

interface SunnyWeather extends Weather {
  int getMinutesOfSunshine();
}

interface RainyWeather extends Weather {
  double getAmount();
  boolean hasPersistence();
}

interface SunshowerWeather extends SunnyWeather, RainyWeather { }

class DailyWeather implements Weather {

  private int min;
  private int max;

  DailyWeather(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public int getMinTemp() {
    return this.min;
  }

  public int getMaxTemp() {
    return this.max;
  }

  public static List getStayIndoorDays(List days) {
    List selected = new ArrayList<>();
    for (Weather day: days) {
      if ((day instanceof RainyWeather) && ((RainyWeather) day).hasPersistence()) {
        selected.add(day);
      }
    }
    return selected;
  }

}

class SunshowerDay extends DailyWeather implements SunshowerWeather {

  private int minutes;
  private double amount;
  private boolean persistence;

  SunshowerDay(int min, int max, int minutes, double amount, boolean persistence) {
    super(min, max);
    this.minutes = minutes;
    this.amount = amount;
    this.persistence = persistence;

  }

  public int getMinutesOfSunshine() {
    return this.minutes;
  }

  public double getAmount() {
    return this.amount;
  }

  public boolean hasPersistence() {
    return this.persistence;
  }
}