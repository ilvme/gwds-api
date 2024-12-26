package cn.ikangjia.gwds.core.manager;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 09:32
 */
public interface DatabaseManager {

    List<String> listDatabase(long datasourceId, boolean systemDatabaseShow);

}
