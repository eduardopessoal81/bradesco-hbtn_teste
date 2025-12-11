public class Person {

    public boolean checkUser(String user) {

        if (user == null) return false;

        // mínimo 8 caracteres
        if (user.length() < 8) return false;

        // não pode ter caracteres especiais → apenas letras e números
        if (!user.matches("[A-Za-z0-9]+")) return false;

        return true;
    }

    public boolean checkPassword(String password) {

        if (password == null) return false;

        // mínimo 8 caracteres
        if (password.length() < 8) return false;

        // pelo menos 1 letra maiúscula
        if (!password.matches(".*[A-Z].*")) return false;

        // pelo menos 1 número
        if (!password.matches(".*[0-9].*")) return false;

        // pelo menos 1 caractere especial
        if (!password.matches(".*[^A-Za-z0-9].*")) return false;

        return true;
    }
}