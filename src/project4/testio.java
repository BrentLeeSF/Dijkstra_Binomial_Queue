package project4;

import java.io.*;


class testio {

	public static void main(String args[]) {

		BufferedReader input;
		String nextLine;
		int intvalue;

		try {
			
			input = new BufferedReader(new FileReader(args[0]));
			nextLine = input.readLine();
			
			while (nextLine.compareTo(".") != 0) {
				
				System.out.println(nextLine);
				nextLine = input.readLine();
			}
			
			System.out.println(".");
			nextLine = input.readLine();
			
			while (nextLine != null) {
				
				System.out.println(nextLine);
				nextLine = input.readLine();
				System.out.println(nextLine);
				nextLine = input.readLine();
				intvalue = Integer.valueOf(nextLine).intValue();
				System.out.println(Integer.toString(intvalue));
				nextLine = input.readLine();
				
			}
			
		} catch (IOException e) {
			System.out.println("File Error");
		}
		
	}
	
}


