package day01.task02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/day01/task01/input"));

        ArrayList<Integer> currentElf = new ArrayList<>();
        ArrayList<Integer> topElfes = new ArrayList<>();
        boolean weakestElfDelete = false;

        while (in.hasNextLine()) {
            String currentLine = in.nextLine();
            if (!currentLine.equals("")) {
                currentElf.add(Integer.parseInt(currentLine));
            } else {
                int currentElfCalories = currentElf.stream().reduce(0, Integer::sum);
                currentElf.clear();
                if (topElfes.size() < 3) {
                    topElfes.add(currentElfCalories);
                } else {
                    for (int i = 0; i < topElfes.size(); i++) {
                        if (topElfes.get(i) < currentElfCalories) {
                            weakestElfDelete = true;
                        }
                    }
                    if (weakestElfDelete) {
                        topElfes.remove(Collections.min(topElfes));
                        topElfes.add(currentElfCalories);
                        weakestElfDelete = false;
                    }
                }
            }
        }
        System.out.println(topElfes.stream().reduce(0, Integer::sum));
    }
}
