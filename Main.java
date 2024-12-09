import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Element {
    private String name;
    private int age;

    // Метод для считывания атрибутов объекта с консоли
    public void readAttributes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        this.name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        this.age = scanner.nextInt();
        scanner.nextLine();
    }


    public void displayAttributes() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }
}
class Container {
    private List<Element> elements;

    // пус. списка
    public Container() {
        elements = new ArrayList<>();
    }
    public void addElement() {
        Element element = new Element();
        element.readAttributes();
        elements.add(element);
    }

    public void removeElement(int index) {
        if (index >= 0 && index < elements.size()) {
            elements.remove(index);
            System.out.println("Элемент удален.");
        } else {
            System.out.println("Неверный индекс. Элемент не удален.");
        }
    }


    public void displayElements() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            System.out.println("Элементы списка:");
            for (int i = 0; i < elements.size(); i++) {
                System.out.print("Элемент " + (i + 1) + ": ");
                elements.get(i).displayAttributes();
            }
        }
    }

    public void clear() {
        elements.clear();
        System.out.println("Список очищен.");
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить элемент");
            System.out.println("2. Показать все элементы");
            System.out.println("3. Удалить элемент");
            System.out.println("4. Очистить список");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    container.addElement();
                    break;
                case 2:
                    container.displayElements();
                    break;
                case 3:
                    System.out.print("Введите индекс элемента для удаления: ");
                    int index = scanner.nextInt();
                    container.removeElement(index);
                    break;
                case 4:
                    container.clear();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        } while (choice != 0);
    }
}
