public class SingleNumberIII260 {
    public static int[] singleNumber(int[] nums) {
        int n = nums.length,xor = 0;
        for(int i=0;i<n;i++){
            xor = xor^nums[i];
        }
        int setBitPos=0;
        int num1 = xor,num2 = 0,temp = xor;
        while((temp&1)==0){
            setBitPos++;
            temp = temp>>1;
        }
        for(int num : nums){
            if((num&(1<<setBitPos)) > 0){
                num1 = num1^num;
            }
        }
        return new int[]{num1,num1^xor};
    }
    public static void main(String[] args) {
        int[] nums = {2,2,4,3,5,3};
        int[] res = singleNumber(nums);
        System.out.println(res[0]+" "+res[1]);
    }
}
