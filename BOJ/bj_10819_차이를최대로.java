package 코딩테스트준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//순열로 숫자 정렬후 다 해보기 
public class bj_10819_차이를최대로 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[]map;
	static int max=Integer.MIN_VALUE;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		map=new int[N];
		tokens=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			map[i]=Integer.parseInt(tokens.nextToken());
		}//입력완료
		makePermutation(N,new int[N],new boolean[N]);
		System.out.println(max);
	}
	static void makePermutation(int toChoose,int[]choosed,boolean[]visited) {
		if(toChoose==0) {
			//이때 최대인지 체크 
			int ans=check(choosed);
			max=Math.max(max, ans);
			return;
		}
		for(int i=0;i<map.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				choosed[choosed.length-toChoose]=map[i];
				makePermutation(toChoose-1,choosed,visited);
				visited[i]=false;
			}
		}
	}
	static int check(int[]choosed) {
		int ans=0;
		for(int i=1;i<N;i++) {
			ans+=Math.abs(choosed[i-1]-choosed[i]);
		}
		return ans;
	}
}
