package com.jason.webproject.dao;

import com.jason.webproject.model.SportOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Jason on 4/13/17.
 */

// 数据库操作
public interface SportOrderDao {
    public List<SportOrder> selectSportOrderByPurposeId(int purposeId);
    public List<SportOrder> selectSportOrderByPageNo(@Param("startId") int startId, @Param("pageSize") int pageSize);
}
