package tech.jianning.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataHandleUtils {

  public static int[] copyArray(int[] original) {
    int[] copy = new int[original.length];
    System.arraycopy(original, 0, copy, 0, original.length);
    return copy;
  }

  public static int[] listToArray(java.util.List<Integer> list) {
    int[] array = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
    }
    return array;
  }

}
