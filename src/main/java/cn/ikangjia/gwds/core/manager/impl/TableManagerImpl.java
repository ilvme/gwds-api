package cn.ikangjia.gwds.core.manager.impl;

import cn.ikangjia.gwds.api.model.table.RenameDTO;
import cn.ikangjia.gwds.api.model.table.TableCreateDTO;
import cn.ikangjia.gwds.api.model.table.TableInfoVO;
import cn.ikangjia.gwds.core.ExecuteHandler;
import cn.ikangjia.gwds.core.entity.ColumnEntity;
import cn.ikangjia.gwds.core.entity.TableEntity;
import cn.ikangjia.gwds.core.manager.TableManager;
import cn.ikangjia.gwds.core.sql.TableSQL;
import cn.ikangjia.gwds.core.sql.TableSQLBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 13:21
 */
@Component
public class TableManagerImpl implements TableManager {

    private final ExecuteHandler handler;
    public TableManagerImpl(ExecuteHandler handler) {
        this.handler = handler;
    }
    @Override
    public List<String> listTable(long datasourceId, String databaseName) {
        return handler.executeQueryStrings(String.format(TableSQL.TABLE_LIST_SELECT, databaseName), "TABLE_NAME");
    }

    @Override
    public void createTable(long datasourceId, TableCreateDTO createDTO) {
        String databaseName = createDTO.getDatabaseName();
        String tableName = createDTO.getTableName();
        String comment = createDTO.getComment();

        TableEntity te = new TableEntity();
        te.setTableName(tableName);
        te.setComment(comment);
        te.setDatabaseName(databaseName);

        List<ColumnEntity> columnDTOList = createDTO.getColumnEntityList();

        String sql = TableSQLBuilder.getCreateSQL(te, columnDTOList);
        handler.execute(sql);
    }

    @Override
    public Boolean clearTable(Long datasourceId, String databaseName, String tableName) {
        String sql = String.format(TableSQL.table_clear, databaseName, tableName);
        handler.execute(sql);
        return true;
    }

    @Override
    public Boolean truncateTable(Long datasourceId, String databaseName, String tableName) {
        String sql = String.format(TableSQL.table_truncate, databaseName, tableName);
        handler.execute(sql);
        return true;
    }

    @Override
    public Boolean dropTable(Long datasourceId, String databaseName, String tableName) {
        String sql = String.format(TableSQL.table_drop, databaseName, tableName);
        handler.execute(sql);
        return true;
    }

    @Override
    public Boolean renameTable(Long datasourceId, RenameDTO renameDTO) {
        String sql = String.format(TableSQL.table_rename, renameDTO.getOldTableName(), renameDTO.getTableName());
        handler.execute("use "  + renameDTO.getDatabaseName());
        handler.execute(sql);
        return true;
    }

    @Override
    public TableInfoVO getTableInfo(Long datasourceId, String databaseName, String tableName) {
        String sql = String.format(TableSQL.table_select_info, databaseName, tableName);

        List<TableEntity> tableEntityList = handler.executeQuery(TableEntity.class, sql);
        TableEntity tableEntity = tableEntityList.getFirst();

        TableInfoVO tableInfoVO = new TableInfoVO();
        BeanUtils.copyProperties(tableEntity, tableInfoVO);

        // ddl
        String sqlDDL = String.format(TableSQL.table_show_create, databaseName, tableName);
        String ddl = handler.executeQueryString(sqlDDL, "Create Table");
        tableInfoVO.setTableDDL(ddl);

        // 行数
        String total = handler.executeQueryString(
                String.format(TableSQL.table_Row_count, databaseName, tableName),
                "total");
        tableInfoVO.setRowNum(total);
        return tableInfoVO;
    }
}
