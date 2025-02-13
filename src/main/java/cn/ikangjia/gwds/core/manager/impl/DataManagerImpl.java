package cn.ikangjia.gwds.core.manager.impl;

import cn.ikangjia.gwds.api.model.query.DataQuery;
import cn.ikangjia.gwds.core.ExecuteHandler;
import cn.ikangjia.gwds.core.entity.DataEntity;
import cn.ikangjia.gwds.core.manager.DataManager;
import cn.ikangjia.gwds.core.sql.DataSQLBuilder;
import org.springframework.stereotype.Service;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/2/7 09:57
 */
@Service
public class DataManagerImpl implements DataManager {

    private final ExecuteHandler handler;
    public DataManagerImpl(ExecuteHandler handler) {
        this.handler = handler;
    }

    @Override
    public DataEntity showTableData(Long datasourceId, DataQuery dataQuery) {
        if (handler.getConnection() != null) {
            DataEntity dataEntity = handler.executeQueryForData(DataSQLBuilder.buildShowTableDataSQL(dataQuery));

            String total = handler.executeQueryString(DataSQLBuilder.buildShowTableDataCountSQL(dataQuery), "total");
            dataEntity.setTotal(Long.parseLong(total));

            return dataEntity;
        }
        return null;
    }
}
