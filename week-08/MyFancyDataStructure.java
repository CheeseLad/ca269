import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Value implements Comparable<Value> {
  private final int value;
  private static boolean SORT_LOWER;

  public static boolean isSortLower() {
    return SORT_LOWER;
  }

  public static boolean isSortHigher() {
    return SORT_LOWER;
  }

  public static void setSortLower() {
    Value.SORT_LOWER = true; 
  }

  public static void setSortHigher() {
    Value.SORT_LOWER = false; 
  }

  public int getValue() {
    return this.value;
  }

  Value(int value) {
    this.value = value;
  }

  public String toString() {
    return String.valueOf(value);
  }

  public int compareTo(Value value) {
    if (SORT_LOWER) {
      return Integer.compare(this.value, value.value);
    } else {
      return Integer.compare(value.value, this.value);
    }
    
  }
}

class PreferLowerValues implements Comparator<Value> {
  public int compare(Value value1, Value value2) {
    if (Value.isSortLower()) {
      return Integer.compare(value2.getValue(), value1.getValue());
    } else {
      return Integer.compare(value1.getValue(), value2.getValue());
    }
  }
}

class PreferHigherValues implements Comparator<Value>  {
  public int compare(Value value1, Value value2) {
    if (Value.isSortHigher()) {
      return Integer.compare(value1.getValue(), value2.getValue());
    } else {
      return Integer.compare(value2.getValue(), value1.getValue());
    }
  }
} 