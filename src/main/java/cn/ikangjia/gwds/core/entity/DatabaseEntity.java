package cn.ikangjia.gwds.core.entity;

import lombok.Data;

/**
 *
 * @author kangJia
 * @email  ikangjia.cn@outlook.com
 * @since  2024/12/26 17:33
 */
@Data
public class DatabaseEntity {
    private String databaseName;
    private String collation;
    private String characterSet;

    private String sqlPath;

    private String version;

    private String databaseDDL;


    private String tableCount;
    private String viewCount;
    private String procedureCount;
    private String functionCount;
}
