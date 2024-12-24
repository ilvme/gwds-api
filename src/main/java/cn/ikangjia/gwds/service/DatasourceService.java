package cn.ikangjia.gwds.service;

import cn.ikangjia.gwds.api.model.TreeVO;
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

    List<TreeVO> listForTree();
}
