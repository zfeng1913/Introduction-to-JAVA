import java.util.Arrays;
public class BlueAstronaut extends Player implements Crewmate{
  private int numTasks;
  private int taskSpeed;
  public static final int Default_suslevel = 15;
  public static final int Default_numTask = 6;
  public static final int Default_taskSpeed = 10;

  public BlueAstronaut(String name){
    this(name, Default_suslevel, Default_numTask, Default_taskSpeed);
  }
  public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed){
    super(name, susLevel);
    this.numTasks = numTasks;
    if (taskSpeed >= 0) {
			this.taskSpeed = taskSpeed;
		}
		else {
			this.taskSpeed = 10;
		}
  }

  public void completeTask(){
    if (this.isFrozen()){
      return;
    }
    if (this.taskSpeed > 20){
      this.numTasks -= 2;

    }else{
      this.numTasks -= 1;
    }
    if (this.numTasks <= 0){
      this.numTasks = 0;
      System.out.println("I have completed all my tasks");
      this.setSusLevel((int)(this.getSusLevel() * 0.5));
    }

  }



  public boolean equals(Object o){
    if (o instanceof BlueAstronaut) {
        BlueAstronaut p = (BlueAstronaut) o;
        return this.getName().equals(p.getName()) && this.isFrozen() == p.isFrozen()
                && this.getSusLevel() == p.getSusLevel() && this.numTasks == p.numTasks
                && this.taskSpeed == p.taskSpeed;
    }
    return false;
  }

  @Override
  public String toString(){
      String frozenString = super.toString() + String.format(
      "I have %s left over", this.numTasks);
      if (this.getSusLevel() > 15){
        return frozenString.toUpperCase();
      }
      return frozenString;
  }

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




}
