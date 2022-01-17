
import java.util.*;
import java.io.*;

//배열썼더니 시간초과 -> arraylist로 변경하기
public class bj_13023_ABCDE {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M;
	static ArrayList<Integer>[]list;
	static boolean[]visited;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken()); //사람의 수
		M=Integer.parseInt(tokens.nextToken()); //친구 관계 수 =>dfs을 탔을때 4여야한다.
		
		list=new ArrayList[N];
		
		for(int i=0;i<N;i++) {
			list[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			tokens=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(tokens.nextToken());
			int b=Integer.parseInt(tokens.nextToken());
			list[a].add(b);
			list[b].add(a);
			
		}
		
		for(int i=0;i<N;i++) {
			visited=new boolean[N];//초기화
			dfs(i,0);
		}
		
	System.out.println(0); //여기까지 왔다는건 찾지 못했다는것
	}
	//이제 깊이가 M이 되면 도달한거다 (친구관계 성립) 
	private static void dfs(int k,int depth) {
		if(depth==4) {
			System.out.println(1);
			System.exit(0); //4에 도달하면 강제종료 
		}
		
			for(int i=0;i<list[k].size();i++) {
				//list에 연결되어있는데 방문하지 않았다면
				if(!visited[list[k].get(i)]) {
					visited[k]=true; //일단 k지점을 true로 변경 후
					dfs(list[k].get(i),depth+1); //나와 이어져있는 곳 방문하기
					visited[k]=false; //다시돌아왔을땐 false로 변경해주기 
				}
			}
		
		}
	}
//
//private static void dfs(int k,int depth) {
//	if(depth==4) {
//		System.out.println(1);
//		System.exit(0);
//	}
//	visited[k]=true;
//	for(int i=0;i<N;i++) {
//		if(!visited[i]) {
//				if(map[k][i]==1||map[i][k]==1) {
//					visited[i]=true;
//					dfs(i,depth+1);
//					visited[i]=false;
//				}
//		}
//		
//	}
//	
//}
