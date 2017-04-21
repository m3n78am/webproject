package com.jason.webproject.controller;

import com.jason.webproject.dao.SportOrderDao;
import com.jason.webproject.dto.SportOrderDto;
import com.jason.webproject.model.SportOrder;
import com.jason.webproject.service.SportOrderService;
import com.jason.webproject.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 4/13/17.
 */
@Controller
@RequestMapping("/sport")
public class SportOrderController {

    private static final Logger logger = LoggerFactory.getLogger(SportOrderController.class);


    @Autowired
    SportOrderService sportOrderService;

    @Autowired
    SportOrderDao sportOrderMapper;

    @RequestMapping(value = "order", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<List<SportOrder>> getOrderDetail(@RequestParam Map<String, String> queryMap, Model model) {

        int purposeId = Integer.parseInt(queryMap.containsKey("id") ? queryMap.get("id") : "1");
        List<SportOrder> result = sportOrderMapper.selectSportOrderByPurposeId(purposeId);

        return new JsonResult<>(result);
    }


    @RequestMapping(value = "orderList", method = RequestMethod.GET)
    public String getOrderListByPageNo(@RequestParam Map<String, String> queryMap, Model model) {

        int pageNo = Integer.parseInt(queryMap.containsKey("page") ? queryMap.get("page") : "1");
        int pageSize = Integer.parseInt(queryMap.containsKey("size") ? queryMap.get("size") : "10");

        List<SportOrderDto> resultList = sportOrderService.getSportOrderList((pageNo - 1) * pageSize, pageSize);

//        logger.info("sportOrderService1: {}", sportOrderService1 );
//        logger.info("sportOrderService2: {}", sportOrderService2 );
        model.addAttribute("orderList", resultList);
        return "orderList";
    }

}
