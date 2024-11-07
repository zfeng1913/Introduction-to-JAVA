public abstract class Pet{
  private String name;
  private double health;
  private int painLevel;

  // constructor

  public Pet(String name1, double health1, int painLevel1) {
    this.name = name1;

    if (health1 > 1){
      this.health = 1.0;
    }else if (health1 < 0){
      this.health = 0;
    }else{
      this.health = health1;
    }

    if (painLevel1 > 10){
      this.painLevel = 10;
    }else if (painLevel1 < 0){
      this.painLevel = 0;
    }else{
      this.painLevel = painLevel1;
    }
  }

  // getter
  public String getName(){
    return this.name;
  }
  public double getHealth(){
    return this.health;
  }
  public int getPainLevel(){
    return this.painLevel;
  }

  public abstract int treat();

  public void speak(){
    String output = String.format("Hello! My name is %s", this.name);
    output = (painLevel > 5) ? output.toUpperCase(): output;
    System.out.println(output);

  }
  public boolean equals(Object o){
    if (o instanceof Pet){
      Pet p = (Pet)o;
      return this.name.equals(p.name);
    }
    return false;
  }

  protected void heal(){
    this.health = 1.0;
    this.painLevel = 1;
  }




}
