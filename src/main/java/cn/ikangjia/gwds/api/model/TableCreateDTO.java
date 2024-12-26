package cn.ikangjia.gwds.api.model;

import cn.ikangjia.gwds.core.entity.ColumnEntity;
import lombok.Data;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 17:50
 */
@Data
public class TableCreateDTO {
    private Long datasourceId;
    private String databaseName;

    private String tableName;
    private String comment;

    private List<ColumnEntity> columnEntityList;
}
