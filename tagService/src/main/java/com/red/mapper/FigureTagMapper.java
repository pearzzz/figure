package com.red.mapper;

import com.red.entity.FigureTag;
import com.red.vo.FigureTagVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 11:05 2022-07-26
 */
@Component
public interface FigureTagMapper {

    public int insertfiguretag(FigureTag figureTag);

    public int updatefiguretag(FigureTag figureTag);

    public int updateStatus(FigureTag figureTag);

    public FigureTag findBytagid(FigureTag figureTag);

    public List<FigureTag> querytagbyvo(FigureTagVo figureTagVo);
}
