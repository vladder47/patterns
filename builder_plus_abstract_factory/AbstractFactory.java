package builder_plus_abstract_factory;

public interface AbstractFactory {
    public void constructPhone(Builder builder);
    public void constructTablet(Builder builder);
}
