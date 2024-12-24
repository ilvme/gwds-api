package cn.ikangjia.gwds.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/23 17:05
 */
@Data
@TableName("t_datasource")
public class DatasourceDO {
    private long id;
    private String name;
    private int type;

    private String host;
    private int port;
    private String username;
    private String password;

    private String description;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    /**
     * 是否启用，true 为启用
     */
    private boolean enabled;
}
