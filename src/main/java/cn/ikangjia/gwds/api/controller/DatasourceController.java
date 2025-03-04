package cn.ikangjia.gwds.api.controller;

import cn.ikangjia.gwds.api.model.TreeNode;
import cn.ikangjia.gwds.api.service.DatasourceService;
import cn.ikangjia.gwds.domain.entity.DatasourceDO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/23 16:51
 */
@RestController
@RequestMapping("/datasource")
public class DatasourceController {

    private final DatasourceService datasourceService;

    public DatasourceController(DatasourceService datasourceService) {
        this.datasourceService = datasourceService;
    }

    @GetMapping
    public List<DatasourceDO> list() {
        return datasourceService.list();
    }

    @GetMapping("/tree")
    public List<TreeNode> tree() {
        return datasourceService.listForTree();
    }

    @GetMapping("/tree/level1")
    public List<TreeNode> treeLevel1() {
        return datasourceService.listForTree();
    }


    @GetMapping("/{id}")
    public DatasourceDO get(@PathVariable Long id) {
        return datasourceService.get(id);
    }

    @PostMapping
    public TreeNode createDatasource(@RequestBody DatasourceDO datasourceDO) {
        return datasourceService.createDatasource(datasourceDO);
    }

    @PutMapping
    public void updateDatasource(@RequestBody DatasourceDO datasourceDO) {
        datasourceService.updateDatasource(datasourceDO);
    }

    @DeleteMapping("/{id}")
    public void removeDatasource(@PathVariable Long id) {
        datasourceService.removeDatasource(id);
    }
}
