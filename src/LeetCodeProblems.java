import java.util.*;

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

    public static boolean determineIfTwoWordsArePermutations(String word1,String word2)
    {
        boolean result = false;
        HashMap<Character, Integer> dictionary = new HashMap<>();
        int frequency = 1;
        int word1Lenght = word1.length();
        int word2Lenght = word2.length();
        if(word1Lenght != word2Lenght || word1.isEmpty()|| word2.isEmpty())
        {
            return result;
        }
        else {
            for(int indexthoughtWord1 = 0; indexthoughtWord1 < word1Lenght;indexthoughtWord1++)
            {
                if(!dictionary.containsKey(word1.charAt(indexthoughtWord1)))
                {
                    dictionary.put(word1.charAt(indexthoughtWord1),frequency);
                }
                else {
                    Integer value = dictionary.get(word1.charAt(indexthoughtWord1));
                    value++;
                    dictionary.put(word1.charAt(indexthoughtWord1),value);
                }
            }
        }

        result=word2CompareAgainstDictionary(dictionary, word2);
        return result;
    }

    private static boolean word2CompareAgainstDictionary(HashMap<Character, Integer> dictionary,String word2)
    {
        for(int indexThoughWord2 = 0;indexThoughWord2 < word2.length();indexThoughWord2++)
        {
            if(dictionary.containsKey(word2.charAt(indexThoughWord2)))
            {
                Integer currentCountofCharacter = dictionary.get(word2.charAt(indexThoughWord2));
                currentCountofCharacter--;
                dictionary.put(word2.charAt(indexThoughWord2),currentCountofCharacter);
            }
            else {
                return false;
            }
        }

        boolean result = true;

        var allkeys = dictionary.keySet();
        for(Character key : allkeys)
        {
            if(dictionary.get(key)!=0)
            {
                result = false;
            }
        }
        return result;
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
}
