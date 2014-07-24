package db.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 *
 * mysql数据库辅助文件
 *
 * @author
 */
public final class DBUtils {

    Connection MyConnection = null;

    /**
     *
     * 创建一个连接 String url="jdbc:mysql://localhost:3306/db_name";
     * //连接的URL,db_name为数据库名 String Username="username"; //用户名 String
     * Password="password"; //密码
     *
     * @param URL
     * @param username 登录用户名
     * @param password 登录密码
     * @throws java.sql.SQLException 创建数据库连异常，考虑数据库连接字符串问题
     */
    public DBUtils(String URL, String username, String password) throws SQLException {
        DbUtils.loadDriver("com.mysql.jdbc.Driver");
        MyConnection = DriverManager.getConnection(URL + "?characterEncoding=utf8", username, password);
    }

    /**
     * 创建一个连接
     *
     * @param serverip 链接地址
     * @param port 端口号
     * @param dbname 数据库名称
     * @param username 登录用户名
     * @param pwd 登录密码
     * @throws java.sql.SQLException 创建数据库连异常，考虑数据库连接字符串问题
     */
    public DBUtils(String serverip, int port, String dbname, String username, String pwd) throws SQLException {
        this("jdbc:mysql://" + serverip + ":" + port + "/" + dbname, username, pwd);
    }

    /**
     * 执行查询语句
     *
     * @param <T>
     * @param conn
     * @param sql
     * @param rsh
     * @return
     * @throws SQLException
     */
    public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh) throws SQLException {
        Statement stmt;
        ResultSet rs;
        T result;
        if (conn == null) {
            throw new SQLException("Null connection");
        }
        if (sql == null) {
            throw new SQLException("Null SQL statement");
        }
        if (rsh == null) {
            throw new SQLException("Null ResultSetHandler");
        }
        stmt = null;
        rs = null;
        result = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        result = rsh.handle(rs);
        stmt.close();
        return result;
    }

    /**
     * 执行SQL
     *
     * @param conn
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public int execture(Connection conn, String sql) throws SQLException {
        Statement stmt;
        if (conn == null) {
            throw new SQLException("Null connection");
        }
        if (sql == null) {
            throw new SQLException("Null SQL statement");
        }
        stmt = null;
        stmt = conn.createStatement();
        return stmt.executeUpdate(sql);

    }

    /**
     * 获取表名
     *
     * @param conn
     * @return
     * @throws SQLException
     */
    public List<String> getTableName(Connection conn) throws SQLException {
        ResultSet tableRet = conn.getMetaData().getTables(null, null, null, null);
        List<String> tablenames = new ArrayList<String>();
        while (tableRet.next()) {
            tablenames.add(tableRet.getString("TABLE_NAME").toLowerCase());
        }
        return tablenames;
    }

    /**
     * 获取表属性列的定义
     *
     * @param conn
     * @param tableName
     * @return
     * @throws SQLException
     */
    public List<ColumnInfo> getColumnDefine(Connection conn, String tableName) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet columns = metaData.getColumns(null, "%", tableName, "%");
        ResultSet primaryKey = metaData.getPrimaryKeys(null, "%", tableName);
        primaryKey.next();
        List<ColumnInfo> infos = new ArrayList<ColumnInfo>();
        while (columns.next()) {
            ColumnInfo info = new ColumnInfo();
            info.setName(columns.getString("COLUMN_NAME").toLowerCase());
            info.setType(columns.getString("TYPE_NAME").toLowerCase());
            info.setSize(columns.getInt("COLUMN_SIZE"));
            info.setNullable(columns.getBoolean("IS_NULLABLE"));
            info.setPrimary(primaryKey.getString(4));
            infos.add(info);
        }
        return infos;
    }

    /**
     * 测试
     *
     * @param args
     */
    public void testMain(String args[]) {
        try {

            List<String> tableName = getTableName(this.MyConnection);
            for (String string : tableName) {
                System.out.println(string);
                List<ColumnInfo> clomnDefine = getColumnDefine(this.MyConnection, string);
                for (ColumnInfo columnInfo : clomnDefine) {
                    System.out.println("\t" + columnInfo);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
