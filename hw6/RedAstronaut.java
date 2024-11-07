import java.util.Arrays;


public class RedAstronaut extends Player implements Impostor{

  protected String skill;

  public static final int Default_suslevel = 15;
  public static final String Default_skill = "experienced";
  // constructor
  public RedAstronaut(String name){
    this(name, Default_suslevel, Default_skill);
  }
  public RedAstronaut(String name, int susLevel, String skill){
    super(name, susLevel);
    this.skill = skill;
  }

  // getter and setter
  public String getSkill() {
      return this.skill;
  }
  public void SetSkill(String skill) {
      this.skill = skill;
  }

  // Method
  @Override
  public void emergencyMeeting(){
    if (this.isFrozen()) {
			System.out.println("Calling player is frozen");
			return;
		}
    int LENGTH = 0;

		for (int i = 0; i < this.getPlayers().length; i++) {
			if (!(this.getPlayers()[i].isFrozen())&& (!(this.getPlayers()[i].equals(this)))) {
				LENGTH += 1;
			}
		}
    if (LENGTH == 0) {
			System.out.println("All other players are frozen");
			return;
		}

		Player[] temp = new Player[LENGTH];

		//Move all unfrozen Players from original array to new temporary array
		int count = 0;
		for (int i = 0; i < this.getPlayers().length; i++) {
			if (!(this.getPlayers()[i].isFrozen()) && (!(this.getPlayers()[i].equals(this)))) {
				temp[count] = this.getPlayers()[i];
				count += 1;
			}
		}

		//Sort temp[] array so that the first array object is the Player with the greatest susLevel
		Arrays.sort(temp);

		if (temp[0].getSusLevel() == temp[1].getSusLevel()) {
			System.out.println("First two players have same sus level");
			return;
		}

		for (int i = 0; i < this.getPlayers().length; i++) {
			if (this.getPlayers()[i].equals(temp[0])) {
				this.getPlayers()[i].setFrozen(true);
			}
		}

		this.gameOver();

  }

  public boolean equals(Object o){
    if (o instanceof RedAstronaut) {
        RedAstronaut p = (RedAstronaut) o;
        return this.getName().equals(p.getName()) && this.isFrozen() == p.isFrozen()
                && this.getSusLevel() == p.getSusLevel() && this.getSkill() == p.getSkill();
    }
    return false;
  }
  public void freeze(Player p){
    if (this.isFrozen() || p.isFrozen() || p instanceof RedAstronaut){
      return;
    }
    if (this.getSusLevel() < p.getSusLevel()){
      p.setFrozen(true);
    }else{
      this.setSusLevel(this.getSusLevel() * 2);
    }
    this.gameOver();
  }

  public void sabotage(Player p){
    if (p instanceof Imposter || this.isFrozen() || p.isFrozen()){
      return;
    }
    if (p.getSusLevel()<20){
      p.setSusLevel((int)(1.5 * p.getSusLevel()));
    }else{
      p.setSusLevel((int)(1.25 * p.getSusLevel()));
    }
  }

  @Override
  public String toString(){
      String frozenString = super.toString() + String.format(
      "I am an %s player!", this.skill);
      if (this.getSusLevel() > 15){
        return frozenString.toUpperCase();
      }
      return frozenString;
  }
}
