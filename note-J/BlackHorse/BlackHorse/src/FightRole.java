import lombok.Getter;
import lombok.Setter;

import java.util.Random;

// 利用Lombok的@Getter和@Setter注解，自动生成Getter和Setter方法
@Getter
@Setter
public class FightRole {
    private int Hp;
    private String name;

    // 构造函数
    public FightRole(int Hp, String name) {
        this.Hp = Hp;
        this.name = name;
    }
    public FightRole() {
        this.Hp = 100;
        this.name = "Default";
    }
    // fight对战函数
    public void fight(FightRole enemy) {
        Random rd = new Random();
        int damage = rd.nextInt(20) + 1; // 设置攻击血量上限
        // 实际造成伤害
        int currentHp = (enemy.getHp() - damage) >=0 ? (enemy.getHp() - damage) : 0;
        enemy.setHp(currentHp);
        System.out.println(this.name+"对"+enemy.getName()+"造成了"+damage+"点伤害，"+enemy.getName()+"剩余Hp为"+enemy.getHp());
    }
}