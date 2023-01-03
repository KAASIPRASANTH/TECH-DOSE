class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length,sum=0;
        for(int val:nums){
            sum+=val;
        }
        List<List<Integer>> l1 = new ArrayList<>();
        List<TreeSet<Integer>> l2 = new ArrayList<>();
        int half = n/2;
        for(int i=0;i<(1<<half);i++){
            l1.add(new ArrayList<>());
            l2.add(new TreeSet<>());
        }
        for(int i=0;i<(1<<half);i++){
            int sum1=0,sum2=0,count=0;
            for(int j=0;j<half;j++){
                if((i&(1<<j)) > 0){
                    count++;
                    sum1+=nums[j];
                    sum2+=nums[half+j];
                }
            }
            l1.get(count).add(sum1);
            l2.get(count).add(sum2);
        }
        int res = Integer.MAX_VALUE;
        for(int size1=0;size1<(1<<half);size1++){
            for(int x:l1.get(size1)){
               int size2 = n/2-size1;
               int target = (sum/2 - x);
               Integer y1 = l2.get(size2).floor(target);
               Integer y2 = l2.get(size2).ceiling(target);
               if(y1 !=null){
                   int s1 = x+y1.intValue();
                   res = Math.min(res,Math.abs(s1-(sum-s1)));
               }
               if(y2 !=null){
                   int s1 = x+y2.intValue();
                   res = Math.min(res,Math.abs(s1-(sum-s1)));
               }
            }
        }
        return res;
    }
}
