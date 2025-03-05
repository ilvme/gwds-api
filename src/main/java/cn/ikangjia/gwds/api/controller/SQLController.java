package cn.ikangjia.gwds.api.controller;

import cn.ikangjia.gwds.api.model.sql.SQLExecuteDTO;
import cn.ikangjia.gwds.core.entity.SQLResultEntity;
import cn.ikangjia.gwds.core.manager.SQLManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SQL 执行器控制器
 *
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/3/5 16:00
 */
@RestController
@RequestMapping("/sql")
public class SQLController {

    private final SQLManager sqlManager;

    public SQLController(SQLManager sqlManager) {
        this.sqlManager = sqlManager;
    }

    @PostMapping("/execute")
    public List<SQLResultEntity> execute(@RequestBody SQLExecuteDTO sqlExecuteDTO) {
        return sqlManager.executeSQLBatch(
                sqlExecuteDTO.getDatasourceId(),
                sqlExecuteDTO.getDatabaseName(),
                sqlExecuteDTO.getSqlList());
    }
}
