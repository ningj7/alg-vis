package tech.jianning.common.pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

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

  @Data
  @AllArgsConstructor
  public static class HeapSortResponse {
    private int[] array;
    private int[] comparingId;
    private int sortedIndex;
  }

  @Data
  public static class SearchRequest {
    private int num;
    private Map<Integer, List<Integer>> edges;
    private int type;
  }

  @Data
  @AllArgsConstructor
  public static class SearchResponse {
    private int[] visited;
    private Map<Integer, List<Integer>> edges;
    private int[] tempEdge;
  }

  @Data
  public static class ShortestPathRequest {
    private int num;
    private Map<Integer, List<int[]>> edges;
    private int start;
  }

  @Data
  @AllArgsConstructor
  public static class ShortestPathResponse {
    private Map<Integer, List<int[]>> edges;
    private int[] dis;
    private int[] visited;
    private int[] tempEdge;
  }

}
