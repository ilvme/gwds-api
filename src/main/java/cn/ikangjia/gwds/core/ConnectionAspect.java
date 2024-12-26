package cn.ikangjia.gwds.core;

import cn.ikangjia.gwds.core.util.MySQLDatasourceUtil;
import cn.ikangjia.gwds.domain.entity.DatasourceDO;
import cn.ikangjia.gwds.domain.mapper.DatasourceMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 09:29
 */
@Slf4j
@Aspect
@Component
public class ConnectionAspect {
    private final JdbcThreadLocal jdbcThreadLocal;

    private final DatasourceMapper datasourceMapper;

    public ConnectionAspect(JdbcThreadLocal jdbcThreadLocal, DatasourceMapper datasourceMapper) {
        this.jdbcThreadLocal = jdbcThreadLocal;
        this.datasourceMapper = datasourceMapper;
    }

    @Pointcut("execution(public * cn.ikangjia.gwds.core.manager.impl..*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("obtain connection...");
        DatasourceDO datasourceDO = datasourceMapper.selectById(Long.valueOf(String.valueOf(joinPoint.getArgs()[0])));
        Connection connection;
        try {
            connection = MySQLDatasourceUtil.getConnection(datasourceDO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.jdbcThreadLocal.setContext(connection);
    }

    @After("pointcut()")
    public void doAfter() {
        log.info("close and remove connection...");
        this.jdbcThreadLocal.remove();
    }
}
