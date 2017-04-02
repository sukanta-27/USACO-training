/*
ID: sukanta1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2 {
  public static void main (String [] args) throws IOException {					  
	Scanner in = new Scanner(new File("milk2.in"));
	BufferedWriter out = new BufferedWriter(new FileWriter("milk2.out"));
	int n = in.nextInt();
	M[] se = new M[n];
	int[] start = new int[n];
	for(int i = 0;i<n;i++){
		se[i] = new M();
		se[i].s = in.nextInt();
		start[i] = se[i].s;
		se[i].e = in.nextInt();
	}
	Arrays.sort(start);
	int milk = 0,noMilk = 0;

	
	int[] o = new int[n];
	for(int i = 0;i<n;i++){
		int x = find(start[i],se);
		o[i]=x;
	}

	//For No milking 
	int t = se[o[0]].e; //t for tail = ending time
	for(int i = 1;i<n;i++){
		int temp = 0;
		if(se[o[i]].s <= t){
			t = Math.max(se[o[i]].e,t);
		}
		else{
			temp = se[o[i]].s-t;
			//System.out.println(t+"\t"+se[o[i]].s+"\t"+temp);
			t = se[o[i]].e;
		}
		if(noMilk < temp){
			noMilk = temp;
		}
	}
	
	
	//For Milking
	int h1 = se[o[0]].s, t1 = se[o[0]].e;
	for(int i=0;i<n;i++){
		int temp = 0;
		if(se[o[i]].s <= t1){
			t1 = Math.max(se[o[i]].e, t1);
			h1 = Math.min(se[o[i]].s, h1);
		}
		else{
			h1 = se[o[i]].s;
			t1 = se[o[i]].e;
		}
		temp = t1 - h1;
		if(milk < temp){
			milk = temp;
		}
		
		
	}
	
	out.write(milk+" "+noMilk+"\n");
    out.close();                                  // close the output file
  }
  
  static int find(int start, M[] se){
	for(int i = 0;i<se.length;i++){
		if(se[i].s == start){
			return i;
		}
	}
	return -1;
  }
}


class M{
	int s;
	int e;
}