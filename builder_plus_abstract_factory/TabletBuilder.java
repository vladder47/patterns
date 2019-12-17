package builder_plus_abstract_factory;

public class TabletBuilder implements Builder {
    private Case device_case;
    private CPU cpu;
    private int memory_size;
    private int capacity;
    private OS os;

    @Override
    public void setCase(Case device_case) {
        this.device_case = device_case;
    }

    @Override
    public void setCPU(CPU cpu) {
        this.cpu = cpu;
    }

    @Override
    public void setRAM(int memory_size) {
        this.memory_size = memory_size;
    }

    @Override
    public void setBattery(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void setOS(OS os) {
        this.os = os;
    }

    public Tablet getResult() {
        return new Tablet(device_case, cpu, memory_size, capacity, os);
    }
}
