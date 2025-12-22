import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class UtilsTemplates {

    public static void arrayInputProblemsReturnValue()
    {
        int[] nums = {10,9,2,5,3,7,101,18};
        int result = LeetCodeProblems.largestIncreasingSubSequence(nums);
        System.out.println("The result is: "+result);
    }

    public static void arrayInputReturnsList()
    {
        int[] arr = {1,3,6,10,15};
        List<List<Integer>> result = LeetCodeProblems.minimumAbsDifference(arr);
        Consumer<List<List<Integer>>> test = (n) -> System.out.println(n.toString());
        test.accept(result);
    }

    public static int arrayInputreturnsInt(int[] input)
    {
        int result = 0;
        return 0;
    }

    public static List<String> intInputArrayOutput(int input)
    {
        List<String> result = new ArrayList<>();
        return result;
    }

    public static void inputStringDisplaySingleOutput()
    {
        String input = "aabcdefghij";
        String result = LeetCodeProblems.stringCompresssion(input);
        System.out.println(result);
    }

}
