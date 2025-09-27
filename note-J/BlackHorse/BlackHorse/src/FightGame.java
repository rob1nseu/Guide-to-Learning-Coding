public class FightGame {
    public static void main(String[] args) {
        FightRole role1 = new FightRole(100,"Rob1n");
        FightRole role2 = new FightRole(100,"Mike");
        while (role1.getHp()!=0 && role2.getHp()!=0){
            role1.fight(role2);
            if(role2.getHp()==0){
                System.out.println(role1.getName()+"获得胜利");
                break;
            }
            role2.fight(role1);
            if(role1.getHp()==0){
                System.out.println(role2.getName()+"获得胜利");
                break;
            }
        }
    }
}
