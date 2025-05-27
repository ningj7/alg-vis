package tech.jianning.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.jianning.common.pojo.AnnouncePojo;
import tech.jianning.core.entity.Announce;
import tech.jianning.core.mapper.AnnounceMapper;
import tech.jianning.core.service.api.IAnnounceService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnounceServiceImpl implements IAnnounceService {

    private final AnnounceMapper announceMapper;

    @Override
    public List<AnnouncePojo.ListResponse> queryList() {
        List<Announce> announces = announceMapper.selectAll();
        List<AnnouncePojo.ListResponse> result = new ArrayList<>();
        announces.forEach(announce -> {
            AnnouncePojo.ListResponse item = new AnnouncePojo.ListResponse();
            BeanUtils.copyProperties(announce, item);
            result.add(item);
        });
        return result;
    }

    @Override
    public Integer insert(AnnouncePojo.AddRequest request) {
        Announce announce = new Announce();
        BeanUtils.copyProperties(request, announce);
        return announceMapper.insertSelective(announce);
    }

    @Override
    public Integer deleteById(Long id) {
        return announceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer update(AnnouncePojo.UpdateRequest request) {
        Announce announce = new Announce();
        BeanUtils.copyProperties(request, announce);
        return announceMapper.updateByPrimaryKeySelective(announce);
    }
}
