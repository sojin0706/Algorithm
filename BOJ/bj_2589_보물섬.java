package 코딩테스트준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//bfs사용 - land마다 최대로 갈 수 있는 L을 체크 -
public class bj_2589_보물섬 {
   static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   static StringTokenizer tokens;
   static char[][]map;
   static int R,C;
   static int max=0,totalmax=0;
   static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
   static LinkedList<Point> land;
   public static void main(String[] args) throws IOException {
      tokens=new StringTokenizer(br.readLine());
      R=Integer.parseInt(tokens.nextToken());
      C=Integer.parseInt(tokens.nextToken());
      map=new char[R][C];
      land=new LinkedList<>();
      for(int r=0;r<R;r++) {
         String str=br.readLine();
         for(int c=0;c<C;c++) {
            map[r][c]=str.charAt(c);
            if(map[r][c]=='L') {
               land.add(new Point(r,c,0));
            }
         }
      } //입력완료
      
      bfs();
      System.out.println(totalmax);
      
      
   }
   private static void bfs() {
      boolean[][]visited;
      totalmax=Integer.MIN_VALUE;
      max=Integer.MIN_VALUE;
      Queue<Point>queue;
      for(Point p:land) {
    	 queue=new LinkedList<>();
     
         visited=new boolean[R][C];
         queue.offer(new Point(p.r,p.c,p.cnt));
         visited[p.r][p.c]=true;
         while(!queue.isEmpty()) {
            Point head=queue.poll();
            for(int d=0;d<deltas.length;d++) {
               int nr=head.r+deltas[d][0];
               int nc=head.c+deltas[d][1];
               if(isIn(nr,nc)&&map[nr][nc]=='L'&&visited[nr][nc]==false) {
                  queue.offer(new Point(nr,nc,head.cnt+1));
                  max=Math.max(max,head.cnt+1);
                  visited[nr][nc]=true;
               }
            }
           
         }
      
         totalmax=Math.max(max, totalmax);
      }
   }
   private static boolean isIn(int r,int c) {
      return r>=0&&c>=0&&r<R&&c<C;
   }
   
   
   public static class Point{
      int r,c,cnt;
      public Point(int r,int c,int cnt) {
         super();
         this.r=r;
         this.c=c;
         this.cnt=cnt;
      }
   }

}