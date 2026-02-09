package javacore.Vio.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PegarPrimeiraLinhaTXT {
    public static void main(String[] args) {
        String nomeArquivoOriginal = "arquivo_original.txt";
        try {
            // 1. Ler a primeira linha do arquivo
            String primeiraLinha = lerPrimeiraLinha(nomeArquivoOriginal);
            if (primeiraLinha != null && !primeiraLinha.trim().isEmpty()) {
                // 2. Gerar o novo nome do arquivo (limpando caracteres inválidos, se necessário)
                String novoNomeArquivo = limparNomeArquivo(primeiraLinha) + ".txt";

                // 3. Renomear o arquivo
                renomearArquivo(nomeArquivoOriginal, novoNomeArquivo);
                System.out.println("Arquivo renomeado com sucesso para: " + novoNomeArquivo);
            } else {
                System.out.println("Não foi possível ler a primeira linha ou ela está vazia.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lê a primeira linha de um arquivo.
     *
     * @param nomeArquivo O nome do arquivo a ser lido.
     * @return A primeira linha do arquivo ou null se não for possível ler.
     */
    public static String lerPrimeiraLinha(String nomeArquivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            return br.readLine();
        }
    }

    /**
     * Renomeia um arquivo de origem para um novo nome de destino.
     *
     * @param nomeOrigem  O nome do arquivo original.
     * @param nomeDestino O novo nome do arquivo.
     */
    public static void renomearArquivo(String nomeOrigem, String nomeDestino) throws IOException {
        Path origem = Paths.get(nomeOrigem);
        Path destino = Paths.get(nomeDestino);

        // Use Files.move para garantir uma operação atômica se possível e melhor tratamento de erros
        // Esta operação move/renomeia o arquivo no mesmo diretório
        Files.move(origem, destino, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Remove caracteres inválidos para nomes de arquivos do Windows/Linux (opcional).
     * Adapte conforme o sistema operacional ou suas necessidades.
     */
    public static String limparNomeArquivo(String nome) {
        // Remove caracteres que geralmente não são permitidos em nomes de arquivos
        return nome.replaceAll("[^a-zA-Z0-9-_\\.]", "_").trim();
    }
}


