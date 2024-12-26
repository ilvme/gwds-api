package cn.ikangjia.gwds.service.impl;

import cn.ikangjia.gwds.api.model.TreeNode;
import cn.ikangjia.gwds.core.TreeMetaEnum;
import cn.ikangjia.gwds.core.manager.DatabaseManager;
import cn.ikangjia.gwds.core.manager.TableManager;
import cn.ikangjia.gwds.core.manager.ViewManager;
import cn.ikangjia.gwds.domain.entity.DatasourceDO;
import cn.ikangjia.gwds.domain.mapper.DatasourceMapper;
import cn.ikangjia.gwds.service.TreeService;
import cn.ikangjia.gwds.utils.TreeUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/24 10:48
 */
@Service
@AllArgsConstructor
public class TreeServiceImpl implements TreeService {

    private final DatasourceMapper datasourceMapper;
    public final DatabaseManager databaseManager;
    private final TableManager tableManager;
    private final ViewManager viewManager;


    @Override
    public List<TreeNode> list(Long datasourceId, TreeNode parent) {
        // 数据源 id 为空时，即为查询根节点
        if (datasourceId == null) {
            List<DatasourceDO> list = datasourceMapper.selectList(null);
            return list.stream().map(TreeUtil::buildDatasourceTreeNode).toList();
        }

        switch (TreeMetaEnum.getByType(parent.getNodeType())) {
            case TreeMetaEnum.DATASOURCE: // 查询数据库列表
                List<String> dbNameList = databaseManager.listDatabase(datasourceId, true);
                System.out.println(dbNameList);
                List<TreeNode> dbTreeNodeList = dbNameList.stream()
                        .map(dbName -> TreeUtil.buildDatabaseTreeNode(datasourceId, parent, dbName))
                        .collect(Collectors.toList());

                dbTreeNodeList.add(TreeUtil.buildServerObjFolderTreeNode(datasourceId, parent));

                return dbTreeNodeList;
            case TreeMetaEnum.DATABASE: // 查询表、视图、存储过程文件夹
                return TreeUtil.buildDatabaseChildrenFolderTreeNodes(datasourceId, parent);
            case TreeMetaEnum.TABLE_FOLDER: // 查询表列表
                List<String> tableNameList = tableManager.listTable(datasourceId, parent.getKey().split("-")[1]);
                return tableNameList.stream()
                        .map(tableName -> TreeUtil.buildTableTreeNode(datasourceId, parent, tableName))
                        .collect(Collectors.toList());
            case TreeMetaEnum.SERVER_OBJECT_FOLDER: // 查询服务对象列表(用户、会话、系统信息、资源)
                return TreeUtil.buildServerObjectItemList(parent);
            case TreeMetaEnum.TABLE: // 查询列、索引、主键文件夹
            case TreeMetaEnum.VIEW_FOLDER: // 查询视图列表
                List<String> viewNameList = viewManager.listView(datasourceId, parent.getKey().split("-")[1]);
                return viewNameList.stream()
                        .map(viewName -> TreeUtil.buildViewTreeNode(datasourceId, parent, viewName))
                        .collect(Collectors.toList());
            case TreeMetaEnum.PROCEDURE_FOLDER: // 查询存储过程列表
            case TreeMetaEnum.SERVER_OBJECT:
            default:
                return List.of();
        }
    }
}
