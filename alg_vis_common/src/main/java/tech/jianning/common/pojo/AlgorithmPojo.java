package tech.jianning.common.pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AlgorithmPojo {

  @Data
  public static class SortRequest {
    private int num;
    private int[] array;
  }

  @Data
  @AllArgsConstructor
  public static class BubbleSortResponse {
    private int[] array;
    private int curIndex;
    private int sortedTailIndex;
  }

  @Data
  @AllArgsConstructor
  public static class MergeSortResponse {
    private int[] array;
    private int[] tempArray;
    private int[] comparing;
    private int[] mergeRange;

  }
}
