package com.red.control;

import com.red.entity.FigureTag;
import com.red.service.FigureTagService;
import com.red.vo.FigureTagConditon;
import com.red.vo.FigureTagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 14:26 2022-07-26
 */
@RestController
@RequestMapping("figuretag")
public class FigureTagController {
    @Autowired
    private FigureTagService figureTagService;

    @RequestMapping(value = "insertTag",method = RequestMethod.POST)
    public void insertTag(@RequestBody FigureTag figureTag){
        figureTagService.insertfiguretag(figureTag);
    }

    @RequestMapping(value = "updateTag",method = RequestMethod.POST)
    public void updateTag(@RequestBody FigureTag figureTag){
        figureTagService.updatefiguretag(figureTag);
    }

    @RequestMapping(value = "updateStatus",method = RequestMethod.POST)
    public void updateStatus(@RequestBody FigureTag figureTag){
        figureTagService.updateStatus(figureTag);
    }

    @RequestMapping(value = "findByTaId",method = RequestMethod.POST)
    public FigureTag findByTaId(@RequestBody FigureTag figureTag){
        return figureTagService.findBytagid(figureTag);
    }

    @RequestMapping(value = "querytagbyvo",method = RequestMethod.POST)
    public List<FigureTag> querytagbyvo(@RequestBody FigureTagConditon figureTagConditon){
        FigureTagVo figureTagVo = new FigureTagVo();
        figureTagVo.setFigureTagConditon(figureTagConditon);
        return figureTagService.querytagbyvo(figureTagVo);
    }
}
