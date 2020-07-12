/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/10
 */

package com.sample.network;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * create on 2020/07/10.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jshan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
public class Sample1 {

  public static void main(String[] args) throws IOException, InterruptedException {
    generateCharacters(new FileOutputStream("output.txt"));
  }

  public static void generateCharacters(OutputStream out) throws IOException, InterruptedException {
    int firstPrintableCharacter = 33;
    int numberOfPrintableCharacters = 94;
    int numberOfCharactersPerLine = 72;

    int start = firstPrintableCharacter;
    // +2는 캐리지리턴과 라인피드를 위함.
    byte[] line = new byte[numberOfCharactersPerLine + 2];
    while (true) {
      Thread.sleep(1000);
      for (int i=start; i<start+numberOfCharactersPerLine; i++) {
        line[i-start] = (byte) ((i - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter);
      }
      line[72] = (byte)'\r';
      line[73] = (byte)'\n';
      // 바이트 배열로 한번에 write 한다.
      out.write(line);
      System.out.println(line);
      start = ((start + 1) -firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
    }
  }

}
