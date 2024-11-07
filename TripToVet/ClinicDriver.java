import java.io.FileNotFoundException;

/**
 * Driver class to demonstrate a Clinic treating various patients
 */
public class ClinicDriver {

    public static void main(String[] args) {
        Clinic clinic = new Clinic("Patients.csv");
        String dayOneReport = "";
        try {
            dayOneReport = clinic.nextDay("Appointments.csv");
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        String[] dayOneAppointments = dayOneReport.split("\\n");
        for (String appointment : dayOneAppointments) {
            if (!clinic.addToFile(appointment)) {
                System.out.println("Appointment could not be added to file!");
            }
        }
    // for appointement2.csv
        String dayTwoReport = "";
        try{
          dayTwoReport = clinic.nextDay("Appointment2.csv");
        }catch (FileNotFoundException fne){
          System.out.println(fne.getMessage());

        }catch(InvalidPetException ipe){
          System.out.println(ipe.getMessage());
        }
        String[] dayTwoAppointments = dayTwoReport.split("\\n");
        for (String appointment : dayTwoAppointments){
          if (!clinic.addToFile(appointment)){
            System.out.println("Appointment could not be added to file");
          }
        }
    }
}
