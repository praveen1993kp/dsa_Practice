package assessment;

public class ConvertIntegerIntoSum_Leetcode1317 {
	public int[] getNoZeroIntegers(int n) {
        int num1 = 1;
        int num2 = n-num1;
        int temp1 = num1;
        int temp2 = num2;
        int output[] = {num1,num2};
        for(int i=temp2;i>=0;i--){
            temp2 = num2;
            temp1 = num1;
            while(temp2>9){
                if(temp2%10==0){
                    num1++;
                    num2--;
                }
                temp2 = temp2/10;
            }
            while(temp1>9){
                if(temp1%10==0){
                    num1++;
                    num2--;
                }
                temp1 = temp1/10;
            }
            
        }
        output[0] = num1;
        output[1] = num2;
        return output;
    }
}

/*
* positive:
* n=2
* edge:
* 9009
* edge2:
* 1009
* negative:
* 9999
*
* --Pseudo code--
* 1. Assign num1 = n-1 and num2 = n-num1
* 2. While num1 contains 0 or num2 contains 0, increment num1 and decrement num2
* 3. When num1 and num2 doesn't contain any 0, return num1 and num2
* Logic: For checking if num1 and num2 doesn't contain 0, use modulo and divide functions repetitively
*
*
*
*
*
*
*/
