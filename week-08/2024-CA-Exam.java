import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

interface Weather {
    String getName();
    int getDuration();
    boolean wasItRaining();
    boolean wasItSunny();
    boolean wasItWindy();
    boolean wasItSnowy();
}

class TypicalDay implements Weather {

    private String name;
    private int duration;
    private boolean raining;
    private boolean sunny;
    private boolean windy;
    private boolean snowy;

    TypicalDay() {
        this.name = "Typical Day";
        this.duration = 1440;
        this.raining = true;
        this.sunny = true;
        this.windy =  true;
        this.snowy = true;
    }

    TypicalDay(String name, int duration, boolean raining, boolean sunny, boolean windy, boolean snowy) {
        this.setName(name);
        this.setDuration(duration);
        this.raining = raining;
        this.sunny = sunny;
        this.windy =  windy;
        this.snowy = snowy;
    }

    public String getName() {
        return this.name;
    }
    public int getDuration() {
        return this.duration;
    }

    public boolean wasItRaining() {
        return this.raining;
    }
    public boolean wasItSunny() {
        return this.sunny;
    }
    public boolean wasItWindy() {
        return this.windy;
    }
    public boolean wasItSnowy() {
        return this.snowy;
    }

    // checking duration is not less than 5 characters
    public void setName(String name) { 
        if (name.length() >= 5) {
            this.name = name;
        }
    }

    // checking duration is not less than 60 minutes
    public void setDuration(int duration) { 
        if (duration >= 60) {
            this.duration = duration;
        }
    }
}

class WeatherStation {

    private final List<Weather> weatherList;
    private final Map<String,Integer> weatherMap;

    WeatherStation() {
        weatherList = new ArrayList<Weather>();
        weatherMap = new LinkedHashMap<String,Integer>();
    }
    // iterating through each of the different types of weather in the map, and printing them out along with their durations
    public String getStats() {
        String output = "";
        for(String weatherType: this.weatherMap.keySet()) {
            output += weatherType + ": " + this.weatherMap.get(weatherType)+ "\n";
        }
        return output;
    }

    public void addWeather(Weather weather) {
        weatherList.add(weather); // adding to ArrayList of Weather instances

        if (weather.wasItRaining()) {
            if (this.weatherMap.containsKey("Raining")) { // if recorded already, update the duration count
                this.weatherMap.put("Raining", + this.weatherMap.get("Raining") + weather.getDuration() / 60);
            } else { // if not recorded already, add the data
                this.weatherMap.put("Raining", weather.getDuration() / 60);
            }
        }

        if (weather.wasItSunny()) {
                if (this.weatherMap.containsKey("Sunny")) {
                this.weatherMap.put("Sunny", this.weatherMap.get("Sunny") + weather.getDuration() / 60);
            } else {
                this.weatherMap.put("Sunny", weather.getDuration() / 60);
            }
        }
            
        if (weather.wasItWindy()) {
                if (this.weatherMap.containsKey("Windy")) {
                this.weatherMap.put("Windy", this.weatherMap.get("Windy") + weather.getDuration() / 60);
            } else {
                this.weatherMap.put("Windy", weather.getDuration() / 60);
            }
        }

        if (weather.wasItSnowy()) {
            if (this.weatherMap.containsKey("Snowy")) {
                this.weatherMap.put("Snowy", this.weatherMap.get("Snowy") + weather.getDuration() / 60);
            } else {
                this.weatherMap.put("Snowy", weather.getDuration() / 60);
            }
        }
    }
}

class SingleWeather<T extends Weather> {
    private T singleton;

    public T getSingleton() {
        return this.singleton;
    }
    public void setSingleton(T singleton) {
        this.singleton = singleton;
    }
    SingleWeather(T singleton) {
       this.singleton = singleton;
    }
}

class WeirdDay extends TypicalDay { }

public class CAExam {
    public static void main(String[] args) {
        WeatherStation weatherstation = new WeatherStation();

        TypicalDay weather1 = new TypicalDay();
        System.out.println(weather1.getName());
        weatherstation.addWeather(weather1);

        TypicalDay weather2 = new TypicalDay("Test5", 2000, true, true, false, false);
        System.out.println(weather2.getName());
        weatherstation.addWeather(weather2);

        TypicalDay weather3 = new TypicalDay("Test1315", 300, false, true, false, false);
        System.out.println(weather3.getName());
        weatherstation.addWeather(weather3);

        TypicalDay weather4 = new TypicalDay("No", 30, true, true, true, true);
        System.out.println("Testing Setters: " + weather4.getName());
        System.out.println("Testing Setters: " + weather4.getDuration());

        System.out.println(weatherstation.getStats());

        SingleWeather<TypicalDay> WeatherFactory = new SingleWeather<TypicalDay>(new TypicalDay());
        System.out.println(WeatherFactory.getSingleton());
    }
}