package DesignPattern.StructuralDP;

//Component interface
interface Coffee {
 String getDescription();
 double cost();
}

//ConcreteComponent
class SimpleCoffee implements Coffee {
 @Override
 public String getDescription() {
     return "Simple Coffee";
 }

 @Override
 public double cost() {
     return 20.0;  // Cost of a simple coffee
 }
}

//Decorator
abstract class CoffeeDecorator implements Coffee {
 protected Coffee decoratedCoffee;

 public CoffeeDecorator(Coffee decoratedCoffee) {
     this.decoratedCoffee = decoratedCoffee;
 }

 @Override
 public String getDescription() {
     return decoratedCoffee.getDescription();
 }

 @Override
 public double cost() {
     return decoratedCoffee.cost();
 }
}

//ConcreteDecorator - Milk
class MilkDecorator extends CoffeeDecorator {
 public MilkDecorator(Coffee decoratedCoffee) {
     super(decoratedCoffee);
 }

 @Override
 public String getDescription() {
     return super.getDescription() + ", Milk";
 }

 @Override
 public double cost() {
     return super.cost() + 40.0;  // Additional cost for milk
 }
}

//ConcreteDecorator - Sugar
class SugarDecorator extends CoffeeDecorator {
 public SugarDecorator(Coffee decoratedCoffee) {
     super(decoratedCoffee);
 }

 @Override
 public String getDescription() {
     return super.getDescription() + ", Sugar";
 }

 @Override
 public double cost() {
     return super.cost() + 50.0;  // Additional cost for sugar
 }
}

//Client Code
public class Decorator {
 public static void main(String[] args) {
     // Simple Coffee
     Coffee simpleCoffee = new SimpleCoffee();
     System.out.println("Description: " + simpleCoffee.getDescription());
     System.out.println("Cost: Rs." + simpleCoffee.cost());

     // Coffee with Milk
     Coffee coffeeWithMilk = new MilkDecorator(simpleCoffee);
     System.out.println("Description: " + coffeeWithMilk.getDescription());
     System.out.println("Cost: Rs." + coffeeWithMilk.cost());

     // Coffee with Milk and Sugar
     Coffee coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilk);
     System.out.println("Description: " + coffeeWithMilkAndSugar.getDescription());
     System.out.println("Cost: Rs." + coffeeWithMilkAndSugar.cost());
 }
}
/*     Coffee is the component interface with SimpleCoffee as the concrete component.
    CoffeeDecorator is the decorator, and MilkDecorator and SugarDecorator are concrete decorators.
    The client code demonstrates creating different combinations of coffees with added condiments.   */