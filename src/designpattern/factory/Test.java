package designpattern.factory;

public class Test {
    public static void main(String[] args) {
        AbstractGenerator factory = new LanguageFactory();
        Java javaStdOutput = factory.create(Java.class);
        javaStdOutput.stdOutput();
        CPP cppStdOutput = factory.create(CPP.class);
        cppStdOutput.stdOutput();
    }
}
