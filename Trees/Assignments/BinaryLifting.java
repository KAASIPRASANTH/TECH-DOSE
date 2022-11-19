public class BinaryLifting {
    int n, maxAncestor;
    int[][] parentTable;

    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        maxAncestor = (int)Math.ceil((Math.log(n)/Math.log(2)));
        parentTable = new int[n][maxAncestor];
        for(int i=0;i<n;i++){
            Arrays.fill(parentTable[i],-1);
            parentTable[i][0] = parent[i];
        }
        for(int col=1;col<maxAncestor;col++){
            for(int node=0;node<n;node++){
                int firstJump = parentTable[node][col-1];
                if(firstJump != -1){
                    int secondJump = parentTable[firstJump][col-1];
                    if(secondJump != -1){
                        parentTable[node][col] = secondJump;
                    }
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int col = maxAncestor - 1; col >= 0; col--) {
            if (k >= (1 << col) && parentTable[node][col] != -1) {
                node = parentTable[node][col];
                k -= (1 << col);
            }
        }
        return k == 0 ? node : -1;
    }
}
