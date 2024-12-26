package cn.ikangjia.gwds.core.sql;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 17:36
 */
public class CommonSQL {
    String select_character_Set = """
            select character_Set_name as characterSet, default_collate_name as defaultCollation,
            description as description, maxlen as maxLen from information_schema.character_sets;
            """;
    String select_collation = """
            select collation_name as collation
            from information_schema.collation_character_Set_applicability
            where character_Set_name = '%s';
            """;
}
