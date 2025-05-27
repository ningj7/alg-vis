package tech.jianning.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.jianning.common.context.BaseContext;
import tech.jianning.common.pojo.SuggestionPojo;
import tech.jianning.core.entity.SuggestionRecord;
import tech.jianning.core.mapper.SuggestionRecordMapper;
import tech.jianning.core.service.api.ISuggestionService;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements ISuggestionService {

    private final SuggestionRecordMapper suggestionRecordMapper;

    @Override
    public List<SuggestionPojo.ListResponse> queryList() {
        List<SuggestionRecord> suggestionRecords = suggestionRecordMapper.selectAll();
        Collections.reverse(suggestionRecords);
        List<SuggestionPojo.ListResponse> result = new ArrayList<>();
        suggestionRecords.forEach(suggestionRecord -> {
            SuggestionPojo.ListResponse listResponse = new SuggestionPojo.ListResponse();
            BeanUtils.copyProperties(suggestionRecord, listResponse);
            result.add(listResponse);
        });
        return result;
    }

    @Override
    public SuggestionPojo.AddResponse insert(SuggestionPojo.AddRequest suggestion) {
        SuggestionRecord suggestionRecord = new SuggestionRecord();
        suggestionRecord.setCreatorName(BaseContext.current.get().getUsername());
        suggestionRecord.setCreatorId(BaseContext.current.get().getId());
        BeanUtils.copyProperties(suggestion, suggestionRecord);
        suggestionRecordMapper.insertSelective(suggestionRecord);
        return new SuggestionPojo.AddResponse(suggestionRecord.getId(), suggestionRecord.getCreatorName(), Instant.now());
    }
}
