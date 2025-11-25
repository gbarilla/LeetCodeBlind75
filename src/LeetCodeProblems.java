import java.util.ArrayList;
import java.util.List;

public class LeetCodeProblems {

    public static void MoveZeroes(int[] nums) {
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
        }
        while (currentIndex < nums.length) {
            nums[currentIndex] = 0;
            currentIndex++;
        }
        System.out.println(nums);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        int maxNumber = 0;
        for(int index = 0; index < candies.length;index++)
        {
            if(maxNumber < candies[index])
            {
                maxNumber = candies[index];
            }
        }
        for(int secondIndex = 0; secondIndex < candies.length;secondIndex++)
        {
            if(candies[secondIndex]+extraCandies >= maxNumber)
            {
                result.add(true);
            }
            else
            {
                result.add(false);
            }
        }
        return result;
    }
}
