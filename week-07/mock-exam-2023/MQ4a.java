abstract class Item {}
class Apple extends Item { }
class Orange extends Item { }
class Lemon extends Item { }

class Factory<T extends Item> {
  T item;
  public T getItem() {
    return this.item;
  }

  public void setItem(T item) {
    this.item = item;
  }
}