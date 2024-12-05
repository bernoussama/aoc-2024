package com.bernoussama.aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Day05 implements Day {

  private String rules;
  private String update;
  private List<Integer> rulesList = new ArrayList<>();

  public Day05(Path path) {
    try {
      var parts = Files.readString(path).split("\n\n");
      rules = parts[0];
      update = parts[1];
      System.out.println(rules);
      System.out.println(update);

      var parsedRules = parseRules(rules);
      for (Integer integer : parsedRules) {

        System.out.println(integer);
      }

    } catch (IOException e) {
      System.err.println("error reading file");
      e.printStackTrace();
    }
  }

  private List<Integer> parseRules(String rules) {
    List<Integer> rulesList = new ArrayList<>();
    rules.lines().map(line -> line.split("|"));

    return rulesList;
  }

  @Override
  public String part1() {
    return "";
  }

  @Override
  public String part2() {

    return "";
  }
}
