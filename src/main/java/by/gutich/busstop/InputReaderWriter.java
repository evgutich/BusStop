package by.gutich.busstop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReaderWriter {
    public static final String POSH = "Posh";
    public static final String GROTTY = "Grotty";

    private static String PATH = "D:\\BusStop\\src\\com\\company";

    public static Stream<Bus> inputReader() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Path of file input.txt: ");
        String path = in.next();
        List<Bus> busList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path + "\\input"))) {
            String line;
            String[] busInf;
            while ((line = reader.readLine()) != null) {
                for (String bus : line.split("\n")) {
                    busInf = bus.split(" ");
                    busList.add(Bus.builder().busCompany(busInf[0]).departureTime(busInf[1]).arrivalTime(busInf[2]).build());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return busList.stream();
    }

    public static void outputWriter(List<Bus> busList) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("D:\\java\\BusStop\\src\\main\\resources\\output.txt"))) {
            for (Bus bus : busList.stream()
                    .filter(b -> b.getBusCompany().equals(POSH))
                    .collect(Collectors.toList())) {
                out.write(bus.toString() + "\n");
            }
            out.write("\n");
            for (Bus bus : busList.stream()
                    .filter(b -> b.getBusCompany().equals(GROTTY))
                    .collect(Collectors.toList())) {
                out.write(bus.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
