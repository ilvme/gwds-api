package cn.ikangjia.gwds.service;

import cn.ikangjia.gwds.api.model.TreeVO;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/24 10:38
 */
public interface TreeService {

    List<TreeVO> list(Long datasourceId, TreeVO parent);
}
