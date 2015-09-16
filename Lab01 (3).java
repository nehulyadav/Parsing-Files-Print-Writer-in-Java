import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

/*
  * Assignment: CSE-Lab-01 – reading, processing, and exporting
  *    file data
  * Author: sargenss and yadavn
  * Date: 8/28/2015
  */
public class Lab01 {

	public static void main(String[] args) throws Exception {
		String fileName = "TestRecords1.txt";
		String fileName2 = "TestRecords2.txt";
		
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> data2 = new ArrayList<String>();
		
		int numpeople = 0;
		try { Scanner file = new Scanner(new File(fileName));

			
			while(file.hasNextLine()) {
				data.add(file.nextLine());
				numpeople++;
			}
			
		}
		
		catch (Exception e)
		{System.out.println(e);
		}
		
		
		
		
		int numpeople2 = 0;
		try { Scanner file = new Scanner(new File(fileName2));

		
			while(file.hasNextLine()) {
				data2.add(file.nextLine());
				numpeople2++;
			}
		
		}
		
		catch (Exception e)
		{System.out.println(e);
		}
	
		numpeople2 = numpeople2/8;
		
		
		//ArrayLists for TestRecords1 data
		
		ArrayList<String> email = new ArrayList<String>();
		ArrayList<String> phonenums = new ArrayList<String>();
		ArrayList<String> ohio = new ArrayList<String>();
		ArrayList<String> lastname = new ArrayList<String>();
		ArrayList<String> id = new ArrayList<String>();
		
		
		//ArrayLists for TestRecords2 data
		
		ArrayList<String> email2 = new ArrayList<String>();
		ArrayList<String> phonenums2 = new ArrayList<String>();
		ArrayList<String> ohio2 = new ArrayList<String>();
		ArrayList<String> lastname2 = new ArrayList<String>();
		ArrayList<String> id2 = new ArrayList<String>();
		
		for(int i = 0; i < data.size(); i++) {
			
			String sorted[] = data.get(i).split("\\|");
			id.add(sorted[0]);
			lastname.add(sorted[2]);
			phonenums.add(sorted[6]);
			ohio.add(sorted[4]);
			email.add(sorted[7]);
			
			
		}
		
		for(int i = 0; i < data2.size(); i += 8) {
				id2.add(data2.get(i));
				lastname2.add(data2.get(i + 2));
				phonenums2.add(data2.get(i + 6));
				ohio2.add(data2.get(i + 4));
				email2.add(data2.get(i + 7));
				
		}
		
		//Test Record 1 assignment specification sorting using 'for' loop
		
		int educount = 0;
		int phonecount = 0;
		int ohiocount = 0;
		int johncount = 0;
		
		for(int j= 0; j < data.size(); j++) {
			if(email.get(j).contains(".edu")) {
				educount++;
				
			}
			if(phonenums.get(j).startsWith("(513)")) {
				phonecount++;
			}
			if(ohio.get(j).equals("OH")) {
				ohiocount++;
			}
			if(lastname.get(j).equals("John")) {
				johncount++;
			}
			
		}
		
		int namelength = 0;
		int max = 0;
		int nameindex = 0;
		
		for(int l = 0; l < lastname.size(); l++) {
			
			namelength = lastname.get(l).length();
			if(namelength > max) {
				max = namelength;
				nameindex = l;
			}
			
		}
	
	//Test Record 2 assignment specification sorting using 'for' loop

		int educount2 = 0;
		int phonecount2 = 0;
		int ohiocount2 = 0;
		int johncount2 = 0;
		
		for(int j= 0; j < data.size(); j++) {
			if(email2.get(j).contains(".edu")) {
				educount2++;
				
			}
			if(phonenums2.get(j).startsWith("(513)")) {
				phonecount2++;
			}
			if(ohio2.get(j).equals("OH")) {
				ohiocount2++;
			}
			if(lastname2.get(j).equals("John")) {
				johncount2++;
			}
			
		}
		
		int namelength2 = 0;
		int max2 = 0;
		int nameindex2 = 0;
		
		for(int l = 0; l < lastname2.size(); l++) {
			
			namelength2 = lastname2.get(l).length();
			if(namelength2 > max2) {
				max2 = namelength2;
				nameindex2 = l;
			}
			
		}
		
		
		//nameindex points to the id of the person with the 'longest last name'
		
		//try & catch have been taken care of in the code to catch the exception
		
		PrintWriter printWriter = new PrintWriter ("Lab-01-Summary.txt");
		printWriter.println("numpeople:" + numpeople);
		printWriter.println("educount:"  + educount);
		printWriter.println("phonecount:"+ phonecount);
		printWriter.println("ohiocount:" + ohiocount);
		printWriter.println("johncount:" + johncount);
		printWriter.println(id.get(nameindex));
		printWriter.println("");
		
		printWriter.println("numpeople2:" + numpeople2);
		printWriter.println("educount2:"  + educount2);
		printWriter.println("phonecount2:"+ phonecount2);
		printWriter.println("ohiocount2:" + ohiocount2);
		printWriter.println("johncount2:" + johncount2);
		printWriter.println(id.get(nameindex2));
		
		
		printWriter.close();
	}
	
}
