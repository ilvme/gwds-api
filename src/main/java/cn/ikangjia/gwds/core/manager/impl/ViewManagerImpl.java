package cn.ikangjia.gwds.core.manager.impl;

import cn.ikangjia.gwds.core.ExecuteHandler;
import cn.ikangjia.gwds.core.manager.ViewManager;
import cn.ikangjia.gwds.core.sql.ViewSQL;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 13:54
 */
@Component
public class ViewManagerImpl implements ViewManager {
    private final ExecuteHandler handler;

    public ViewManagerImpl(ExecuteHandler handler) {
        this.handler = handler;
    }

    @Override
    public List<String> listView(long datasourceId, String databaseName) {
        return handler.executeQueryStrings(String.format(ViewSQL.VIEW_LIST_SELECT, databaseName), "TABLE_NAME");
    }
}
