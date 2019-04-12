package interfaceTest;

public class Male implements People {

    @Override
    public String getSex() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }
}

class Male1 extends Human {
    @Override
    public int getAge() {
        return 0;
    }
}

abstract class FeMale implements People {

}

abstract class MF extends Human {

}
