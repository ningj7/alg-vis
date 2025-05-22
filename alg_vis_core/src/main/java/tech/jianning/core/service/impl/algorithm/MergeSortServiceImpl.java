package tech.jianning.core.service.impl.algorithm;

import org.springframework.stereotype.Service;
import tech.jianning.common.pojo.AlgorithmPojo;
import tech.jianning.common.utils.DataHandleUtils;
import tech.jianning.core.service.api.IMergeSortService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MergeSortServiceImpl implements IMergeSortService {

    @Override
    public List<AlgorithmPojo.MergeSortResponse> mergeSort(AlgorithmPojo.SortRequest request) {
        int[] array = request.getArray();
        int n = request.getNum();
        List<AlgorithmPojo.MergeSortResponse> result = new ArrayList<>();
        result.add(new AlgorithmPojo.MergeSortResponse(DataHandleUtils.copyArray(array), null, null, null));
        merge(array, 0, n - 1, result);
        return result;
    }

    private void merge(int[] arr, int start, int end, List<AlgorithmPojo.MergeSortResponse> result) {
        if (start >= end) return;
        int mid = (start + end) >> 1;
        merge(arr, start, mid, result);
        merge(arr, mid + 1, end, result);
        List<Integer> tempArray = new ArrayList<>();
        int left = start;
        int right = mid + 1;
        result.add(new AlgorithmPojo.MergeSortResponse(DataHandleUtils.copyArray(arr), DataHandleUtils.listToArray(tempArray),
            getComparingArray(left, right, mid, end), new int[]{start, end}));
        while (left <= mid || right <= end) {
            if (left > mid || (right <= end && arr[right] < arr[left])) {
                tempArray.add(arr[right]);
                arr[right++] = -1;
            } else {
                tempArray.add(arr[left]);
                arr[left++] = -1;
            }
            result.add(new AlgorithmPojo.MergeSortResponse(DataHandleUtils.copyArray(arr), DataHandleUtils.listToArray(tempArray),
                getComparingArray(left, right, mid, end), new int[]{start, end}));
        }
        for (int i = 0; i < tempArray.size(); i++) {
            arr[start + i] = tempArray.get(i);
        }
        result.add(new AlgorithmPojo.MergeSortResponse(DataHandleUtils.copyArray(arr), null, null, null));
    }

    private int[] getComparingArray(int l, int r, int mid, int end) {
        if (l <= mid) {
            if (r <= end) return new int[]{l, r};
            else return new int[]{l};
        } else if (r <= end) return new int[]{r};
        else return null;
    }
}
