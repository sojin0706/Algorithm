package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11047_동전0 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K;
	static int[]coin;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		K=Integer.parseInt(tokens.nextToken());
		coin=new int[N];
		
		for(int i=0;i<N;i++) {
			coin[i]=Integer.parseInt(br.readLine());
		} //동전 입력받기
		
		int cnt=0;
		int T=N-1;
		while(true) {
			if(K==0) {
				break;
			}
			for(int i=T;i>=0;i--) {
				if(coin[i]<=K) {
					//찾으면
					K-=coin[i];
					T=i;
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
		
		
		
		
	}

}
