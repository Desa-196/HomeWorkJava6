import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static HashMap<String, Object> searchParameters = new HashMap<>();
    public static HashSet<Notebook> hashSet = new HashSet<>();
    public static void main(String[] args){
        Notebook notebook1 = new Notebook("Asus", "AX35", 32000, 32, 1000, 15.6f, "Intel", "Не установлена");
        Notebook notebook2 = new Notebook("Asus", "AX35", 30000, 16, 1000, 15.6f, "Intel", "Не установлена");
        Notebook notebook3 = new Notebook("Asus", "AX35", 28000, 8, 1000, 15.6f, "Intel", "Не установлена");
        Notebook notebook4 = new Notebook("Asus", "AX35", 42000, 32, 1000, 15.6f, "AMD", "Windows");
        Notebook notebook5 = new Notebook("ACER", "PO054", 38000, 16, 1000, 15.6f, "Intel", "Windows");
        Notebook notebook6 = new Notebook("ACER", "U754", 22000, 8, 1000, 15.6f, "AMD", "Linux");

        hashSet.add(notebook1);
        hashSet.add(notebook2);
        hashSet.add(notebook3);
        hashSet.add(notebook4);
        hashSet.add(notebook5);
        hashSet.add(notebook6);     

        
        loop:
        while(true){
            //Выводим меню
            viewMenu();
            //Запрашиваем у пользователя пункт меню 
            int selectMenu = readIntFromConsole("Введите номер параметра поиска для изменения параметра фильтрации: ");
            switch(selectMenu){
                case 1:
                    searchParameters.put("brand", readString("Введите название производителя: "));
                    break;
                case 2:
                    searchParameters.put("model", readString("Введите название модели: "));
                    break;
                case 3:
                    searchParameters.put("price", readIntFromConsole("Введите минимальную стоимость: "));
                    break;
                case 4:
                    searchParameters.put("sizeMainMemory", readIntFromConsole("Введите минимальный объем RAM: "));
                    break;
                case 5:
                    searchParameters.put("sizeHardDrive", readIntFromConsole("Введите минимальный объем HDD: "));
                    break;
                case 6:
                    searchParameters.put("diagonal", readIntFromConsole("Введите минимальную диагональ: "));
                    break;
                case 7:
                    searchParameters.put("processor", readString("Введите наименование процессора: "));
                    break;
                case 8:
                    searchParameters.put("os", readString("Введите наименование операционной системы: "));
                    break;
                case 9: //Если выбран 9-й, очищаем наш список с параметрами фильтрации
                    searchParameters.clear();
                    break;
                case 10: //Если выбран 10-й, выводим список ноутбуков
                    viewNotebook();
                    break;
                case 11: //Если 11 - выходим из цикла while
                    break loop;
            }
        }
    }
    public static void viewMenu(){
        System.out.println("1. Производитель: " +  (String)searchParameters.get("brand"));
        System.out.println("2. Модель: " +  (String)searchParameters.get("model"));
        System.out.println("3. Минимальная стоимость: " +  (Integer)searchParameters.get("price"));
        System.out.println("4. Минимальный объем RAM: "  +  (Integer)searchParameters.get("sizeMainMemory"));
        System.out.println("5. Минимальный объем HDD: " +  (Integer)searchParameters.get("sizeHardDrive"));
        System.out.println("6. Минимальная диагональ: " +  (Integer)searchParameters.get("diagonal"));
        System.out.println("7. Процессор: " +  (String)searchParameters.get("processor"));
        System.out.println("8. Операционная система: " +  (String)searchParameters.get("os"));
        System.out.println("9. Очистить параметры фильтрации");
        System.out.println("10. Вывести список ноутбуков подходящих по параметрам");
        System.out.println("11. Закрыть программу");
    }

    public static void viewNotebook(){
        
        Predicate<Notebook> predicate = (x -> true);

        //Набиваем наш предикат для фильтрации собирая их через оператор and если имеется в hashMap параметр поиска

        if(searchParameters.containsKey("brand")) predicate = predicate.and(x -> x.getBrand().equals((String)searchParameters.get("brand")));
        if(searchParameters.containsKey("model")) predicate = predicate.and(x -> x.getModel().equals((String)searchParameters.get("model")));
        if(searchParameters.containsKey("price")) predicate = predicate.and(x -> x.getPrice() > (Integer)searchParameters.get("price"));
        if(searchParameters.containsKey("sizeMainMemory")) predicate = predicate.and(x -> x.getSizeMainMemory() > (Integer)searchParameters.get("sizeMainMemory"));
        if(searchParameters.containsKey("sizeHardDrive")) predicate = predicate.and(x -> x.getSizeHardDrive() > (Integer)searchParameters.get("sizeHardDrive"));
        if(searchParameters.containsKey("diagonal")) predicate = predicate.and(x -> x.getDiagonal() > (Integer)searchParameters.get("diagonal"));
        if(searchParameters.containsKey("processor")) predicate = predicate.and(x -> x.getProcessor().equals((String)searchParameters.get("processor")));
        if(searchParameters.containsKey("os")) predicate = predicate.and(x -> x.getOs().equals((String)searchParameters.get("os")));


        for (Notebook notebook : hashSet.stream().filter(predicate).collect(Collectors.toList())) {
            System.out.println(notebook);
        };
    }

    //Функция ввода  числа с проверкой
    public static int readIntFromConsole(String text)
    {
        System.out.print(text);
        Scanner input = new Scanner(System.in);
        while(!input.hasNextInt())
        {
            System.out.println("\nОшибка ввода, повторите ввод: ");
            input.next();
        }
        int result = input.nextInt();
        return result;

    }
    public static String readString(String text){
        Scanner in = new Scanner(System.in);
        System.out.print(text);
        return in.nextLine();
    }
}
