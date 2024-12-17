package menu;

import conversor.OperacoesConversor;
import util.RunnableWithException;

import java.util.HashMap;
import java.util.Scanner;

public class MenuConversor {
    private static Boolean sair = false;

    public void run() {
        OperacoesConversor operacoes = new OperacoesConversor();
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, RunnableWithException> operacoesMenu = new HashMap<>();
        operacoesMenu.put(1, operacoes::getActualRate);
        operacoesMenu.put(2, operacoes::convertFromUSAToBRA);

        while (!sair) {
            System.out.println("Bem vindo ao conversor da One");
            System.out.println("---- Opções ----");
            System.out.println("1 - Câmbio atual da moeda de escolha");
            System.out.println("2 - Converter de USD para BRA");
            System.out.println("3 - Converter de EUR para BRA");
            System.out.println("4 - Descobrir taxa de cambio entre moedas");
            System.out.println("5 - Descobrir o valor da moeda no passado");
            System.out.println("6 - Codigos de moedas suportados");
            System.out.println("7 - Sair");
            var res = scan.nextInt();
            RunnableWithException operacao = operacoesMenu.get(res);
            if (operacao != null) {
                try {
                    operacao.run();
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
            if (res == 7) {
                sair = true;
                System.out.println("Saindo do conversor...");
                break;
            }
        }
    }
}
