interface PersonalDetails {
  String getName();
  int getAge();
}

interface FamilyMember extends PersonalDetails {
  String getNickname();
  void setNickname(String name);
}

class Individual implements PersonalDetails {
  public String name;
  public int age;

  Individual(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String toString() {
    return this.name;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }
}

class Person extends Individual implements FamilyMember {
  private String nickname;

  Person(String name, int age, String nickname) {
    super(name, age);
    this.nickname = nickname;
  }

  public String toString() {
    return this.name + " (" + this.nickname + ")" ;
  }

  public String getNickname() {
    return this.nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
}