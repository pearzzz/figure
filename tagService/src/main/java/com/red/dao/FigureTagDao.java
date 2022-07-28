package com.red.dao;

import com.red.entity.FigureTag;
import com.red.vo.FigureTagVo;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 14:08 2022-07-26
 */
public interface FigureTagDao {
    public int insertfiguretag(FigureTag figureTag);

    public int updatefiguretag(FigureTag figureTag);

    public int updateStatus(FigureTag figureTag);

    public FigureTag findBytagid(FigureTag figureTag);

    public List<FigureTag> querytagbyvo(FigureTagVo figureTagVo);
}
