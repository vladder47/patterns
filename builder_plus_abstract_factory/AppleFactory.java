package builder_plus_abstract_factory;

public class AppleFactory implements AbstractFactory {
    @Override
    public void constructPhone(Builder builder) {
        builder.setCase(Case.METAL);
        builder.setCPU(CPU.A13);
        builder.setRAM(128);
        builder.setBattery(6000);
        builder.setOS(OS.IOS);
    }

    @Override
    public void constructTablet(Builder builder) {
        builder.setCase(Case.METAL);
        builder.setCPU(CPU.A13);
        builder.setRAM(128);
        builder.setBattery(10000);
        builder.setOS(OS.IOS);
    }
}
