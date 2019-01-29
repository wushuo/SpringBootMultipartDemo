package com.ws.springbootStudy.server.controller;

import com.google.common.collect.Maps;
import com.ws.springbootStudy.domain.OrderRecord;
import com.ws.springbootStudy.mapper.OrderRecordMapper;
import com.ws.springbootStudy.server.dto.OrderRecordInsertUpdateDto;
import com.ws.springbootStudy.server.enums.StatusCode;
import com.ws.springbootStudy.server.response.BaseResponse;
import com.ws.springbootStudy.server.service.OrderRecordService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by UPC on 2019/1/5.
 */

@RestController
public class OrderRecordController {

    private final Logger logger = Logger.getLogger(OrderRecordController.class);

    private static final String prefix = "orderRecord";

    @Autowired
    private OrderRecordMapper orderRecordMapper;
    @Autowired
    private OrderRecordService orderRecordService;

    @RequestMapping(path = prefix+"/order/detail/{id}", method = RequestMethod.GET)
    public OrderRecord detail() {
        return this.orderRecordMapper.selectByPrimaryKey(1);
    }

    /**
     * 查询单个实体信息
     * @param id
     * @return
     */
    @RequestMapping(value = prefix+"/order/detail1/{id}", method = RequestMethod.GET)
    public BaseResponse detail1(@PathVariable Integer id) {
        BaseResponse response = new BaseResponse(StatusCode.SUCCESS);

        try {
            OrderRecord orderRecord = this.orderRecordService.selectByPrimaryKey(id);
            response.setData(orderRecord);
        } catch (Exception e) {
            logger.error("查询异常",e);
            response = new BaseResponse(StatusCode.FAIL);
            response.setMessage("参数不正确");
        }
        return response;
    }

    @RequestMapping(value = prefix+"/order/list/")
    public BaseResponse list() {
        BaseResponse response = new BaseResponse(StatusCode.SUCCESS);

        try {
            //存放list
            List<OrderRecord> dataList = this.orderRecordService.findAll();
            //存放map
            Map<String, Object> map = Maps.newHashMap();
            map.put("dataList", dataList);
            response.setData(map);
        } catch (Exception e) {
            logger.error("查询列表信息异常", e);
            response = new BaseResponse(StatusCode.FAIL);
        }

        return response;
    }

    @RequestMapping(value = prefix+"/order/insert")
    public BaseResponse insert(@RequestBody OrderRecordInsertUpdateDto dto) {
        BaseResponse response = new BaseResponse(StatusCode.SUCCESS);
        try {
            logger.info("请求参数{}:"+dto);
            this.orderRecordService.insert(dto);
        } catch (Exception e) {
            logger.error("新增数据异常", e);
            response = new BaseResponse(StatusCode.FAIL);
        }
        return response;
    }

    @RequestMapping(value = prefix+"/order/update")
    public BaseResponse update(@RequestBody OrderRecordInsertUpdateDto dto) {
        BaseResponse response = new BaseResponse(StatusCode.SUCCESS);
        try {
            logger.info("请求参数{}:"+dto);
            OrderRecord orderRecord = this.orderRecordService.selectByPrimaryKey(dto.getId());
            if(orderRecord == null) {
                response = new BaseResponse(StatusCode.NOT_EXIST_ENTITY);
                return response;
            }
            this.orderRecordService.update(orderRecord,dto);
        } catch (Exception e) {
            logger.error("更新数据异常", e);
            response = new BaseResponse(StatusCode.FAIL);
        }
        return response;
    }
}
