// Adapted from Java Software Solutions by Lewis/Loftus/Cocking

// Demonstrates the useof Abstract Classes

// Instantiates objects of type pet and prints information
public class Pets
{
  public static void main(String Args[])
  {
    Dog fido =new Dog ("Fido", 45);
    Snake sam = new Snake("Sam", 6);
    Cat rosie = new Cat("Rosie", 12);
    
    System.out.println(fido);
    System.out.println(fido.getName() + " " + "says " + fido.speak());
    System.out.println(fido.move() + " " + fido.getName() + " " + fido.move());
    System.out.println();
    
    System.out.println(sam);
    System.out.println(sam.getName() + " " + "says " + sam.speak());
    System.out.println(sam.move() + " " + sam.getName() + " " + sam.move());
    System.out.println();

    System.out.println(rosie);
    System.out.println(rosie.getName() + " " + "says " + rosie.speak());
    System.out.println(rosie.move() + " " + rosie.getName() + " " + rosie.move());
    System.out.println();
    
    Chihuahua pero  = new Chihuahua ("El Guapo", 2);
    pero.setPlace("Ciudad Juarez");
    System.out.println(pero + " from " + pero.cityOfOrigin());
    System.out.println(pero.getName() + " " + "says " + pero.speak());
    System.out.println(pero.move() + " " + pero.getName() + " " + pero.move());
    System.out.println();
    
    KingCobra cobra = new KingCobra("Venetious", 4);
    cobra.setColor("gold with red spots.");
    System.out.println(cobra + " and is " + cobra.getColor());
    System.out.println(cobra.getName() + " " + "says " + cobra.speak());
    System.out.println(cobra.move() + " " + cobra.getName() + " " + cobra.move());
    System.out.println();
    
    Schnauzer mackie = new Schnauzer("Mackie", 12);
    mackie.setPlace("Dusseldorf");
    System.out.println(mackie + " from " + mackie.cityOfOrigin());
    System.out.println(mackie.getName() + " " + "says " + mackie.speak());
    System.out.println(mackie.move() + " " + mackie.getName() + " " + mackie.move());
    System.out.println();
    
    Parrot parrot = new Parrot("Polly", 12, "red and green");
    System.out.println(parrot + " and is " + parrot.getColor());
    System.out.println(parrot.getName() + " " + "says " + parrot.speak());
    System.out.println(parrot.move() + " " + parrot.getName() + " " + parrot.move());
    System.out.println();
    
    Parakeet parakeet = new Parakeet("Twitter", 12, "cerulean");
    System.out.println(parakeet + " and is " + parakeet.getColor());
    System.out.println(parakeet.getName() + " " + "says " + parakeet.speak());
    System.out.println(parakeet.move() + " " + parakeet.getName() + " " + parakeet.move());
    System.out.println();
    
    MaineCoon ashtar = new MaineCoon("Ashtar", 13, "fuzzy");
    System.out.println(ashtar);
    System.out.println(ashtar.getName() + " " + "says " + ashtar.speak());
    System.out.println(ashtar.move() + " " + ashtar.getName() + " " + ashtar.move());
    System.out.println();
    
    BlackCat minnie = new BlackCat("Minnie", 12, "sleek");
    System.out.println(minnie);
    System.out.println(minnie.getName() + " " + "says " + minnie.speak());
    System.out.println(minnie.move() + " " + minnie.getName() + " " + minnie.move());
    System.out.println();
    
  }
}
    
     
   
