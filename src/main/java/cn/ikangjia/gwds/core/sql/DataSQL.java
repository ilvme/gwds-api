package cn.ikangjia.gwds.core.sql;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/2/7 09:59
 */
public interface DataSQL {
    
    String SHOW_TABLE_DATA = "select * from %s.%s limit %s,%s";
    String SHOW_TABLE_DATA_WHERE = "select * from %s.%s where %s limit %s,%s";
    String SHOW_TABLE_DATA_ORDER_BY = "select * from %s.%s order by %s limit %s,%s";
    String SHOW_TABLE_DATA_ORDER_BY_WHERE = "select * from %s.%s where %s order by %s limit %s,%s";
    String SHOW_TABLE_DATA_COUNT = "select count(*) from %s.%s";
    String SHOW_TABLE_DATA_COUNT_WHERE = "select count(*) from %s.%s where %s";
}
