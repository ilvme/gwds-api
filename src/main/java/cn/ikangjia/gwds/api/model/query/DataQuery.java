package cn.ikangjia.gwds.api.model.query;

import lombok.Data;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 17:45
 */
@Data
public class DataQuery {
    private Long datasourceId;
    private String databaseName;
    private String tableName;

    private Integer pageNum;
    private Integer pageSize;

    private String orderBy;
    private String where;
}
