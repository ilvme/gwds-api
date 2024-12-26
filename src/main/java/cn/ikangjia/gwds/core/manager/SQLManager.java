package cn.ikangjia.gwds.core.manager;

import cn.ikangjia.gwds.core.entity.SQLResultEntity;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 17:43
 */
public interface SQLManager {
    List<SQLResultEntity> executeSQLBatch(Long datasourceId, String databaseName, List<String> sqlList);
}
