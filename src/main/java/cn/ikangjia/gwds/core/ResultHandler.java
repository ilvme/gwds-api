package cn.ikangjia.gwds.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 09:38
 */
public class ResultHandler {
    public static List<Map<String, Object>> doMapResult(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        List<Map<String, Object>> result = new ArrayList<>(columnCount);
        while (rs.next()) {
            Map<String, Object> temMap = new HashMap<>();
            for (int i = 0; i < columnCount; i++) {
                temMap.put(metaData.getColumnLabel(i + 1), rs.getObject(i + 1));
            }
            result.add(temMap);
        }
        return result;
    }
}
