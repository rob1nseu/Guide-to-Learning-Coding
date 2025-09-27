import java.util.Random;

// 验证码格式：前四位为大小写字母，最后一位为数字.
public class VerificationCode {
    public static void main(String[] args) {

        // 1、将大小写字母存储在数组中
        // 强制类型转化 -- (char)(变量)
        char[] letters = new char[52];
        for (int i = 0; i < letters.length; i++) {
            if(i<26) {
                letters[i] = (char)(97+i); // 小写字母
            }
            else {
                letters[i] = (char)(65+i-26); // 大写字母
            }
        }

        // 2、生成四个随机字母
        // Random类
        Random rd = new Random();
        String code = "";
        for (int i = 0; i < 4; i++) {
            int current_index = rd.nextInt(letters.length); // 0~51的随机数
            code += letters[current_index];
        }

        // 3、生成一个随机数字
        int rd_num = rd.nextInt(10);
        code += rd_num;

        System.out.println("验证码："+code);
    }
}
