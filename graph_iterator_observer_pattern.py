from abc import ABCMeta, abstractmethod


def dfs(graph, node, visited):
    if node not in visited:
        visited.append(node)
        for n in graph[node]:
            dfs(graph, n, visited)
    return visited


class Observer(metaclass=ABCMeta):

    @abstractmethod
    def update(self, message: str) -> None:
        pass


class Observable(metaclass=ABCMeta):

    def __init__(self) -> None:
        self.observers = []  # инициализация списка наблюдателей

    def register(self, observer: Observer) -> None:
        self.observers.append(observer)

    def notify_observers(self, message: str) -> None:
        for observer in self.observers:
            observer.update(message)


class News(Observable):

    def add_news(self, news: str) -> None:
        self.notify_observers(news)


class Citizen(Observer):

    def __init__(self, name: str) -> None:
        self.name = name

    def update(self, message: str) -> None:
        print('{} узнал следующее: {}'.format(self.name, message))


class GraphIterator():
    def __init__(self, graph, start='C'):
        self.graph = graph
        self.start = start
        self.next = self.start
        self.visited = []
        self.i = 0

    def __iter__(self):
        return self

    def dfs(self):
        if self.next not in self.visited:
            self.visited.append(self.next)
            for elem in self.graph[self.next]:
                if elem not in self.visited:
                    self.next = elem
                self.dfs()
        return self.visited

    def __next__(self):
        self.visited = self.dfs()
        self.i += 1
        if self.i > len(self.visited):
            raise StopIteration()
        return self.visited[self.i-1]

    def current(self):
        return self.next

    def first(self):
        self.next = self.start
        self.i = 0


# graph = {'A': (['B', 'C']),
#          'B': (['A', 'D', 'E']),
#          'C': (['A', 'F']),
#          'D': (['B']),
#          'E': (['B']),
#          'F': (['C'])}

graph = {'C' : (['O', 'T']),
         'O' : (['C', 'M', 'P']),
         'M' : (['O']),
         'P' : (['O', 'U']),
         'U' : (['P']),
         'T' : (['C', 'E']),
         'E' : (['T', 'R']),
         'R' : (['E'])}

print(graph)
iter = GraphIterator(graph)
print('Обход в глубину с  помощью отдельной функции:')
print(dfs(graph, 'C', []))
print('Первый обход:')
for i in iter:
    print(i)
print('Текущий элемент:', iter.current())
iter.first()
print('Текущий элемент после выполнения функции iter.first():', iter.current())
print('Паттерн "наблюдатель"')
news = News()
news.register(Citizen('Владислав'))
news.register(Citizen('Александр'))
count = 0
for i in iter:
    print(i)
    count += 1
    if count == 4:
        news.add_news('Прошли 4 вершины графа')
