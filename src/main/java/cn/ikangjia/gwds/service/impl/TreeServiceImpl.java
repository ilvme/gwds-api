package cn.ikangjia.gwds.service.impl;

import cn.ikangjia.gwds.api.model.TreeVO;
import cn.ikangjia.gwds.core.DatasourceEnum;
import cn.ikangjia.gwds.domain.entity.DatasourceDO;
import cn.ikangjia.gwds.domain.mapper.DatasourceMapper;
import cn.ikangjia.gwds.service.DatasourceService;
import cn.ikangjia.gwds.service.TreeService;
import cn.ikangjia.gwds.utils.TreeUtil;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author kangJia
 * @email  ikangjia.cn@outlook.com
 * @since  2024/12/24 10:48
 */
@Service
public class TreeServiceImpl implements TreeService {

    private final DatasourceMapper datasourceMapper;

    public TreeServiceImpl(DatasourceMapper datasourceMapper) {
        this.datasourceMapper = datasourceMapper;
    }

    @Override
    public List<TreeVO> list(Long datasourceId, TreeVO parent) {
        // 查询数据源列表
        if (datasourceId == null) {
            List<DatasourceDO> list = datasourceMapper.selectList(null);
            return list.stream().map(ds -> {
                TreeVO treeVO = new TreeVO();
                treeVO.setLevel(0);
                treeVO.setIsLeaf(false);
                treeVO.setParentNode(null);
                treeVO.setChildren(null);
                treeVO.setLabel(ds.getName());
                treeVO.setKey(TreeUtil.buildDatasourceKey(ds));
                treeVO.setType(DatasourceEnum.getName(ds.getType()));
                return treeVO;
            }).toList();
        }
        if (Objects.equals(parent.getKey(), "1_1")){
            // 获取数据源下的数据库
            TreeVO d1 = new TreeVO();
            d1.setLevel(1);
            d1.setIsLeaf(false);
            d1.setParentNode(parent);
            d1.setChildren(null);
            d1.setLabel("mysql");
            d1.setKey("11");
            d1.setType("database");

            TreeVO d2 = new TreeVO();
            d2.setLevel(1);
            d2.setIsLeaf(false);
            d2.setParentNode(parent);
            d2.setChildren(null);
            d2.setLabel("information_schema");
            d2.setKey("22");
            d2.setType("database");

            TreeVO d3 = new TreeVO();
            d3.setLevel(1);
            d3.setIsLeaf(false);
            d3.setParentNode(parent);
            d3.setChildren(null);
            d3.setLabel("数据对象");
            d3.setKey("33");
            d3.setType("数据对象");



            return List.of(d1,d2,d3);
        }
        return List.of();
    }
}
