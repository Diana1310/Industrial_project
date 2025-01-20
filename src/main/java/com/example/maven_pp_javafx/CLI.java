package com.example.maven_pp_javafx;

import java.util.Scanner;
import java.util.stream.Stream;

public class CLI {
    boolean continueWorking = true;
    Scanner in = new Scanner(System.in);
    String realizationMethod;

    public String getRealizationMethod() {
        return realizationMethod;
    }

    public boolean isContinueWorking() {
        return continueWorking;
    }

    public void setContinueWorking(boolean continueWorking) {
        this.continueWorking = continueWorking;
    }

    public void intro() {
        System.out.println("Какой вид реализации использовать?\n" +
                "1.Консоль\n" +
                "2.UI based");

        byte tmp;
        boolean isCorrectInput = false;
        while (!isCorrectInput) {
            tmp = in.nextByte();
            if (tmp == 1) {
                realizationMethod = "CLI";
                isCorrectInput = true;
            } else if (tmp == 2) {
                realizationMethod = "UI";
                isCorrectInput = true;
            }

            if (!isCorrectInput) {
                System.out.println("Неправильный ввод, попробуйте ещё раз.");
            }
        }
    }

    public void inputFileInfo(IOFileInfo file) {
        System.out.println("Введите расширение входного файла: txt, xml, json");

        boolean isCorrectInput = false;
        while (!isCorrectInput) {
            file.inputFileData = in.next();

            switch (file.inputFileData) {
                case "txt", "json", "xml" -> {
                    isCorrectInput = true;
                }
            }

            if (!isCorrectInput) {
                System.out.println("Неправильный ввод, попробуйте ещё раз.");
            }
        }

        System.out.println("Введите без расширения имя входного файла: ");
        file.inputFileName = in.next();

        System.out.println("Выберите подходящий вариант для входного файла:\n" +
                "\t1.Заархивирован\n" +
                "\t2.Зашифрован\n" +
                "\t3.Сначала заархивирован, потом зашифрован\n" +
                "\t4.Сначала зашифрован, потом заархивирован\n" +
                "\t5.Ни заархивирован, ни зашифрован");

        isCorrectInput = false;
        while (!isCorrectInput) {
            file.inputEncryptionMethod = in.next();

            if (Stream.of("1", "2", "3", "4", "5").anyMatch(s -> file.inputEncryptionMethod.equals(s))) {
                isCorrectInput = true;
            }

            if (!isCorrectInput) {
                System.out.println("Неправильный ввод, попробуйте ещё раз.");
            }
        }

        if (Stream.of("1", "3", "4").anyMatch(s -> file.inputEncryptionMethod.equals(s))) {
            System.out.println("Выберите тип архива: rar, zip:");

            isCorrectInput = false;
            while (!isCorrectInput) {
                file.inArchveData = in.next();

                switch (file.inArchveData) {
                    case "rar", "zip" -> {
                        isCorrectInput = true;
                    }
                }

                if (!isCorrectInput) {
                    System.out.println("Неправильный ввод, попробуйте ещё раз.");
                }
            }
        } else {
            file.inArchveData = "none";
        }

        System.out.println("Введите номер метода, которым хотите произвести подсчёт выражений:" +
                "\n1.Ручной" +
                "\n2.С помощью регулярных выражений" +
                "\n3.С помощью сторонней библиотеки");

        isCorrectInput = false;
        while (!isCorrectInput) {
            file.numberOfCalculationMethod = in.next();
            if (Stream.of("1", "2", "3").anyMatch(s -> file.numberOfCalculationMethod.equals(s))) {
                isCorrectInput = true;
            }

            if (!isCorrectInput) {
                System.out.println("Неправильный ввод, попробуйте ещё раз.");
            }
        }

        System.out.println("Введите расширение выходного файла: txt, json, xml");

        isCorrectInput = false;
        while (!isCorrectInput) {
            file.outputFileData = in.next();

            switch (file.outputFileData) {
                case "txt", "json", "xml" -> {
                    isCorrectInput = true;
                }
            }

            if (!isCorrectInput) {
                System.out.println("Неправильный ввод, попробуйте ещё раз.");
            }
        }

        System.out.println("Введите без расширения имя выходного файла: ");
        file.outputFileName = in.next();

        System.out.println("Выберите подходящий вариант для выходного файла:\n" +
                "\t1.Заархивировать\n" +
                "\t2.Зашифровать\n" +
                "\t3.Сначала заархивировать, потом зашифровать\n" +
                "\t4.Сначала зашифровать, потом заархивировать\n" +
                "\t5.Ни зашифровать, ни заархивировать");

        isCorrectInput = false;
        while (!isCorrectInput) {
            file.outputEncryptionMethod = in.next();

            if (Stream.of("1", "2", "3", "4", "5").anyMatch(s -> file.outputEncryptionMethod.equals(s))) {
                isCorrectInput = true;
            }

            if (!isCorrectInput) {
                System.out.println("Неправильный ввод, попробуйте ещё раз.");
            }
        }

        if (Stream.of("1", "3", "4").anyMatch(s -> file.outputEncryptionMethod.equals(s))) {
            System.out.println("Выберите тип архива: rar, zip");

            isCorrectInput = false;
            while (!isCorrectInput) {
                file.outArchveData = in.next();

                switch (file.outArchveData) {
                    case "rar", "zip" -> {
                        isCorrectInput = true;
                    }
                }

                if (!isCorrectInput) {
                    System.out.println("Неправильный ввод, попробуйте ещё раз.");
                }
            }
        } else {
            file.outArchveData = "none";
        }
    }

    public void finishOrContinue() {
        String isContinue;
        System.out.println("Желаете ли обработать ещё файл? (ДА/НЕТ): ");

        boolean isCorrectInput = false;
        while (!isCorrectInput) {
            isContinue = in.next();

            if (isContinue.equals("ДА")) {
                setContinueWorking(true);
                isCorrectInput = true;
            } else if (isContinue.equals("НЕТ")) {
                setContinueWorking(false);
                isCorrectInput = true;
            }

            if (!isCorrectInput) {
                System.out.println("Неправильный ввод, попробуйте ещё раз.");
            }
        }
    }
}