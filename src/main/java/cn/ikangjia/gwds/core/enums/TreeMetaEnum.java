package cn.ikangjia.gwds.core.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 10:55
 */
@Getter
public enum TreeMetaEnum {
    DATASOURCE("ds", "ds-%", "数据源类型节点，即根节点"),

    DATABASE("db", "db-%-%", "数据库类型节点"),

    TABLE_FOLDER("tf", "tf-%-%", "表文件夹类型节点"),
    TABLE("t", "t-%-%-%", "表类型节点"),

    VIEW_FOLDER("vf", "vf-%-%", "视图文件夹类型节点"),
    VIEW("v", "v-%-%-%", "视图类型节点"),

    PROCEDURE_FOLDER("pf", "pf-%", "存储过程文件夹类型节点"),
    PROCEDURE("p", "p-%", "存储过程类型节点"),

    SERVER_OBJECT_FOLDER("sof", "sof-%", "服务对象文件夹类型节点"),
    SERVER_OBJECT("so", "so-%-%", "服务对象类型节点"),

    COLUMN_FOLDER("cf", "cf-%", "列文件夹类型节点"),
    COLUMN("c", "c-%", "列类型节点"),
    INDEX_FOLDER("if", "if-%", "索引文件夹类型节点"),
    INDEX("i", "i-%", "索引类型节点"),
    ;

    private final String type;
    private final String keyTemplate;
    private final String description;


    TreeMetaEnum(String type, String keyTemplate, String description) {
        this.type = type;
        this.keyTemplate = keyTemplate;
        this.description = description;
    }

    public static TreeMetaEnum getByType(String type){
        return Arrays.stream(TreeMetaEnum.values())
                .filter(e -> e.getType().equals(type))
                .findFirst()
                .orElse(null);
    }
}
