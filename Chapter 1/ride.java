/*
ID: sukanta1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
  public static void main (String [] args) throws IOException {
    Scanner in = new Scanner(new File("ride.in"));
	PrintWriter out = new PrintWriter(new FileWriter("ride.out", true),true);
	String comet = in.nextLine();
	String group = in.nextLine();
	char[] a = comet.toCharArray();
	char[] b = group.toCharArray();
	int ap = 1;
	int bp = 1;
	char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	for(int i = 0;i<a.length;i++){
		for(int j = 0;j<alphabet.length;j++){
			if(a[i] == alphabet[j]){
				ap *= j+1;
			}
			
		}
	}
	for(int i = 0;i<b.length;i++){
		for(int j = 0;j<alphabet.length;j++){
			if(b[i] == alphabet[j]){
				bp *= j+1;
			}
			
		}
	}
	if((ap%47) == (bp%47)){
		out.println("GO");
	}
	else{
		out.println("STAY");
	}
    out.close();// close the output file
  }
}
