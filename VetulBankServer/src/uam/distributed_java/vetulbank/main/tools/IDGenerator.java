package uam.distributed_java.vetulbank.main.tools;

import java.util.Random;

public class IDGenerator {

	private static int ID_LENGTH = 16;
	
	public static String generateID() {
		StringBuilder builder = new StringBuilder();
		Random rand = new Random();
		for(int i = 0; i < ID_LENGTH; i++)
			builder.append(rand.nextInt(10));
		return builder.toString();
	}
	
}
