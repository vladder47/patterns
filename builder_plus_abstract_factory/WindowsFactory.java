package builder_plus_abstract_factory;

public class WindowsFactory implements AbstractFactory {
    @Override
    public void constructPhone(Builder builder) {
        builder.setCase(Case.PLASTIC);
        builder.setCPU(CPU.SNAPDRAGON);
        builder.setRAM(64);
        builder.setBattery(3000);
        builder.setOS(OS.WINDOWS);
    }

    @Override
    public void constructTablet(Builder builder) {
        builder.setCase(Case.PLASTIC);
        builder.setCPU(CPU.SNAPDRAGON);
        builder.setRAM(512);
        builder.setBattery(8000);
        builder.setOS(OS.WINDOWS);
    }
}
