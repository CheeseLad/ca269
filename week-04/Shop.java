interface StorageCondition { }
interface LockedShelves extends StorageCondition { }
interface SecurityTag extends StorageCondition { }
interface Cooled {
    void setOptimumTemp(int temp);
}
interface Refrigerated extends Cooled {
    void setMinTemp(int temp);
}
interface Frozen extends Refrigerated  {
    void setMaxTemp(int temp);
}

abstract class Item {
    final String name;
    double price;
    int expiryInDays;
}

class Perfume extends Item implements { }
class AirFreshner extends Perfume { } // does not inherit security measures

class ExpensivePerfume extends Item implements LockedShelves, SecurityTag { }
class CalvinKleinPerfume extends ExpensivePerfume { } // inherits security measures

class Milk extends Item implements Refrigerated {
    int minTemp;
    int maxTemp;
    int optimumTemp;

    void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    void setOptimumTemp(int optimumTemp) {
        this.optimumTemp = optimumTemp;
    }
}