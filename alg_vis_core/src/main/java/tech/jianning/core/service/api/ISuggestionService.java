package tech.jianning.core.service.api;

import tech.jianning.common.pojo.SuggestionPojo;

import java.util.List;

public interface ISuggestionService {

    List<SuggestionPojo.ListResponse> queryList();

    SuggestionPojo.AddResponse insert(SuggestionPojo.AddRequest suggestion);

}
