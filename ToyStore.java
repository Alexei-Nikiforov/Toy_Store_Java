package toy_store;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToyStore {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(int id, String name, int quantity, double weight) {
        toys.add(new Toy(id, name, quantity, weight));
    }

    public void printToy() {
        for (Toy toy : toys) {
            System.out.println(toy.toString());
        }
    }

    public void changeToyWeight(int toyId, double newWeight) {
        if (toyId <= toys.size() & toyId > 0) {
            for (Toy toy : toys) {
                if (toy.getId() == toyId) {
                    toy.setWeight(newWeight);
                    System.out.println("У игрушки с id=" + toyId + " name=" + toy.getName() + " новый weight=" + toy.getWeight());
                }
            } 
        } else {
            System.out.println("Игрушка с id " + toyId + " не найдена.");
        }
    }

    public void drawToys() {
        double randomValue = Math.random() * 100;
        for (Toy toy : toys) {
            if (toy.getWeight() >= randomValue) {
                if (toy.getQuantity() > 0) {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("Поздравляем! Вы выиграли игрушку: " + toy.getName());
                    System.out.println("Вы хотите ее забрать? (1 - да)");
                    String str = scanner.nextLine();

                    if (str.contains("1")) {
                        saveToyForLottery(toy);
                        toy.setQuantity(toy.getQuantity() - 1);
                        System.out.println("Поздравляем! Вы забрали игрушку: " + toy.getName());
                        break;
                    } else {
                        System.out.println("Вы не захотели забрать игрушку. Давайте попробуем снова");
                    }
                } else {
                    System.out.println("У Вас не получилось выиграть игрушку, т.к. она закончились. Попробуйте снова");
                }
            }
        }
    }

    public void saveToyForLottery(Toy toy) {
        String text = toy.toString();
        try(FileWriter writer = new FileWriter("Toys.txt", true))
        { 
            writer.write(text);
            writer.append('\n');
            writer.flush();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
