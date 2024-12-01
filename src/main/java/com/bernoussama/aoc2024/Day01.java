package com.bernoussama.aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

public class Day01 implements Day {

  private ArrayList<Integer> list1 = new ArrayList<Integer>();
  private ArrayList<Integer> list2 = new ArrayList<Integer>();

  public Day01(Path path) {
    try {
      Files.lines(path).forEach((n) -> {
        var line = n.split("   ");
        list1.add(Integer.parseInt(line[0]));
        list2.add(Integer.parseInt(line[1]));
      });
    } catch (IOException e) {
      System.err.println("error reading file");
      e.printStackTrace();
    }
  }

  @Override
  public String part1() {
    int totalDistance = 0;
    list1.sort(Comparator.naturalOrder());
    list2.sort(Comparator.naturalOrder());

    for (int i = 0; i < list1.size(); i++) {
      totalDistance += Math.abs(list1.get(i) - list2.get(i));
    }
    return Integer.toString(totalDistance);
  }

  @Override
  public String part2() {
    int similarity = 0;
    for (int lNum : list1) {
      int occurences = 0;
      for (int rNum : list2) {
        if (lNum == rNum) {
          occurences++;
        }
      }
      similarity += lNum * occurences;
    }
    return Integer.toString(similarity);
  }
}
