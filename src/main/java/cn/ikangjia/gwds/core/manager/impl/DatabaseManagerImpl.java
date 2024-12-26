package cn.ikangjia.gwds.core.manager.impl;

import cn.ikangjia.gwds.api.model.query.DataQuery;
import cn.ikangjia.gwds.core.ExecuteHandler;
import cn.ikangjia.gwds.core.entity.CharacterSetEntity;
import cn.ikangjia.gwds.core.entity.DataEntity;
import cn.ikangjia.gwds.core.entity.DatabaseEntity;
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
    public void createDatabase(long datasourceId, DatabaseEntity database) {

    }

    @Override
    public void dropDatabase(long datasourceId, String databaseName) {

    }

    @Override
    public void alterDatabase(long datasourceId, String databaseName, String characterSet, String collation) {

    }

    @Override
    public DatabaseEntity getDatabaseInfo(long datasourceId, String databaseName) {
        return null;
    }

    @Override
    public List<String> listDatabase(long datasourceId, boolean systemDatabaseShow) {
        return handler.executeQueryStrings("show databases;", "Database");
    }

    @Override
    public List<String> listTable(long datasourceId, String databaseName) {
        return List.of();
    }

    @Override
    public List<String> listView(long datasourceId, String databaseName) {
        return List.of();
    }

    @Override
    public List<CharacterSetEntity> listCharacterSets(Long datasourceId) {
        return List.of();
    }

    @Override
    public List<String> listCollations(Long datasourceId, String characterSet) {
        return List.of();
    }

    @Override
    public DataEntity showTableData(Long datasourceId, DataQuery dataQuery) {
        return null;
    }

    @Override
    public Long countTableDataRows(Long datasourceId, String databaseName, String tableName) {
        return 0L;
    }
}
