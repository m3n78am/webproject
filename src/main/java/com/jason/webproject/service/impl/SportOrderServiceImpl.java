package com.jason.webproject.service.impl;

import com.jason.webproject.dto.SportOrderDto;
import com.jason.webproject.dao.SportOrderDao;
import com.jason.webproject.model.SportOrder;
import com.jason.webproject.service.SportOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 4/13/17.
 */

@Component
public class SportOrderServiceImpl implements SportOrderService {

    private static final Logger logger = LoggerFactory.getLogger(SportOrderService.class);
    private static final Map<Integer, String> purposeMap = new HashMap<Integer, String>() {{
        put(1, "羽毛球场地费用");
        put(2, "羽毛球水费");
        put(3, "篮球场地费用");
    }};

    @Autowired
    SportOrderDao sportOrderMapper;

    public List<SportOrderDto> getSportOrderList(int startId, int pageSize) {
        List<SportOrder> resultList = sportOrderMapper.selectSportOrderByPageNo(startId, pageSize);

        List<SportOrderDto> dtoResultList = new ArrayList<>();

        for (SportOrder item : resultList) {
            SportOrderDto x = new SportOrderDto();
            x.setId(item.getId());
            x.setDate(item.getDate());
            x.setPayment(item.getPayment());
            x.setPurpose(purposeMap.get(item.getPurpose()));
            dtoResultList.add(x);
        }
        return dtoResultList;
    }
}
