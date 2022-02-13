package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1969_DNA_ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws Exception{
		tokens=new StringTokenizer(br.readLine());
		StringBuilder dnas=new StringBuilder();
		int N=Integer.parseInt(tokens.nextToken());
		int M=Integer.parseInt(tokens.nextToken());
		String[]map=new String[N];
		for(int i=0;i<N;i++) {
			map[i]=br.readLine();
		}
		int sum=0;
		int[]dna;
		//T,A,C,G이렇게 4개있음
		for(int i=0;i<M;i++) {
			dna=new int[4];
			for(int j=0;j<N;j++) {
				//개수가 얼만큼 있는지 세어주기
				if(map[j].charAt(i)=='A') {
					dna[0]++;
				}else if(map[j].charAt(i)=='C') {
					dna[1]++;
				}else if(map[j].charAt(i)=='G') {
					dna[2]++;
				}else if(map[j].charAt(i)=='T') {
					dna[3]++;
				}
			}
			//그중에서 최댓값 찾기
			int max=Integer.MIN_VALUE;
			int tmp=0;
			for(int k=0;k<4;k++) {
				if(max<dna[k]) {
					max=dna[k];
					tmp=k;
				}
			}
			if(tmp==0) {
				dnas.append("A");
			}else if(tmp==1) {
				dnas.append("C");
			}else if(tmp==2) {
				dnas.append("G");
			}else if(tmp==3) {
				dnas.append("T");
			}
			//나머지값들은 sum에 더해주기
			for(int k=0;k<4;k++) {
				if(k==tmp) continue;
				sum+=dna[k];
			}
			
		}
		
		System.out.println(dnas);
		System.out.println(sum);
		
	}

}
