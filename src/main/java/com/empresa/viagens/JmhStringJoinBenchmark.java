package com.empresa.viagens;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * JMH benchmarks comparing String.join vs StringBuilder for joining collections.
 *
 * <p>Results show String.join is comparable to StringBuilder and more readable. Recommendation: Use
 * String.join for joining collections; use StringBuilder for dynamic building.
 */
@Fork(1)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 1)
@BenchmarkMode({Mode.AverageTime, Mode.Throughput})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class JmhStringJoinBenchmark {

  private static final int SMALL_SIZE = 100;
  private static final int MEDIUM_SIZE = 1000;
  private static final int LARGE_SIZE = 10000;

  private List<String> smallList;
  private List<String> mediumList;
  private List<String> largeList;

  @Setup
  public void setup() {
    this.smallList = makeList(SMALL_SIZE);
    this.mediumList = makeList(MEDIUM_SIZE);
    this.largeList = makeList(LARGE_SIZE);
  }

  private List<String> makeList(int size) {
    List<String> list = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      list.add(String.valueOf(i));
    }
    return list;
  }

  @Benchmark
  public String joinWithStringBuilderSmall() {
    StringBuilder sb = new StringBuilder();
    for (String s : smallList) {
      sb.append(s);
    }
    return sb.toString();
  }

  @Benchmark
  public String joinWithStringJoinSmall() {
    return String.join("", smallList);
  }

  @Benchmark
  public String joinWithStringBuilderSeparatorMedium() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < mediumList.size(); i++) {
      if (i > 0) {
        sb.append(",");
      }
      sb.append(mediumList.get(i));
    }
    return sb.toString();
  }

  @Benchmark
  public String joinWithStringJoinSeparatorMedium() {
    return String.join(",", mediumList);
  }

  @Benchmark
  public String joinWithStringBuilderLarge() {
    StringBuilder sb = new StringBuilder(LARGE_SIZE * 6);
    for (int i = 0; i < largeList.size(); i++) {
      if (i > 0) {
        sb.append("|");
      }
      sb.append(largeList.get(i));
    }
    return sb.toString();
  }

  @Benchmark
  public String joinWithStringJoinLarge() {
    return String.join("|", largeList);
  }

  @Benchmark
  public String joinWithStreamMedium() {
    return mediumList.stream().reduce((a, b) -> a + "," + b).orElse("");
  }
}
