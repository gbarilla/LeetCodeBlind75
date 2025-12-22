import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class UtilsTemplates {

    public static <T,R> void display(T input, Function<T,R> algorithm)
    {
        R result = algorithm.apply(input);
        System.out.println("The string: "+input+" is "+result);
    }

    public static <T,R> void displayWithName(T input, Function<T,R> algorithm,String name)
    {
        R result = algorithm.apply(input);
        System.out.println("Currently Running: "+name);
        System.out.println("The string: "+input+" is "+result);
    }

    public static <R> void displayArray(int[] input,Function<int[],R> algorithm,String name)
    {
        StringBuilder inputString = new StringBuilder();
        for(int i : input)
        {
            inputString.append(i);
            inputString.append(",");
        }
        R result = algorithm.apply(input);
        System.out.println("Currently Running: "+name);
        System.out.println("The string: "+inputString.toString()+" is "+result);
    }

}
