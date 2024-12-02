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
  private int safe1 = 0;
  private int safe2 = 0;

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
      safe1++;
    });
    return Integer.toString(safe1);
  }

  @Override
  public String part2() {
    reports.stream().forEach(report -> {
      if (isSafe(report)) {
        safe2++;
      } else {
        for (int i = 0; i < report.size(); i++) {
          List<Integer> modifiedReport = new ArrayList<>(report);
          modifiedReport.remove(i);
          if (isSafe(modifiedReport)) {
            safe2++;
            break;
          }
        }
      }
    });
    return Integer.toString(safe2);
  }

  private boolean isSafe(List<Integer> report) {
    boolean change = report.get(1) - report.get(0) > 0;
    for (int i = 0; i < report.size() - 1; i++) {
      int diff = report.get(i + 1) - report.get(i);
      boolean currChange = diff > 0;
      diff = Math.abs(diff);
      if (currChange != change || diff < 1 || diff > 3) {
        return false;
      }
    }
    return true;
  }
}
