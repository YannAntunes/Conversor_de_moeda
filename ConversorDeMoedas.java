import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorDeMoedas {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/bfb25d9305d942483f6ff4a4/latest/USD";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            JsonObject rates = fetchRates();

            while (true) {
                System.out.println("\n==== Conversor de Moedas====");
                System.out.println("1- USD => BRL");
                System.out.println("2- BRL => USD");
                System.out.println("3- USD => EUR");
                System.out.println("4- EUR => USD");
                System.out.println("5- BRL => EUR");
                System.out.println("6- EUR => BRL");
                System.out.println("0- SAIR");
                System.out.println("Escolha uma opcao: ");
                int opcao = sc.nextInt();

                if (opcao == 0) {
                    System.out.println("Encerrado!");
                    break;
                }

                System.out.println("Digite o valor a converter: ");
                double valor = sc.nextDouble();

                double convertido = converter(opcao, valor, rates);

                System.out.println("Valor convertido: " + convertido);
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar o programa: " + e.getMessage());
        }
    }

    private static JsonObject fetchRates() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

        return json.getAsJsonObject("conversion_rates");
    }

    private static double converter(int opcao, double valor, JsonObject rates) {
        double usd = 1.0;
        double brl = rates.get("BRL").getAsDouble();
        double eur = rates.get("EUR").getAsDouble();

        return switch (opcao) {
            case 1 -> valor * brl;
            case 2 -> valor / brl;
            case 3 -> valor * eur;
            case 4 -> valor / eur;
            case 5 -> valor * (eur / brl);
            case 6 -> valor * (brl / eur);
                default -> {
                    System.out.println("Opcao invalida!");
                    yield 0;
                }
        };
    }
}
