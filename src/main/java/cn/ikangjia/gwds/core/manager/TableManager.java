package cn.ikangjia.gwds.core.manager;

import cn.ikangjia.gwds.api.model.RenameDTO;
import cn.ikangjia.gwds.api.model.TableCreateDTO;
import cn.ikangjia.gwds.api.model.TableInfoVO;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 13:20
 */
public interface TableManager {
    List<String> listTable(long datasourceId, String databaseName);

    void createTable(long datasourceId, TableCreateDTO createDTO);

    Boolean clearTable(Long datasourceId, String databaseName, String tableName);

    Boolean truncateTable(Long datasourceId, String databaseName, String tableName);

    Boolean dropTable(Long datasourceId, String databaseName, String tableName);

    Boolean renameTable(Long datasourceId, RenameDTO renameDTO);

    TableInfoVO getTableInfo(Long datasourceId, String databaseName, String tableName);
}
