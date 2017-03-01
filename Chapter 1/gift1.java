/*
ID: sukanta1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
  public static void main (String [] args) throws IOException {
    Scanner in = new Scanner(new File("gift1.in"));
	PrintWriter out = new PrintWriter(new FileWriter("gift1.out", true),true);
	int np = in.nextInt();
	ArrayList<String> pe = new ArrayList<>();
	ArrayList<Integer> mo = new ArrayList<>();
	in.nextLine();
	for(int i = 0;i<np;i++){
		String name = in.nextLine();
		int money = 0;
		pe.add(name);
		mo.add(money);
	}
	
	while(in.hasNext()){
		String name = in.nextLine();
		if(in.hasNextInt()){
		int m = in.nextInt();
		int p = in.nextInt();
		if(p>0){
		int mp = m/p;
		int index = pe.indexOf(name);
		int value = mo.get(index);
		int v = (value-m)+(m%p);
		mo.set(index,v);
		in.nextLine();
		for(int j = 0;j<p;j++){
			String n = in.nextLine();
			int l = pe.indexOf(n);
			int ind = mo.get(l);
			ind += mp;
			mo.set(l,ind);
		}
		}
		}
	}
	for(int i = 0;i<np;i++){
		String a = pe.get(i);
		int b = mo.get(i);
		out.println(a+" "+b);
	}
	in.close();
    out.close();// close the output file
  }
}