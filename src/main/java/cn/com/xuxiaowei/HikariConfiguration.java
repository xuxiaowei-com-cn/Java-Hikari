package cn.com.xuxiaowei;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hikari 示例
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class HikariConfiguration {

    public static void main(String[] args) {

        HikariConfiguration hikariConfiguration = new HikariConfiguration();

        hikariConfiguration.mysql();

        hikariConfiguration.oracle();

    }

    public void mysql() {

        // 创建连接池示例
        HikariDataSource dataSource = new HikariDataSource();

        // 设置连接池所需驱动
        dataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());

        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/hikari?useSSL=false&serverTimezone=GMT%2B8");

        dataSource.setUsername("root");

        dataSource.setPassword("root");

        try (Connection connection = dataSource.getConnection()) {

            System.out.println(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void oracle() {

        // 创建连接池示例
        HikariDataSource dataSource = new HikariDataSource();

        // 设置连接池所需驱动
        dataSource.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());

        dataSource.setJdbcUrl("jdbc:oracle:thin:@192.168.8.128:1521:ORCL");

        dataSource.setUsername("scott");

        dataSource.setPassword("orcl");

        try (Connection connection = dataSource.getConnection()) {

            System.out.println(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
