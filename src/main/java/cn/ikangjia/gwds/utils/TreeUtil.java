package cn.ikangjia.gwds.utils;

import cn.ikangjia.gwds.api.model.TreeVO;
import cn.ikangjia.gwds.domain.entity.DatasourceDO;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/24 09:45
 */
public class TreeUtil {

    public static String buildDatasourceKey(DatasourceDO ds) {
        return ds.getId() + "_" + ds.getType();
    }

    public static Integer judgeNodeType(TreeVO node){
        return 1;
    }
}
