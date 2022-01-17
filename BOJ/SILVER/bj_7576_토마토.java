package SILVER;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_7576_?† ë§ˆí†  {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int R,C;
	static int[][]map;
	static Queue<Point>queue;
	static int count;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		C=Integer.parseInt(tokens.nextToken());
		R=Integer.parseInt(tokens.nextToken());
		map=new int[R][C];
		queue=new LinkedList<>();
		count=0;
		for(int r=0;r<R;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<C;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
				if(map[r][c]==1) {
					queue.add(new Point(r,c));
				}else if(map[r][c]==0) {
					count++;
				}
			}
		}
		bfs();
		System.out.println(output);
	}
	private static void bfs() {
		int day=0;
		int size=0;
		//queueê°? ë¹„ì–´?žˆì§? ?•Š?„?•Œê¹Œì? ?ˆ?‹¤. queue?—?Š” ê¸°ë³¸? ?¸ ? •ë³´ê? ?“¤?–´ê°??žˆ?Œ
		while(!queue.isEmpty()) {
			size=queue.size(); //queue?˜ ?‚¬?´ì¦ˆë?? ?„£?Š”?‹¤.
			// ?•œ ?„´?´ ì§??‚˜ë©? ?¼?ˆ˜ê°? ?Š˜?–´?‚œ?‹¤.
			while(size-- >0) {
				Point head=queue.poll();
				for(int d=0;d<deltas.length;d++) {
					int nr=head.r+deltas[d][0];
					int nc=head.c+deltas[d][1];
					
					if(isIn(nr,nc)&&map[nr][nc]==0) {
						map[nr][nc]=-1;
						count--;
						queue.offer(new Point(nr,nc));
					}
					
				}
			}
			if(queue.size()>0) {
				day++;
			}
		}
		if(count==0) {
			output.append(day);
		}else {
			output.append(-1);
		}
		
	}
	private static boolean isIn(int r,int c) {
		return r>=0&&r<R&&c>=0&&c<C;
	}
	
	private static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
}
