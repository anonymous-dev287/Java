package DesignPattern;

//Abstract Product interfaces
interface Bat {
 void hit();
}

interface Ball {
 void bowl();
}

interface Stumps {
 void set();
}

//Concrete Product classes
class SGBat implements Bat {
 @Override
 public void hit() {
     System.out.println("SG Bat hits the ball!");
 }
}

class KookaburraBat implements Bat {
 @Override
 public void hit() {
     System.out.println("Kookaburra Bat hits the ball!");
 }
}

class SGBall implements Ball {
 @Override
 public void bowl() {
     System.out.println("SG Ball is bowled!");
 }
}

class KookaburraBall implements Ball {
 @Override
 public void bowl() {
     System.out.println("Kookaburra Ball is bowled!");
 }
}

class SGStumps implements Stumps {
 @Override
 public void set() {
     System.out.println("SG Stumps are set!");
 }
}

class KookaburraStumps implements Stumps {
 @Override
 public void set() {
     System.out.println("Kookaburra Stumps are set!");
 }
}

//Abstract Factory interface
interface CricketFactory {
 Bat createBat();
 Ball createBall();
 Stumps createStumps();
}

//Concrete Factory classes
class SGCricketFactory implements CricketFactory {
 @Override
 public Bat createBat() {
     return new SGBat();
 }

 @Override
 public Ball createBall() {
     return new SGBall();
 }

 @Override
 public Stumps createStumps() {
     return new SGStumps();
 }
}

class KookaburraCricketFactory implements CricketFactory {
 @Override
 public Bat createBat() {
     return new KookaburraBat();
 }

 @Override
 public Ball createBall() {
     return new KookaburraBall();
 }

 @Override
 public Stumps createStumps() {
     return new KookaburraStumps();
 }
}

//Client
public class AbstractFactoryMethod {
 private CricketFactory cricketFactory;

 public AbstractFactoryMethod(CricketFactory cricketFactory) {
     this.cricketFactory = cricketFactory;
 }

 public void playCricket() {
     Bat bat = cricketFactory.createBat();
     Ball ball = cricketFactory.createBall();
     Stumps stumps = cricketFactory.createStumps();

     bat.hit();
     ball.bowl();
     stumps.set();
 }

 public static void main(String[] args) {
     // Cricket player with SG Cricket Equipment
     AbstractFactoryMethod sgPlayer = new AbstractFactoryMethod(new SGCricketFactory());
     sgPlayer.playCricket();

     // Cricket player with Kookaburra Cricket Equipment
     AbstractFactoryMethod kookaburraPlayer = new AbstractFactoryMethod(new KookaburraCricketFactory());
     kookaburraPlayer.playCricket();
 }
}

