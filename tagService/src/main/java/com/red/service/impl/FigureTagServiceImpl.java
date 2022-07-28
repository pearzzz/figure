package com.red.service.impl;

import com.red.dao.FigureTagDao;
import com.red.entity.FigureTag;
import com.red.service.FigureTagService;
import com.red.vo.FigureTagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 14:21 2022-07-26
 */
@Service
public class FigureTagServiceImpl implements FigureTagService {

    @Autowired
    private FigureTagDao figureTagDao;

    @Override
    public int insertfiguretag(FigureTag figureTag) {
        figureTag.setCreateTime(new Date());
        figureTag.setStatus(0);
        return figureTagDao.insertfiguretag(figureTag);
    }

    @Override
    public int updatefiguretag(FigureTag figureTag) {
        figureTag.setUpdateTime(new Date());
        return figureTagDao.updatefiguretag(figureTag);
    }

    @Override
    public int updateStatus(FigureTag figureTag) {
        figureTag.setUpdateTime(new Date());
        return figureTagDao.updateStatus(figureTag);
    }

    @Override
    public FigureTag findBytagid(FigureTag figureTag) {
        return figureTagDao.findBytagid(figureTag);
    }

    @Override
    public List<FigureTag> querytagbyvo(FigureTagVo figureTagVo) {
        return figureTagDao.querytagbyvo(figureTagVo);
    }
}
