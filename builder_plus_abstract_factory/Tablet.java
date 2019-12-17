package builder_plus_abstract_factory;

public class Tablet {
    private final Case device_case;
    private final CPU cpu;
    private final int memory_size;
    private final int capacity;
    private final OS os;

    Tablet(Case device_case, CPU cpu, int memory_size, int capacity, OS os){
        this.device_case = device_case;
        this.cpu = cpu;
        this.memory_size = memory_size;
        this.capacity = capacity;
        this.os = os;
    }

    public Case getCase(){
        return device_case;
    }

    public CPU getCPU(){
        return cpu;
    }

    public int getMemory_size(){
        return memory_size;
    }

    public int getCapacity(){
        return capacity;
    }

    public OS getOS(){
        return os;
    }

    public String getParameters(){
        return "Характеристики планшета: \n" +
                "Материал корпуса: " + device_case + "\n" +
                "Процессор: " + cpu + "\n" +
                "Объём памяти: " + memory_size + " ГБ" +"\n" +
                "Ёмкость батареи: " + capacity + " мАч" +"\n" +
                "Операционная система: " + os;
    }
}
