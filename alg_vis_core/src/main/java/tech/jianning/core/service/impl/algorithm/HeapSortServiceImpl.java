package tech.jianning.core.service.impl.algorithm;

import org.springframework.stereotype.Service;
import tech.jianning.common.pojo.AlgorithmPojo;
import tech.jianning.common.utils.DataHandleUtils;
import tech.jianning.core.service.api.IHeapSortService;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeapSortServiceImpl implements IHeapSortService {

  private static int sortedIndex = -1;

  @Override
  public List<AlgorithmPojo.HeapSortResponse> heapSort(AlgorithmPojo.SortRequest request) {
    List<AlgorithmPojo.HeapSortResponse> result = new ArrayList<>();
    int[] array = request.getArray();
    int n = request.getNum();
    sortedIndex = n;
    result.add(new AlgorithmPojo.HeapSortResponse(DataHandleUtils.copyArray(array), null, sortedIndex));
    buildHeap(array, n, result);
    result.add(new AlgorithmPojo.HeapSortResponse(DataHandleUtils.copyArray(array), null, 0));
    return result;
  }

  private void buildHeap(int[] array, int n, List<AlgorithmPojo.HeapSortResponse> result) {
    for (int i = n / 2 - 1; i >= 0; i--) {
      result.add(new AlgorithmPojo.HeapSortResponse(DataHandleUtils.copyArray(array), new int[]{i}, sortedIndex));
      adjustHeap(array, n, i, result);
    }
    for (int i = n - 1; i > 0; i--) {
      result.add(new AlgorithmPojo.HeapSortResponse(DataHandleUtils.copyArray(array), new int[]{0, i}, sortedIndex));
      int temp = array[i];
      array[i] = array[0];
      array[0] = temp;
      sortedIndex = i;
      result.add(new AlgorithmPojo.HeapSortResponse(DataHandleUtils.copyArray(array), null, sortedIndex));
      adjustHeap(array, i, 0, result);
    }
  }

  private void adjustHeap(int[] array, int n, int id, List<AlgorithmPojo.HeapSortResponse> result) {
    int left = 2 * id + 1;
    int right = 2 * id + 2;
    int maxId = id;
    if (left < n && array[left] > array[maxId]) {
      maxId = left;
    }
    if (right < n && array[right] > array[maxId]) {
      maxId = right;
    }
    if (maxId != id) {
      result.add(new AlgorithmPojo.HeapSortResponse(DataHandleUtils.copyArray(array), new int[]{id, maxId}, sortedIndex));
      int temp = array[id];
      array[id] = array[maxId];
      array[maxId] = temp;
      result.add(new AlgorithmPojo.HeapSortResponse(DataHandleUtils.copyArray(array), new int[]{id, maxId}, sortedIndex));
      adjustHeap(array, n, maxId, result);
    }
  }
}
