package tech.jianning.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import tech.jianning.core.entity.SuggestionRecord;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface SuggestionRecordMapper extends BaseMapper<SuggestionRecord> {
}
