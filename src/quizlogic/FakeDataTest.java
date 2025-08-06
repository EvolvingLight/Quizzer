package quizlogic;

import java.io.Serializable;

public class FakeDataTest implements Serializable {
	
	protected static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		FakeDataDeliverer fdd = new FakeDataDeliverer();

		for (Thema th : fdd.themes) {
			System.out.println(th.toString());
		}
	}

}
