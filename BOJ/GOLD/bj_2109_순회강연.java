package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 1. ������ ��������, ���� ������ �ð����� ���������� �Ѵ�. (�ϴ� ���� ������ �����ϴϱ�)
// 2. boolean�迭�� �̿��ؼ�, �ش絷�� �޴³�  �����ִ� ��¥�� true�� üũ 
public class bj_2109_��ȸ���� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static Lecture[] lecture;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		//0�ϼ�������(����ó�� ������Ѵ� -> ��Ÿ�ӿ����� ����)
		if(N==0) {
			System.out.println(0);
			System.exit(0);
		}
		lecture=new Lecture[N];
		
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(br.readLine());
			lecture[i]=new Lecture(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
		}//����
		Arrays.sort(lecture);
		//���
//		for(int i=0;i<lecture.length;i++) {
//			System.out.println(lecture[i].money+" "+lecture[i].day);
//		}
		int max=Integer.MIN_VALUE;
		int temp=0;
		for(int i=0;i<lecture.length;i++) {
			temp=lecture[i].day;
			if(max<temp) {
				max=temp;
			}
		}
		boolean[]visited=new boolean[max+1]; 
		//�湮���� ���� �����̸� ���Ѵ�.
		int sum=0;
		for(int i=0;i<lecture.length;i++) {
			//�ִ���� �ϳ��� �ٿ����鼭 ��¥�� �����ҰŴ�
			for(int j=lecture[i].day;j>0;j--) {
				//�� ��¥ �湮���� �ʾҴµ�
				if(!visited[j]) {			
						visited[j]=true;
						sum+=lecture[i].money;
						break;
				}
			}
		}
		
		System.out.println(sum);
		
		
	}
	static public class Lecture implements Comparable<Lecture>{
		int money;
		int day;
		public Lecture(int money,int day) {
			this.money=money;
			this.day=day;
		}
		@Override //���� ������ ���������ϰ�, ���� ������ ��¥�� ��������
		public int compareTo(Lecture o) {
			if(o.money==this.money) {
				return o.day-this.day;
			}else {
				return o.money-this.money;
			}
		
		}
		

	}
}
