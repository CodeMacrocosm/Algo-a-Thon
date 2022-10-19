package LeetcodeFirstMonth;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,23,5,3};
        System.out.println(containsDuplicate(nums));
    }
}