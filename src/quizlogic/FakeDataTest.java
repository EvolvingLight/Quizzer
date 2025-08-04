package quizlogic;

public class FakeDataTest {

	public static void main(String[] args) {

		FakeDataDeliverer fdd = new FakeDataDeliverer();

		for (Thema th : fdd.themes) {
			System.out.println(th.toString());
		}
	}

}
