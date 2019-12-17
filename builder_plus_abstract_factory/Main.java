package builder_plus_abstract_factory;

public class Main {
    private static void FactoryWork(AbstractFactory factory, Builder builder){
        if (builder instanceof PhoneBuilder){
            factory.constructPhone(builder);
            Phone phone = ((PhoneBuilder) builder).getResult();
            System.out.println(phone.getParameters());
            System.out.print("\n");
        }
        else {
            factory.constructTablet(builder);
            Tablet tablet = ((TabletBuilder) builder).getResult();
            System.out.println(tablet.getParameters());
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        //создание фабрик по производству устройств
        AppleFactory first_factory = new AppleFactory();
        SamsungFactory second_factory = new SamsungFactory();
        WindowsFactory third_factory = new WindowsFactory();
        //создание двух строителей: для телефона и для планшета
        PhoneBuilder phone_builder = new PhoneBuilder();
        TabletBuilder tablet_builder = new TabletBuilder();
        //создание IPhone и Ipad
        FactoryWork(first_factory, phone_builder);
        FactoryWork(first_factory, tablet_builder);
        //создание телефона и планшета Samsung
        FactoryWork(second_factory, phone_builder);
        FactoryWork(second_factory, tablet_builder);
        //создание телефона и планшета Windows
        FactoryWork(third_factory, phone_builder);
        FactoryWork(third_factory, tablet_builder);
    }
}
