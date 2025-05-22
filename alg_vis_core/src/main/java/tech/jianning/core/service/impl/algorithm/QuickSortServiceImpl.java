package tech.jianning.core.service.impl.algorithm;

import org.springframework.stereotype.Service;
import tech.jianning.common.pojo.AlgorithmPojo;
import tech.jianning.common.utils.DataHandleUtils;
import tech.jianning.core.service.api.IQuickSortService;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuickSortServiceImpl implements IQuickSortService {

    private int[] status;

    @Override
    public List<AlgorithmPojo.QuickSortResponse> quickSort(AlgorithmPojo.SortRequest request) {
        int num = request.getNum();
        int[] array = request.getArray();
        status = new int[num];
        List<AlgorithmPojo.QuickSortResponse> result = new ArrayList<>();
        result.add(new AlgorithmPojo.QuickSortResponse(DataHandleUtils.copyArray(array), DataHandleUtils.copyArray(status), -1));
        sort(array, 0, num - 1, result);
        return result;
    }

    private void sort(int[] array, int left, int right, List<AlgorithmPojo.QuickSortResponse> result) {
        if (left >= right) {
            if (left == right) {
                status[left] = 3;
                result.add(new AlgorithmPojo.QuickSortResponse(DataHandleUtils.copyArray(array), DataHandleUtils.copyArray(status), -1));
            }
            return;
        }
        int pivot = partition(array, left, right, result);
        sort(array, left, pivot - 1, result);
        sort(array, pivot + 1, right, result);
    }

    private int partition(int[] arr, int left, int right, List<AlgorithmPojo.QuickSortResponse> result) {
        int index = left + 1;
        status[left] = 1;
        result.add(new AlgorithmPojo.QuickSortResponse(DataHandleUtils.copyArray(arr), DataHandleUtils.copyArray(status), index > right ? -1 : index));
        for (int i = index; i <= right; i++) {
            status[i] = 2;
            result.add(new AlgorithmPojo.QuickSortResponse(DataHandleUtils.copyArray(arr), DataHandleUtils.copyArray(status), index > right ? -1 : index));
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
                index++;
                result.add(new AlgorithmPojo.QuickSortResponse(DataHandleUtils.copyArray(arr), DataHandleUtils.copyArray(status), index > right ? -1 : index));
            }
            status[i] = 0;
        }
        swap(arr, left, index - 1);
        status[left] = 0;
        status[index - 1] = 3;
        result.add(new AlgorithmPojo.QuickSortResponse(DataHandleUtils.copyArray(arr), DataHandleUtils.copyArray(status), -1));
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
