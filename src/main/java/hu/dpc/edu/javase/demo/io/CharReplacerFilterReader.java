/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.io;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author u122951
 */
public class CharReplacerFilterReader extends FilterReader{

    private char from;
    private char to;
    
    public CharReplacerFilterReader(Reader in, char from, char to) {
        super(in);
        this.from = from;
        this.to = to;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int count = super.read(cbuf, off, len);
        for (int i = off; i < off + len; i++) {
            char c = cbuf[i];
            if (c == from) {
                cbuf[i] = to;
            }
        }
        return count;
    }

}
