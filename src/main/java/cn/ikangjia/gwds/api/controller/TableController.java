package cn.ikangjia.gwds.api.controller;

import cn.ikangjia.gwds.api.model.table.RenameDTO;
import cn.ikangjia.gwds.core.manager.TableManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/2/6 11:06
 */
@RestController
@RequestMapping("/table")
public class TableController {

    private final TableManager tableManager;
    public TableController(TableManager tableManager) {
        this.tableManager = tableManager;
    }

    @GetMapping
    public List<String> listTables(Long datasourceId, String databaseName){
        return tableManager.listTable(datasourceId, databaseName);
    }

    @PutMapping("/rename")
    public Boolean renameTable(@RequestBody RenameDTO renameDTO){
        return tableManager.renameTable(renameDTO.getDatasourceId(), renameDTO);
    }
}
