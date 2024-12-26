package cn.ikangjia.gwds.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 09:36
 */
@Slf4j
@Component
public class ExecuteHandler {
    private final JdbcThreadLocal jdbcThreadLocal;

    public ExecuteHandler(JdbcThreadLocal jdbcThreadLocal) {
        this.jdbcThreadLocal = jdbcThreadLocal;
    }

    /**
     * 返回查询结果集中的指定列所有数据
     *
     * @param sql                   sql 语句
     * @param needReturnColumnLabel 需要返回列数据的列名称
     * @param params                参数
     * @return 列数据
     */
    public List<String> executeQueryStrings(String sql, String needReturnColumnLabel, String... params) {
        try (PreparedStatement statement = this.getPrepareStatement(sql, params)) {
            ResultSet rs = statement.executeQuery();

            List<Map<String, Object>> mapList = ResultHandler.doMapResult(rs);
            if (mapList.isEmpty()) {
                return new ArrayList<>();
            }
            return mapList.stream()
                    .map(map -> map.get(needReturnColumnLabel))
                    .map(String::valueOf)
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            throw new DMSException(e.getMessage(), e);
        }
    }

    private PreparedStatement getPrepareStatement(String sqlTemplate, String... params) {
        Connection context = jdbcThreadLocal.getContext();
        try {
            PreparedStatement statement = context.prepareStatement(sqlTemplate);
            if (params == null || params.length == 0) {
                return statement;
            }
            for (int i = 0, j = params.length; i < j; i++) {
                statement.setObject(i + 1, params[i]);
            }
            return statement;
        } catch (SQLException e) {
            log.error("获取 PrepareStatement 失败{}", e.getMessage());
            throw new DMSException(e.getMessage(), e);
        }
    }
}
