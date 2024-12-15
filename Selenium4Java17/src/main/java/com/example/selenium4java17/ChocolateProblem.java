package com.example.selenium4java17;

import java.util.*;

public class ChocolateProblem {

    public static int minTotalWeight(int[] weights, int d) {
        int n = weights.length;

        // Create a priority queue to store the weights of chocolates
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int weight : weights) {
            pq.offer(weight);
        }

        // Iterate for d days
        for (int i = 0; i < d; i++) {
            // Remove the chocolate with the maximum weight
            int maxWeight = pq.poll();

            // Calculate the weight of the remaining half
            int remainingWeight = maxWeight / 2;

            // Add the remaining weight back to the priority queue
            pq.offer(remainingWeight);
        }

        // Calculate the total weight of the remaining chocolates
        int totalWeight = 0;
        while (!pq.isEmpty()) {
            totalWeight += pq.poll();
        }

        return totalWeight;
    }

//    public static void main(String[] args) {
//        int[] weights = {2, 1, 4};
//        int d = 2;
//        int result = minTotalWeight(weights, d);
//        System.out.println("Minimum total weight: " + result);
//    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static void main(String[] args)
    {

        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        // enter data into hashmap
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        Map<String, Integer> hm1 = sortByValue(hm);

        // print the sorted hashmap
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println("Key = " + en.getKey() +
                    ", Value = " + en.getValue());
        }
    }
}
