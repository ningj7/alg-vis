package tech.jianning.core.service.api;

import tech.jianning.common.pojo.AnnouncePojo;

import java.util.List;

public interface IAnnounceService {

    List<AnnouncePojo.ListResponse> queryList();

    Integer insert(AnnouncePojo.AddRequest request);

    Integer deleteById(Long id);

    Integer update(AnnouncePojo.UpdateRequest request);
}
