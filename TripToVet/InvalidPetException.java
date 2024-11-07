public class InvalidPetException extends RuntimeException {

    // constructor
    public InvalidPetException() {
      super("Your pet is invalid!");
    }

    public InvalidPetException(String s) {
      super(s);
    }
}
