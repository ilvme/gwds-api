package cn.ikangjia.gwds.core.manager.impl;

import cn.ikangjia.gwds.core.ExecuteHandler;
import cn.ikangjia.gwds.core.manager.DatabaseManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 09:32
 */
@Service
public class DatabaseManagerImpl implements DatabaseManager {

    private final ExecuteHandler handler;
    public DatabaseManagerImpl(ExecuteHandler handler) {
        this.handler = handler;
    }

    @Override
    public List<String> listDatabase(long datasourceId, boolean systemDatabaseShow) {
        return handler.executeQueryStrings("show databases;", "Database");
    }
}
