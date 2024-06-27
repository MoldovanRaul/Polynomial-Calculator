package gui;

import dataModel.Polynomial;
import logic.Operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    private JPanel polynomialPanel, inputPanel, buttonPanel;
    private JTextField p1Field, p2Field, resField;
    private JButton addButton, subtractButton, multiplyButton, differentiateButton, integrateButton;
    public GUI() {
        setTitle("Polynomial Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        polynomialPanel = new JPanel();
        polynomialPanel.setLayout(new GridLayout(5, 1));
        JLabel label1 = new JLabel("In order to use Differentiate or Integrate use Polynomial 1 as input");
        label1.setForeground(new Color(0, 0, 139));
        JLabel label2 = new JLabel("Insert polynomials like:   ax^b+cx-d");
        label2.setForeground(new Color(0, 0, 139));
        polynomialPanel.setBackground(new Color(173, 216, 230));
        polynomialPanel.add(label1);
        polynomialPanel.add(label2);
        add(polynomialPanel, BorderLayout.NORTH);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        p1Field = new JTextField();
        p2Field = new JTextField();
        p1Field.setBackground(new Color(120, 200, 200));
        p1Field.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230)));
        p2Field.setBackground(new Color(120, 200, 200));
        p2Field.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230)));
        inputPanel.add(new JLabel("Polynomial 1:"));
        inputPanel.add(p1Field);
        inputPanel.add(new JLabel("Polynomial 2:"));
        inputPanel.add(p2Field);
        inputPanel.add(new JLabel("Result:"));
        resField = new JTextField();
        resField.setEditable(false);
        resField.setBackground(new Color(120, 200, 200));
        resField.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230)));
        inputPanel.add(resField);
        for (Component component : inputPanel.getComponents()) {
            if (component instanceof JTextField || component instanceof JLabel) {
                component.setForeground(new Color(0, 0, 139));
            }
        }
        inputPanel.setBackground(new Color(173, 216, 230));
        add(inputPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 5));
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        differentiateButton = new JButton("Differentiate");
        integrateButton = new JButton("Integrate");

        addButton.setBackground(new Color(0, 0, 139));
        addButton.setForeground(new Color(173, 216, 230));
        subtractButton.setBackground(new Color(0, 0, 139));
        subtractButton.setForeground(new Color(173, 216, 230));
        multiplyButton.setBackground(new Color(0, 0, 139));
        multiplyButton.setForeground(new Color(173, 216, 230));
        differentiateButton.setBackground(new Color(0, 0, 139));
        differentiateButton.setForeground(new Color(173, 216, 230));
        integrateButton.setBackground(new Color(0, 0, 139));
        integrateButton.setForeground(new Color(173, 216, 230));

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(differentiateButton);
        buttonPanel.add(integrateButton);
        buttonPanel.setBackground(new Color(234, 115, 141));
        add(buttonPanel, BorderLayout.SOUTH);

        addOpButton();
        subtractOpButton();
        multiplyOpButton();
        differentiateOpButton();
        integrateOpButton();


        pack();
        setVisible(true);
    }
    private void addOpButton(){
        addButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = p1Field.getText();
                String p2 = p2Field.getText();
                Polynomial poly1 = new Polynomial();
                poly1.fromString(p1);
                Polynomial poly2 = new Polynomial();
                poly2.fromString(p2);
                Polynomial polyRes = Operations.add(poly1,poly2);
                resField.setText(polyRes.toString());
            }
        });
    }
    private void subtractOpButton(){
        subtractButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = p1Field.getText();
                String p2 = p2Field.getText();
                Polynomial poly1 = new Polynomial();
                poly1.fromString(p1);
                Polynomial poly2 = new Polynomial();
                poly2.fromString(p2);
                Polynomial polyRes = Operations.subtract(poly1,poly2);
                resField.setText(polyRes.toString());
            }
        });
    }
    private void multiplyOpButton(){
        multiplyButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = p1Field.getText();
                String p2 = p2Field.getText();
                Polynomial poly1 = new Polynomial();
                poly1.fromString(p1);
                Polynomial poly2 = new Polynomial();
                poly2.fromString(p2);
                Polynomial polyRes = Operations.multiply(poly1,poly2);
                resField.setText(polyRes.toString());
            }
        });
    }
    private void differentiateOpButton(){
        differentiateButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = p1Field.getText();
                Polynomial poly1 = new Polynomial();
                poly1.fromString(p1);
                Polynomial polyRes = Operations.derivate(poly1);
                resField.setText(polyRes.toString());
            }
        });
    }
    private void integrateOpButton(){
        integrateButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1 = p1Field.getText();
                Polynomial poly1 = new Polynomial();
                poly1.fromString(p1);
                Polynomial polyRes = Operations.integral(poly1);
                resField.setText(polyRes.toString());
            }
        });
    }
}
