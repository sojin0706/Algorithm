package SILVER;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj_1759_??Έλ§λ€κΈ? {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static StringTokenizer tokens;
	static String[]number;
	static String[]stored;
	static int L,C;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		L=Integer.parseInt(tokens.nextToken()); //λͺκ° λ½μκ±΄μ?
		C=Integer.parseInt(tokens.nextToken()); //??λ²? μ΄? λͺκ°?
		number=new String[C];
		stored=new String[L];
		tokens=new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			number[i]=tokens.nextToken();
		}
		Arrays.sort(number,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
		});
		combi(0,0);
		System.out.println(output);
		
	}
	public static void combi(int cnt,int index) {
		if(cnt==L) {
			int count=0;
			int count2=0;
			for(int i=0;i<L;i++) {
				switch(stored[i]) {
				case "i":
				case "o":
				case "u":
				case "e":
				case "a":
					count++;
					break;
				default:
					count2++;
				}
			}
			if(count>=1&&count2>=2) {
				for(int i=0;i<L;i++) {
					output.append(stored[i]);
					}
				output.append("\n");
				}
				
			return;
				
			}
		
		for(int i=index;i<C;i++) {
			stored[cnt]=number[i];
			combi(cnt+1,i+1);
		}
		
	}

}
