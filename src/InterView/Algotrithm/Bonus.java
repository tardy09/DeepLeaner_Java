package InterView.Algotrithm;

public class Bonus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int res=  new Bonus().getTotalA(70);
		System.out.println(res);
	}
	public int getMost(int[][] board) {
		int result[][]=new int[6][6];
		result[0][0]=board[0][0];
		for(int i=1;i<6;i++){
			result[i][0]=result[i-1][0]+board[i][0];
		}
		for(int i=1;i<6;i++){
			result[0][i]=result[0][i-1]+board[0][i];
		}
		for(int i=1;i<6;i++){
			for(int j=1;j<6;j++){
				result[i][j]=Math.max(result[i-1][j], result[i][j-1])+board[i][j];
			}
		}
		
		return result[5][5];
        // write code here
    }
	/**
	 * 100,90,80,70
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	 public int calcDistance(int A, int B, int C, int D) {
		int totalSum=0;
		int totalA=getTotalA(A);
		int totalB=getTotalA(A);
		int totalC=getTotalA(A);
		int totalD=getTotalA(A);
		 
		 return totalA+totalB+totalC+totalD;
	        // write code here
		
	    }
	private int getTotalA(int a) {
		// TODO Auto-generated method stub
		int sum=a;
		
		while(a!=0){
			a/=2;
			sum+=(a*2);
		}
		return sum;
	}

}
