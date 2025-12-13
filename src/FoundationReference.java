import java.util.*;

public class FoundationReference {

    public static List<String> listOfMajorClasses()
    {
        String lists = "List<Integer>";
        String linkedList = "LinkedList<>()";
        String hashMap = "Map<T>,HashMap<>()";
        String set = "Set<T>,HashSet<>()";
        String stack = "Stack<T>";
        String queue = "Queue<T>,LinkedList<>()";
        String priorityQueue = "PriorityQueue<>()";
        String deque = "Deque<T>,ArrayDeque<>()";
        String TreeMap = "TreeMap<T>";
        String TreeSet = "TreeSet<T>";
        String linkedHashMap = "LinkedHashMap<>()";
        String linkedHashSet = "LinkedHashSet()";

        List<String> result = new ArrayList<>();
        result.add(lists);
        result.add(linkedList);
        result.add(hashMap);
        result.add(set);
        result.add(stack);
        result.add(queue);
        result.add(priorityQueue);
        result.add(deque);
        result.add(TreeMap);
        result.add(TreeSet);
        result.add(linkedHashMap);
        result.add(linkedHashSet);

        return result;
    }

    public static List<String> implementallFeaturesOfList()
    {
        List<String> listImplementation = new ArrayList<>();
        listImplementation.add("First Element");
        listImplementation.add("Second Element");
        listImplementation.add(1,"Update Second Element when you add(index,value)");
        listImplementation.add(1,"Update Second Element Again");
        listImplementation.add(1,"Notice the Shift at this index as the array expands");
        int indexOfSecondElement = 1;
        StringBuilder builder = new StringBuilder();
        builder.append("The element at the current index of : ");
        builder.append(indexOfSecondElement);
        builder.append(" is: ");
        builder.append(listImplementation.get(indexOfSecondElement));
        System.out.println(builder.toString());
        System.out.println("To get the size you use .size(): "+listImplementation.size());
        listImplementation.set(1,"TRUE UPDATE NOT A SHIFT when using .set()");
        System.out.println("You can find if its empty using the .isEmpty() "+listImplementation.isEmpty());
        System.out.println("Similar to a set you can check if it .contains(First Element) "+listImplementation.contains("First Element"));
        return listImplementation;
    }

    public static void priorityQueueCheatSheet()
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //How to do inline insert into a queue
        PriorityQueue<Integer> example = new PriorityQueue<>(Arrays.asList(5,2,8,1));
        PriorityQueue<Integer> customComparator = new PriorityQueue<>((a,b)->Math.abs(a)-Math.abs(b));

        minHeap.offer(5);
        minHeap.offer(2);
        minHeap.offer(8);
        minHeap.offer(1);
        minHeap.offer(10);

        maxHeap.offer(5);
        maxHeap.offer(2);
        maxHeap.offer(8);
        maxHeap.offer(1);
        maxHeap.offer(10);

        System.out.println("Min heap Print");
        for(Integer i : minHeap)
        {
            System.out.println(i);
        }

        System.out.println("Max heap Print");
        for(Integer i : maxHeap)
        {
            System.out.println(i);
        }

    }
}
