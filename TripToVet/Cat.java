public class Cat extends Pet{
  int miceCaught;

  // constructor

  public Cat(String name, double health, int painLevel, int miceCaught){
    super(name, health, painLevel);
    this.miceCaught  = (miceCaught<0) ? 0 : miceCaught;

  }
  public Cat(String name, double health, int painLevel){
    this(name, health, painLevel, 0);
  }
  // getter
  public double getMiceCaught(){
    return this.miceCaught;
  }

  public int treat(){

    int treattime;
    if (miceCaught< 4){
      treattime = (int)Math.ceil((getPainLevel() * 2)/getHealth());
    }else if (miceCaught <= 7){
      treattime = (int)Math.ceil(getPainLevel()/getHealth());
    }else{
      treattime = (int)Math.ceil(getPainLevel()/(2 * getHealth()));
    }
    heal();
    return treattime;
  }
  public void speak(){
    super.speak();
    String output = "";
    String sound = (getPainLevel() > 5) ? "MEOW ":"meow ";
    for (int i = 1; i<miceCaught; i++){
      output = output + sound;
    }
    System.out.println(output.trim());
  }
  public boolean equals(Object o){
    if (o instanceof Cat){
      Cat p = (Cat)o;
      return super.equals(p) && this.miceCaught == (p.getMiceCaught());
    }
    return false;
  }

  }
