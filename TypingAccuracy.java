import java.util.Scanner;

public class TypingAccuracy {
    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatch == -1) {
                    firstMismatch = i + 1;
                }
            }
        }

        double accuracy = (matched * 100.0) / original.length();
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, original.length(), accuracy);

        if (firstMismatch != -1) {
            System.out.println(" | First Mismatch at position " + firstMismatch +
                    " ('" + original.charAt(firstMismatch - 1) + "' vs '" + typed.charAt(firstMismatch - 1) + "')");
        } else {
            System.out.println(" | No Mismatches");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter the typed passage: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}
