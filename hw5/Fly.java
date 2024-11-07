public class Fly{
  // instance variable
  private double mass;
  private double speed;
  public static final double Default_speed = 10;
  public static final double Default_mass = 5;


  // constructor
  public Fly(){
    this(Default_mass, Default_speed);
  }
  public Fly(double initmass){
    this(initmass, Default_speed);
  }
  public Fly(double initmass, double initspeed){
    this.mass = initmass;
    this.speed = initspeed;
  }



  // methods
  public double getMass(){
    return mass;
  }
  public void setMass(double new_mass){
    // if (isLegalmass(new_mass)){
      this.mass = new_mass;
    }
  public double getSpeed(){
    return speed;
  }
  public void setSpeed(double new_speed){
    // if (isLegalspeed(new_speed)){
    this.speed = new_speed;
  }

  public void grow(int added_mass){
    if (this.mass > 20){
      this.speed = this.speed - added_mass * 0.5;
    }else{
      if (this.mass + added_mass <= 20){
        this.speed = this.speed + added_mass;
      }else{
        double increase = 20 - this.mass;
        double decrease = this.mass + added_mass - 20;
        this.speed  = this.speed + increase - 0.5 * decrease;
      }
    }
    this.mass = this.mass + added_mass;
  }

  public boolean isDead(){
    return (this.mass == 0);
  }

  public String toString(){
    if (this.mass == 0){
      return String.format("I’m dead, but I used to be a fly with a speed of %.2f .", this.speed);
    }
    else{
      return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", this.speed, this.mass);
    }

  }

  // public static void main(String[] args){
  //   Fly fly1 = new Fly();
  //   Fly fly2 = new Fly(3);
  //   Fly fly3 = new Fly(4, 5);
  //   System.out.println(fly3.isDead());
  //   fly3.grow(17.0);
  //   System.out.println(fly3.getspeed());




  // }
}
