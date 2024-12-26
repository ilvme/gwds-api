package cn.ikangjia.gwds.utils;

import cn.ikangjia.gwds.api.model.TreeNode;
import cn.ikangjia.gwds.core.enums.DatasourceTypeEnum;
import cn.ikangjia.gwds.core.enums.TreeMetaEnum;
import cn.ikangjia.gwds.domain.entity.DatasourceDO;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/24 09:45
 */
public class TreeUtil {
    public static final String DATASOURCE_KEY_TEMPLATE = "ds-%s"; // 数据源 key 模板

    public static final String DATABASE_KEY_TEMPLATE = "db-%s-%s"; // 数据库 key 模板, 数据库名称-%s数据源id

    // 表文件夹 key 模板, tf-数据库名称-数据源id
    public static final String TABLE_FOLDER_KEY_TEMPLATE = "tf-%s-%s"; // 表文件夹 key 模板
    // 表 key 模板，t-表名称-数据库名称-数据源id
    public static final String TABLE_KEY_TEMPLATE = "t-%s-%s-%s";

    // 视图文件夹 key 模板，vf-数据库名称-数据源id
    public static final String VIEW_FOLDER_KEY_TEMPLATE = "vf-%s-%s";
    // 视图 key 模板, v-视图名称-数据库名称-数据源id
    public static final String VIEW_KEY_TEMPLATE = "v-%s-%s-%s";

    // 存储过程文件夹 key 模板, pf-数据库名称-数据源id
    public static final String PROCEDURE_FOLDER_KEY_TEMPLATE = "pf-%s-%s";
    // 存储过程 key 模板, p-存储过程名称-数据库名称-数据源id
    public static final String PROCEDURE_KEY_TEMPLATE = "p-%s";


    // 服务对象文件夹 key 模板, sof-数据源id
    public static final String SERVER_OBJECT_FOLDER_KEY_TEMPLATE = "sof-%s"; // 服务对象文件夹 key 模板
    // 服务对象 key 模板, so-服务对象类型名称-数据源id
    public static final String SERVER_OBJECT_KEY_TEMPLATE = "so-%s-%s"; // 服务对象 key 模板

    // 列文件夹 key 模板
    public static final String COLUMN_FOLDER_KEY_TEMPLATE = "cf-%s";
    public static final String COLUMN_KEY_TEMPLATE = "c-%s";

    // 索引文件夹 key 模板
    public static final String INDEX_FOLDER_KEY_TEMPLATE = "if-%s";
    public static final String INDEX_KEY_TEMPLATE = "i-%s";

    // 主键文件夹 key 模板
    public static final String PRIMARY_KEY_FOLDER_KEY_TEMPLATE = "pkf-%s";
    public static final String PRIMARY_KEY_KEY_TEMPLATE = "pk-%s";

    /**
     * 构建数据源 key
     * @param ds 数据源
     * @return 数据源 key
     */
    public static String buildDatasourceKey(DatasourceDO ds) {
        return String.format(DATASOURCE_KEY_TEMPLATE, ds.getId());
    }

    /**
     * 构建数据库 key
     * @param datasourceId 数据源id
     * @param dbName 数据库名称
     * @return 数据库 key
     */
    public static String buildDatabaseKey(Long datasourceId,String dbName) {
        return String.format(DATABASE_KEY_TEMPLATE, dbName, datasourceId);
    }

    public static String buildServerObjFolderKey(Long datasourceId) {
        return String.format(SERVER_OBJECT_FOLDER_KEY_TEMPLATE, datasourceId);
    }

    public static TreeNode buildDatasourceTreeNode(DatasourceDO datasourceDO) {
        TreeNode treeNode = new TreeNode();
        treeNode.setLevel(0);
        treeNode.setIsLeaf(false);
        treeNode.setParent(null);
        treeNode.setChildren(null);
        treeNode.setLabel(datasourceDO.getName());
        treeNode.setKey(buildDatasourceKey(datasourceDO));
        treeNode.setNodeType(TreeMetaEnum.DATASOURCE.getType());
        treeNode.setDsType(DatasourceTypeEnum.MYSQL.getName());
        return treeNode;
    }

    public static TreeNode buildDatabaseTreeNode(Long datasourceId,TreeNode parent, String dbName) {
        TreeNode treeNode = new TreeNode();
        treeNode.setLevel(1);
        treeNode.setIsLeaf(false);
        treeNode.setParent(parent);
        treeNode.setChildren(null);
        treeNode.setLabel(dbName);
        treeNode.setKey(buildDatabaseKey(datasourceId,dbName));
        treeNode.setNodeType(TreeMetaEnum.DATABASE.getType());
        treeNode.setDsType(DatasourceTypeEnum.MYSQL.getName());
        return treeNode;
    }

