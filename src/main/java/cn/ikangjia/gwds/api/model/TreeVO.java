package cn.ikangjia.gwds.api.model;

import lombok.Data;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/24 09:34
 */
@Data
public class TreeVO {
    private Integer level; // 层级
    private String type;  // 类型

    private String key;
    private String label;

    private TreeVO parentNode;

    private List<TreeVO> children;
}
