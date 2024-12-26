package cn.ikangjia.gwds.core.manager;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 13:20
 */
public interface TableManager {
    List<String> listTable(long datasourceId, String databaseName);
}
