package PracticePackage;

public class Practice2 {

	//Running sum of 1D Array 
	
	public int [] runningArray(int [] nums) {
		for (int i=0; i<nums.length-1;i++) {
			nums[i] =+ nums[i+1];
		}
		
		return nums;
		
	}
	public static void main (String [] args) {
		
		int[] nums = {1,2,3,4,5};
		System.out.println(nums);
		
	}
	}	
	
	
//
//[1,2,3,4]