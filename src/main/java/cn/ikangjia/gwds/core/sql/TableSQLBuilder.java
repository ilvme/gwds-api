package cn.ikangjia.gwds.core.sql;

import cn.ikangjia.gwds.core.entity.ColumnEntity;
import cn.ikangjia.gwds.core.entity.TableEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 17:35
 */
public class TableSQLBuilder {
    public static String getCreateSQL(TableEntity tableEntity, List<ColumnEntity> columnEntityList) {
        String databaseName = tableEntity.getDatabaseName();
        String tableName = tableEntity.getTableName();
        String comment = tableEntity.getComment();
        String engine = tableEntity.getEngine();

        StringBuilder sb = new StringBuilder();

        // create table db_xx.t_person (
        sb.append("create table ").append(databaseName).append(".").append(tableName).append(" ( ");

        // 列字段信息
        String columnStr = getColumnStr(columnEntityList);

        sb.append(columnStr)
                .append(" ) ");

        // 注释
        if (StringUtils.hasText(comment)) {
            sb.append(" comment='").append(comment).append("'");
        }

        // 引擎
        if (StringUtils.hasText(engine)) {
            sb.append(" engine='").append(comment).append("'");
        }

        sb.append(";");
        return sb.toString();
    }

    private static String getColumnStr(List<ColumnEntity> columnDTOList) {
        if (ObjectUtils.isEmpty(columnDTOList) || columnDTOList.isEmpty()) {
            throw new RuntimeException("列参数有误");
        }

        StringBuilder columnSB = new StringBuilder();
        columnDTOList.forEach(columnInfo -> {
            System.out.println(columnInfo);
            columnSB.append(columnInfo.getColumnName()).append(" ")
                    .append(columnInfo.getTypeInfo());

            if (columnInfo.isNull()) {
                columnSB.append(" NULL ");
            } else {
                columnSB.append(" NOT NULL ");
            }

            if (columnInfo.isUnique()) {
                columnSB.append(" unique ");
            }

            if (StringUtils.hasText(columnInfo.getDefaultValue())) {
                columnSB.append(" DEFAULT ").append("'")
                        .append(columnInfo.getDefaultValue()).append("'");
            }

            if (columnInfo.isIncrement()){
                columnSB.append(" AUTO_INCREMENT ");
            }
            columnSB.append(",");
        });
        String columnStr = columnSB.toString();

        List<String> primaryColumn = columnDTOList.stream()
                .filter(ColumnEntity::isPrimaryKey)
                .map(ColumnEntity::getColumnName)
                .toList();
        if (primaryColumn.isEmpty()) {
            columnStr = columnStr.substring(0, columnStr.length() - 1);
        }else {
            String collect = String.join(",", primaryColumn);
            String primaryStr = "PRIMARY KEY ( " + collect + ")";
            columnStr = columnStr + primaryStr;
        }
        return columnStr;
    }
}
