class NumArray {
    static int[] segmentTree;
    static int n;
    public static int BuildSegment(int SI,int[] nums,int sl,int sr){
        if(sl==sr){
            return segmentTree[SI] = nums[sl];
        }
        int mid = sl+(sr-sl)/2;
        int leftSide = BuildSegment(SI*2+1,nums,sl,mid);
        int rightSide = BuildSegment(SI*2+2,nums,mid+1,sr);
        segmentTree[SI] = leftSide+rightSide;
        return segmentTree[SI];
    }
    public static int getRangeSum(int SI,int sl,int sr,int left,int right){
        if(right<sl || sr<left){ //no overlap
            return 0;
        }
        if(left<=sl && sr<=right){ //fully overlap 0<=1 && 1
            return segmentTree[SI];
        }
        int mid = sl+(sr-sl)/2;
        int leftSide = getRangeSum(SI*2+1,sl,mid,left,right);
        int rightSide = getRangeSum(SI*2+2,mid+1,sr,left,right);
        return leftSide+rightSide;
    }
    public static int update(int SI,int sl,int sr,int pos,int val){
        if(sl>pos || sr<pos){ // no overlap
            return segmentTree[SI];
        }
        if(sl==sr && sl==pos){ // fully overlap
            segmentTree[SI] = val;
            return segmentTree[SI] ;
        }
        int mid = sl+(sr-sl)/2;
        int leftSide = update(SI*2+1,sl,mid,pos,val);
        int rightSide = update(SI*2+2,mid+1,sr,pos,val);
        segmentTree[SI] = leftSide+rightSide;
        return segmentTree[SI];
    }
    public NumArray(int[] nums) {
        n = nums.length;
        int height = (int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int size = (1<<height)-1;
        segmentTree = new int[size];
        int sum = BuildSegment(0,nums,0,n-1);
    }
    
    public void update(int index, int val) {
        int sum = update(0,0,n-1,index,val);
        
    }
    
    public int sumRange(int left, int right) {
        return getRangeSum(0,0,n-1,left,right);
    }
}
