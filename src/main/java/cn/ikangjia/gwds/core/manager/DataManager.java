package cn.ikangjia.gwds.core.manager;

import cn.ikangjia.gwds.api.model.query.DataQuery;
import cn.ikangjia.gwds.core.entity.DataEntity;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/2/7 09:56
 */
public interface DataManager {

    DataEntity showTableData(Long datasourceId, DataQuery dataQuery);
}
