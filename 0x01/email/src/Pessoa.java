package com.exemplo;

public class Pessoa {

    public static boolean emailValid(String email) {
        if (email == null) return false;

        // Verificar se contém @
        if (!email.contains("@")) {
            return false;
        }

        // Verificar se tem até 50 caracteres
        if (email.length() > 50) {
            return false;
        }

        return true;
    }
}
