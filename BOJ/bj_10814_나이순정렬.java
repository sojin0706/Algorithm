import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj_10814_나이순정렬 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static person[]persons;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N=Integer.parseInt(br.readLine());
		persons=new person[N]; //persons배열 초기화
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(br.readLine());
			int age=Integer.parseInt(tokens.nextToken());
			String name=tokens.nextToken();
			person p=new person(age,name);
			persons[i]=p;
		}
		Arrays.sort(persons);
		for(int i=0;i<N;i++) {
			output.append(persons[i].age).append(" ").append(persons[i].name).append("\n");
		}
		System.out.println(output);
		
	}
	
	private static class person implements Comparable<person>{
		int age;
		String name;
		
		public person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(person o) {
			if(this.age==o.age) {
				return 0;
			}else {
				return this.age-o.age;
			}
			
		}
		
		
	}

	}
