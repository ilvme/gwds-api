package cn.ikangjia.gwds.core.manager;

import cn.ikangjia.gwds.core.entity.CharacterSetEntity;
import cn.ikangjia.gwds.core.entity.DatabaseEntity;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 09:32
 */
public interface DatabaseManager {
    void createDatabase(long datasourceId, DatabaseEntity database);

    void dropDatabase(long datasourceId, String databaseName);

    void alterDatabase(long datasourceId, String databaseName, String characterSet, String collation);

    DatabaseEntity getDatabaseInfo(long datasourceId, String databaseName);

    List<String> listDatabase(long datasourceId, boolean systemDatabaseShow);

    List<String> listTable(long datasourceId, String databaseName);

    List<String> listView(long datasourceId, String databaseName);

    List<CharacterSetEntity> listCharacterSets(Long datasourceId);

    List<String> listCollations(Long datasourceId, String characterSet);

    Long countTableDataRows(Long datasourceId, String databaseName, String tableName);

}
