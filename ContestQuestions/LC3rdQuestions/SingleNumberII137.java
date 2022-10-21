public class SingleNumberII137 {
    public static int singleNumber(int[] nums) {
        int val = 0;
        for(int i=0;i<32;i++){
            int bitCount = 0;
            for(int num:nums){
                if(((num>>i)&1) == 1){
                    bitCount++;
                }
            }
            if(bitCount % 3 !=0){
                val = val|(1<<i);
            }
        }
        return val;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));
    }
}
