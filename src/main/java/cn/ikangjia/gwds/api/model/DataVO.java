package cn.ikangjia.gwds.api.model;

import cn.ikangjia.gwds.core.entity.DataEntity;
import lombok.Data;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/2/7 09:52
 */
@Data
public class DataVO {
    private Long datasourceId;
    private String databaseName;
    private String tableName;

    private DataEntity data;
}
