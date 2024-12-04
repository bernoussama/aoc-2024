package com.bernoussama.aoc2024;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
  // var println = System.out.println();
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("forgot filename");
      return;
    }
    StringBuilder test = new StringBuilder("");
    if (args.length > 1) {
      if (args[1].equals("test")) {
        test.append("_test");
      }
    }
    int day = Integer.parseInt(args[0]);
    String file = String.format("Day%02d%s.txt", day, test.toString());
    Path filename = Paths.get(file);
    try {
      Day daySolver = getDay(day, filename);
      String part1 = daySolver.part1();
      String part2 = daySolver.part2();
      System.out.println("part1: " + part1);
      System.out.println("part2: " + part2);
    } catch (Exception e) {
      System.err.println(e);
    }

  }

  private static Day getDay(int day, Path filename) throws Exception {
    return switch (day) {
      case 1 -> new Day01(filename);
      case 2 -> new Day02(filename);
      case 3 -> new Day03(filename);
      default ->
        throw new Exception(String.format("Day %d has not been solved yet, or it is invalid.", day));
    };
  }
}
