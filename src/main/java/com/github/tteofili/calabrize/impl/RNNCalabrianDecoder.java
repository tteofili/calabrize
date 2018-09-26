package com.github.tteofili.calabrize.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import com.github.tteofili.calabrize.CalabrianDecoder;

/**
 *
 */
public class RNNCalabrianDecoder implements CalabrianDecoder {

  private final RNN rnn;

  public RNNCalabrianDecoder(String text) {
    float learningRate = 1e-1f;
    int seqLength = 15;
    int hiddenLayerSize = 50;
    int epochs = 10;
    rnn = new RNN(learningRate, seqLength, hiddenLayerSize, epochs, text, 5, true);
    rnn.learn();
  }


  @Override
  public void decode(InputStream input, OutputStream output) throws IOException {
    throw new UnsupportedOperationException("not implemented yet!");
  }

  @Override
  public void decode(InputStream input, OutputStream output, String charsetName) throws IOException {
    throw new UnsupportedOperationException("not implemented yet!");
  }

  @Override
  public void decode(Reader input, Writer output) throws IOException {
    throw new UnsupportedOperationException("not implemented yet!");
  }

  @Override
  public String decode(String text) {
    throw new UnsupportedOperationException("not implemented yet!");
  }
}
