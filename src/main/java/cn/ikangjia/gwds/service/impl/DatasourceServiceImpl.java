package cn.ikangjia.gwds.service.impl;

import cn.ikangjia.gwds.api.model.TreeVO;
import cn.ikangjia.gwds.core.DatasourceEnum;
import cn.ikangjia.gwds.domain.entity.DatasourceDO;
import cn.ikangjia.gwds.domain.mapper.DatasourceMapper;
import cn.ikangjia.gwds.service.DatasourceService;
import cn.ikangjia.gwds.utils.TreeUtil;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<TreeVO> listForTree() {
        List<DatasourceDO> list = datasourceMapper.selectList(null);

        return list.stream().map(ds -> {
            TreeVO treeVO = new TreeVO();
            treeVO.setLevel(0);
            treeVO.setParentNode(null);
            treeVO.setChildren(Collections.emptyList());
            treeVO.setLabel(ds.getName());
            treeVO.setKey(TreeUtil.buildDatasourceKey(ds));
            treeVO.setType(DatasourceEnum.getName(ds.getType()));
            return treeVO;
        }).toList();
    }
}
