import java.util.*;

public class Zadanie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> fioAndNumberMap = new HashMap<>();

        while (true) {
            System.out.println("-".repeat(16) +
                    "\nЖелаете добавить контакт? " +
                    "\nДа - введите 1, \nНет - введите 2");

            int cont = scanner.nextInt();
            scanner.nextLine();

            if (cont == 2) {
                break;
            }

            System.out.print("Введите ФИО (для завершения введите 'exit'): ");
            String fullName = scanner.nextLine();
            if (fullName.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Введите номер телефона через запятую (для завершения введите 'exit'): ");
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("-".repeat(16));

            fioAndNumberMap.computeIfAbsent(fullName, k -> new HashSet<>()).add(phoneNumber);

            Comparator<Map.Entry<String, Set<String>>> byPhoneCount =
                    Map.Entry.<String, Set<String>>comparingByValue(Comparator.comparingInt(Set::size)).reversed();

            List<Map.Entry<String, Set<String>>> entryList = new ArrayList<>(fioAndNumberMap.entrySet());

            entryList.sort(byPhoneCount);

            System.out.println("Контакты:");
            for (Map.Entry<String, Set<String>> entry : entryList) {
                System.out.println("ФИО: " + entry.getKey() + ", Номер(а): " + entry.getValue());
            }


        }

        scanner.close();
    }
}
