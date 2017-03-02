/*
ID: sukanta1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
  public static void main (String [] args) throws IOException {
    Scanner in = new Scanner(new File("friday.in"));
	PrintWriter out = new PrintWriter(new FileWriter("friday.out", true),true);
	int year = 1900;
	int n = in.nextInt();
	String day = "Monday";
	//String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    int[] re = {0,0,0,0,0,0,0};
	int index = 1;	
	//Map<String , Integer> map = new HashMap<String,Integer>();
	int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
	for(int i = year;i<year+n;i++){
		//out.println(i);
		if(isLeapYear(i)){
			months[1] = 29;
		}
		else{
			months[1] = 28;
		}
		for(int j = 0;j<12;j++){
			//out.println(index%7+"\t");
			//out.println(days[index]);
			int day13th = ((index%7 + (13%7)))%7;
			//out.println(day13th);
			re[day13th]++;
			index += ((months[j]%7));
		}

	}
	String output = "";
	for(int i = 0;i< 7;i++){
		output += (re[i]+" ");
	}
	out.println(output.trim());
    out.close();// close the output file
  }
  
  public static boolean isLeapYear(int x){
	  boolean check = false;
	  if(x%400 == 0){
		  check = true; 
	  }
	  else if((x%4==0) && (x%100 != 0)){
		  check = true;
	  }
	return check;
  }
}