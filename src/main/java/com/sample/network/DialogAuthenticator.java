/*
 * COPYRIGHT (c) Enliple 2019
 * This software is the proprietary of Enliple
 *
 * @author <a href="mailto:jshan@enliple.com">jshan</a>
 * @since 2020/07/12
 */

package com.sample.network;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * create on 2020/07/12.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jshan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
public class DialogAuthenticator extends Authenticator {
  private JDialog passwordDialog;
  private JTextField usernameField = new JTextField(20);
  private JPasswordField passwordField = new JPasswordField(20);
  private JButton okButton = new JButton("OK");
  private JButton cancelButton = new JButton("Calcel");
  private JLabel mainLabel = new JLabel("Please enter username and password: ");

  public DialogAuthenticator() {
    this("", new JFrame());
  }

  public DialogAuthenticator(String username) {
    this(username, new JFrame());
  }

  public DialogAuthenticator(JFrame parent) {
    this("", parent);
  }


  public DialogAuthenticator(String username, JFrame parent) {
    this.passwordDialog = new JDialog(parent, true);
    Container pane = passwordDialog.getContentPane();
    pane.setLayout(new GridLayout(4,1));

    JLabel userLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");
    pane.add(mainLabel);
    JPanel p2 = new JPanel();
    p2.add(userLabel);
    p2.add(usernameField);
    usernameField.setText(username);
    pane.add(p2);

    JPanel p3 = new JPanel();
    p3.add(passwordLabel);
    p3.add(passwordField);
    pane.add(p3);

    JPanel p4 = new JPanel();
    p4.add(okButton);
    p4.add(cancelButton);
    pane.add(p4);
    passwordDialog.pack();

    ActionListener al = new OKResponse();
    okButton.addActionListener(al);
    usernameField.addActionListener(al);
    passwordField.addActionListener(al);
    cancelButton.addActionListener(new CancelResponse());
  }

  private void show() {
    String prompt = this.getRequestingPrompt();
    if(prompt == null) {
      String site = this.getRequestingSite().getHostName();
      String protocol = this.getRequestingProtocol();
      int port = this.getRequestingPort();
      if(site != null && protocol != null) {
        prompt = protocol + "://" + site;
        if(port > 0) prompt += ":" + port;
      } else {
        prompt = "";
      }
    }

    mainLabel.setText("Please enter username and password for " + prompt +  ": ");
    passwordDialog.pack();
    passwordDialog.setVisible(true);
  }
  PasswordAuthentication response = null;

  class OKResponse implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      passwordDialog.setVisible(false);
      //보안상의 이유로 패스워드 문자 배열 형태로 반환한다.
      char[] password = passwordField.getPassword();
      String username = usernameField.getText();
      //재사용을 위해서 기존 패스워드를 지운다.
      passwordField.setText("");
      response = new PasswordAuthentication(username, password);
    }
  }

  class CancelResponse implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      passwordDialog.setVisible(false);
      // 재 사용을 위해서 기존 패스워드를 지운다.
      passwordField.setText("");
      response = null;
    }
  }

  public PasswordAuthentication getPasswordAuthentication() {
    this.show();
    return this.response;
  }
}
