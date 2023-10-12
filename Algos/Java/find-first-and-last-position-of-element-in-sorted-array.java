class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=search(nums,target,true);
        ans[1]=search(nums,target,false);
        return ans;   
    }
    int search(int[] nums,int target,boolean findStartIndex)
    {
        int ans=-1;
        int start=0,end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(target<nums[mid])
                end=mid-1;
            else if(target>nums[mid])
                start=mid+1;
            else{
                ans=mid;
                if(findStartIndex)
                    end=mid-1;
                else
                    start=mid+1;
            }
        }
        return ans;
    }
}
