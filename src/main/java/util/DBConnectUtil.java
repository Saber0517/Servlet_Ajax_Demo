package util;



import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ??JDBC????????jdbc?properties????????db
 * Created by ZHANGJA4 on 7/29/2015.
 */
public class DBConnectUtil {
    private static BasicDataSource datasource;

    static {
        datasource = new BasicDataSource();
        InputStream inputStream = DBConnectUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
            datasource.setDriverClassName(p.getProperty("DriverClassName"));
            datasource.setUrl(p.getProperty("Url"));
            datasource.setUsername(p.getProperty("Username"));
            datasource.setPassword(p.getProperty("Password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return getConnectionFromDataSource();
    }

    public static Connection getConnectionFromDataSource() {
        Connection con = null;

        try {
            con = datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

    public static void free(Connection con, PreparedStatement pst, ResultSet rs) {
        try {
            if (con != null) {
                con.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
