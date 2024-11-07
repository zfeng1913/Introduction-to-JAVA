import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.InputMismatchException;

public class Clinic {
  File patientFile;
  int day;

  // constructor
  public Clinic(File patientFile){
    patientFile = patientFile;
    day=1;
  }
  public Clinic(String fileName) {
		this(new File(fileName));
	}
  public boolean addToFile(String info){
    Scanner filescan = null;
    String[] tokens = null;
    PrintWriter fileprint = null;
    String stringoutput = "";
    try{
      filescan = new Scanner(patientFile);
      boolean new_patient = true;
      tokens = info.split(",");
      String name = tokens[0];
      while (filescan.hasNextLine()){
        String line = filescan.nextLine();
        if (line.startsWith(name)){
          new_patient = false;
          int currDelim = info.indexOf(",");
          for (int i = 2; i < 3; i++){
            int nextDelim = info.indexOf(",", currDelim + 1);
            currDelim = nextDelim;
          }
          line += info.substring(currDelim);
        }
        stringoutput += (line + "\n");
      }

      if (new_patient){
        stringoutput += info;
      }
      filescan.close();
      fileprint = new PrintWriter(patientFile);
      fileprint.print(stringoutput);
      return true;
    } catch(Exception e){
      return false;
    }finally{
      if (filescan != null){
        filescan.close();
      }
      if (fileprint != null){
        fileprint.close();
      }
    }
  }
  private static String addTime(String timeIn, int treatTime){
    int hours;
    int minites;
    hours = (int)(treatTime / 60);
    minites = (int)(treatTime - hours * 60);
    int original_hour = Integer.parseInt(timeIn.substring(0, 2));
    int original_minite = Integer.parseInt(timeIn.substring(2));
    int new_hour = original_hour + hours;
    int new_minute = original_minite + minites;
    String output = "";
    output += (new_hour< 10)?"0"+new_hour : new_hour;
    output += (new_minute< 10)?"0"+new_minute : new_minute;
    return output;

  }
  public String nextDay(String filename) throws FileNotFoundException {
    return nextDay(new File(filename));
  }
  public String nextDay(File f) throws FileNotFoundException {
    day++;
    String output = "";
    Scanner fileScan = new Scanner(f);
    Scanner input  = new Scanner(System.in);
    String line = null;
    while (fileScan.hasNextLine()){
      line=fileScan.nextLine();
      String[] pInfo = line.split(",");
      String name = pInfo[0];
      String species = pInfo[1];
      String stat = pInfo[2];
      String timeIn = pInfo[3];

      if (!(species.equals("Dog")||species.equals("Cat"))){
        throw new InvalidPetException();
      }
      System.out.printf("Consultation for %s the %s at %s.\n", name, species, timeIn);
      double health = 0;
      int painLevel = 0;
      boolean validhealth = false;
      boolean validpain = false;
      while (!validhealth){
        System.out.printf("Waht is the health of %s?\n", name);
        if (input.hasNextDouble()){
          health = input.nextDouble();
          validhealth = true;
        }else{
          input.nextLine();
          System.out.println("Please enter a number");
        }
      }

      while (!validpain){
        System.out.printf("On a scale of 1 to 10, how much pain is %s " + "in right now?\n", name);
        if (input.hasNextInt()){
          health = input.nextInt();
          validpain = true;
        }else{
          input.nextLine();
          System.out.println("Please enter a number");
        }
      }
      Pet petPatient;
      switch (species){
        case "Dog":
          petPatient = new Dog(name, health, painLevel, Double.parseDouble(stat));
          break;
        case "Cat":
          petPatient = new Cat(name, health, painLevel, Integer.parseInt(stat));
          break;
        default:
        throw new InvalidPetException();
      }
      health = petPatient.getHealth();
      painLevel = petPatient.getPainLevel();
      petPatient.speak();
      int treatmenttime = petPatient.treat();
      String timeout = addTime(timeIn, treatmenttime);
      output += String.format("%s, %s, %s, Day %d, %s, %s, %s, %d\n", name, species, stat, day, timeIn, timeout, String.valueOf(health), painLevel);

    }
    fileScan.close();
    input.close();
    return output.trim();
  }

}
