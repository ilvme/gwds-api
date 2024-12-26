package cn.ikangjia.gwds.core.entity;

import lombok.Data;

/**
 *
 * @author kangJia
 * @email  ikangjia.cn@outlook.com
 * @since  2024/12/26 17:34
 */
@Data
public class CharacterSetEntity {
    private String characterSet;
    private String defaultCollation;
    private String description;
    private String maxLen;
}
