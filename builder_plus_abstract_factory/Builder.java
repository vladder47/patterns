package builder_plus_abstract_factory;

public interface Builder {
    public void setCase(Case device_case);
    public void setCPU(CPU cpu);
    public void setRAM(int memory_size);
    public void setBattery(int capacity);
    public void setOS(OS os);
}
