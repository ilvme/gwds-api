package cn.ikangjia.gwds.api.model.table;

import lombok.Data;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 17:47
 */
@Data
public class TableInfoVO {
    private String databaseName;
    private String tableName;
    private String tableType;
    private String dataLength;
    private String engine;
    private String createTime;
    private String updateTime;
    private String collation;
    private String comment;

    private String rowNum; // 数据行数
    private String tableDDL;
}
