/*
 * @author 09022211李宾
 * ATM控制器类 -- 管理ATM操作 & ATM的MAIN入口
 */
package ch01.Homework_finalwithsql;
// ATMController.java
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ATMController
{
    private ConnectSQL userDAO;
    private ATMView view;
    private User currentUser;
    private ScheduledExecutorService scheduler;

    public ATMController() throws SQLException
    {
        userDAO = new ConnectSQL();
        view = new ATMView();
        //利用讲到的“线程池技术” 多开一个线程用于利息的增添
        scheduler = Executors.newScheduledThreadPool(1);
    }

    //ATM运行程序
    public void start()
    {
        while (true)
        {
            int choice = view.showMainMenu();
            switch (choice)
            {
                case 1:
                    createNewUser();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    // 停止利息服务
                    scheduler.shutdown();
                    return;
                default:
                    view.showMessage("无效选择，请重试");
            }
        }
    }

    //创建新用户 并将信息同步到数据库中
    private void createNewUser()
    {
        String username = view.promptUsername();
        String password = view.promptPassword();
        try
        {
            if (userDAO.createUser(username, password))
            {
                view.showMessage("用户创建成功！");
            }
            else
            {
                view.showMessage("用户创建失败！");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            view.showMessage("错误: " + e.getMessage());
        }
    }

    //用户登录
    private void login()
    {
        String username = view.promptUsername();
        String password = view.promptPassword();
        try
        {
            //用户登录后 将当前currentUser进行覆盖
            currentUser = userDAO.getUser(username, password);
            if (currentUser != null)
            {
                view.showMessage("登录成功！");
                startInterestTimer();
                userMenu();
            }
            else
            {
                view.showMessage("用户名或密码无效！");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            view.showMessage("错误: " + e.getMessage());
        }
    }

    //用户菜单展示
    private void userMenu()
    {
        while (true)
        {
            int choice = view.showUserMenu();
            switch (choice)
            {
                case 1:
                    changePassword();
                    break;
                case 2:
                    queryBalance();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    deposit();
                    break;
                case 5:
                    return;
                default:
                    view.showMessage("无效选择，请重试！");
            }
        }
    }

    //修改密码 并同步到数据库
    private void changePassword()
    {
        String newPassword = view.promptPassword();
        currentUser.setPassword(newPassword);
        try
        {
            if (userDAO.updateUser(currentUser))
            {
                view.showMessage("密码修改成功！");
            }
            else
            {
                view.showMessage("密码修改失败！");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            view.showMessage("错误: " + e.getMessage());
        }
    }

    //查询余额 直接利用currentUser的内置方法就好
    private void queryBalance()
    {
        view.showBalance(currentUser.getBalance());
    }

    //取款 同步到数据库
    private void withdraw()
    {
        double amount = view.promptAmount();
        if (amount > currentUser.getBalance())
        {
            view.showMessage("余额不足");
        }
        else
        {
            currentUser.setBalance(currentUser.getBalance() - amount);
            try
            {
                if (userDAO.updateUser(currentUser))
                {
                    view.showMessage("取款成功！");
                    queryBalance();
                }
                else
                {
                    view.showMessage("取款失败！");
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                view.showMessage("错误: " + e.getMessage());
            }
        }
    }

    //存款 同步到数据库
    private void deposit()
    {
        double amount = view.promptAmount();
        currentUser.setBalance(currentUser.getBalance() + amount);
        try {
            if (userDAO.updateUser(currentUser))
            {
                view.showMessage("存款成功！");
                queryBalance();
            }
            else
            {
                view.showMessage("存款失败！");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            view.showMessage("错误: " + e.getMessage());
        }
    }

    //利用线程池ScheduledExecutorService 定时增加5%的利息
    private void startInterestTimer()
    {
        scheduler.scheduleAtFixedRate(() -> {
            if (currentUser != null)
            {
                //线程任务为--增加5%的利息
                currentUser.setBalance(currentUser.getBalance() * 1.05);
                try {userDAO.updateUser(currentUser);}
                catch (SQLException e){e.printStackTrace();}
            }
        }, 0, 10, TimeUnit.SECONDS); // 每10秒增加一次利息
    }

    //主程序的入口
    public static void main(String[] args)
    {
        try
        {
            ATMController controller = new ATMController();
            controller.start();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}