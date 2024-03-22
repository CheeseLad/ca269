class A implements Comparable<A> {
  B b;
  C c;

  compareTo(A other) {
    BComparator bc = new BComparator(); // what to do when comparable class isnt given
    bc.compare(this.b, other.get());
    //this.b.compareTo(other.b);
    //return this.b.x < oter.c.y;
  }
}

class B implements Comparable<B> {
  Z z;
}

class C implements Comparable<C> {

}

class BComparator implements Comparator<B> {

}
