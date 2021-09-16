package 혼자공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class sw_최장증가부분수열 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			int[]arr=new int[N];
			int[]LIS=new int[N];
			tokens=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(tokens.nextToken());
			}
			int max=0;
			for(int i=0;i<N;i++) {
				LIS[i]=1; //최소값
				for(int j=0;j<i;j++) {
					if(arr[i]>arr[j]&&LIS[i]<LIS[j]+1) {
						LIS[i]=LIS[j]+1;
					}
				}
				
				if(max<LIS[i]) {
					max=LIS[i];
				}
			}
			
			output.append("#").append(t).append(" ").append(max).append("\n");
			
		}
		System.out.println(output);

	}

}
