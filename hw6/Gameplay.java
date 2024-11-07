import java.util.Arrays;

public class Gameplay {
	public static void main(String[] args) {

		BlueAstronaut Bob = new BlueAstronaut("Bob", 20, 6, 30);
		BlueAstronaut Heath = new BlueAstronaut("Heath", 30, 3 , 21);
		BlueAstronaut Albert = new BlueAstronaut("Albert", 44, 2, 0);
		BlueAstronaut Angel = new BlueAstronaut("Angel", 0, 1, 0);

		RedAstronaut Liam = new RedAstronaut("Liam", 19, "experienced");
		RedAstronaut SP = new RedAstronaut("Suspicious Person", 100, "expert");


		Liam.sabotage(Bob);
		System.out.println(Bob);

		Liam.freeze(SP);
		System.out.println(SP);

		Liam.freeze(Albert);
		System.out.println(Liam);
		System.out.println(Albert);

		SP.emergencyMeeting();

		Bob.emergencyMeeting();
		System.out.println(SP);

		//TODO - Test Case # 7
	}
}
