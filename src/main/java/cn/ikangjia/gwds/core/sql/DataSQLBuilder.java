package cn.ikangjia.gwds.core.sql;

import cn.ikangjia.gwds.api.model.query.DataQuery;
import org.springframework.util.StringUtils;

import static cn.ikangjia.gwds.core.sql.DataSQL.*;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/2/7 09:59
 */
public class DataSQLBuilder {

    /**
     * 获取表数据
     *
     * @param dataQuery 查询条件
     * @return 结果
     */
    public static String buildShowTableDataSQL(DataQuery dataQuery) {
        String databaseName = dataQuery.getDatabaseName();
        String tableName = dataQuery.getTableName();
        String where = dataQuery.getWhere();
        String orderBy = dataQuery.getOrderBy();
        int pageNum = dataQuery.getPageNum();
        int pageSize = dataQuery.getPageSize();

        // 存在 where 条件
        if (StringUtils.hasLength(where)) {
            if (StringUtils.hasLength(orderBy)) {
                // 存在 order by
                return String.format(SHOW_TABLE_DATA_ORDER_BY_WHERE, databaseName, tableName, where, orderBy, (pageNum - 1) * pageSize, pageSize);
            } else {
                // 不存在 order by
                return String.format(SHOW_TABLE_DATA_WHERE, databaseName, tableName, where, (pageNum - 1) * pageSize, pageSize);
            }
            // 不存在 where 条件
        } else {
            if (StringUtils.hasLength(orderBy)) {
                // 不存在 order by
                return String.format(SHOW_TABLE_DATA_ORDER_BY, databaseName, tableName, orderBy, (pageNum - 1) *pageSize, pageSize);
            } else {
                // 不存在 order by
                return String.format(SHOW_TABLE_DATA, databaseName, tableName, (pageNum - 1) * pageSize, pageSize);
            }
        }
    }

    /**
     * 获取表数据总数
     *
     * @param dataQuery 查询条件
     * @return 结果
     */
    public static String buildShowTableDataCountSQL(DataQuery dataQuery) {
        String databaseName = dataQuery.getDatabaseName();
        String tableName = dataQuery.getTableName();
        String where = dataQuery.getWhere();
        if (StringUtils.hasLength(where)) {
            return String.format(SHOW_TABLE_DATA_COUNT_WHERE, databaseName, tableName, where);
        } else {
            return String.format(SHOW_TABLE_DATA_COUNT, databaseName, tableName);
        }
    }
}
