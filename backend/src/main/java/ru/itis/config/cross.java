package ru.itis.config;
import java.util.Random;
import java.util.Scanner;


public class cross {

    // количество подряд, необходимое для победы
    static final int qtforwin = 4;


    // 3. Определяем размеры массива
    static final int SIZE_X = 10;
    static final int SIZE_Y = 6;

    // 1. Создаем двумерный массив
    static char[][] field = new char[SIZE_Y][SIZE_X];

    // 2. Обозначаем кто будет ходить какими фишками
    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = '0';
    static final char EMPTY_DOT = '.';

    // 8. Создаем сканер
    static Scanner scanner = new Scanner(System.in);
    // 12. Создаем рандом
    static final Random rand = new Random();

    // 4. Заполняем на массив
    private static void initField() {
        for(int i = 0; i < SIZE_Y; i++) {
            for(int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    // 5. Выводим на массив на печать
    private static void printField() {
        //6. украшаем картинку
        System.out.println("-------");
        for(int i = 0; i < SIZE_Y; i++) {
            System.out.print("|");
            for(int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        //6. украшаем картинку
        System.out.println("-------");
    }

    // 7. Метод который устанавливает символ
    private static void setSym(int y, int x, char sym){
        field[y][x] = sym;
    }

    // 9. Ход игрока
    private static void playerStep() {
        // 11. с проверкой
        int x;
        int y;
        do {
            System.out.println("Введите координаты: X Y ("+SIZE_X+"-"+SIZE_Y+")");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y,x));
        setSym(y, x, PLAYER_DOT);

    }

    // 13. Ход ПК
    private static void aiStep() {

        for (int i = 0; i < SIZE_Y; i++)
            for (int j = 0; j < SIZE_X; j++) {

                // для не первого хода
                if (field[i][j] != EMPTY_DOT && field[i][j] != AI_DOT) {
                    // столбик
                    if (i<SIZE_Y-1&&field[i][j] == field[i + 1][j])
                        if (isCellValid(i + 2, j)) {
                            setSym(i + 2, j, AI_DOT);
                            return;
                        }
                        else
                        if (isCellValid(i - 1, j)) {
                            setSym(i - 1, j, AI_DOT);
                            return;
                        }
                    // строка
                    if (j<SIZE_X-1&&field[i][j] == field[i][j + 1])
                        if (isCellValid(i, j + 2)) {
                            setSym(i, j + 2, AI_DOT);
                            return;
                        }
                        else
                        if (isCellValid(i, j - 1)) {
                            setSym(i, j - 1, AI_DOT);
                            return;
                        }
                    // диагональ1
                    if (i< SIZE_Y -1&&j<SIZE_X-1&&field[i][j] == field[i + 1][j + 1])
                        if( isCellValid(i + 2, j + 2))
                        {
                            setSym(i + 2, j + 2, AI_DOT);
                            return;
                        }
                        else
                        if (isCellValid(i - 1, j - 1)) {
                            setSym(i-1, j-1, AI_DOT);
                            return;
                        }
                    // диагональ 2
                    if (i>0&&j<SIZE_X-1&&field[i][j] == field[i - 1][j + 1])
                        if(isCellValid(i + 1, j - 1)) {
                            setSym(i+1, j-1, AI_DOT);
                            return;
                        }

                    //для первого хода
                    if (isCellValid(i + 1, j)){
                        setSym(i + 1, j, AI_DOT); return;
                    }
                    if (isCellValid(i - 1, j)) {
                        setSym(i - 1, j, AI_DOT); return;
                    }
                    if (isCellValid(i, j + 1)) {
                        setSym(i, j + 1, AI_DOT); return;
                    }
                    if (isCellValid(i, j - 1)) {
                        setSym(i, j - 1, AI_DOT); return;
                    }
                    if (isCellValid(i + 1, j + 1)) {
                        setSym(i + 1, j + 1, AI_DOT); return;
                    }
                    if (isCellValid(i - 1, j - 1)) {
                        setSym(i - 1, j - 1, AI_DOT); return;
                    }
                    if (isCellValid(i - 1, j + 1)) {
                        setSym(i - 1, j + 1, AI_DOT); return;
                    }
                    if (isCellValid(i + 1, j - 1)) {
                        setSym(i + 1, j - 1, AI_DOT); return;
                    }
                }
            }

    }


    // Проверка подряд идущих одинаковых ячеек
    static int quantityINaROW() {
        int quantity = 1, MAXquantity = -1;
        for(int i =0;i<SIZE_Y;i++)
            for (int j = 0; j < SIZE_X; j++)
            {
                if (field[i][j] != EMPTY_DOT) {
                    // столбцы
                    for (int k = 1; k < qtforwin; k++) {
                        if (i<SIZE_Y-qtforwin+1&&field[i][j] == field[i + k][j])
                        {
                            quantity++;
                            if (quantity > MAXquantity) MAXquantity = quantity;
                        }
                    }
                    quantity = 1;
                    // строки
                    for (int k = 1; k < qtforwin; k++) {
                        if (j < SIZE_X - qtforwin+1 && field[i][j] == field[i][j+k])
                        {
                            quantity++;
                            if (quantity > MAXquantity) MAXquantity = quantity;
                        }
                    }
                    quantity = 1;
                    // диагональ слева направо
                    for (int k = 1; k < qtforwin; k++) {
                        if (i < SIZE_Y - qtforwin + 1 && j < SIZE_X - qtforwin + 1 && field[i][j] == field[i + k][j+k])
                        {
                            quantity++;
                            if (quantity > MAXquantity) MAXquantity = quantity;
                        }
                    }
                    quantity = 1;
                    // диагональ справа налево
                    for (int k = 1; k < qtforwin; k++) {
                        if (i>3&& j < SIZE_X - qtforwin + 1 && field[i][j] == field[i-k][j + k])
                        {
                            quantity++;
                            if (quantity > MAXquantity) MAXquantity = quantity;
                        }
                    }
                    quantity = 1;
                }
            }
        return MAXquantity;
    }

    // 14. Проверка победы
    static boolean checkWin(char sym) {
        if (quantityINaROW() == qtforwin) return true;
        return false;
    }

    // 16. Проверка полное ли поле? возможно ли ходить?
    private static boolean isFieldFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for(int j = 0; j < SIZE_X; j++) {
                if(field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    // 10. Проверяем возможен ли ход
    private static boolean isCellValid(int y, int x) {
        // если вываливаемся за пределы возвращаем false
        if(x < 0 || y < 0 || x > SIZE_X -1 || y > SIZE_Y - 1) {
            return false;
        }
        // если не путое поле тоже false
        return (field[y][x] == EMPTY_DOT);
    }

    public static void main(String[] args) {
        // 1 - 1 иницируем и выводим на печать
        initField();
        printField();
        // 1 - 1 иницируем и выводим на печать

        // 15 Основной ход программы

        while (true) {
            playerStep();
            printField();
            if(checkWin(PLAYER_DOT)) {
                System.out.println("Player WIN!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW");
                break;
            }

            aiStep();
            printField();
            if(checkWin(AI_DOT)) {
                System.out.println("Win SkyNet!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW!");
                break;
            }
        }

    }
}
