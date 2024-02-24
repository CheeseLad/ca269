class Individual {
  public String name;

  Individual(String name) {
    this.name = name;
  }

  public String toString() {
    return this.name;
  }
}

class Person extends Individual {
  private String nickname;

  Person(String name, String nickname) {
    super(name);
    this.nickname = nickname;
  }

  public String toString() {
    return this.name + " (" + this.nickname + ")" ;
  }
}