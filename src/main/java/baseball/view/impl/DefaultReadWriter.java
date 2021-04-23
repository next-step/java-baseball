package baseball.view.impl;

import baseball.view.ReaderWriter;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class DefaultReadWriter implements ReaderWriter {
    private Scanner scanner;

    public DefaultReadWriter() {
        this(System.in, System.out);
    }

    public DefaultReadWriter(InputStream inputStream, OutputStream outputStream) {
        this.scanner = new Scanner(inputStream);
        System.setOut(new PrintStream(outputStream));
    }

    @Override
    public void print(Object object) {
        System.out.println(object);
    }

    @Override
    public String read() {
        return this.scanner.next();
    }
}
