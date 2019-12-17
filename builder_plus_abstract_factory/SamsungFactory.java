package builder_plus_abstract_factory;

public class SamsungFactory implements AbstractFactory {
    @Override
    public void constructPhone(Builder builder) {
        builder.setCase(Case.GLASS);
        builder.setCPU(CPU.EXYNOS);
        builder.setRAM(64);
        builder.setBattery(7000);
        builder.setOS(OS.ANDROID);
    }

    @Override
    public void constructTablet(Builder builder) {
        builder.setCase(Case.GLASS);
        builder.setCPU(CPU.EXYNOS);
        builder.setRAM(128);
        builder.setBattery(12000);
        builder.setOS(OS.ANDROID);
    }
}
