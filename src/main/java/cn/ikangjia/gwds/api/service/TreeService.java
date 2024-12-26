package cn.ikangjia.gwds.api.service;

import cn.ikangjia.gwds.api.model.TreeNode;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/24 10:38
 */
public interface TreeService {

    List<TreeNode> list(Long datasourceId, TreeNode parent);
}
