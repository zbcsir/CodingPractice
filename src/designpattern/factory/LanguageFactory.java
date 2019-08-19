package designpattern.factory;

public class LanguageFactory extends AbstractGenerator {
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ProgramLanguage> T create(Class<T> c) {
        ProgramLanguage language = null;
        try {
            language = (ProgramLanguage)Class.forName(c.getName()).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)language;
    }
}
