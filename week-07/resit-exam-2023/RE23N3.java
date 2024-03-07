interface CarPart {}
class Engine implements CarPart {}

class Car {
  private Engine engine;
  public void setEngine(Engine engine) {
    this.engine = engine;
  }
}

class Sedan extends Car {}
class Van extends Car {}

class SedanBuilder extends CarBuilder<Sedan> {}
class VanBuilder extends CarBuilder<Van> {}

class CarBuilder<T extends Car> {
  private Engine engine;
  private T car;
  public void setCar(T car) {
    this.car = car;
  }

  public void setEngine(Engine engine) {
    this.car.setEngine(engine);
  }

  public T getCar() {
    return car;
  }
}