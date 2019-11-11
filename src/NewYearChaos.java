import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue. Initial positions increment by  from  at the front of the line to  at the back.
 *
 * Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the same sticker denoting their original places in line. One person can bribe at most two others. For example, if  and  bribes , the queue will look like this: .
 *
 * Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!
 *
 * Function Description
 *
 * Complete the function minimumBribes in the editor below. It must print an integer representing the minimum number of bribes necessary, or Too chaotic if the line configuration is not possible.
 *
 * minimumBribes has the following parameter(s):
 *
 * q: an array of integers
 * Input Format
 *
 * The first line contains an integer , the number of test cases.
 *
 * Each of the next  pairs of lines are as follows:
 * - The first line contains an integer , the number of people in the queue
 * - The second line has  space-separated integers describing the final state of the queue.
 *
 * Constraints
 *
 * Subtasks
 *
 * For  score
 * For  score
 *
 * Output Format
 *
 * Print an integer denoting the minimum number of bribes needed to get the queue into its final state. Print Too chaotic if the state is invalid, i.e. it requires a person to have bribed more than  people.
 *
 * Sample Input
 *
 * 2
 * 5
 * 2 1 5 3 4
 * 5
 * 2 5 1 3 4
 * Sample Output
 *
 * 3
 * Too chaotic
 */















public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int n = q.length;
        int swaps = 0;
//        for (int i=0; i <n-2; i++){
//            int init = q[i];
//            int actual = i+1;
//            if (init - actual > 2){
//                System.out.println("Too chaotic");
//                return;
//            }
//        }

        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                int init = q[i];
                int actual = i+1;
                if (init - actual > 2){
                    System.out.println("Too chaotic");
                    return;
                }
                if (q[j] > q[j+1]){
                    swaps++;
                    int temp   = q[j];
                    q[j]       = q[j+1];
                    q[j+1]     = temp;
                }
            }
        }
        System.out.println(swaps);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
