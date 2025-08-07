import java.util.Arrays;

public class GradeStatisticsSystem {

    public static char getLetterGrade(int score) {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        if (score >= 60) return 'D';
        return 'F';
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 82, 90};

        int sum = 0;
        int max = scores[0];
        int min = scores[0];
        int countAboveAverage = 0;

        int[] gradeCount = new int[5]; // A, B, C, D, F

        for (int score : scores) {
            sum += score;
            if (score > max) max = score;
            if (score < min) min = score;

            char grade = getLetterGrade(score);
            switch (grade) {
                case 'A': gradeCount[0]++; break;
                case 'B': gradeCount[1]++; break;
                case 'C': gradeCount[2]++; break;
                case 'D': gradeCount[3]++; break;
                case 'F': gradeCount[4]++; break;
            }
        }

        double average = (double) sum / scores.length;

        for (int score : scores) {
            if (score > average) countAboveAverage++;
        }

        System.out.println("Grade Report");
        System.out.println("============");
        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Highest: " + max);
        System.out.println("Lowest: " + min);
        System.out.println("Grade Distribution:");
        System.out.println("A: " + gradeCount[0]);
        System.out.println("B: " + gradeCount[1]);
        System.out.println("C: " + gradeCount[2]);
        System.out.println("D: " + gradeCount[3]);
        System.out.println("F: " + gradeCount[4]);
        System.out.println("Number of students above average: " + countAboveAverage);
    }
}
