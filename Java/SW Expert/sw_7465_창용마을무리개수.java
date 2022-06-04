import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_7465_창용마을무리개수 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static StringTokenizer tokens;
	static int[]map;
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			
			tokens=new StringTokenizer(br.readLine());
			N=Integer.parseInt(tokens.nextToken()); //총 사람수
			M=Integer.parseInt(tokens.nextToken()); //간선의 수
			int count=0;
			make();
			for(int i=0;i<M;i++) {
				tokens=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(tokens.nextToken());
				int b=Integer.parseInt(tokens.nextToken());
				union(a,b);
			}
			for(int i=1;i<map.length;i++) {
				if(map[i]==i) {
					count++;
				}
			}
			
			output.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(output);
	}
	static void make() {
		map=new int[N+1];
		for(int i=1;i<map.length;i++) {
			map[i]=i; //make-set
		}
	}
	static int find(int a) {
		if(a==map[a]) {
			return a;
		}else {
			return map[a]=find(map[a]);
		}
	}
	static void union(int a,int b) {
		int findA=find(a);
		int findB=find(b);
		if(findA==findB) {
			return;
		}else {
			map[findB]=findA;
		}
			
				
	}

}
