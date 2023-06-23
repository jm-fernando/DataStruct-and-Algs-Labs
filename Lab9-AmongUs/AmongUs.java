import java.util.LinkedList;


public class AmongUs {
    /**
     * Find out the imposter in the spaceship,
     * which each crew-mate suspect one other person,
     * while the imposter suspect nobody.
     *
     * @param n       number of people
     * @param suspect list of sus
     *                i.e. n = 2, suspect = [[1,2]] -> 1 suspect 2, and 2 suspect no one
     *                therefore 2 is the imposter
     * @return the label of the imposter or -1 if the imposter does not exist
     */
    public int findImposter(int n, int[][] suspect) {
        
    	int[] player = new int[n];
    	int[] susPlayer = new int[n];
    	
    	for(int i = 0; i < suspect.length; i++) {
    		int playerArr = suspect[i][0];
    		int susArr = suspect[i][1];
    		player[playerArr - 1]++;
    		susPlayer[susArr - 1]++;
    	}
    	
    	for(int i = 0; i < n; i++) {
    		if(player[i] == 0 && susPlayer[i] == n - 1) {
    			return i + 1;
    		}
    	}
    	return -1;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    public static void main(String[] args) {
        AmongUs sus = new AmongUs();
        
        int[][] s1 = {{1, 2}};
        System.out.println(sus.findImposter(2, s1));
        
        int[][] s2 = {{1, 3}, {2, 3}};
        System.out.println(sus.findImposter(3, s2));
        
        int[][] s3 = {{1, 3}, {2, 3}, {3, 2}};
        System.out.println(sus.findImposter(3, s3));
        
        int[][] s4 = {{1, 2}, {2, 3}};
        System.out.println(sus.findImposter(3, s4));
        
        int[][] s5 = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(sus.findImposter(4, s5));
    }
}