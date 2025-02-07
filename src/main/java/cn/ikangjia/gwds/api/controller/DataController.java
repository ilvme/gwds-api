package cn.ikangjia.gwds.api.controller;

import cn.ikangjia.gwds.api.model.DataVO;
import cn.ikangjia.gwds.api.model.query.DataQuery;
import cn.ikangjia.gwds.core.entity.DataEntity;
import cn.ikangjia.gwds.core.manager.DataManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/2/6 11:04
 */
@RestController
@RequestMapping("/data")
public class DataController {

    private final DataManager dataManager;

    public DataController(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @PostMapping
    public DataVO fetchData(@RequestBody DataQuery dataQuery) {
        DataEntity dataEntity = dataManager.showTableData(dataQuery.getDatasourceId(), dataQuery);

        DataVO dataVO = new DataVO();
        dataVO.setData(dataEntity);
        dataVO.setDatabaseName(dataQuery.getDatabaseName());
        dataVO.setTableName(dataQuery.getTableName());
        dataVO.setDatasourceId(dataQuery.getDatasourceId());

        return dataVO;
    }
}
