package cn.ikangjia.gwds.core;

import lombok.Getter;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/24 09:50
 */
@Getter
public enum DatasourceTypeEnum {
    MYSQL(1, "mysql"),
    GBASE_8A(2, "gbase8a"),
    ORACLE(3, "oracle"),
    SQLSERVER(4, "sqlserver"),
    ;

    private final int type;
    private final String name;

    DatasourceTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String getName(int type) {
        for (DatasourceTypeEnum ds : DatasourceTypeEnum.values()) {
            if (ds.getType() == type) {
                return ds.getName();
            }
        }
        throw new RuntimeException("未知的数据库类型");
    }
}
