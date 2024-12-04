package com.bernoussama.aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Day04 implements Day {

  private List<String[]> chars;
  int x, y;

  private String target = "XMAS";
  private String[] targetList = target.split("");

  public Day04(Path path) {
    try {
      chars = Files.lines(path).map(line -> line.split("")).collect(Collectors.toList());
      x = chars.get(0).length;
      y = chars.size();

    } catch (IOException e) {
      System.err.println("error reading file");
      e.printStackTrace();
    }
  }

  @Override
  public String part1() {
    // for each char
    for (String[] strings : chars) {
      System.out.println(strings);
    }
    // traverse horizontally
    // vertically
    // diagonally
    // if char idx > target.length
    // traverse -horizontally
    // -vertically
    // -diagonally

    return "";
  }

  @Override
  public String part2() {
    return "";
  }
}
