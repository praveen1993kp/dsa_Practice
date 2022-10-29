package assessment;

public class TwoSumII_Leetcode167 {
	public int[] twoSum(int[] numbers, int target) { 
        int left=0,right=numbers.length-1;
        int sum=0;
        int[] output = new int[2];
        while(left<right){
            sum = numbers[left] + numbers[right];
            if(sum > target) right--;
            else if (sum < target) left++;
            else{
                output[0] = left+1;
                output[1] = right+1;
                break;
            }
        }
        return output;
    }
}

/*
* Brute force:
* 1. Create two loops i=0 and j=i+1
* 2. When nums[i] == nums[j], return target
* 
* -Two Pointer-
* 1. Create two pointers left=0 and right = nums.length-1
* 2. If nums[left] + nums[right] > target, increment left
* 3. If nums[left] + nums[right] < target, decrement right
* 4. Traverse while left<right
* 5. When the sum equals target, return left+1,right+1;
*
* positive:
* {2,7,11,15} target = 9
* edge:
* {-1,0} target = -1
* edge2:
* {2,2,3,5} target = 4
* negative:
* {2,25,75} target = 100
*
*
*/
