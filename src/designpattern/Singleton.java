package designpattern;

public enum Singleton {
    INSTANCE;

    @Override
    public String toString() {
        return "hello enum";
    }
}

class TestEnum {
    public static void main(String[] args) {
        Singleton s = Singleton.INSTANCE;
        System.out.println(s.toString());
    }
}
