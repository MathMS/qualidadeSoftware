package pkgOperacoes;

public class Operacoes {
    private double resultado = 0;
    // maior 
    public double maiorValor(double v1, double v2) {
        if (v1 > v2) {
            return v1;
        } else {
            return v2;
        }
    }
    // menor
    public double menorValor(double v1, double v2) {
        if (v1 < v2) {
            return v1;
        } else {
            return v2;
        }
    }
    // raiz
    public double raizQuadrada(double v1) {
        if (v1 >= 0) {
            resultado = Math.sqrt(v1);
        } else {
            throw new IllegalArgumentException(
                    "O Valor não pode ser negativo");
        }
        return resultado;
    }
    // divisao
    public double divide(double v1, double v2) {
        try {
            resultado = v1 / v2;
            return resultado;
        } catch (Exception e) {
            System.out.println(
                    "Um erro ocorreu" + e.getMessage());
        }
        System.out.println(
                "O(s) valor(es) não pode(m) se nulos (Zeros!)");
        throw new IllegalArgumentException(
                "O(s) Valor(es) não pode(m)"
                + "ser nulo(s)");
    }
    // produto
    public double produto(double v1, double v2) {
        resultado = v1 * v2;
        return resultado;
    }
    // soma
    public double soma(double v1, double v2) {
        resultado = v1 + v2;
        return resultado;
    }
}
