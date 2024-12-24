package cn.ikangjia.gwds.api.controller;

import cn.ikangjia.gwds.api.model.ResultVO;
import cn.ikangjia.gwds.api.model.TreeVO;
import cn.ikangjia.gwds.domain.entity.DatasourceDO;
import cn.ikangjia.gwds.service.DatasourceService;
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
        List<DatasourceDO> list = datasourceService.list();
        System.out.println(list.getFirst());
        return list;
    }

    @GetMapping("/tree")
    public List<TreeVO> tree() {
        return datasourceService.listForTree();
    }

    @GetMapping("/{id}")
    public DatasourceDO get(@PathVariable Long id) {
        return datasourceService.get(id);
    }

    @PostMapping
    public void createDatasource(@RequestBody DatasourceDO datasourceDO) {
        datasourceService.createDatasource(datasourceDO);
    }

    @PutMapping
    public void updateDatasource(@RequestBody DatasourceDO datasourceDO) {
        datasourceService.updateDatasource(datasourceDO);
    }

    @DeleteMapping
    public void removeDatasource(Long id) {
        datasourceService.removeDatasource(id);
    }
}
