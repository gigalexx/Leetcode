package algorithms;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveD {

    public static void main(String[] args) {

        // String input = "Ab9raCad341AdBraA3lak2Az44am";

        //  System.out.println(removeD(input));


        Scanner scan = new Scanner(System.in);

        long upperBound = Long.parseLong(scan.next().trim());

        HashSet<Long> set = new HashSet<>();

        while (scan.hasNext()) {
            set.add(Long.parseLong(scan.next().trim()));
        }
        for (Long number = 0L; number <= upperBound; number++) {
            if (!set.contains(number)) {
                System.out.print(number + " ");
            }
        }
    }

    private static String removeD(String input) {

        HashSet<Character> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < input.length(); index++) {

            Character ch = input.charAt(index);

            if (Character.isLetter(ch) && set.add(Character.toUpperCase(ch))) {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

}


