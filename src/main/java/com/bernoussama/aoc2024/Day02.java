package com.bernoussama.aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day02 implements Day {

  private List<List<Integer>> reports = new ArrayList<>();
  private int safe = 0;

  public Day02(Path path) {
    try {
      Files.lines(path).forEach((line) -> {
        var nums = Arrays.asList(line.split(" "));
        List<Integer> report = nums.stream().map(n -> Integer.parseInt(n)).collect(Collectors.toList());
        reports.add(report);
      });
    } catch (IOException e) {
      System.err.println("error reading file");
      e.printStackTrace();
    }
  }

  @Override
  public String part1() {
    reports.stream().forEach(report -> {
      boolean change = report.get(1) - report.get(0) > 0 ? true : false;
      int diff;
      for (int i = 0; i < report.size() - 1; i++) {
        diff = report.get(i + 1) - report.get(i);
        boolean currChange = diff > 0 ? true : false;
        if (currChange != change) {
          return;
        }
        diff = Math.abs(diff);
        if (diff < 1 || diff > 3)
          return;
      }
      safe++;
    });
    System.out.println(reports);
    return Integer.toString(safe);
  }

  @Override
  public String part2() {
    return "";
  }
}
