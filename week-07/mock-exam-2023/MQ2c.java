class Person {
  private String name;

  Person(String name) {
    this.name = name;
  }
}

class Employee extends Person {
  private String employeeID;

  Employee(String name, String employeeID) {
    super(name);
    this.employeeID = employeeID;
  }
}

interface VIP {
  String VIPStatus();
}

class VeryImportantPerson extends Person implements VIP {

  VeryImportantPerson(String name) {
    super(name);
  }

  public String VIPStatus() {
    return "yes";
  }
}

class CompanyGathering {
  public boolean admitPerson(Person person) {
    if ((person instanceof Employee) || (person instanceof VeryImportantPerson)) {
      return true;
    } else {
      return false;
    }
  }
}