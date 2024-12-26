package cn.ikangjia.gwds.core.manager.impl;

import cn.ikangjia.gwds.core.ExecuteHandler;
import cn.ikangjia.gwds.core.manager.TableManager;
import cn.ikangjia.gwds.core.sql.TableSQL;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 13:21
 */
@Component
public class TableManagerImpl implements TableManager {

    private final ExecuteHandler handler;
    public TableManagerImpl(ExecuteHandler handler) {
        this.handler = handler;
    }
    @Override
    public List<String> listTable(long datasourceId, String databaseName) {
        return handler.executeQueryStrings(String.format(TableSQL.TABLE_LIST_SELECT, databaseName), "TABLE_NAME");
    }
}
