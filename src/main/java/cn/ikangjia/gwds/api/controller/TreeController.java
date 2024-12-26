package cn.ikangjia.gwds.api.controller;

import cn.ikangjia.gwds.api.model.TreeQuery;
import cn.ikangjia.gwds.api.model.TreeNode;
import cn.ikangjia.gwds.service.TreeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author kangJia
 * @email  ikangjia.cn@outlook.com
 * @since  2024/12/24 10:38
 */
@RestController
@RequestMapping("/tree")
public class TreeController {

    private final TreeService treeService;

    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @PostMapping
    public List<TreeNode> tree(@RequestBody TreeQuery treeQuery) {
        return treeService.list(treeQuery.getDatasourceId(), treeQuery.getParent());
    }
}
