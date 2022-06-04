package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 1. 돈으로 내림차순, 돈이 같으면 시간으로 내림차순을 한다. (일단 돈이 높은걸 골라야하니까)
// 2. boolean배열을 이용해서, 해당돈을 받는날  갈수있는 날짜를 true로 체크 
public class bj_2109_순회강연 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static Lecture[] lecture;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		//0일수도있음(예외처리 해줘야한다 -> 런타임에러의 이유)
		if(N==0) {
			System.out.println(0);
			System.exit(0);
		}
		lecture=new Lecture[N];
		
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(br.readLine());
			lecture[i]=new Lecture(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
		}//저장
		Arrays.sort(lecture);
		//출력
//		for(int i=0;i<lecture.length;i++) {
//			System.out.println(lecture[i].money+" "+lecture[i].day);
//		}
		int max=Integer.MIN_VALUE;
		int temp=0;
		for(int i=0;i<lecture.length;i++) {
			temp=lecture[i].day;
			if(max<temp) {
				max=temp;
			}
		}
		boolean[]visited=new boolean[max+1]; 
		//방문하지 않은 지점이면 더한다.
		int sum=0;
		for(int i=0;i<lecture.length;i++) {
			//최대부터 하나씩 줄여가면서 날짜를 선정할거다
			for(int j=lecture[i].day;j>0;j--) {
				//그 날짜 방문하지 않았는데
				if(!visited[j]) {			
						visited[j]=true;
						sum+=lecture[i].money;
						break;
				}
			}
		}
		
		System.out.println(sum);
		
		
	}
	static public class Lecture implements Comparable<Lecture>{
		int money;
		int day;
		public Lecture(int money,int day) {
			this.money=money;
			this.day=day;
		}
		@Override //먼저 돈으로 내림차순하고, 돈이 같으면 날짜로 내림차순
		public int compareTo(Lecture o) {
			if(o.money==this.money) {
				return o.day-this.day;
			}else {
				return o.money-this.money;
			}
		
		}
		

	}
}
