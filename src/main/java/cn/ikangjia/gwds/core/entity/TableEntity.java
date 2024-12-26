package cn.ikangjia.gwds.core.entity;

import lombok.Data;

/**
 *
 * @author kangJia
 * @email  ikangjia.cn@outlook.com
 * @since  2024/12/26 17:33
 */
@Data
public class TableEntity {
    private String databaseName;
    private String tableName;
    private String tableType;
    private String dataLength;
    private String engine;
    private String createTime;
    private String updateTime;
    private String collation;
    private String comment;
}
