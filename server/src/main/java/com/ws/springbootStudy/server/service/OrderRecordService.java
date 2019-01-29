package com.ws.springbootStudy.server.service;

import com.ws.springbootStudy.domain.OrderRecord;
import com.ws.springbootStudy.mapper.OrderRecordMapper;
import com.ws.springbootStudy.server.dto.OrderRecordInsertUpdateDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 业务逻辑处理
 * Created by UPC on 2019/1/5.
 */
@Service
public class OrderRecordService {

    @Autowired
    private OrderRecordMapper orderRecordMapper;

    public OrderRecord selectByPrimaryKey(Integer id) {
        return this.orderRecordMapper.selectByPrimaryKey(id);
    }

    public List<OrderRecord> findAll() {
        return this.orderRecordMapper.findAll();
    }

    @Transactional()
    public void insert(OrderRecordInsertUpdateDto dto) throws Exception{

        OrderRecord orderRecord = new OrderRecord();
        BeanUtils.copyProperties(dto, orderRecord);
        orderRecord.setCreateTime(new Date());

        this.orderRecordMapper.insert(orderRecord);
    }

    public void update(OrderRecord orderRecord, OrderRecordInsertUpdateDto dto) {

        final Integer pk = orderRecord.getId();
        BeanUtils.copyProperties(dto, orderRecord);
        orderRecord.setId(pk);
        orderRecord.setUpdateTime(new Date());
        this.orderRecordMapper.updateByPrimaryKey(orderRecord);
    }
}
