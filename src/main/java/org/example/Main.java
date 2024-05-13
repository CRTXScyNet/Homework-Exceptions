package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            registration("Ya_login", "sos_null", "sos_null");
        } catch (WrongLoginException e) {
            System.out.println("Перехватили исключение вызванное неверным логином");
        } catch (WrongPasswordException e) {
            System.out.println("Перехватили исключение вызванное неверным паролем");
        } finally {
            System.out.println("Метод main закончил работу");
        }
    }

    public static void registration(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        boolean isLoginSymbolsWrong = !login.matches("[a-zA-Z0-9_]+$");
        boolean isLoginLengthWrong = !(login.length() <= 20);
        if (isLoginSymbolsWrong || isLoginLengthWrong) {
            throw new WrongLoginException("Логин не удовлетворяет условиям");
        }

        boolean isPasswordSymbolsWrong = !password.matches("[a-zA-Z0-9_]+$");
        boolean isPasswordLengthWrong = !(password.length() <= 20);
        boolean isPasswordsNotMatches = !password.equals(confirmPassword);
        if (isPasswordLengthWrong || isPasswordsNotMatches || isPasswordSymbolsWrong) {
            throw new WrongPasswordException("Пароль не удовлетворяет условиям");
        }
    }
}