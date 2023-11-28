package InterView.Algotrithm;

public class TestTreverSe {
	public int tranSeFibo(int n){
		if(n==0||n==1){
			return 1;
		}
		System.out.println("hahahhah");
			return tranSeFibo(n-2)+tranSeFibo(n-1);
		
	}
  public static void main(String [] args){
	int s=  new TestTreverSe().tranSeFibo(3);
	 System.out.println(s); 
  }
}
