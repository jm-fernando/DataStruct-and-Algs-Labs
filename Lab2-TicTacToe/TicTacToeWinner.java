
public class TicTacToeWinner {

	//function to establish TTC board, implement moves and returns
	//either the winner between player A and B, a draw, or winner still
	//pending
	public static String ttcWinner(int[][] moves) {
		
		int[] rows = new int[3];
		int[] columns = new int[3];
		int diagonal = 0;
		int antidiagonal = 0;
		int z = 0;
		int x;
		int y;
		
		for (int i = 0; i < moves.length; i++) {
			
			if (i % 2 == 0) {
				z = 1; 
				x = moves[i][0];
				y = moves[i][1];
				rows[x] += z;
				columns[y] += z;
				
			} else {
				z = -1;
				x = moves[i][0];
				y = moves[i][1];
				rows[x] += z;
				columns[y] += z;
			}
			
			if(x == y) {
				diagonal += z;
			}
			
			if(y == 3 - x - 1) {
				antidiagonal += z;
			}
			
			if(checkAWin(rows, columns, diagonal, antidiagonal)) {
				return "A";
			}
			
			if(checkBWin(rows, columns, diagonal, antidiagonal)) {
				return "B";
			}
			
			if(moves.length == 9) {
				return "Draw";
			}
				
		}
		return "Pending";
		
	}
	
	//helper function to determine if player A wins
	private static boolean checkAWin(int[] rows, int[] columns, int diagonal, int antidiagonal) {
		for(int i = 0; i < 3; i++) {
			if(rows[i] == 3 || columns[i] == 3) {
				return true;
			}
		}
		return diagonal == 3 || antidiagonal == 3;
	}
	
	//helper function to determine if player B wins
	private static boolean checkBWin(int[] rows, int[] columns, int diagonal, int antidiagonal) {
		for(int i = 0; i < 3; i++) {
			if(rows[i] == -3 || columns [i] == -3) {
				return true;
			}
		}
		return diagonal == -3 || antidiagonal == -3;
	}
	
	
	
	//main to test if code works 
	public static void main(String[] args) {
		
		int[][] moves = {{0, 0}, {1,1}, {0,1}, {0,2}, {1,0}, {2,0}};
		
		System.out.println(ttcWinner(moves));
	}

}
