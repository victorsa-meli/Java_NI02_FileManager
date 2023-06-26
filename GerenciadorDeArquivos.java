package org.manager.testes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorDeArquivos {
    private final static String nomeArquivo = "newFileText.txt";
    private final static String caminhoArquivo = "/Users/victo/OneDrive/Área de Trabalho/Projetos/Estacionamento/Parkapp/src/main/java/org/manager/testes";
    private final static String conteudoDoArquivo = "\n _____________________________ \n Teste de conteudo do arquivo \n _____________________________ \n Teste de conteudo do arquivo";


    private static void criarArquivoDeTexto() {
        Path path = Paths.get(GerenciadorDeArquivos.caminhoArquivo, GerenciadorDeArquivos.nomeArquivo);

        if (Files.exists(path)) {
            System.out.println("Arquivo ja existe!");

        } else {
            try {
                Files.createFile(path);
                System.out.println("Arquivo criado com sucesso!");

            } catch (IOException e) {
                throw new RuntimeException("Erro ao criar arquivo!!!");
            }


        }

    }

    private static void escreveArquivo() {
        Path path = Paths.get(GerenciadorDeArquivos.caminhoArquivo + "/" + GerenciadorDeArquivos.nomeArquivo);
        if (!Files.exists(path)) {
            System.out.println("Arquivo nao existe!");
            return;
        }

        if (!Files.isWritable(path)) {
            System.out.println("Arquivo nao pode ser escrito!");
            return;
        }

        try {
            Files.write(path, GerenciadorDeArquivos.conteudoDoArquivo.getBytes());
            System.out.println("Arquivo escrito com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo!!!");
        }

    }

    private static void lerArquivo() {
        Path path = Paths.get(GerenciadorDeArquivos.caminhoArquivo + "/" + GerenciadorDeArquivos.nomeArquivo);
        byte[] texto = new byte[0];
        try {
            texto = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo!!!");
        }
        String leitura = new String(texto);
        System.out.println(leitura);
    }

    private static void deletarArquivo() {
        Path path = Paths.get(GerenciadorDeArquivos.caminhoArquivo + "/" + GerenciadorDeArquivos.nomeArquivo);
        if (!Files.exists(path)) {
            System.out.println("Arquivo nao existe!");
            return;
        } else {
            try {
                Files.delete(path);
                System.out.println("Arquivo deletado com sucesso!");
            } catch (IOException e) {
                throw new RuntimeException("Nao foi possivel deletar o arquivo!");
            }
        }
    }

    private static Map<Integer, String> lerArquivoRetornaDentroDeMap() {
        Path path = Paths.get(GerenciadorDeArquivos.caminhoArquivo, GerenciadorDeArquivos.nomeArquivo);
        Map<Integer, String> textoMap = new HashMap<>();


        if (!Files.exists(path)) {
            System.out.println("File is not exists!");
            return null;
        } else {
            try {
                List<String> linhas = Files.readAllLines(path);
                for (int i = 0; i < linhas.size(); i++) {
                    textoMap.put(i, linhas.get(i));
                }
            } catch (IOException e) {
                throw new RuntimeException("Erro ao ler o arquivo!!!", e);
            }

            return textoMap;


        }


    }

    public static void main(String[] args) {

        // criarArquivoDeTexto();
        //escreveArquivo();
        //lerArquivo();
        deletarArquivo();

        // System.out.println(lerArquivoRetornaDentroDeMap());


    }

}
