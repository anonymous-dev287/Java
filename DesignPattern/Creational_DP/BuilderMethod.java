package DesignPattern;

//Product
class Computer {
 private String cpu;
 public String getCpu() {
	return cpu;
}

public void setCpu(String cpu) {
	this.cpu = cpu;
}

public String getRam() {
	return ram;
}

public void setRam(String ram) {
	this.ram = ram;
}

public String getStorage() {
	return storage;
}

public void setStorage(String storage) {
	this.storage = storage;
}

private String ram;
 private String storage;

 public Computer(String cpu, String ram, String storage) {
     this.cpu = cpu;
     this.ram = ram;
     this.storage = storage;
 }

}

//Builder
interface ComputerBuilder {
 void buildCpu(String cpu);
 void buildRam(String ram);
 void buildStorage(String storage);
 Computer getResult();
}

//ConcreteBuilder
class DesktopBuilder implements ComputerBuilder {
 private Computer computer = new Computer("Default CPU", "Default RAM", "Default Storage");

 @Override
 public void buildCpu(String cpu) {
     computer = new Computer(cpu, computer.getRam(), computer.getStorage());
 }

 @Override
 public void buildRam(String ram) {
     computer = new Computer(computer.getCpu(), ram, computer.getStorage());
 }

 @Override
 public void buildStorage(String storage) {
     computer = new Computer(computer.getCpu(), computer.getRam(), storage);
 }

 @Override
 public Computer getResult() {
     return computer;
 }
}

//Director
class ComputerDirector {
 private ComputerBuilder builder;

 public ComputerDirector(ComputerBuilder builder) {
     this.builder = builder;
 }

 public void constructComputer() {
     builder.buildCpu("Intel i7");
     builder.buildRam("16GB");
     builder.buildStorage("512GB SSD");
 }
}

//Client
public class BuilderMethod {
 public static void main(String[] args) {
     ComputerBuilder desktopBuilder = new DesktopBuilder();
     ComputerDirector director = new ComputerDirector(desktopBuilder);

     director.constructComputer();
     Computer desktop = desktopBuilder.getResult();

     System.out.println("Desktop Configuration:");
     System.out.println("CPU: " + desktop.getCpu());
     System.out.println("RAM: " + desktop.getRam());
     System.out.println("Storage: " + desktop.getStorage());
 }
}
/* Same example with different way of solving
*Comment the above code and run this*/
//Example#2 Construct a bike 
//Product
//public class Bike {
// private String brand;
// private String model;
// private String color;
// private int wheelSize;
// private boolean hasGears;
// // Other properties...
//
// private Bike(BikeBuilder builder) {
//     this.brand = builder.brand;
//     this.model = builder.model;
//     this.color = builder.color;
//     this.wheelSize = builder.wheelSize;
//     this.hasGears = builder.hasGears;
//     // Set other properties...
// }
//
// // Getter methods...
//
// // Builder
// public static class BikeBuilder {
//     private String brand;
//     private String model;
//     private String color;
//     private int wheelSize;
//     private boolean hasGears = false;
//     // Other properties...
//
//     public BikeBuilder(String brand, String model, String color, int wheelSize) {
//         this.brand = brand;
//         this.model = model;
//         this.color = color;
//         this.wheelSize = wheelSize;
//     }
//
//     public BikeBuilder addGears() {
//         this.hasGears = true;
//         return this;
//     }
//
//     public BikeBuilder setWheelSize(int wheelSize) {
//         this.wheelSize = wheelSize;
//         return this;
//     }
//
//     // Methods for setting other properties...
//
//     public Bike build() {
//         return new Bike(this);
//     }
//
//	public void setColor(String string) {
//		// TODO Auto-generated method stub
//		
//	}
// }
//
// // Director
// public static class BikeDirector {
//     private BikeBuilder builder;
//
//     public BikeDirector(BikeBuilder builder) {
//         this.builder = builder;
//     }
//
//     public void constructMountainBike() {
//         builder.addGears().setWheelSize(26).setColor("Green");
//         // Add other configuration steps...
//     }
// }
//
// // Main Client Code
// public static void main(String[] args) {
//     // Creating a bike using a director
//     BikeBuilder bikeBuilder = new Bike.BikeBuilder("Trek", "Mountain Bike", "Red", 26);
//     BikeDirector director = new BikeDirector(bikeBuilder);
//
//     director.constructMountainBike();
//     Bike mountainBike = bikeBuilder.build();
//
//     // Display the configuration of the constructed mountain bike
//     System.out.println("Mountain Bike Configuration:");
//     System.out.println("Brand: " + mountainBike.brand);
//     System.out.println("Model: " + mountainBike.model);
//     System.out.println("Color: " + mountainBike.color);
//     System.out.println("Wheel Size: " + mountainBike.wheelSize);
//     System.out.println("Has Gears: " + mountainBike.hasGears);
//     // Display other properties...
// }
//}
//
// 
/*

Computer is the product being built.
ComputerBuilder is the builder interface.
DesktopBuilder is a concrete builder implementing the ComputerBuilder interface.
ComputerDirector is the director class responsible for orchestrating the construction process.
The main method in BuilderPatternExample demonstrates how a client can use the builder pattern to construct a complex object (Computer) step by step.

This design pattern is useful when an object needs to be constructed with numerous possible configurations or when the construction process is complex and
 needs to be separated from the representation of the object

*/