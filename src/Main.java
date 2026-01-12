import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // MoveZeroes();
        // kidsWithCandies();
        // twoWordPermutation();
        // reverseVowels();
        //replaceWhiteSpaces();
        //reverseWords();
        //productExceptSelf();
        //findMaxAverage();
        //gcdOfStrings();
        //get_robots();
        //getMaximumNumberOfVowels();
        //calculateCommonShifts();
        //identifySequenceInString();
        //largestAltitude();
        //LeetCodeProblems.headTalesGame();
        //uniquenessInArrays();
        //uniqueNumberOfOccurances();
        //oneAway();
        //basicStringCompression();
        //longestConsecutive();
        //coinChange();
        //basicStringCompression();
        //FizzBuzz();
        //lastStoneWeight();
        //minimumAbsDifference();
        //importantClassesToKnow();
        //longestSubstringWithoutRepeating();
        //largestIncreasingSubsequence();
        //interpretRoman();
        //BuySellEffieciently();
        //mustCompleteCopy();
        //understandTrees();
        //implementBinarySearch();
        buySellMaxProfit();
    }

    public static void uniqueTracker()
    {
        int[] input = {1,1,2,2,3};
        UtilsTemplates.displayArray(input,LeetCodeProblems::removeDuplicates,"UniqueCount");
    }

    public static void buySellMaxProfit()
    {
        int[] input = {6,1,3,2,4,7};
        UtilsTemplates.displayArray(input,LeetCodeProblems::maxProfits2,"MaxProfit");
        //int output = LeetCodeProblems.maxProfits2(input);

    }

    public static void implementBinarySearch()
    {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        int inputLenght = nums.length;
        int trueLenght = inputLenght-1;

        int start = 0;
        int end = trueLenght;

        while(start<=end)
        {
            int displacement = start+end;
            int mid = displacement/2;
            int midValue = nums[mid];

            if(target == midValue)
            {
                System.out.println("VALUE FOUND");
            }

            if(target < midValue)
            {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        System.out.println("Value Not Found");
    }

    public static void understandTrees()
    {
        System.out.println("We are here to understand trees");
        System.out.println("Determine interface behavior all trees have nodes:");
        System.out.println("They can have pointers or not on leafs");
        System.out.println("Interface has behavior to see element and left and right pointer");

    }

    public static void decodeString()
    {
        String input = "3[a]2[bc]";
        ArrayList<Character> whatToRepeate = new ArrayList<>();
        for(int i =0;i<input.length();i++)
        {
            Character current = input.charAt(i);
            //if(Integer.getInteger(current))

        }
    }



    public static void mustCompleteCopy()
    {
        String input = "()";
        UtilsTemplates.display(input,LeetCodeProblems::isValid);
    }

    public static void BuySellEffieciently()
    {
        int[] input = {7,1,5,3,6,4};
        UtilsTemplates.displayArray(input,LeetCodeProblems::maxProfit,"Max Profits");
    }

    public static void interpretRoman()
    {
        String input = "IV";
        UtilsTemplates.displayWithName(input,LeetCodeProblems::romanToInt,"ROMAN Converstion");
    }

    public static void displayPriorityQueues()
    {
        PriorityQueue<Integer> test= new PriorityQueue<Integer>();
        test.offer(10);
        test.offer(5);
        test.offer(25);
        test.offer(15);

        System.out.println(test.peek());
        var test2 = test.poll();
        System.out.println(test2);
        System.out.println(test.peek());

        System.out.println("NEWWW HERER REVERSE ORDER");

        PriorityQueue<Integer> test3 = new PriorityQueue<>(Collections.reverseOrder());
        test3.offer(10);
        test3.offer(5);
        test3.offer(25);
        test3.offer(15);

        System.out.println(test3.peek());
        var test4 = test3.poll();
        System.out.println(test4);
        System.out.println(test3.peek());

        Consumer<Integer> lambaTest = (a) -> {
            String fun = a+"HELLO WORLD";
            System.out.println(fun);
        };


        PriorityQueue<Integer> custom = new PriorityQueue<Integer>(
                (a,b)-> a-b
        );
    }

    public static void largestIncreasingSubsequence()
    {
        int[] nums = {10,9,2,5,3,7,101,18};
        UtilsTemplates.displayArray(nums,LeetCodeProblems::largestIncreasingSubSequence,"Largest Growing Subsequence");
    }

    public static void minimumAbsDifference()
    {
        int[] arr = {1,3,6,10,15};
        List<List<Integer>> result = LeetCodeProblems.minimumAbsDifference(arr);
        Consumer<List<List<Integer>>> test = (n) -> System.out.println(n.toString());
        test.accept(result);
    }

    public static void coinChange()
    {
        int[] coins = {1,2,5};
        int amount = 11;
        int result = LeetCodeProblems.coinChange(coins,amount);
        System.out.println(result);
    }

    public static void longestConsecutive()
    {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println("The longest consecutive is: "+LeetCodeProblems.longestConsecutive(nums));
        importantClassesToKnow();
    }

    public static void importantClassesToKnow()
    {
        var allClasses = FoundationReference.listOfMajorClasses();
        Consumer<List<String>> printAll = (n) -> {
            System.out.println(n);
        };
        printAll.accept(allClasses);
        printAll.accept(FoundationReference.implementallFeaturesOfList());
        FoundationReference.priorityQueueCheatSheet();

    }

    public static void lastStoneWeight()
    {
        int[] input = {2,7,4,1,8,1};
        int result = LeetCodeProblems.lastStoneWeight(input);
        System.out.println(result);
    }

    public static void longestSubstringWithoutRepeating()
    {
        String input = "pwwkew";
        int result = LeetCodeProblems.longestSubstringWithoutRepeating(input);
        System.out.println("The longest is: "+result);
    }

    public static void FizzBuzz()
    {
        int input = 15;
        List<String> result = LeetCodeProblems.fizzBuzz(input);
        Consumer<List<String>> printer = (n) -> {
            System.out.println(n);
        };
        printer.accept(result);
    }

    public static void basicStringCompression()
    {
        String input = "aabcdefghij";
        String result = LeetCodeProblems.stringCompresssion(input);
        System.out.println(result);
    }

    public static void oneAway()
    {
        String orignal = "HELLO00000";
        String revised = "HASLO00000";
        boolean result  = LeetCodeProblems.isOneAway(orignal,revised);

        if(result)
        {
            System.out.println("This combination is one edit way");
        }
        else
        {
            System.out.println("This combination is NNNNOOOTTTT one edit away");
        }
    }

    public static void uniqueNumberOfOccurances()
    {
        /*
        1207. Unique Number of Occurrences
        Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

        Example 1:

        Input: arr = [1,2,2,1,1,3]
        Output: true
        Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
        Example 2:

        Input: arr = [1,2]
        Output: false

         */
        int[] arr = {1,2,2,1,1,3};
        boolean result = LeetCodeProblems.uniqueOccurrences(arr);

        if(result)
        {
            System.out.println("This has unique occurances");
        }
        else
        {
            System.out.println("This frequency repeats ");
        }

    }

    public static void uniquenessInArrays()
    {
        //int[] nums1 = new int[0]; - Same thing essentially since you are just
        //int[] nums2 = {}; declaring a empty fixed array unlike the arrayList

        /*
            2215. Find the Difference of Two Arrays
            Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

            answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
            answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
            Note that the integers in the lists may be returned in any order.
         */

        /*
            Input: nums1 = [1,2,3], nums2 = [2,4,6]
            Output: [[1,3],[4,6]]
         */


        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        LeetCodeProblems.findDifference(nums1,nums2);
    }

    public static void identifySequenceInString()
    {

        /*
        392. Is Subsequence
        Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
        A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
        Example 1:
        Input: s = "abc", t = "ahbgdc"
        Output: true
        Example 2:

        Input: s = "axc", t = "ahbgdc"
        Output: false
         */

        String sequence, input;
        sequence = "abc";
        input = "ahbgdc";
        System.out.println(LeetCodeProblems.isSubsequence(sequence,input));
    }


    public static void calculateCommonShifts()
    {
        int innerGear = 3;
        int outerGear = 5;
        var result = LeetCodeProblems.calculateGrinderSettings(innerGear,outerGear);
        for(var row : result)
        {
            System.out.println(row.toString());
        }
    }


    private static void getMaximumNumberOfVowels()
    {
        // 1456. Maximum Number of Vowels in a Substring of Given Length
        //Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
        //
        //Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

        /*
        Example 1:
        Input: s = "abciiidef", k = 3
        Output: 3
        Explanation: The substring "iii" contains 3 vowel letters.
        Example 2:

        Input: s = "aeiou", k = 2
        Output: 2
        Explanation: Any substring of length 2 contains 2 vowels.
        Example 3:

        Input: s = "leetcode", k = 3
        Output: 2
        Explanation: "lee", "eet" and "ode" contain 2 vowels.
         */

        String input1 = "abciiidef";
        int k = 3;

        String input2 = "aeiou";
        int k2 = 2;

        String input3="weallloveyou";
        int k4 = 4;
        int k7 = 7;

        String input4="tryhard";

        System.out.println(LeetCodeProblems.maxVowels(input3,k7));
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
        int[] example2 = {1,2,3,4,5,6};
        //int[] exampleTry = {8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891};
        int[] try2 = {-1};

        int[] failedCase = {};
        int k = 3;
        System.out.println(LeetCodeProblems.findMaxAverage(example2,k));
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

        System.out.println(LeetCodeProblems.reverseWords(phrase));
    }

    public static void MoveZeroes()
    {
        int[] nums = {0, 1, 0, 3, 12};
        LeetCodeProblems.MoveZeroes(nums);
    }

    public static void reverseVowels()
    {
        System.out.println(LeetCodeProblems.reverseVowels("FarekIy"));
    }

    public static void kidsWithCandies()
    {

        int[] candies = {4,2,3,5,2};
        int extraCandies = 1;
        var test = LeetCodeProblems.kidsWithCandies(candies,extraCandies);
        for(var i : test)
        {
            System.out.println(i);
        }
    }

    public static void replaceWhiteSpaces()
    {
        String input ="M  r Jo h  n Smith   ";
        String input2 = "Mr John    Smith BBBBB";
        int trueLenght = 17;
        System.out.println(LeetCodeProblems.replaceWhitespace(input2,trueLenght));
    }

    public static void twoWordPermutation()
    {
        String word1 = "ABCA";
        String word2 = "AABCA";

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

    public static void largestAltitude() {
        int[] gain = {-5,1,5,0,-7};
        int[] gain2 = {-4,-3,-2,-1,4,3,2};
        int result = LeetCodeProblems.largestAltitude(gain2);
        System.out.println(result);
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

