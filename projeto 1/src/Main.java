public class Main {
    public static void main(String[] args) {
        System.out.println("Esse é o ScreenWatch");
        System.out.println("Filme: Top Gun: Maverick");

        int anoDeLancamento = 2022;
        System.out.println("Ano de lançamento: " + anoDeLancamento);
        boolean incluidoNoPlano = true;
        double notaDoFilme = 8.1;

        double media = (9.8 + 6.3 + 8.0)/3;
                System.out.println(String.format("%.1f", media));
                String sinopse;
                sinopse = """
                Filme Top Gun
                Filme de aventura com galã bonitão dos anos 80.
                Muito bom!
                Ano de lançamento:
                """ + anoDeLancamento;
                System.out.println(sinopse);

                int classificacao;
                classificacao = (int) (media /2);
                System.out.println(classificacao);
    }
}