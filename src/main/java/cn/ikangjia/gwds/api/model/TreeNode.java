package cn.ikangjia.gwds.api.model;

import lombok.Data;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/24 09:34
 */
@Data
public class TreeNode {
    private Integer level; // 节点层级
    private String nodeType;  // 节点类型
    private String dsType; // 数据源类型

    private String key;
    private String label;

    private Boolean isLeaf;
    private TreeNode parent;

    private List<TreeNode> children;
}
