public class LargestCombinationWithBitwiseANDGreaterThanZero2275 {
    public static int largestCombination(int[] candidates) {
        int res = 0;
        for(int i=0;i<32;i++){
            int count = 0;
            for(int num:candidates){
                if((num&(1<<i))>0){
                    count++;
                }
            }
            res = Math.max(count,res);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] candidates = {16,17,71,62,12,24,14};
        System.out.println(largestCombination(candidates));
    }
}
