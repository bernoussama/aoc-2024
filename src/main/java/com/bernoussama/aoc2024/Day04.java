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
    int count = 0;

    // for each char
    for (int i = 0; i < chars.size(); i++) {
      for (int j = 0; j < chars.get(i).length; j++) {
        var string = chars.get(i)[j];
        System.out.printf("%s ", string);
        if (string.equals(targetList[0])) {
          // traverse horizontally
          if (checkDirection(i, j, 0, 1))
            count++;
          if (checkDirection(i, j, 0, -1))
            count++;
          // traverse vertically
          if (checkDirection(i, j, 1, 0))
            count++;
          if (checkDirection(i, j, -1, 0))
            count++;
          // traverse diagonally (down-right)
          if (checkDirection(i, j, 1, 1))
            count++;
          if (checkDirection(i, j, -1, 1))
            count++;
          // traverse diagonally (down-left)
          if (checkDirection(i, j, 1, -1))
            count++;
          if (checkDirection(i, j, -1, -1))
            count++;
        }
      }
      System.out.println();
    }

    return Integer.toString(count);
  }

  private boolean checkDirection(int startX, int startY, int dx, int dy) {
    for (int k = 0; k < targetList.length; k++) {
      int newX = startX + k * dx;
      int newY = startY + k * dy;
      if (newX < 0 || newX >= y || newY < 0 || newY >= x || !chars.get(newX)[newY].equals(targetList[k])) {
        return false;
      }
    }
    return true;
  }

  private boolean checkXmas(int x, int y) {
    String mas = "MAS";
    String sam = "SAM";
    StringBuilder str = new StringBuilder();
    str.append(chars.get(x)[y]);
    str.append(chars.get(x + 1)[y + 1]);
    str.append(chars.get(x + 2)[y + 2]);
    String string = str.toString();
    if (!string.equals(sam) && !string.equals(mas)) {
      return false;
    }
    x = x + 2;
    str = new StringBuilder();
    str.append(chars.get(x)[y]);
    str.append(chars.get(x - 1)[y + 1]);
    str.append(chars.get(x - 2)[y + 2]);
    string = str.toString();
    if (!string.equals(sam) && !string.equals(mas)) {
      return false;
    }
    return true;
  }

  @Override
  public String part2() {
    int count = 0;
    for (int i = 0; i < chars.size() - 2; i++) {
      for (int j = 0; j < chars.get(i).length - 2; j++) {
        if (checkXmas(i, j))
          count++;
      }
    }

    return Integer.toString(count);
  }
}
