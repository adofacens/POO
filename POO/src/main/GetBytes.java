package main;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class GetBytes {
    public static void main(String[] args) {
        // Criamos uma String para trabalhar
        String texto = "Olá Mundo";

        // -------------------------
        // 1. Usando getBytes()
        // -------------------------
        // Converte a string para um array de bytes utilizando a codificação padrão da JVM (geralmente UTF-8)
        byte[] bytesPadrao = texto.getBytes();
        System.out.println("Bytes (codificação padrão): " + Arrays.toString(bytesPadrao));

        // -------------------------
        // 2. Usando getBytes(Charset charset)
        // -------------------------
        // Converte a string em bytes usando uma codificação explícita, como UTF-16
        byte[] bytesUtf16 = texto.getBytes(StandardCharsets.UTF_16);
        System.out.println("Bytes (UTF-16): " + Arrays.toString(bytesUtf16));

        // -------------------------
        // 3. Usando getBytes(String charsetName)
        // -------------------------
        // Também permite especificar o charset, mas passando o nome como String
        try {
            byte[] bytesIso = texto.getBytes("ISO-8859-1");
            System.out.println("Bytes (ISO-8859-1): " + Arrays.toString(bytesIso));
        } catch (Exception e) {
            System.out.println("Erro ao converter para ISO-8859-1: " + e.getMessage());
        }

        // -------------------------
        // 4. Usando getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin)
        // -------------------------
        // Este método copia os caracteres de uma parte da string diretamente em um array de bytes já existente
        byte[] destino = new byte[10]; // array de destino com tamanho suficiente
     // Copiando os primeiros 4 caracteres da string e convertendo para bytes
        try {
            String subTexto = texto.substring(0, 4); // extrai substring segura
            byte[] subBytes = subTexto.getBytes(StandardCharsets.UTF_8); // converte para bytes com charset explícito
            System.arraycopy(subBytes, 0, destino, 0, Math.min(subBytes.length, destino.length)); // copia para destino
            System.out.println("Bytes parciais (0 a 4): " + Arrays.toString(destino));
        } catch (Exception e) {
            System.out.println("Erro ao copiar bytes parciais: " + e.getMessage());
        }

    }
}

