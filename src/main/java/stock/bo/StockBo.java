package stock.bo;


import stock.model.Stock;

/**
 * Created by Jason on 4/10/17.
 */
public interface StockBo {

    void save(Stock stock);
    void update(Stock stock);
    void delete(Stock stock);
    Stock findByStockCode(String stockCode);
}