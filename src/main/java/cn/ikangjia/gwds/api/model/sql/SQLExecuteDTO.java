package cn.ikangjia.gwds.api.model.sql;

import lombok.Data;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/3/5 16:04
 */
@Data
public class SQLExecuteDTO {
    private Long datasourceId;
    private String databaseName;

    private List<String> sqlList;
}
