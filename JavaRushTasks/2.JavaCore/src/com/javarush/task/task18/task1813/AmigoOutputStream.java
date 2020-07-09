package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream str;

    @Override
    public void write(int b) throws IOException {
        str.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        str.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        str.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        str.flush();
    }

    public AmigoOutputStream(FileOutputStream str) throws FileNotFoundException {
        super(fileName);
        this.str = str;
    }

    @Override
    public void close() throws IOException {
        flush();
        String end = "JavaRush © All rights reserved.";
        str.write(end.getBytes());
        str.close();

    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
