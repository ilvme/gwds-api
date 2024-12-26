package cn.ikangjia.gwds.api.service;

import cn.ikangjia.gwds.api.model.TreeNode;
import cn.ikangjia.gwds.domain.entity.DatasourceDO;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/23 17:15
 */
public interface DatasourceService {
    void createDatasource(DatasourceDO datasourceDO);
    void updateDatasource(DatasourceDO datasourceDO);
    void removeDatasource(Long id);
    List<DatasourceDO> list();
    DatasourceDO get(Long id);

    List<TreeNode> listForTree();
}
