public class Frog{
  // instance variable
  private String name;
  private int age;
  private double tongueSpeed;
  private boolean isFroglet;
  private static String species = "Rare Pepe";


  public static final int defaultage = 5;
  public static final double defaulttonguespeed = 5.0;

  // constructor
  public Frog(String initname){
    this(initname, defaultage, defaulttonguespeed);
  }
  public Frog(String initname, double initageyear, double inittongueSpeed){
    this(initname, (int)initageyear * 12, inittongueSpeed);
  }
  public Frog(String initname, int initage, double inittongueSpeed){
    this.name = initname;
    this.age = initage;
    this.tongueSpeed = inittongueSpeed;
    this.isFroglet = (this.age > 1 && this.age < 7);
  }
  public void grow(int month){
    for (int i=1; i<=month; i++){
      this.age += 1;
      if (this.age <= 12){
        this.tongueSpeed += 1;
      }
      else if (this.age > 30){
        this.tongueSpeed -= 1;
      }
    }

    if (this.tongueSpeed < 5){
      this.tongueSpeed = 5;
    }

    this.isFroglet = (this.age > 1 && this.age < 7);

  }

  public void grow(){
    grow(1);
  }

  public void eat(Fly fly){
    if (!fly.isDead()){
      if (this.tongueSpeed > fly.getSpeed()){
        if (fly.getMass() >= 0.5*this.age){
          grow();}
        else{fly.setMass(0);}}
      else{
        fly.grow(1);}
    }
  }



  public String toString(){
    if (this.isFroglet){
      return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
    }
    else{
      return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
    }
  }

  public static String getSpecies(){
    return species;
  }
  public static void setSpecies(String new_species){
    species = new_species;
  }


}
