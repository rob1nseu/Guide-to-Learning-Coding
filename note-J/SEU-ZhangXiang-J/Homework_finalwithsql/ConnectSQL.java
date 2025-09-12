/*
 * @author 09022211李宾
 * 数据库连接与更新类 -- 将用户数据保存到本地数据库中
 */
package ch01.Homework_finalwithsql;
import java.sql.*;
public class ConnectSQL
{
    private Connection connect;
    public ConnectSQL() throws SQLException
    {
        // 连接到本地数据库
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "Robin20031213");
    }

    // 创建用户
    public boolean createUser(String username, String password) throws SQLException
    {
        //MySQL语句 INSERT 将用户初始化信息输入到数据库中
        String query = "INSERT INTO users (username, password, balance) VALUES (?, ?, 0.00)";
        //利用讲到的 PreparedStatement 模板化数据库输入
        PreparedStatement stmt = connect.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        //executeUpdate 向数据库回滚信息
        int result = stmt.executeUpdate();
        return result > 0;
    }

    // 获取用户信息
    public User getUser(String username, String password) throws SQLException
    {
        //MySQL语句 SELECT 查询数据库中用户名与密码匹配的用户
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement stmt = connect.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setBalance(rs.getDouble("balance"));
            return user;
        }
        return null;
    }

    // 更新用户信息
    public boolean updateUser(User user) throws SQLException
    {
        //MySQL语句 UPDATE 更新当前用户的信息
        String query = "UPDATE users SET password = ?, balance = ? WHERE username = ?";
        PreparedStatement stmt = connect.prepareStatement(query);
        stmt.setString(1, user.getPassword());
        stmt.setDouble(2, user.getBalance());
        stmt.setString(3, user.getUsername());
        int result = stmt.executeUpdate();
        return result > 0;
    }
}