package StructuralDP_CDPFBF;

interface Burger {
    double price();
}

class BeefBurger implements Burger {
    @Override
    public double price() {
        return 8.0;
    }
}

class VegBurger implements Burger {
    @Override
    public double price() {
        return 6.0;
    }
}

class EggBurger implements Burger {
    @Override
    public double price() {
        return 7.0;
    }
}

abstract class BurgerDecorator implements Burger {
    protected Burger decoratedBurger;

    public BurgerDecorator(Burger burger) {
        this.decoratedBurger = burger;
    }

    @Override
    public double price() {
        return decoratedBurger.price();
    }
}

class ExtraCheese extends BurgerDecorator {
    public ExtraCheese(Burger burger) {
        super(burger);
    }

    @Override
    public double price() {
        return super.price() + 2.0;
    }
}

public class DecoratorDP {
    public static void main(String[] args) {
        Burger beefBurger = new BeefBurger();
        Burger vegBurger = new VegBurger();
        Burger eggBurger = new EggBurger();

        Burger beefBurgerWithCheese = new ExtraCheese(beefBurger);
        Burger vegBurgerWithCheese = new ExtraCheese(vegBurger);
        Burger eggBurgerWithCheese = new ExtraCheese(eggBurger);

        System.out.println("Beef Burger price: $" + beefBurger.price());
        System.out.println("Veg Burger price: $" + vegBurger.price());
        System.out.println("Egg Burger price: $" + eggBurger.price());

        System.out.println("Beef Burger with Extra Cheese price: $" + beefBurgerWithCheese.price());
        System.out.println("Veg Burger with Extra Cheese price: $" + vegBurgerWithCheese.price());
        System.out.println("Egg Burger with Extra Cheese price: $" + eggBurgerWithCheese.price());
    }
}
