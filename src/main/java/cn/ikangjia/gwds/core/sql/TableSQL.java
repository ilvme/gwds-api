package cn.ikangjia.gwds.core.sql;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 13:20
 */
public interface TableSQL {
    String TABLE_LIST_SELECT = """
            select table_name from information_schema.tables
            where table_schema = '%s' and table_type = 'BASE TABLE';
            """;
}
