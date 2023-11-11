package toy_store;

/*
 * Магазин игрушек (Java)
 * 
 * Информация о проекте
 * Необходимо написать проект, для розыгрыша в магазине игрушек. Функционал
 * должен содержать добавление новых игрушек и задания веса для выпадения игрушек.
 * 
 * Функционал программы:
 * В программе должен быть минимум один класс со следующими свойствами:
 * - id игрушки,
 * - текстовое название,
 * - количество
 * - частота выпадения игрушки (вес в % от 100)
 * 
 * Метод добавление новых игрушек и возможность изменения веса (частоты выпадения игрушки)
 * Возможность организовать розыгрыш игрушек.
 * Например, следующим образом:
 * С помощью метода выбора призовой игрушки – мы получаем эту призовую игрушку и записываем в список\массив.
 * Это список призовых игрушек, которые ожидают выдачи.
 * Еще у нас должен быть метод – получения призовой игрушки.
 * После его вызова – мы удаляем из списка\массива первую игрушку и сдвигаем массив. А эту игрушку записываем в текстовый файл.
 * Не забываем уменьшить количество игрушек
*/

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        int i = 0;

        toyStore.addToy(++i, "Кукла", 10, 60);
        toyStore.addToy(++i, "Мяч", 5, 40);
        toyStore.addToy(++i, "Конструктор", 1, 20);

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Выберите команду:");
            System.out.println("1. Добавить игрушку");
            System.out.println("2. Изменить вес игрушки");
            System.out.println("3. Розыгрыш игрушек");
            System.out.println("4. Вывести список игрушек");
            System.out.println("5. Выйти");
            System.out.println("Введите номер команды");

            option = scanner.nextInt();
            
            switch (option) {
                case 1:
                try{
                    scanner.nextLine();
                    System.out.println("Введите название игрушки:");
                    String name = scanner.nextLine();
                    System.out.println("Введите количество игрушек:");
                    String quantity = scanner.nextLine();
                    System.out.println("Введите вес игрушки:");
                    String weight = scanner.nextLine();

                    int newQuantity = Integer.parseInt(quantity);
                    double newWeight = Double.parseDouble(weight);
                    
                    toyStore.addToy(++i, name, newQuantity, newWeight);
                } catch (Exception e) {
                    System.out.println("Не получилось добавить игрушку. Попробуйте снова");
                } finally {
                    break;
                }
                case 2:
                try{
                    scanner.nextLine();
                    System.out.println("Введите ID игрушки, у которой хотите изменить вес:");
                    String id = scanner.nextLine();
                    System.out.println("Введите новый вес (в % от 100):");
                    String weight = scanner.nextLine();

                    int toyId = Integer.parseInt(id);
                    double newWeight = Double.parseDouble(weight);
                    
                    toyStore.changeToyWeight(toyId, newWeight);
                } catch (Exception e) {
                    System.out.println("Не получилось изменить вес игрушки. Попробуйте снова");
                } finally {
                    break;
                }
                case 3:
                    toyStore.drawToys();
                    break;
                case 4:
                    toyStore.printToy();
                    break;
                case 5:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверная команда. Попробуйте снова");
                    break;
            }
        } while (option != 5);
    }
}
