package JavaBasics;

public class ArrayConcepts {

	String[] userDetails = new String[5]; // 0,1,2,3,4
	String[] aryStrings = { "Autumn", "Spring", "Summer", "Winter" };

	public void EnhancedForLoop() {

		userDetails[0] = "485";
		userDetails[1] = "Prakashpandian Rajaram";
		userDetails[2] = "Testing Executive";
		userDetails[3] = "Msc Technology India Pvt Ltd";
		userDetails[4] = "Ambattur";

		System.out.println("Enhanced For Loop :");
		int i = 0;
		for (String details : userDetails) {
			System.out.println(details + " - " + (i + 1));
			i++;
		}
		System.out.println();

		System.out.println("Enhanced For Loop :");
		int j = 0;
		for (String arydetails : aryStrings) {
			System.out.println(arydetails + " - " + (j + 1));
			j++;
		}
		System.out.println();
	}

	public void NormalForLoop() {

		userDetails[0] = "485";
		userDetails[1] = "Prakashpandian Rajaram";
		userDetails[2] = "Testing Executive";
		userDetails[3] = "Msc Technology India Pvt Ltd";
		userDetails[4] = "Ambattur";

		System.out.println("Normal For Loop :");
		for (int i = 0; i < userDetails.length; i++) {
			System.out.println(userDetails[i] + " - " + (i + 1));
		}
		System.out.println();

		System.out.println("hashCode : " + userDetails.hashCode());
	}

	public static void main(String[] args) {

		ArrayConcepts arrayConcepts = new ArrayConcepts();
		arrayConcepts.EnhancedForLoop();
		arrayConcepts.NormalForLoop();
	}
}
