package GOLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1922_?��?��?��?��?���? {
	//모든 간선?�� 만들?��?��?��, �? ?��?��  최소?��?��?��?��.
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
		
		
	}
	static int N,M;
	static Edge[]edge;
	static int[]parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer tokens;
		 int cnt=0;
		 int result=0;
		 N=Integer.parseInt(br.readLine()); //컴퓨?�� ?��
		 M=Integer.parseInt(br.readLine()); //간선 ?��
		 edge=new Edge[M];
		 make();
		 for(int i=0;i<M;i++) {
			 tokens=new StringTokenizer(br.readLine());
			 edge[i]=new Edge(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
			 
		 }
		 Arrays.sort(edge);
		 for (Edge edges : edge) {
			if(union(edges.from,edges.to)==true) { //true?��?���? 최소?���? ?��결했?��. 
				result+=edges.weight; //그럼 �? �?중치 ?��?��?�� 
				cnt++;
				if(cnt==N) {
					break;
				}
				
			}
		 }
		 System.out.println(result);
		 
	}
	static void make() {
		parents=new int[N+1];
		for(int i=1;i<=N;i++) {
			parents[i]=i; //1�??�� ?��?���? 
		}
	}
	static int find(int a) {
		if(parents[a]==a) {
			return parents[a];
		}else {
			return parents[a]=find(parents[a]);
		}
		
	}
	static boolean union(int a,int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		if(aRoot==bRoot) {
			return false;
		}else {
			parents[bRoot]=aRoot;
			return true;
		}
	}

}