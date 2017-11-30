package search;

public class ArtificialForLoop implements Action{

	public static void main(String[] args) {
		forLoop(10, new Action() {
			
			
			int count = 1;
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				System.out.println(count + ". Hello world!");
				count++;
			}
		});
	}

	public static void forLoop(int n, Action s) {
		if(n == 1) {
			s.act();
		}
		else {
			s.act();
			forLoop(n-1,s);
		}
	}
}
