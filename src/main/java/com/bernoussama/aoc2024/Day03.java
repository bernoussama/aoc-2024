package com.bernoussama.aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 implements Day {

  String content;

  public Day03(Path path) {
    try {
      content = Files.readString(path);
      System.out.println(content);
    } catch (IOException e) {
      System.err.println(e);
    }

  }

  @Override
  public String part1() {
    return multSum(content).toString();
  }

  @Override
  public String part2() {
    List<String> parts = new ArrayList<>();
    Integer lastIdx = 0;
    boolean doMatch = true;
    Pattern doPattern = Pattern.compile("do(n't)?\\(\\)");
    Matcher matcher = doPattern.matcher(content);
    while (matcher.find()) {
      if (matcher.group(1) != null) {
        // don't match
        if (doMatch) {
          parts.add(content.substring(lastIdx, matcher.start()));
        }
        doMatch = false;
        continue;
      }
      if (!doMatch) {
        lastIdx = matcher.end();
      }
      doMatch = true;
    }
    parts.add(content.substring(lastIdx, content.length()));
    return parts.stream().map(part -> multSum(part)).reduce(0L, (acc, el) -> acc + el).toString();
  }

  private Long multSum(String input) {
    Pattern pattern = Pattern.compile("(mul\\()(\\d+),(\\d+)(\\))");
    Matcher matcher = pattern.matcher(input);
    List<List<Long>> result = new ArrayList<>();
    while (matcher.find()) {
      List<Long> nums = new ArrayList<>();
      nums.add(Long.parseLong(matcher.group(2)));
      nums.add(Long.parseLong(matcher.group(3)));
      result.add(nums);
    }
    return result.stream().map(nums -> nums.get(0) * nums.get(1)).reduce(0L, (acc, el) -> acc + el);
  }

}
