package cn.ikangjia.gwds.api.service.impl;

import cn.ikangjia.gwds.api.model.TreeNode;
import cn.ikangjia.gwds.domain.entity.DatasourceDO;
import cn.ikangjia.gwds.domain.mapper.DatasourceMapper;
import cn.ikangjia.gwds.api.service.DatasourceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/23 17:16
 */
@Service
public class DatasourceServiceImpl implements DatasourceService {

    private final DatasourceMapper datasourceMapper;

    public DatasourceServiceImpl(DatasourceMapper datasourceMapper) {
        this.datasourceMapper = datasourceMapper;
    }

    @Override
    public void createDatasource(DatasourceDO datasourceDO) {
        datasourceMapper.insert(datasourceDO);
    }

    @Override
    public void updateDatasource(DatasourceDO datasourceDO) {
        datasourceMapper.updateById(datasourceDO);
    }

    @Override
    public void removeDatasource(Long id) {
        datasourceMapper.deleteById(id);
    }

    @Override
    public List<DatasourceDO> list() {
        return datasourceMapper.selectList(null);
    }

    @Override
    public DatasourceDO get(Long id) {
        return datasourceMapper.selectById(id);
    }

    @Override
    public List<TreeNode> listForTree() {
        return List.of();
    }
}
