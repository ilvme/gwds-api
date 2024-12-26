package cn.ikangjia.gwds.core.sql;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 13:54
 */
public interface ViewSQL {
    String VIEW_LIST_SELECT = """
            select table_name from information_schema.tables
            where table_schema = '%s' and table_type in('VIEW', 'SYSTEM VIEW');
            """;
}
