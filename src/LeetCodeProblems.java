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
        //System.out.println(s);
        //System.out.println(k);
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int countOfCurrentWindow = 0;
        int maxCount = 0;

        for(int i = 0; i < k ; i++)
        {
            Character currentLetter = s.charAt(i);
            if(vowels.contains(s.charAt(i)))
            {
                countOfCurrentWindow++;
            }
        }

        for(int windowEnd = k; windowEnd < s.length();windowEnd++)
        {
            //System.out.println("The window is currently at:" + (windowEnd-k));
            //System.out.println("The window is currently at:" + (windowEnd));

            int currentCount = countOfCurrentWindow;

            if(countOfCurrentWindow > maxCount)
            {
                maxCount = countOfCurrentWindow;
            }

            Character letterToAdd = s.charAt(windowEnd);
            if(vowels.contains(letterToAdd))
            {
                countOfCurrentWindow++;
            }
            Character letterToRemove = s.charAt(windowEnd-k);
            if(vowels.contains(letterToRemove))
            {
                countOfCurrentWindow--;
            }
        }

        if(countOfCurrentWindow > maxCount)
        {
            maxCount = countOfCurrentWindow;
        }

        return maxCount;
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


    public static boolean isSubsequence(String sequence, String input) {
        if(sequence.isEmpty())
        {
            return true;
        }

        int indexOfSequence = 0;
        int lenghtOfAllCharacterInSequence = sequence.length();
        char currentLetterToCompareFromSequence = sequence.charAt(indexOfSequence);

        char[] inputCharacters = input.toCharArray();
        for(Character currentCharacter: inputCharacters)
        {
            if(currentCharacter == currentLetterToCompareFromSequence)
            {
                indexOfSequence++;
                if(indexOfSequence < lenghtOfAllCharacterInSequence)
                {
                    currentLetterToCompareFromSequence = sequence.charAt(indexOfSequence);
                }
            }
        }

        return indexOfSequence == lenghtOfAllCharacterInSequence;
    }

    public static int largestAltitude(int[] gain) {
        // {-5,1,5,0,-7};
        // 0 -5 , -4 , 1 , 1 , -6
        //[0,-5,-4,1,1,-6]
        int largestAltitude = 0;
        int currentDifference = 0;
        //int difference = trail.get(index) + gain[index];

        for(int value : gain)
        {
            if(currentDifference > largestAltitude)
            {
                largestAltitude = currentDifference;
            }
            currentDifference = currentDifference + value;
        }

        return largestAltitude;
    }

    public static void headTalesGame()
    {
        int[] s0 = {0,0,0};
        int[] s1 = {0,0,1};
        int[] s2 = {0,1,0};
        int[] s3 = {0,1,1};
        int[] s4 = {1,0,0};
        int[] s5 = {1,0,1};
        int[] s6 = {1,1,0};
        int[] s7 = {1,1,1};

        ArrayList<Integer> games = new ArrayList<>();

        int numberOfItemsInSequence = 3;


        int numberOfGames = 100;

        //Penney’s ante

        int[] currentWindow = {0,0,0};

        int timesPlayer1Won = 0;
        int timesPlayer2Won = 0;

        int startingIndex = 0;


        for(int i = 0; i<numberOfGames;i++)
        {
            double value = Math.random();
            int side = 0;
            if(value>0.5)
            {
                side = 1;
            }

            games.add(side);
            if(i>=2)
            {
                if(games.get(startingIndex)==s0[0])
                {
                    if(games.get(startingIndex+1)==s0[1])
                    {
                        if(games.get(startingIndex+2)==s0[2])
                        {
                            timesPlayer1Won++;
                        }
                    }
                }
                if(games.get(startingIndex)==s4[0])
                {
                    if(games.get(startingIndex+1)==s4[1])
                    {
                        if(games.get(startingIndex+2)==s4[2])
                        {
                            timesPlayer2Won++;
                        }
                    }
                }
                startingIndex++;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append("Player 1 has won a total of: ");
        builder.append(timesPlayer1Won);
        builder.append(" times. With a percentage of: ");
        int totalNumberOfGames = timesPlayer1Won + timesPlayer2Won;
        double percentWon1 = (double)timesPlayer1Won/totalNumberOfGames;
        builder.append(percentWon1);
        System.out.println(builder.toString());

        StringBuilder builder2 = new StringBuilder();
        builder2.append("Player 2 has won a total of: ");
        builder2.append(timesPlayer2Won);
        builder2.append(" times. With a percentage of: ");
        double percentWon2 = (double)timesPlayer2Won/totalNumberOfGames;
        builder2.append(percentWon2);
        System.out.println(builder2.toString());

    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> unique1 = new HashSet<>();
        Set<Integer> unique2 = new HashSet<>();
        for(int value: nums1)
        {
            unique1.add(value);
        }

        for(int value: nums2)
        {
            unique2.add(value);
        }

        ArrayList<Integer> unique1Array = new ArrayList<>();
        for(int value : unique1)
        {
            if(!unique2.contains(value))
            {
                unique1Array.add(value);
            }
        }

        ArrayList<Integer> unique2Array = new ArrayList<>();
        for(int value : unique2)
        {
            if(!unique1.contains(value))
            {
                unique2Array.add(value);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(unique1Array);
        result.add(unique2Array);

        return result;


    }

    public static boolean uniqueOccurrences(int[] arr) {

        boolean result = false;
        HashMap<Integer,Integer> dictionary = new HashMap<>();

        for(int value : arr)
        {
            System.out.println("The currentValue to evaluate is: "+value);
            if(dictionary.containsKey(value))
            {
                int counter = dictionary.get(value);
                counter++;
                dictionary.put(value,counter);
            }
            else
            {
                dictionary.put(value,1);
            }
        }

        Set<Integer> keys = dictionary.keySet();
        Set<Integer> values = new HashSet<>();

        for(int key : keys)
        {
            Integer currentFequence = dictionary.get(key);
            //[3,2,1]
            //[2,2,1]

            if(!values.contains(currentFequence))
            {
                values.add(currentFequence);
            }
            else
            {
                return result;
            }
        }
        result = true;
        return result;
    }

    public static boolean isOneAway(String original, String edited)
    {
        int originalLenght = original.length();
        int editedLenght = edited.length();
        String smallest = edited;
        String largest = original;
        int changeCounter = 0;
        if(originalLenght < editedLenght)
        {
            smallest = original;
            largest = edited;
        }
        int differnce = largest.length() - smallest.length();
        if(differnce>1||largest.length() < 1)
        {
            return false;
        }
        else
        {
            for(int i = 0; i < smallest.length();i++)
            {
                System.out.println("This ran a total of x many tines: "+ i);
                if(changeCounter > 1)
                {
                    return false;
                }
                if(smallest.charAt(i) != largest.charAt(i))
                {
                    changeCounter++;
                }
            }
            return true;
        }
    }

    public static String stringCompresssion(String input)
    {
        StringBuilder builder = new StringBuilder();
        Character currentLetter = input.charAt(0);
        int currentCounter = 0;
        int uniqueCounter = 1;
        for(int i = 0 ; i < input.length();i++)
        {
            if(currentLetter == input.charAt(i))
            {
                currentCounter++;
            }
            else
            {
                uniqueCounter++;
                builder.append(currentLetter);
                builder.append(currentCounter);
                currentCounter = 1;
                currentLetter = input.charAt(i);
            }
        }
        builder.append(currentLetter);
        builder.append(currentCounter);

        if(builder.length() < input.length())
        {
            return builder.toString();
        }
        else
        {
            return input;
        }
    }

    public static int longestConsecutive(int[] nums) {
        int largestConsecutiveOrder = 0;
        if(nums.length==0)
        {
            return 0;
        }
        int previousValue  = nums[0];
        if(nums.length == 1)
        {
            return 1;
        }
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        previousValue = sorted[0];
        int currentLargest = 1;
        for(int i =1; i < sorted.length;i++)
        {
            if(currentLargest > largestConsecutiveOrder)
            {
                largestConsecutiveOrder = currentLargest;
            }
            int currentValue = sorted[i];
            int difference = Math.abs(currentValue-previousValue);
            if(difference==1)
            {
                currentLargest++;
                previousValue = sorted[i];
            }
            else if(difference==0)
            {
                previousValue = sorted[i];
            }
            else {
                currentLargest = 1;
                previousValue = sorted[i];
            }
        }
        if(currentLargest > largestConsecutiveOrder)
        {
            largestConsecutiveOrder = currentLargest;
        }

        return largestConsecutiveOrder;
    }

    public static int revisedLongestConsecutive(int[] nums)
    {
        Set<Integer> removeDuplicates = new HashSet<>();
        if(nums.length==0)
        {
            return 0;
        }
        if(nums.length == 1)
        {
            return 1;
        }
        for(int values:nums)
        {
            removeDuplicates.add(values);
        }

        int maxlenght = 0;

        for( int currentValue : removeDuplicates)
        {
            if(!removeDuplicates.contains(currentValue-1))//What is your starting condition. Attempt to build and check possibilitys while going forward,
            {
                int currentNum = currentValue;
                int currentLenght = 1;

                while(removeDuplicates.contains(currentNum+1))
                {
                    currentNum++;
                    currentLenght++;
                }

                maxlenght = Math.max(maxlenght,currentLenght);
            }
        }
        return maxlenght;
    }

    public static int coinChange(int[] coins, int amount) {
        int currentCounter = 1;
        if(amount == 0)
        {
            return 0;
        }
        Set uniqueCoins = new HashSet();
        for(int coin : coins)
        {
            uniqueCoins.add(coin);
        }
        int[] sorted = Arrays.stream(coins).sorted().toArray();

        int currentValue = sorted[sorted.length-1];
        for(int i = sorted.length-1; i >=1; i--)
        {
            int remainder = amount%currentValue;
            if(uniqueCoins.contains(remainder))
            {
                return ((amount-remainder)/currentValue)/currentCounter+1;
            }
            if(remainder == 0)
            {
                return ((amount-remainder)/currentValue)/currentCounter;
            }
            else {
                currentValue = currentValue+sorted[i-1];
                currentCounter++;

            }
        }
        return currentCounter;
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int[] sortedArray = Arrays.stream(arr).sorted().toArray();

        if(arr.length==0)
        {
            return result;
        }
        if(arr.length==1)
        {
            return result;
        }
        if(arr.length==2)
        {
            List<Integer> firstpair = new ArrayList<>();
            firstpair.add(arr[0]);
            firstpair.add(arr[1]);
            result.add(firstpair);
            return result;
        }

        int a = sortedArray[0];
        int b = sortedArray[1];

        int firstDistance = b-a;
        int minimumDistance = firstDistance;

        for(int i =1; i < sortedArray.length;i++)
        {
            a = sortedArray[i-1];
            b = sortedArray[i];

            firstDistance = b-a;
            if(firstDistance < minimumDistance)
            {
                minimumDistance = firstDistance;
            }
        }

        for(int i =1; i < sortedArray.length;i++)
        {
            a = sortedArray[i-1];
            b = sortedArray[i];

            firstDistance = b-a;
            if(firstDistance == minimumDistance)
            {
                List<Integer> pair = new ArrayList<>();
                pair.add(a);
                pair.add(b);
                result.add(pair);
            }
        }

        return result;
    }
    public static List<String> fizzBuzz(int input)
    {
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= input;i++)
        {

            if(i%3==0&&i%5==0)
            {
                result.add("FizzBuzz");
            }
            else if(i%5==0)
            {
                result.add("Buzz");
            }
            else if(i%3==0)
            {
                result.add("Fizz");
            }
            else
            {
                result.add(""+i);
            }
        }

        return result;
    }

    public static int lastStoneWeight(int[] stones) {
        int result = 0;
        PriorityQueue<Integer> maxTop = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones)
        {
            maxTop.add(stone);
        }

        while(maxTop.size()!=1)
        {
            int largest = maxTop.poll();
            int secondLargest = maxTop.poll();
            int difference = largest-secondLargest;
            maxTop.add(difference);
        }

        return maxTop.peek();
    }

}
