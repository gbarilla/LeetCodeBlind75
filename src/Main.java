import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //MoveZeroes();
        //kidsWithCandies();
        //twoWordPermutation();



        System.out.println(reverseVowels("IceCream"));
        String input ="Mr John    Smith     ";
        int trueLenght = 17;
        System.out.println(replaceWhitespace(input,trueLenght));


        //151. Reverse Words in a String
        //expected output = blue is sky the
        String phrase ="the sky is blue";

        //expected output = world hello
        String phrase2 = "  hello world  ";

        System.out.println(reverseWords(phrase2));



        //238. Product of Array Except Self
        //expected Output: [24,12,8,6]
        int[] nums = {1,2,3,4};

        //expected Output: [0,0,9,0,0]
        int[] nums2 = {-1,1,0,-3,3};

        for(int i : productExceptSelf(nums2))
        {
            System.out.println(i);
        }







        //643. Maximum Average Subarray I
        //Input: nums = [1,12,-5,-6,50,3], k = 4
        //Output: 12.75000
        int[] example1 = {1,12,-5,-6,50,3};
        int[] exampleTry = {1,2,3,4,5,6};
        int k = 4;
        System.out.println(findMaxAverage(exampleTry,k));





        String str1 =  "ABC";
        String str2 =  "ABCABC";

        var test2 = gcdOfStrings(str1,str2);
        System.out.println(test2);


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

        ArrayList<String> result =  get_robots(all_parts,required_parts_1);
        for(String s : result)
        {
            System.out.println(s);
        }

    }

    public static void MoveZeroes()
    {
        int[] nums = {0, 1, 0, 3, 12};
        LeetCodeProblems.MoveZeroes(nums);
    }

    public static void kidsWithCandies()
    {

        int[] candies = {4,2,1,1,2};
        int extraCandies = 1;
        var test = LeetCodeProblems.kidsWithCandies(candies,extraCandies);
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


    public static String gcdOfStrings(String str1, String str2) {
        ArrayList<Character> result = new ArrayList<>();

        int currentIndexforNextWord = 0;

        for(int index = 0; index < str1.length()&&index < str2.length();index++)
        {
            Character currentStr1Value=' ';
            Character currentStr2Value=' ';


            if(index < str1.length())
            {
                currentStr1Value = str1.charAt(index);
            }
            if(index < str2.length())
            {
                currentStr2Value = str2.charAt(index);
            }

            if(currentStr1Value == currentStr2Value)
            {
                result.add(currentStr1Value);
            }


            if(index > str1.length())
            {

            }


        }

        return "";
        
    }





    public static String reverseVowels(String s) {
        if(s.isEmpty())
        {
            return "";
        }
        else if(s.length()==1)
        {
            return s;
        }
        else
        {
            ArrayList<Character> reverseVowels = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            Set<Character> vowel = new HashSet<>();
            vowel.add('a');
            vowel.add('e');
            vowel.add('i');
            vowel.add('o');
            vowel.add('u');
            vowel.add('A');
            vowel.add('E');
            vowel.add('I');
            vowel.add('O');
            vowel.add('U');
            if(s.isEmpty())
            {
                return "";
            }
            else if(s.length() ==1)
            {
                return s;
            }
            else {
                for(int x = s.length()-1; x>-1;x--)
                {
                    if(vowel.contains(s.charAt(x)))
                    {
                        reverseVowels.add(s.charAt(x));
                    }
                }
            }

            int vowelCounter = 0;
            for(int indexThoughWord = 0; indexThoughWord<s.length();indexThoughWord++)
            {
                if(vowel.contains(s.charAt(indexThoughWord)))
                {
                    builder.append(reverseVowels.get(vowelCounter));
                    vowelCounter++;
                }
                else {
                    builder.append(s.charAt(indexThoughWord));
                }
            }

            return builder.toString();
        }
    }


    public static String replaceWhitespace(String input,int trueLenght)
    {
        String wordWithWhitespace = input;
        String wordWithoutWhitespaces;
        StringBuilder builder = new StringBuilder();
        String replace = "%20";
        ArrayList<Integer> batchFound = new ArrayList<>();

        for(int wordIndex = 0; wordIndex < trueLenght; wordIndex++)
        {
            char currentletter = input.charAt(wordIndex);
            if(currentletter==' ') {
                batchFound.add(wordIndex);
                System.out.println("whitespace found at index: "+wordIndex);
                builder.append(replace);
            }
            else {
                builder.append(currentletter);
                System.out.println("Current batch to clear");
                for(int index : batchFound)
                {
                    System.out.println("Clearing this batch: index at :"+index);
                }
                batchFound.clear();
            }
        }
        return builder.toString();
    }


    public static String reverseWords(String s) {
        String[] wordArray = s.split(" ");
        StringBuilder builder = new StringBuilder();
        ArrayList<String> wordArrayWithoutSpaces = new ArrayList<>();
        String space = " ";

        for(int currentIndex = 0; currentIndex< wordArray.length ; currentIndex++)
        {
            if(!wordArray[currentIndex].isEmpty())
            {
                wordArrayWithoutSpaces.add(wordArray[currentIndex]);
            }
        }

        for(int reverseIndex = wordArrayWithoutSpaces.size()-1; reverseIndex >= 0; reverseIndex--)
        {
            builder.append(wordArrayWithoutSpaces.get(reverseIndex));
            if(reverseIndex != 0)
            {
                builder.append(space);
            }
        }

        return builder.toString();

    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] leftSide = new int[nums.length];
        int[] rightSide = new int[nums.length];

        int rollingvalue = 1;
        //get all to the left of this index
        for(int currentIndex =0; currentIndex < nums.length; currentIndex ++)
        {
            leftSide[currentIndex] = rollingvalue;
            rollingvalue = rollingvalue*nums[currentIndex];
        }

        int currentIndex = 0;
        int rollingReverseValue = 1;
        for(int reverseIndex = nums.length-1 ; reverseIndex >= 0; reverseIndex--)
        {
            rightSide[reverseIndex] = rollingReverseValue;
            rollingReverseValue = rollingReverseValue*nums[reverseIndex];
        }

        for(int i =0; i < nums.length;i++)
        {
            result[i] = leftSide[i]*rightSide[i];
        }



        return result;


    }

    public static double findMaxAverage(int[] nums, int k) {


        int windowSize = k;
        //int startIndexForWindow = 0;
        //int endIndexForWindow = k;

        //1+2+3+4

        //1+2+3+4+5-1

        //1+2+3+4+5+6-1-2

        ArrayList<Integer> store = new ArrayList<>();

        int sum = 0;
        for(int index = 0; index<nums.length+1;index++)
        {
            int end = k;
            if(index<end)
            {
                sum = sum+nums[index];
            }


        }

        return 1.2;

    }

    public static ArrayList<String> get_robots(String[] all_parts, String required_parts)
    {
        HashMap<String,Set<String>> robotParts = new HashMap<String,Set<String>>();
        String[] allRequiredParts = required_parts.split(",");
        for(String currentAllPartString : all_parts)
        {
            //TODO:more check
            String[] split = currentAllPartString.split("_");
            //[Rosie][Claw];
            if(!robotParts.containsKey(split[0]))
            {
                Set<String> parts = new HashSet<>();
                parts.add(split[1]);
                robotParts.put(split[0],parts);
            }
            else
            {
                Set<String> currentListOfParts = robotParts.get(split[0]);
                currentListOfParts.add(split[1]);
                robotParts.put(split[0],currentListOfParts);
            }


            //TODO: after storing check from iterating though the required_parts_1 to check what is returned incrementally
        }

        Set<String> allRobotNames = robotParts.keySet();
        ArrayList<String> result = new ArrayList<>();

        for(String robotName : allRobotNames)
        {
            Set<String> robotPart = robotParts.get(robotName);
            Boolean isCompatible = true;
            for(int index = 0; index<allRequiredParts.length;index++)
            {
                String requiredPart = allRequiredParts[index];
                if(!robotPart.contains(requiredPart))
                {
                    isCompatible=false;
                }
            }
            if(isCompatible)
            {
                result.add(robotName);
            }
        }
        return result;



    }

    //Iterate though all parts once
    //key = name
    //value = arraylist string
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

