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
}
