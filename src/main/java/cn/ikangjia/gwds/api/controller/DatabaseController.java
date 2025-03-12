package cn.ikangjia.gwds.api.controller;

import cn.ikangjia.gwds.api.model.DatabaseDTO;
import cn.ikangjia.gwds.api.model.TreeNode;
import cn.ikangjia.gwds.core.manager.DatabaseManager;
import cn.ikangjia.gwds.utils.TreeUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 14:18
 */
@RestController
@RequestMapping("/database")
public class DatabaseController {

    private final DatabaseManager databaseManager;

    public DatabaseController(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @PostMapping
    public TreeNode createDatabase(@RequestBody DatabaseDTO databaseDTO) {
        databaseManager.createDatabase(databaseDTO.getDatasourceId(), databaseDTO);
        TreeNode treeNode = new TreeNode();
        treeNode.setKey(TreeUtil.buildDatabaseKey(databaseDTO.getDatasourceId(), databaseDTO.getDatabaseName()));
        treeNode.setLabel(databaseDTO.getDatabaseName());
        treeNode.setNodeType("db");
        treeNode.setDsType("mysql");
        treeNode.setIsLeaf(false);

        return treeNode;
    }

    @DeleteMapping
    public void dropDatabase(Long datasourceId, String databaseName) {
        databaseManager.dropDatabase(datasourceId, databaseName);
    }

    @GetMapping
    public List<String> listDatabase(Long datasourceId, boolean systemDatabaseShow) {
        return databaseManager.listDatabase(datasourceId, true);
    }
}
