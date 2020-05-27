package com.jade.cidadesapi.service;

import com.jade.cidadesapi.model.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    final static Charset ENCODING = StandardCharsets.ISO_8859_1;
    BufferedReader reader;
    Reader importer;

    private ArrayList<String[]> readFile(String fileName) throws IOException {
        ArrayList<String[]> dadosArquivo = new ArrayList<>();
        Path path = Paths.get(fileName);
        reader = Files.newBufferedReader(path, ENCODING);
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.replaceAll("\"", "");
            String[] valores = line.split(",");
            dadosArquivo.add(valores);
        }
        return dadosArquivo;
    }

    public List<City> setData() throws IOException {
        ArrayList<String[]> dadosArquivo = readFile("C:\\Users\\jadef\\IdeaProjects\\cidades-api\\src\\main\\resources\\cidades.csv");
        ArrayList<City> list = new ArrayList<>();

        for (int i = 1; i < dadosArquivo.size(); i++) {
            City city = new City(
                    dadosArquivo.get(i)[0],
                    dadosArquivo.get(i)[1],
                    dadosArquivo.get(i)[2],
                    dadosArquivo.get(i)[3],
                    dadosArquivo.get(i)[4],
                    dadosArquivo.get(i)[5],
                    dadosArquivo.get(i)[6],
                    dadosArquivo.get(i)[7],
                    dadosArquivo.get(i)[8],
                    dadosArquivo.get(i)[9]
            );
            list.add(city);
        }

        return list;
    }
}
