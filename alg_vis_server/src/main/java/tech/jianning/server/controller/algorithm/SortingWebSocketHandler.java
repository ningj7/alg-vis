package tech.jianning.server.controller.algorithm;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class SortingWebSocketHandler extends TextWebSocketHandler {
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
    JsonNode jsonNode = objectMapper.readTree(message.getPayload());
    int[] array = objectMapper.convertValue(jsonNode.get("array"), int[].class);

    bubbleSort(session, array);  // 运行冒泡排序
  }

  private void bubbleSort(WebSocketSession session, int[] arr) throws IOException {
    int n = arr.length;
    boolean swapped;
    for (int i = 0; i < n - 1; i++) {
      swapped = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
        sendArrayState(session, arr); // 每次交换后发送数据
        sleep(500);  // 模拟动画延迟
      }
      if (!swapped) break;
    }
  }

  private void sendArrayState(WebSocketSession session, int[] arr) throws IOException {
    session.sendMessage(new TextMessage(objectMapper.writeValueAsString(arr)));
  }

  private void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
