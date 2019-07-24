package interfaceTest;

public class MultiImplTest implements People, Action {
    @Override
    public String getSex() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }

    public static void main(String[] args) {
        People p = new MultiImplTest();
        System.out.println(p.getAge());
        Action a = new MultiImplTest();
        a.hello();
        a.hello2();
        a.getSex();
    }
}
