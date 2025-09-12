/**
 * @author 09022211李宾
 * 本题参考了谢林峰同学的思路
 * DirLister程序实现了一个应用程序，
 * 该应用程序根据用户输入列出目录中的文件
 */

package ch01.HomeWork;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DirLister {
    private String directoryPath;
    private String extension;
    private int order;

    public DirLister(String directoryPath, String extension, int order) {
        this.directoryPath = directoryPath;
        this.extension = extension;
        this.order = order;
    }

    /**
     * 列出目录中的文件
     */
    public void listFiles() {
        File dir = new File(directoryPath);

        //isDirectory函数 若该文件名对应的不是目录
        if (!dir.isDirectory()) {
            System.out.println("无效的目录。");
            return;
        }

        // 列出并过滤文件
        File[] files = filterFiles(dir);
        if (files != null) {
            // 排序文件
            sortFiles(files);

            // 打印文件名
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("未找到文件。");
        }
    }

    /**
     * 筛选目录中的文件
     *
     * @param dir 目录
     * @return 过滤后的文件数组
     */
    private File[] filterFiles(File dir) {
        return dir.listFiles((d, name) -> name.endsWith(extension));
    }

    /**
     * 根据最后修改时间排序文件
     *
     * @param files 文件数组
     */
    private void sortFiles(File[] files) {
        Arrays.sort(files, (f1, f2) -> {
            if (order == 1) {
                return Long.compare(f1.lastModified(), f2.lastModified());
            } else {
                return Long.compare(f2.lastModified(), f1.lastModified());
            }
        });
    }

    //main 方法
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 用户输入
        System.out.print("请输入目录路径：");
        String directoryPath = scanner.nextLine();

        System.out.print("请输入文件扩展名（例如：.txt）：");
        String extension = scanner.nextLine();

        System.out.print("输入1表示升序，输入2表示降序：");
        int order = scanner.nextInt();

        DirLister dirLister = new DirLister(directoryPath, extension, order);
        dirLister.listFiles();
    }
}

