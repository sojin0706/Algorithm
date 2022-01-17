package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj_10825_Íµ??òÅ?àò {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static StringTokenizer tokens;
	static person[] persons;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N=Integer.parseInt(br.readLine());
		persons=new person[N];
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(br.readLine());
			String name=tokens.nextToken();
			int kor=Integer.parseInt(tokens.nextToken());
			int eng=Integer.parseInt(tokens.nextToken());
			int math=Integer.parseInt(tokens.nextToken());
			person p=new person(name,kor,eng,math);
			persons[i]=p;
			}
		
		Arrays.sort(persons);
		
		for(int i=0;i<N;i++) {
			System.out.println(persons[i].name);
		}
		

	}
	static class person implements Comparable<person>{
		String name;
		int kor;
		int eng;
		int math;
		public person(String name, int kor, int eng, int math) {
			super();
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		@Override
		public int compareTo(person o) {
			if(this.kor==o.kor) {
				if(this.eng==o.eng) {
					if(this.math==o.math) {
						return this.name.compareTo(o.name);
					}else {
						return o.math-this.math;
					}
				}else {
					return this.eng-o.eng;
				}
			}else {
				return o.kor-this.kor;
			}
			
		}
		
		
	}
}
