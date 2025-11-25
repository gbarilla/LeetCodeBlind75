import java.util.*;

public class Main {
    public static void main(String[] args) {
        // MoveZeroes();
        // kidsWithCandies();
        // twoWordPermutation();
        // reverseVowels();
        // replaceWhiteSpaces();
        //reverseWords();
        //productExceptSelf();
        findMaxAverage();
        gcdOfStrings();
        get_robots();
    }

    private static void get_robots() {
        String required_parts_1 = "sensors,case,speaker,wheels";
        String required_parts_2 = "sensors,case,speaker,wheels,claw";
        String required_parts_3 = "sensors,case,screws";

        String[] all_parts = {
                "Rosie_claw",
                "Rosie_sensors",
                "Dustie_case",
                "Optimus_sensors",
                "Rust_sensors",
                "Rosie_case",
                "Rust_case",
                "Optimus_speaker",
                "Rosie_wheels",
                "Rosie_speaker",
                "Dustie_case",
                "Dustie_arms",
                "Rust_claw",
                "Dustie_case",
                "Dustie_speaker",
                "Optimus_case",
                "Optimus_wheels",
                "Rust_legs",
                "Optimus_sensors"};

        ArrayList<String> result =  LeetCodeProblems.get_robots(all_parts,required_parts_1);
        for(String s : result)
        {
            System.out.println(s);
        }
    }

    private static void gcdOfStrings() {
        String str1 =  "ABC";
        String str2 =  "ABCABC";

        var test2 = LeetCodeProblems.gcdOfStrings(str1,str2);
        System.out.println(test2);
    }

    private static void findMaxAverage() {
        // 643. Maximum Average Subarray I
        // Input: nums = [1,12,-5,-6,50,3], k = 4
        // Output: 12.75000
        int[] example1 = {1,12,-5,-6,50,3};
        int[] exampleTry = {1,2,3,4,5,6};
        int k = 4;
        System.out.println(LeetCodeProblems.findMaxAverage(exampleTry,k));
    }

    private static void productExceptSelf() {
        // 238. Product of Array Except Self
        // expected Output: [24,12,8,6]
        int[] nums = {1,2,3,4};

        // expected Output: [0,0,9,0,0]
        int[] nums2 = {-1,1,0,-3,3};

        for(int i : LeetCodeProblems.productExceptSelf(nums2))
        {
            System.out.println(i);
        }
    }

    private static void reverseWords() {
        // 151. Reverse Words in a String
        // expected output = blue is sky the
        String phrase ="the sky is blue";

        //expected output = world hello
        String phrase2 = "  hello world  ";

        System.out.println(LeetCodeProblems.reverseWords(phrase2));
    }

    public static void MoveZeroes()
    {
        int[] nums = {0, 1, 0, 3, 12};
        LeetCodeProblems.MoveZeroes(nums);
    }

    public static void reverseVowels()
    {
        System.out.println(LeetCodeProblems.reverseVowels("IceCream"));
    }

    public static void kidsWithCandies()
    {

        int[] candies = {4,2,1,1,2};
        int extraCandies = 1;
        var test = LeetCodeProblems.kidsWithCandies(candies,extraCandies);
    }

    public static void replaceWhiteSpaces()
    {
        String input ="Mr John    Smith     ";
        int trueLenght = 17;
        System.out.println(LeetCodeProblems.replaceWhitespace(input,trueLenght));
    }

    public static void twoWordPermutation()
    {
        String word1 = "AA";
        String word2 = "ABAB";

        System.out.println(LeetCodeProblems.determineIfTwoWordsArePermutations(word1,word2));
    }



    public boolean isSubsequence(String s, String t) {
        return true;
    }


    public static String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int currentPointerThroughBoth = 0;
        int word1pointer = 0;
        int word2pointer = 0;
        int word1Lenght = word1.length();
        int word2Lneght = word2.length();

        while(currentPointerThroughBoth<word1Lenght||currentPointerThroughBoth<word2Lneght)
        {
            if(word1pointer<word1Lenght)
            {
                stringBuilder.append(word1.charAt(currentPointerThroughBoth));
                word1pointer++;
            }
            if(word2pointer<word2Lneght)
            {
                stringBuilder.append(word2.charAt(currentPointerThroughBoth));
                word2pointer++;
            }
            currentPointerThroughBoth++;

        }

        return stringBuilder.toString();
    }
}





//1
//1,2,3,4
//get 2*3*4
//store


//nums = [1,12,-5,-6,50,3], k = 4
//Output: 12.75000
//Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
//Example 2:


//[-6,-5,1,3,12,50]
//sum of values / k

