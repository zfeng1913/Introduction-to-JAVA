import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //read keyboard input
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        String operator = input.next();
        switch (operator.toLowerCase()) {

          case "add":
            System.out.println("Enter two integers:");
            try {
              int a = input.nextInt();
              int b = input.nextInt();
              System.out.println("Answer: " + (a + b));
            }
            catch (Exception e){
              System.out.println("Invalid input entered. Terminating...");
            }

            break;


            case "subtract":
              System.out.println("Enter two integers:");
              try {
                int c = input.nextInt();
                int d = input.nextInt();
                System.out.println("Answer: " + (c - d));
              }
              catch (Exception e){
                System.out.println("Invalid input entered. Terminating...");
              }

              break;


            case "multiply":
              System.out.println("Enter two doubles:");
              try {
                double e = input.nextDouble();
                double f = input.nextDouble();
                System.out.println("Answer: " + String.format("%.2f", e*f));
              }
              catch (Exception e){
                System.out.println("Invalid input entered. Terminating...");
              }

              break;


            case "divide":
              System.out.println("Enter two doubles:");
              try {
                double g = input.nextDouble();
                double h = input.nextDouble();
                if (h == 0.00){
                  System.out.println("Invalid input entered. Terminating...");
                  break;
                }else{
                  System.out.println("Answer: " + String.format("%.2f", g/h));
                }

              }
              catch (Exception e){
                System.out.println("Invalid input entered. Terminating...");
              }

              break;


            case "alphabetize":
              System.out.println("Enter two words:");
              String i = input.next();
              String j = input.next();
              // System.out.println(i + " " + j);
              int res = i.toLowerCase().compareTo(j.toLowerCase());
              if (res > 0){
                System.out.println("Answer: " + j + " comes before " + i + " alphabetically.");
              }else if (res < 0){
                System.out.println("Answer: " + i + " comes before " + j + " alphabetically.");
              }
              else{
                System.out.println("Answer: Chicken or Egg.");
              }
              break;



            default:
              System.out.println("Invalid input entered. Terminating...");
              break;

          }
    }
}
