package problems.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LicenseKeyFormatting {

    public static void main(String[] args) {

        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();

        System.out.println((licenseKeyFormatting.licenseKeyFormatting2("5F3Z-2e-9-w", 4)));
    }

    public String licenseKeyFormatting(String S, int K) {

        Queue queue = new LinkedList<Character>();

        String income = S.toUpperCase();
        int bucketSize = S.length() / K;


        for (int index = income.length() - 1; index >= 0; index--) {

            Character ch = income.charAt(index);
            if (ch != '-') {
                queue.offer(ch);
            }
        }
        StringBuilder builder = new StringBuilder();

        int counter = K;
        while (!queue.isEmpty()) {

            if (counter > 0) {
                builder.append(queue.poll());
            } else {
                builder.append("-");
                builder.append(queue.poll());
                counter = K;
            }
            counter--;
        }

        return builder.reverse().toString();
    }

    public String licenseKeyFormatting2(String S, int K) {

        Stack<Character> stack = new Stack<>();

        String income = S.toUpperCase();

        int counter = K;

        for (int index = income.length() - 1; index >= 0; index--) {
            Character ch = income.charAt(index);
            if (ch != '-') {
                stack.push(ch);
                counter--;
            }
            if (counter == 0 && index != 0) {
                stack.push('-');
                counter = K;
            }
        }
        StringBuilder builder = new StringBuilder();

        if (stack.lastElement() == '-') stack.remove(stack.size() - 1);
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}



