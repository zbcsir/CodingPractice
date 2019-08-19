package designpattern.factory;

public class CPP implements ProgramLanguage {
    @Override
    public void stdOutput() {
        System.out.println("cout<<*<<endl");
    }
}
