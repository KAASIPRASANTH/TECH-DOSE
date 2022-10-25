import java.util.*;;
public class BucketSort1 {
    public static int findMin(int[] nums){
        int min = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min){
                min = nums[i];
            }
        }
        return min;
    }
    public static int findMax(int[] nums){
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }
    public static void sort(int[] nums,int NumOfBuckets){
        int min = findMin(nums);
        int max = findMax(nums);

        //maximum size of each bucket
        float range = (max - min+1)/NumOfBuckets;

        //Allocating bucket to store
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<NumOfBuckets;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<nums.length;i++){
            float diff = (nums[i] - min+1)/range - (int)((nums[i] - min+1)/range);

            //if diff == 0 then exactly it's divisible so, we should reduce it's position by 1;
            //Ex: min = 1 , max = 12 and NumOfBucket = 3,range = 4 =>(12-1+1)/4 = 3 but, index=(0 to 2) for bucket
            
            if(diff == 0 && nums[i] != min){
                list.get((int)((nums[i] - min+1)/range)-1).add(nums[i]);
            }else{
                list.get((int)((nums[i] - min+1)/range)).add(nums[i]);
            }
        }
        for(int i=0;i<NumOfBuckets;i++){
            Collections.sort(list.get(i));
        }
        System.out.println(list);
    }
    public static void main(String[] args) {
        int[] nums = {12,11,10,9,7,8,3,2,5,1,4,6};
        int bucketSize = 3;
        sort(nums, bucketSize);
    }
}
