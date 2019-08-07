package by.gutich.busstop;

import java.util.List;

import static by.gutich.busstop.InputReaderWriter.inputRead;
import static by.gutich.busstop.InputReaderWriter.outputWrite;
import static by.gutich.busstop.TimeTable.createTimeTableList;

public class Main {

    public static void main(String[] args) {
        List<Bus> busList = inputRead(args[0]);
        outputWrite(createTimeTableList(busList));
    }
}
