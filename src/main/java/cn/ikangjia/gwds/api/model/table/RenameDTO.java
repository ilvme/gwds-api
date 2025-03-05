package cn.ikangjia.gwds.api.model.table;

import lombok.Data;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 17:47
 */
@Data
public class RenameDTO {
    private Long datasourceId;
    private String databaseName;
    private String tableName;
    private String oldTableName;
}