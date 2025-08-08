package org.example;

import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //exercise 1: A simple lambda expression

        //result prediction: "short", false, "This is a very long string", true
        //actual result: 'short', false, 'This is a very long string', true

//        Predicate<String> isLong = s -> s.length() > 10;
//
//        String str1 = "short";
//        String str2 = "This is a very long string";
//
//        System.out.println("Is '" + str1 + "' long? " + isLong.test(str1));
//        System.out.println("Is '" + str2 + "' long? " + isLong.test(str2));

        //explanation: This makes use of a predicate to test whether a string is more than 10 characters
        // expressed through a simple lambda function. Predicate makes use of its single method, .test()
        // to return true or false given the lambda expression.

        //exercise 2: Using Predicates to Filter a List

        //result prediction: "Alpha", "Archangel", "Avengers"
        //actual result: "Alpha", "Archangel", "Avengers"
//        List <String> callSigns = new ArrayList<>();
//
//        callSigns.add("Alpha");
//        callSigns.add("Bravo");
//        callSigns.add("Archangel");
//        callSigns.add("Echo");
//        callSigns.add("Avengers");
//
//        Predicate<String> startsWithA = s -> s.startsWith("A");
//
//        filterAndPrint(callSigns, startsWithA, "Call signs starting with 'A'");

        //explanation: Using a predicate expression, we were able to use it as a condition for the if statement, acting
        //as a filter as the for-loop iterates over the ArrayList.

        //exercise 3: Chaining Predicates

        //result prediction: "Archangel", "Avenger", "Bravo", "Echo"
        //actual result: "Archangel", "Avenger", "Bravo", "Echo"

        List<String> callSigns = new ArrayList<>();
        callSigns.add("Alpha");
        callSigns.add("Bravo");
        callSigns.add("Archangel");
        callSigns.add("Echo");
        callSigns.add("Avenger");

        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> hasLengthGreaterThan5 = s -> s.length() > 5;

        Predicate<String> complexCondition = startsWithA.and(hasLengthGreaterThan5);
        filterAndPrint(callSigns, complexCondition, "Starts with 'A' AND length > 5");

        Predicate<String> doesNotStartWithA = startsWithA.negate();
        filterAndPrint(callSigns, doesNotStartWithA, "Does NOT start with 'A'");

        //explanation: For the first method call, we created a predicate chain using the .and() method wherein
        //the predicate expression had two expressions that filters out the iterated list. This shows how we use
        //predicate expression to make more specific filters for our data. In the second method call, it is a single
        //predicate expression but this time it does the oppositive of the original startsWithA expression using
        //.negate()

    }
    public static void filterAndPrint(List<String> list, Predicate<String> predicate, String description){
        System.out.println("--- " + description + " ---");
        for (String item : list) {
            if(predicate.test(item)) {
                System.out.println(item);
            }
        }
        System.out.println();
    }
}