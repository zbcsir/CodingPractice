package designpattern.factory;

public abstract class AbstractGenerator {
    public abstract <T extends ProgramLanguage> T create(Class<T> c);
}
