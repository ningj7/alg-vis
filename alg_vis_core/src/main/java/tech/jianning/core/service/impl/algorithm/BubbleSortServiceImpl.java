package tech.jianning.core.service.impl.algorithm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.jianning.common.pojo.AlgorithmPojo;
import tech.jianning.common.utils.DataHandleUtils;
import tech.jianning.core.service.api.IBubbleSortService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BubbleSortServiceImpl implements IBubbleSortService {

  @Override
  public List<AlgorithmPojo.BubbleSortResponse> bubbleSort(AlgorithmPojo.SortRequest request) {
    List<AlgorithmPojo.BubbleSortResponse> result = new ArrayList<>();
    int[] array = request.getArray();
    int n = request.getNum();
    result.add(new AlgorithmPojo.BubbleSortResponse(DataHandleUtils.copyArray(array), n, n));
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        result.add(new AlgorithmPojo.BubbleSortResponse(DataHandleUtils.copyArray(array), j, n - i));
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
        result.add(new AlgorithmPojo.BubbleSortResponse(DataHandleUtils.copyArray(array), j, n - i));
      }
    }
    if (n >= 2) result.add(new AlgorithmPojo.BubbleSortResponse(DataHandleUtils.copyArray(array), n, 1));
    result.add(new AlgorithmPojo.BubbleSortResponse(DataHandleUtils.copyArray(array), n, 0));
    return result;
  }
}
