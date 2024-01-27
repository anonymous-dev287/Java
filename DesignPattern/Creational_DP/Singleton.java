package DesignPattern;

/*Lazy Initialization of Singleton Instances*/

public class Singleton {
    // Private static instance of the Singleton class
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
        // Initialization code (if needed)
    }

    // Public static method to get the instance of the Singleton class
    public static Singleton getInstance() {
        // Lazy initialization: create the instance only if it doesn't exist
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods and properties of the Singleton class
    public void doSomething() {
        System.out.println("Singleton instance is doing something.");
    }
    public class Main {
        public static void main(String[] args) {
            // Get the Singleton instance
            Singleton singleton = Singleton.getInstance();

            // Use the Singleton instance
            singleton.doSomething();
        }
    }
}

/*Comment Above Code to Run this
Early Initialization of Singleton Instance 
*/

// 	public class Singleton {
//    // Private static instance of the Singleton class, initialized at class loading
//    private static final Singleton instance = new Singleton();
//
//    // Private constructor to prevent instantiation from outside
//    private Singleton() {
//        // Initialization code (if needed)
//    }
//
//    // Public static method to get the instance of the Singleton class
//    public static Singleton getInstance() {
//        return instance;
//    }
//
//    // Other methods and properties of the Singleton class
//    public void doSomething() {
//        System.out.println("EagerInitializedSingleton instance is doing something.");
//    }
//    public class Main {
//    public static void main(String[] args) {
//        // Get the Singleton instance
//        Singleton singleton = Singleton.getInstance();
//
//        // Use the Singleton instance
//        singleton.doSomething();
//    }
//}
//
//}

