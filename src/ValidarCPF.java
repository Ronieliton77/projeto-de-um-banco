public class ValidarCPF {

    public boolean isCPFValido(String cpf) {

        // Remove non-digit characters
        cpf = cpf.replace(".", "").replace("-", "");

        // Check if CPF is empty or has invalid length
        if (cpf.isEmpty() || cpf.length() != 11) {
            return false;
        }

        // Calculate first verification digit
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = cpf.charAt(i) - '0';
            soma += (10 - i) * digito;
        }

        int primeiroDV = soma % 11;
        if (primeiroDV < 2) {
            primeiroDV = 0;
        } else {
            primeiroDV = 11 - primeiroDV;
        }

        // Calculate second verification digit
        soma = 0;
        for (int i = 0; i < 10; i++) {
            int digito = cpf.charAt(i) - '0';
            soma += (11 - i) * digito;
        }

        int segundoDV = soma % 11;
        if (segundoDV < 2) {
            segundoDV = 0;
        } else {
            segundoDV = 11 - segundoDV;
        }

        // Extract and compare verification digits
        String digitosVerificadores = cpf.substring(9, 11);
        return digitosVerificadores.equals("" + primeiroDV + segundoDV);
    }
}
