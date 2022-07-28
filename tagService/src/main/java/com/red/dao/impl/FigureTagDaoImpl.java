package com.red.dao.impl;

import com.red.dao.FigureTagDao;
import com.red.entity.FigureTag;
import com.red.mapper.FigureTagMapper;
import com.red.vo.FigureTagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 14:09 2022-07-26
 */
@Component
public class FigureTagDaoImpl implements FigureTagDao {

    @Autowired
    private FigureTagMapper figureTagMapper;

    @Override
    public int insertfiguretag(FigureTag figureTag) {
        return figureTagMapper.insertfiguretag(figureTag);
    }

    @Override
    public int updatefiguretag(FigureTag figureTag) {
        return figureTagMapper.updatefiguretag(figureTag);
    }

    @Override
    public int updateStatus(FigureTag figureTag) {
        return figureTagMapper.updateStatus(figureTag);
    }

    @Override
    public FigureTag findBytagid(FigureTag figureTag) {
        return figureTagMapper.findBytagid(figureTag);
    }

    @Override
    public List<FigureTag> querytagbyvo(FigureTagVo figureTagVo) {
        return figureTagMapper.querytagbyvo(figureTagVo);
    }
}
