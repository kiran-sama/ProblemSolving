package me.sama.problemsolving;

import java.util.UUID;

/**
 * Created by ksama on 2/1/15.
 */
public class SystemOutTest {
  public static void main(String args[]) {
    System.out.println("sama");
    System.out.println(UUID.randomUUID().getMostSignificantBits()+":"+UUID.randomUUID().getLeastSignificantBits());
  }
}