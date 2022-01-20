package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_16439_치킨치킨치킨 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M;
	static int[][]arr;
	static int totalmax=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		M=Integer.parseInt(tokens.nextToken());
		arr=new int[N][M];
		for(int r=0;r<N;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				arr[r][c]=Integer.parseInt(tokens.nextToken());
			}
		}//입력완료
		
		makeCombination(3,new int[3],0);
		System.out.println(totalmax);
		
	}
	private static void makeCombination(int toChoosed,int[]choosed,int start) {
		if(toChoosed==0) {
			//다뽑음
			cal(choosed);
			return;
		}
		for(int i=0;i<M;i++) {
			choosed[choosed.length-toChoosed]=i;
			makeCombination(toChoosed-1,choosed,i+1);
			
		}
	}
	private static void cal(int[]choosed) {
		//사람수만큼 for문 돌고 그 뽑은 3개중에서 최댓값 1개 구하기
		int sum=0;
		for(int i=0;i<N;i++) {
			int max=Integer.MIN_VALUE;
			for(int j=0;j<choosed.length;j++) {
				if(arr[i][choosed[j]]>max) {
					max=arr[i][choosed[j]];
				}
			}
			sum+=max;
		}
		if(sum>totalmax) {
			totalmax=sum;
		}
		
	}
}
