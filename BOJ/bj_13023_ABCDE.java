
import java.util.*;
import java.io.*;

//�迭����� �ð��ʰ� -> arraylist�� �����ϱ�
public class bj_13023_ABCDE {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M;
	static ArrayList<Integer>[]list;
	static boolean[]visited;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken()); //����� ��
		M=Integer.parseInt(tokens.nextToken()); //ģ�� ���� �� =>dfs�� ������ 4�����Ѵ�.
		
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
			visited=new boolean[N];//�ʱ�ȭ
			dfs(i,0);
		}
		
	System.out.println(0); //������� �Դٴ°� ã�� ���ߴٴ°�
	}
	//���� ���̰� M�� �Ǹ� �����ѰŴ� (ģ������ ����) 
	private static void dfs(int k,int depth) {
		if(depth==4) {
			System.out.println(1);
			System.exit(0); //4�� �����ϸ� �������� 
		}
		
			for(int i=0;i<list[k].size();i++) {
				//list�� ����Ǿ��ִµ� �湮���� �ʾҴٸ�
				if(!visited[list[k].get(i)]) {
					visited[k]=true; //�ϴ� k������ true�� ���� ��
					dfs(list[k].get(i),depth+1); //���� �̾����ִ� �� �湮�ϱ�
					visited[k]=false; //�ٽõ��ƿ����� false�� �������ֱ� 
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
