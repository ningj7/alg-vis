package tech.jianning.core.mapper;


import org.apache.ibatis.annotations.Mapper;
import tech.jianning.core.entity.Announce;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface AnnounceMapper extends BaseMapper<Announce> {
}
