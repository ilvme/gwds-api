package cn.ikangjia.gwds.core.manager.impl;

import cn.ikangjia.gwds.api.model.DatabaseDTO;
import cn.ikangjia.gwds.core.ExecuteHandler;
import cn.ikangjia.gwds.core.entity.CharacterSetEntity;
import cn.ikangjia.gwds.core.entity.DatabaseEntity;
import cn.ikangjia.gwds.core.manager.DatabaseManager;
import cn.ikangjia.gwds.core.sql.DatabaseSQL;
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
    public void createDatabase(long datasourceId, DatabaseDTO databaseDTO) {
        handler.executeUpdate("create database " + databaseDTO.getDatabaseName() + ";");
    }

    @Override
    public void dropDatabase(long datasourceId, String databaseName) {
        handler.execute(String.format(DatabaseSQL.database_drop, databaseName));
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
    public Long countTableDataRows(Long datasourceId, String databaseName, String tableName) {
        return 0L;
    }
}
