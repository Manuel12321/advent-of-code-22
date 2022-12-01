package day01.task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:\\workarea\\workspace\\LeetCode\\src\\adventOfCode\\day01\\task01\\input"));

        ArrayList<Integer> currentElf = new ArrayList<>();
        int maxCalories = 0;
        int elfCounter = 1;

        while (in.hasNextLine()) {
            String currentLine = in.nextLine();
            if (!currentLine.equals("")) {
                currentElf.add(Integer.parseInt(currentLine));
            } else {
                int currentElfCalories = currentElf.stream().reduce(0, Integer::sum);
                currentElf.clear();
                if (maxCalories < currentElfCalories) {
                    maxCalories = currentElfCalories;
                    System.out.println("Neuer Top elf: " + maxCalories);
                }
                elfCounter++;
            }
        }
    }
}
