package Final;

	import java.util.ArrayList;

	/**
	 * Solution: three Sodoku rules.
	 * 1. Each row must have the number 1-9 occuring just once.
	 * 2. Each column .....
	 * 3. The number 1-9 must occur just once in each of sub-boxes of the grid.
     * @author Ananya
	 * @date Feb 8, 2017
	 */
	public class IsValidSudoku {
		
		public boolean isValidSudoku(int[][] board) {
			
			//initially checking board is empty or not
			if (board == null || board.length == 0 || board[0].length == 0) {
				return false;
			}
			 // check that the board is 9 x 9
			 if (board.length != 9) return false;
			 for (int i = 0; i < board.length; i++) {
			 if (board[i].length != 9) return false;
			 }
			
			int length = board.length;
			ArrayList<Integer> visited = new ArrayList<Integer>();
			// Check every row
			for (int i = 0; i < length; i++) {
				visited.clear();
				for (int j = 0; j < length; j++) {
					if (!process(visited, board[i][j])) {
						return false;
					}
				}
			}
			
			// Check every column		
			for (int i = 0; i < length; i++) {
				visited.clear();
				for (int j = 0; j < length; j++) {
					if (!process(visited, board[j][i])) {
						return false;
					}
				}
			}

			// Check every subx-box
			for (int i = 0; i < length; i += 3) {
				for (int j = 0; j < length; j += 3) {
					visited.clear();
					for (int k = 0; k < length; k++) {
						if (!process(visited, board[i + k / 3][j + k % 3])) {
							return false;
						}
					}
				}
			}
			
			return true;
	    }
		
		 // check that the digits 1-9 each appear exactly once in the given array
		private boolean process(ArrayList<Integer> visited, int digit) {

			int num= digit;
			if ( num < 1 || num > 9 || visited.contains(num)) {
				return false;
			}
			
			visited.add(num);
			return true;
		}
	}


