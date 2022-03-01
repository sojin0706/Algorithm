package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1292_쉽게푸는문제 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws Exception{
		
		tokens=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(tokens.nextToken());
		int M=Integer.parseInt(tokens.nextToken());
		
		int[]arr=new int[1001];
		int k=1;
		int i=0;
		while(i<=1000) {
			for(int j=0;j<k;j++) {	
				if(i>1000) break;
				arr[i]=k;
				i++;
			}
			k++;
		}
		int sum=0;
		for(int m=N-1;m<M;m++) {
			sum+=arr[m];
		}
		System.out.println(sum);
	}

}