    public static TreeNode buildServerObjFolderTreeNode(Long datasourceId,TreeNode parent) {

        TreeNode treeNode = new TreeNode();
        treeNode.setLevel(1);
        treeNode.setIsLeaf(false);
        treeNode.setParent(parent);
        // TODO 无需懒加载
//        treeNode.setChildren(buildServerObjectItemList(treeNode));
        treeNode.setLabel("服务器对象");
        treeNode.setKey(buildServerObjFolderKey(datasourceId));
        treeNode.setNodeType(TreeMetaEnum.SERVER_OBJECT_FOLDER.getType());
        treeNode.setDsType(DatasourceTypeEnum.MYSQL.getName());


        return treeNode;
    }


    public static List<TreeNode> buildServerObjectItemList(TreeNode parent) {
        TreeNode userNode = new TreeNode();
        userNode.setLevel(2);
        userNode.setIsLeaf(false);
        userNode.setParent(parent);
        userNode.setChildren(null);
        userNode.setLabel("用户与权限");
        userNode.setKey("qqweq");
        userNode.setNodeType("用户权限");
        userNode.setDsType(DatasourceTypeEnum.MYSQL.getName());

        TreeNode sessionNode = new TreeNode();
        sessionNode.setLevel(2);
        sessionNode.setIsLeaf(false);
        sessionNode.setParent(parent);
        sessionNode.setChildren(null);
        sessionNode.setLabel("会话信息");
        sessionNode.setKey("qqweqss");
        sessionNode.setNodeType("会话信息");
        sessionNode.setDsType(DatasourceTypeEnum.MYSQL.getName());


        return List.of(userNode,sessionNode);
    }

    public static List<TreeNode> buildDatabaseChildrenFolderTreeNodes(Long datasourceId, TreeNode parent) {
        TreeNode tableFolderNode = new TreeNode();
        tableFolderNode.setLevel(2);
        tableFolderNode.setIsLeaf(false);
        tableFolderNode.setParent(parent);
        tableFolderNode.setChildren(null);
        tableFolderNode.setLabel("表");
        tableFolderNode.setKey(String.format(TABLE_FOLDER_KEY_TEMPLATE, parent.getLabel(), datasourceId));
        tableFolderNode.setNodeType(TreeMetaEnum.TABLE_FOLDER.getType());
        tableFolderNode.setDsType(DatasourceTypeEnum.MYSQL.getName());

        TreeNode viewFolderNode = new TreeNode();
        viewFolderNode.setLevel(2);
        viewFolderNode.setIsLeaf(false);
        viewFolderNode.setParent(parent);
        viewFolderNode.setChildren(null);
        viewFolderNode.setLabel("视图");
        viewFolderNode.setKey(String.format(VIEW_FOLDER_KEY_TEMPLATE, parent.getLabel(), datasourceId));
        viewFolderNode.setNodeType(TreeMetaEnum.VIEW_FOLDER.getType());
        viewFolderNode.setDsType(DatasourceTypeEnum.MYSQL.getName());

        TreeNode procedureFolderNode = new TreeNode();
        procedureFolderNode.setLevel(2);
        procedureFolderNode.setIsLeaf(false);
        procedureFolderNode.setParent(parent);
        procedureFolderNode.setChildren(null);
        procedureFolderNode.setLabel("存储过程");
        procedureFolderNode.setKey(String.format(PROCEDURE_FOLDER_KEY_TEMPLATE, parent.getLabel(), datasourceId));
        procedureFolderNode.setNodeType(TreeMetaEnum.PROCEDURE_FOLDER.getType());
        procedureFolderNode.setDsType(DatasourceTypeEnum.MYSQL.getName());

        return List.of(tableFolderNode, viewFolderNode, procedureFolderNode);
    }

    public static TreeNode buildTableTreeNode(Long datasourceId, TreeNode parent, String tableName) {
        TreeNode treeNode = new TreeNode();
        treeNode.setLevel(3);
        treeNode.setIsLeaf(true);
        treeNode.setParent(parent);
        treeNode.setChildren(null);
        treeNode.setLabel(tableName);
        treeNode.setKey(String.format(TABLE_KEY_TEMPLATE, tableName, parent.getKey().split("-")[1], datasourceId));
        treeNode.setNodeType(TreeMetaEnum.TABLE.getType());
        treeNode.setDsType(DatasourceTypeEnum.MYSQL.getName());
        return treeNode;
    }

    public static TreeNode buildViewTreeNode(Long datasourceId, TreeNode parent, String viewName) {
        TreeNode treeNode = new TreeNode();
        treeNode.setLevel(3);
        treeNode.setIsLeaf(true);
        treeNode.setParent(parent);
        treeNode.setChildren(null);
        treeNode.setLabel(viewName);
        treeNode.setKey(String.format(VIEW_KEY_TEMPLATE, viewName, parent.getKey().split("-")[1], datasourceId));
        treeNode.setNodeType(TreeMetaEnum.VIEW.getType());
        treeNode.setDsType(DatasourceTypeEnum.MYSQL.getName());
        return treeNode;
    }
}
