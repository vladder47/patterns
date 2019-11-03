class HotDog():
    def template_method(self):
        self.take_bun()
        self.put_sausage()
        self.pour_sauce()

    def take_bun(self):
        print('Взята булочка для хот-дога')

    def put_sausage(self):
        print('Положена горячая сосиска')

    def pour_sauce(self):
        pass

class HotDogWithKetchup(HotDog):
    def pour_sauce(self):
        print('Добавлен кетчуп')

class HotDogWithMustard(HotDog):
    def pour_sauce(self):
        print('Добавлена горчица')

class HotDogMix(HotDog):
    def pour_sauce(self):
        print('Добавлен кетчуп с горчицей')


if __name__ == '__main__':
    print('Первый клиент:')
    first_client = HotDogWithKetchup()
    first_client.template_method()
    print('Второй клиент:')
    second_client = HotDogMix()
    second_client.template_method()
    print('Третий клиент:')
    third_client = HotDogWithMustard()
    third_client.template_method()