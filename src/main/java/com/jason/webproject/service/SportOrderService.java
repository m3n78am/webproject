package com.jason.webproject.service;

import com.jason.webproject.dto.SportOrderDto;

import java.util.List;

/**
 * Created by Jason on 4/13/17.
 */
public interface SportOrderService {
    List<SportOrderDto> getSportOrderList(int startId, int pageSize);
}
