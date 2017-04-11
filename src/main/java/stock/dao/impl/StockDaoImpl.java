package stock.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import stock.dao.StockDao;
import stock.model.Stock;

import java.util.List;

/**
 * Created by Jason on 4/10/17.
 */
public class StockDaoImpl extends HibernateDaoSupport implements StockDao {

    @Transactional(readOnly = false)
    public void save(Stock stock){
        getHibernateTemplate().save(stock);
    }

    @Transactional(readOnly = false)
    public void update(Stock stock){
        getHibernateTemplate().update(stock);
    }

    @Transactional(readOnly = false)
    public void delete(Stock stock){
        getHibernateTemplate().delete(stock);
    }

    @Transactional(readOnly = false)
    public Stock findByStockCode(String stockCode){
        List list = getHibernateTemplate().find(
                "from Stock where stockCode=?",stockCode
        );
        return (Stock)list.get(0);
    }

}