package com.tribocode.codingchallenge;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class main {
    public static void main(String[] args) {
        // 1. FIzzBuzz
        // Solution
        // printFizzBuzz(10);

        // 2. Two sum
        // [2, 3, 7, 4, 8] = result is 7
        // output - N[1] + N[3]
//        int[] numbers = new int[] {2, 3, 7, 4, 8};
//        int target = 7;
//        int[] result = getTwoSum(numbers, target);
//        System.out.println(result[0] + " " + result[1]);

//        // LinkList
//        LinkedList list = new LinkedList();
//        list.addLast(10);
//        list.addLast(20);
//        list.addLast(30);
////        list.addFirst(5);
////        list.removeLast();
//        System.out.println(list.contains(10));
//        System.out.println(list.indexOf(10));
//        System.out.println(list.size());
//        System.out.println(list);
//        var array = list.toArray();
//        System.out.println(Arrays.toString(array));

//        // From custom LinkedList
//        LinkedList list = new LinkedList();
//        list.addLast(10);
//        list.addLast(20);
//        list.addLast(30);
//        list.addFirst(5);
//        System.out.println(list.indexOf(5));

        System.out.println(detectCapitalUse("USA"));
        System.out.println(ReverseStringManual("hello"));
        System.out.println(ReverseStringWithStringBuilder("hello"));
    }

    // Code challenge: 1
    // FizzBuzz
    private static void printFizzBuzz(int number) {
        for (int i = 0; i <= number; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    private static int[] getTwoSum(int[] numbers, int target) {
        Map<Integer, Integer> visitedNumbers = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int delta = target - numbers[i];
            if (visitedNumbers.containsKey(delta)) {
                return new int[]{i, visitedNumbers.get(delta)};
            }
            visitedNumbers.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }

    public static boolean detectCapitalUse(String word) {
//        Solution 1
//        int numberOfCapitals = 0;
//        for (int i = 0; i < word.length(); i++) {
//            if (Character.isUpperCase(word.charAt(i))){
//                numberOfCapitals++;
//            }
//        }
//        if (numberOfCapitals == word.length() || numberOfCapitals ==0 ) return true;
//        return numberOfCapitals == 1 && Character.isUpperCase(word.charAt(0));
//        Best Solution using Lambda
        if (word.length() <= 1) return true;
        Predicate<Character> correctCase = Character::isLowerCase;
        ;
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            correctCase = Character::isUpperCase;
        }
        for (int i = 1; i < word.length(); i++) {
            if (!correctCase.test(word.charAt(i))) return false;
        }

        return true;
    }

    public static String ReverseStringManual(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String ReverseStringWithStringBuilder(String str){
        StringBuilder sb = new StringBuilder(str);
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}

