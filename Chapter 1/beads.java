/*
ID: sukanta1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {
  public static void main (String [] args) throws IOException {
    Scanner in = new Scanner(new File("beads.in"));
	PrintWriter out = new PrintWriter(new FileWriter("beads.out", true),true);

	int n = in.nextInt();
	String input = in.next();

	int result = 0;
	int l = 0,r = 0;
	for(int i = 0;i<input.length();i++){
		 l = left(input, i);
		 r = right(input,i);
		
		if(l >= input.length()){
			result = input.length();
		}
		else if(r >= input.length()){
			result = input.length();
		}
		else{
			int beads = l + r;
			if(beads > result){
				result = beads;
			}
		}
	}
	out.println((result < input.length() ? result : input.length()));
	//System.out.println(result);
    out.close();// close the output file
  }
  
  static int left(String s,int i){
	int j = i;
	int count = 0;
	char c = s.charAt(i);
	for(;j>=0;j--){
		if(c == 'w'){
			c = s.charAt(j);
			count++;
		}
		else if(s.charAt(j)==c || s.charAt(j) == 'w'){
			count++;
		}
		else{
			break;
		}
	}
	if(j < 0){
		j = s.length()-1;
	}
	for(;j>i;j--){
		if(c == 'w'){
			c = s.charAt(j);
			count++;
		}
		else if(s.charAt(j)==c || s.charAt(j) == 'w'){
			count++;
		}
		else{
			break;
		}
	}
	return count;
  }
  
  static int right(String s,int i){
	int j = i;
	
	if(i == s.length() -1 ){
		j = 0;
		
	}
	else{
		j = i+1;
	}
	char c = s.charAt(j);
	int count = 0;
	for(;j<s.length();j++){
		if(c == 'w'){
			count++;
			c = s.charAt(j);
		}
		else if(s.charAt(j) == c || s.charAt(j) == 'w'){
			count++;
		}
		else{
			break;
		}
		
	}
	
	if(j==s.length()){
		j = 0;
	}
	for(;j< i-1;j++){
		if(c == 'w'){
			count++;
			c = s.charAt(j);
		}
		else if(s.charAt(j) == c || s.charAt(j) == 'w'){
			count++;
		}
		else{
			break;
		}
	}
	return count;
  }
}