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
        for(int n : nums)
        {
            System.out.println(n);
        }
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        int maxNumber = 0;
        for (int candy : candies) {
            if (maxNumber < candy) {
                maxNumber = candy;
            }
        }
        for (int candy : candies) {
            if (candy + extraCandies >= maxNumber) {
                result.add(true);
            } else {
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
        if(word1Lenght != word2Lenght || word1.isEmpty())
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
            for(int x = s.length()-1; x>-1;x--)
            {
                if(vowel.contains(s.charAt(x)))
                {
                    reverseVowels.add(s.charAt(x));
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

    public static String replaceWhitespace(String baseInput,int trueLenght)
    {
        //String input ="Mr John    Smith BBBBB    ";
        //int trueLenght = 17;
        String input = baseInput.trim();
        String specialCharacter = "%20";
        StringBuilder builder = new StringBuilder();
        int counter = 0;
        for(int inputIndex = 0; inputIndex < trueLenght;inputIndex++)
        {
            counter++;
            if(input.charAt(inputIndex)==' ')
            {
                //check if list is populated
                if(input.charAt(inputIndex - 1) != ' ')
                {
                    builder.append(specialCharacter);
                }
            }
            else
            {
                builder.append(input.charAt(inputIndex));
            }
        }
        System.out.println("This app ran a max of: "+counter+" times");
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

        for (String value : wordArray) {
            if (!value.isEmpty()) {
                wordArrayWithoutSpaces.add(value);
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


        //int startIndexForWindow = 0;
        //int endIndexForWindow = k;

        //1+2+3+4

        //1+2+3+4+5-1

        //1+2+3+4+5+6-1-2

        ArrayList<Integer> store = new ArrayList<>();

        int sum = 0;
        for(int index = 0; index<nums.length+1;index++)
        {
            if(index< k)
            {
                sum = sum+nums[index];
            }


        }

        return 1.2;

    }

    public static String gcdOfStrings(String str1, String str2) {
        ArrayList<Character> result = new ArrayList<>();

        int currentIndexforNextWord = 0;


        return "";

    }

    public static ArrayList<String> get_robots(String[] all_parts, String required_parts)
    {
        HashMap<String,Set<String>> robotParts = new HashMap<>();
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
            boolean isCompatible = true;
            for (String requiredPart : allRequiredParts) {
                if (!robotPart.contains(requiredPart)) {
                    isCompatible = false;
                    break;
                }
            }
            if(isCompatible)
            {
                result.add(robotName);
            }
        }
        return result;
    }

    public static int maxVowels(String s, int k) {
        System.out.println(s);
        System.out.println(k);
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int currentMax = 0;
        int windowStartIndex = 0;
        StringBuilder builder = new StringBuilder();
        int isFirstVowel = 0;

        int counter = 0;
        int numberOfVowels = 0;

        //we dont want to track the window. we want to track the rolling result.
        for(int indexForFirstWindow = windowStartIndex; indexForFirstWindow < k; indexForFirstWindow++)
        {
            counter++;
            if(vowels.contains(s.charAt(indexForFirstWindow)))
            {
                numberOfVowels++;
            }
        }
        //ill have the result of the first one;

        for(int currentIndex = k; currentIndex<s.length(); currentIndex++)
        {
            counter++;
            if(currentMax<numberOfVowels)
            {
                currentMax = numberOfVowels;
            }
            if(vowels.contains(s.charAt(windowStartIndex)))
            {
                numberOfVowels = numberOfVowels - 1;
            }
            if(vowels.contains(s.charAt(currentIndex)))
            {
                numberOfVowels = numberOfVowels + 1;
            }
            if(numberOfVowels == k )
            {
                System.out.println("THIS HAS RUN: "+counter+" times");
                return numberOfVowels;
            }
            windowStartIndex++;
        }

        System.out.println("THIS HAS RUN: "+counter+" times");
        return currentMax;
    }

    public static ArrayList<Integer[]> calculateGrinderSettings(int innerburSetting, int outerBurSetting)
    {
        int innerBurMaxShifts = 8;
        int outerBurMaxShifts = 16;
        int estimatedShiftEquivalent = 3;
        ArrayList<ArrayList<Integer>> allsettings = new ArrayList<>();

        //5+6-1=10

        ArrayList<Integer> firstWindow = new ArrayList<>();
        for(int i =1; i < outerBurMaxShifts+1; i++)
        {
            firstWindow.add(i);
        }
        allsettings.add(firstWindow);

        for(int round = 1; round < innerBurMaxShifts;round++)
        {
            ArrayList<Integer> nextWindow = new ArrayList<>();
            ArrayList<Integer> pastWindow = allsettings.get(round-1);
            for(Integer value :pastWindow)
            {
                nextWindow.add(value+estimatedShiftEquivalent);
            }
            allsettings.add(nextWindow);
        }

        int value = allsettings.get(innerburSetting).get(outerBurSetting);
        ArrayList<Integer[]> result = new ArrayList<>();

        for(int currentRound = innerburSetting-1; currentRound>0;currentRound--)
        {
            var currentSettingsList = allsettings.get(currentRound);
            for(int indexOfValue = 0; indexOfValue<currentSettingsList.size();indexOfValue++)
            {
                int currentValue = currentSettingsList.get(indexOfValue);
                if(currentValue==value)
                {
                    result.add(compatableSettings(currentRound,indexOfValue));
                }
            }
        }

        return result;

    }

    private static Integer[] compatableSettings(int innerSetting, int outerSetting)
    {
        Integer[] result = {innerSetting,outerSetting};
        return result;
    }
}
