package com.empresa.viagens;

import org.junit.jupiter.api.Test;

public class PerformanceBenchmarks {

  @Test
  void stringConcatVsBuilder() {
    final int runs = 10_000;
    long t1 = System.nanoTime();
    String s = "";
    for (int i = 0; i < runs; i++) {
      s = s + "x";
    }
    long t2 = System.nanoTime();

    long t3 = System.nanoTime();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < runs; i++) {
      sb.append('x');
    }
    sb.toString();
    long t4 = System.nanoTime();

    System.out.printf("string concat: %d ms\n", (t2 - t1) / 1_000_000);
    System.out.printf("StringBuilder: %d ms\n", (t4 - t3) / 1_000_000);
  }
}
