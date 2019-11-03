class Auto():
    strategy = None

    def __init__(self, passengers=1):
        self.passengers = passengers

    def gas(self):
        print('Едем вперед!')

    def stop(self):
        print('Тормозим!')

    def rev(self):
        print('Едем назад!')

    def fill(self):
        self.strategy.fill()

#семейство классов заправки топлива
class FillStrategy():
    def fill(self):
        pass

#заправка гибридных автомобилей
class HybridFillStrategy(FillStrategy):
    def fill(self):
        print('Заправляем машину бензином или электричеством на выбор!')

#заправка автомобилей бензином
class StandardFillStrategy(FillStrategy):
    def fill(self):
        print('Заправляем машину бензином!')

#заправка болида Формулы-1
class F1PitStopStrategy(FillStrategy):
    def fill(self):
        print('Проводим смену шин, а затем заправляем болид!')

class F1Car(Auto):
    strategy = F1PitStopStrategy()

class HybridCar(Auto):
    strategy = HybridFillStrategy()

class Truck(Auto):
    strategy = StandardFillStrategy()

if __name__ == '__main__':
    first_car = F1Car()
    first_car.gas()
    first_car.fill()
    second_car = HybridCar(4)
    second_car.gas()
    second_car.stop()
    second_car.fill()
    third_car = Truck()
    third_car.gas()
    third_car.fill()

