package cn.ikangjia.gwds.api.model;

import lombok.Data;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/3/3 11:32
 */
@Data
public class DatabaseDTO {
    private Long datasourceId;
    private String databaseName;
    private String collation;
    private String characterSet;
}
