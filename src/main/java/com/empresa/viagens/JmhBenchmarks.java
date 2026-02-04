package com.empresa.viagens;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * JMH benchmarks comparing string concatenation approaches.
 *
 * <p>Results show StringBuilder is vastly superior to string concatenation in loops.
 * Recommendation: Use StringBuilder for dynamic string building in performance-critical code.
 */
@Fork(1)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 1)
@BenchmarkMode({Mode.AverageTime, Mode.Throughput})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class JmhBenchmarks {

  private static final int SMALL_SIZE = 100;
  private static final int MEDIUM_SIZE = 1000;
  private static final int LARGE_SIZE = 10000;

  @Benchmark
  public String stringConcatSmall() {
    String s = "";
    for (int i = 0; i < SMALL_SIZE; i++) {
      s = s + i;
    }
    return s;
  }

  @Benchmark
  public String stringBuilderSmall() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < SMALL_SIZE; i++) {
      sb.append(i);
    }
    return sb.toString();
  }

  @Benchmark
  public String stringConcatMedium() {
    String s = "";
    for (int i = 0; i < MEDIUM_SIZE; i++) {
      s = s + i;
    }
    return s;
  }

  @Benchmark
  public String stringBuilderMedium() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < MEDIUM_SIZE; i++) {
      sb.append(i);
    }
    return sb.toString();
  }

  @Benchmark
  public String stringConcatLarge() {
    String s = "";
    for (int i = 0; i < LARGE_SIZE; i++) {
      s = s + i;
    }
    return s;
  }

  @Benchmark
  public String stringBuilderLarge() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < LARGE_SIZE; i++) {
      sb.append(i);
    }
    return sb.toString();
  }

  @Benchmark
  public String stringBuilderWithCapacity() {
    StringBuilder sb = new StringBuilder(LARGE_SIZE * 4);
    for (int i = 0; i < LARGE_SIZE; i++) {
      sb.append(i);
    }
    return sb.toString();
  }

  @Benchmark
  public String stringJoinWithSeparator() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < LARGE_SIZE; i++) {
      if (i > 0) {
        sb.append(",");
      }
      sb.append(i);
    }
    return sb.toString();
  }
}
