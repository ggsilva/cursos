package br.com.treinaweb.javaee;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class MeuApplet extends Applet {
  private static final long serialVersionUID = 1L;
  private String line;

  public void init() {
    line = getParameter("line");
  }

  public void paint(Graphics page) {
    page.setColor(Color.red);
    page.fillRect(0, 0, 50, 50);
    page.setColor(Color.green);
    page.fillRect(50, 0, 50, 50);
    page.setColor(Color.blue);
    page.fillRect(0, 50, 50, 50);
    page.setColor(Color.yellow);
    page.fillRect(50, 50, 50, 50);
    page.setColor(Color.black);
    page.drawString(line, 10, 40);
  }
}