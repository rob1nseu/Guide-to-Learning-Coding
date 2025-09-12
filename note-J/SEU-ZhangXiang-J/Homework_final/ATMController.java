/*
 * @author 09022211李宾
 * ATM控制器类 -- 控制ATM的操作
 */
package ch01.Homework_final;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class ATMController
{
    private ATMView view;
    private Map<String, User> users;
    private static final String FILE_NAME = "users.dat";
    private ScheduledExecutorService scheduler;

    // 构造函数，初始化视图和用户数据
    public ATMController(ATMView view)
    {
        this.view = view;
        this.users = new HashMap<>();
        loadUsers(); // 加载用户数据
        startInterestService(); // 启动利息服务
    }

    // 启动ATM系统主循环
    public void start()
    {
        while (true)
        {
            int choice = view.showMainMenu();
            switch (choice)
            {
                case 1:
                    createUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    saveUsers();
                    view.showMessage("Exiting...");
                    scheduler.shutdown(); // 停止利息服务
                    return;
                default:
                    view.showMessage("Invalid option. Try again.");
            }
        }
    }

    // 创建新用户
    private void createUser()
    {
        String username = view.getUsername();
        if (users.containsKey(username))
        {
            view.showMessage("User already exists.");
            return;
        }
        String password = view.getPassword();
        users.put(username, new User(username, password, 0.0));
        view.showMessage("User created successfully.");
    }

    // 用户登录
    private void loginUser()
    {
        String username = view.getUsername();
        String password = view.getPassword();
        User user = users.get(username);
        if (user != null && user.checkPassword(password))
        {
            view.showMessage("Login successful.");
            userSession(user);
        } else
        {
            view.showMessage("Invalid username or password.");
        }
    }

    // 用户会话，显示用户菜单
    private void userSession(User user)
    {
        while (true)
        {
            int choice = view.showUserMenu();
            switch (choice)
            {
                case 1:
                    changePassword(user);
                    break;
                case 2:
                    queryBalance(user);
                    break;
                case 3:
                    withdraw(user);
                    break;
                case 4:
                    deposit(user);
                    break;
                case 5:
                    view.showMessage("Logging out...");
                    return;
                default:
                    view.showMessage("Invalid option. Try again.");
            }
        }
    }

    // 更改用户密码
    private void changePassword(User user)
    {
        String newPassword = view.getPassword();
        user.setPassword(newPassword);
        view.showMessage("Password changed successfully.");
    }

    // 查询用户余额
    private void queryBalance(User user)
    {
        view.showMessage("Your balance is: " + user.getBalance());
    }

    // 用户取款
    private void withdraw(User user)
    {
        double amount = view.getAmount();
        if (user.withdraw(amount))
        {
            view.showMessage("Withdrawal successful.");
        }
        else
        {
            view.showMessage("Insufficient balance.");
        }
    }

    // 用户存款
    private void deposit(User user)
    {
        double amount = view.getAmount();
        user.deposit(amount);
        view.showMessage("Deposit successful.");
    }

    // 启动利息服务
    private void startInterestService()
    {
        //利用讲到的“线程池技术” 多开一个线程用于利息的增添
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            for (User user : users.values())
            {
                user.addInterest(); //线程任务为 addInterest() 方法
            }
        }, 10, 10, TimeUnit.SECONDS); //每隔10秒进行一次利息的增加
    }

    // 保存用户数据到文件
    private void saveUsers()
    {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME)))
        {
            out.writeObject(users);
        }
        catch (IOException e)
        {
            view.showMessage("Error saving user data.");
        }
    }

    // 从文件加载用户数据
    private void loadUsers()
    {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME)))
        {
            users = (Map<String, User>) in.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            view.showMessage("No previous user data found!");
        }
    }
}