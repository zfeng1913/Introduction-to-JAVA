public class Dog extends Pet{
  double droolRate;
  // constructor

  public Dog(String name, double health, int painLevel, double droolRate){
    super(name, health, painLevel);
    this.droolRate = (droolRate<=0) ? 0.5 : droolRate;
  }
  public Dog(String name, double health, int painLevel){
    this(name, health, painLevel, 5.0);
  }

  // getter

  public double getDroolRate(){
    return this.droolRate;
  }

  public int treat(){
    int treattime;

    if (droolRate < 3.5){
      treattime = (int)Math.ceil((getPainLevel() * 2)/getHealth());
    }else if (this.droolRate <=7.5){
      treattime = (int)Math.ceil(getPainLevel()/getHealth());
    }else{
      treattime = (int)Math.ceil(getPainLevel()/(2 * getHealth()));
    }
    heal();
    return treattime;
  }

  public void speak(){
    super.speak();
    String sound = (getPainLevel() > 5) ? "BARK " : "bark ";
    String output = "";
    for (int i = 1; i<getPainLevel(); i++){
      output = output + sound;
    }
    System.out.println(output.trim());
  }

  public boolean equals(Object o){
    if (o instanceof Dog){
      Dog p = (Dog)o;
      return super.equals(p) && this.droolRate == (p.getDroolRate());
    }
    return false;
  }
}
