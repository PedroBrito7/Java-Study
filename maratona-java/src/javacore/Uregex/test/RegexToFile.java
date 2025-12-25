package javacore.Uregex.test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexToFile {

    public static void main(String[] args) {
        String input = "Contato principal: john@example.com. Suporte: support@example.com. Vendas: sales@example.com.";
        // Expressão regular para e-mails (simplificada)
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        // Encontra a próxima subsequência da entrada que corresponde ao padrão
        while (matcher.find()) {
            // Obtém o texto da correspondência encontrada (o "objeto" extraído)
            String email = matcher.group();
            count++;
            // Define o nome do arquivo
            String fileName = "email_" + count + "_" + email + ".txt";

            try {
                // Escreve o e-mail em um novo arquivo
                escreverArquivo(fileName, email);
                System.out.println("E-mail salvo em: " + fileName);
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo " + fileName + ": " + e.getMessage());
            }
        }
    }

}
