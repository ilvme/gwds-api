package cn.ikangjia.gwds.core.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 *
 * @author kangJia
 * @email  ikangjia.cn@outlook.com
 * @since  2024/12/26 17:33
 */
@Data
public class DataEntity {

    private List<String> columnNameList;
    private List<Map<String, Object>> dataMapList;

    private Long total;
}
