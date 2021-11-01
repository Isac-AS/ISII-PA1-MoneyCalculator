package View;

import Model.Currency;
import Model.Money;
import Controller.Controller;
import java.awt.Font;
import java.util.*;
import javax.swing.JOptionPane;

public class DialogSwing extends javax.swing.JFrame implements Dialog, Display{
    
    private final List<Currency> currenciesList;
    private final String[] currenciesForCombobox;
    private final Controller controller;
    
    public DialogSwing(List<Currency> currenciesList, Controller controller) {
        this.currenciesList=currenciesList;
        this.currenciesForCombobox=createCurrencyStringArray(currenciesList);
        this.controller=controller;
        initComponents();
    }
    
    private String[] createCurrencyStringArray(List<Currency> list) {
        String[] arr = new String[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i).toString();
        }
        return arr;
    }

    @Override
    public Money getMoney() {
        double quantity=0;
        try {
            if (jTextFieldQuantityReader.getText().length() > 0)
            quantity=Double.parseDouble(jTextFieldQuantityReader.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error a la hora de procesar la cantidad introducida.\n"
                            + "Debe introducir un número real, donde"
                            + "los decimales son separados por un punto (.).",
                    "Error en la lectura de datos",
                    JOptionPane.ERROR_MESSAGE);
        }
        int selectedIndex=jComboBoxCurrencyFrom.getSelectedIndex();
        return new Money(quantity, currenciesList.get(selectedIndex));
    }

    @Override
    public Currency getCurrencyFrom() {
        return currenciesList.get(jComboBoxCurrencyFrom.getSelectedIndex());
    }
    
    @Override
    public Currency getCurrencyTo() {
        return currenciesList.get(jComboBoxCurrencyTo.getSelectedIndex());
    }
    
    @Override
    public void display(Money money) {
        jTextAreaDisplay.setText("\n" + money.toString());
    }
    
    
    private void jComboBoxCurrencyFromActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.controller.trigger();
    }
    
    private void jComboBoxCurrencyToActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.controller.trigger();
    }
            
    private void jTextFieldQuantityReaderActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.controller.trigger();
    }
    
    
    private javax.swing.JComboBox<String> jComboBoxCurrencyFrom;
    private javax.swing.JComboBox<String> jComboBoxCurrencyTo;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelCurrencyFromText;
    private javax.swing.JLabel jLabelCurrencyToText;
    private javax.swing.JLabel jLabelQuatityText;
    private javax.swing.JLabel jLabelProbablyUnnecessaryCredits;
    private javax.swing.JScrollPane jScrollPaneForTextAreaDisplay;
    private javax.swing.JTextArea jTextAreaDisplay;
    private javax.swing.JTextField jTextFieldQuantityReader;
    
    
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jTextFieldQuantityReader = new javax.swing.JTextField();
        jComboBoxCurrencyFrom = new javax.swing.JComboBox<>();
        jComboBoxCurrencyTo = new javax.swing.JComboBox<>();
        jLabelCurrencyFromText = new javax.swing.JLabel();
        jLabelCurrencyToText = new javax.swing.JLabel();
        jScrollPaneForTextAreaDisplay = new javax.swing.JScrollPane();
        jTextAreaDisplay = new javax.swing.JTextArea();
        jLabelQuatityText = new javax.swing.JLabel();
        jLabelProbablyUnnecessaryCredits = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTitle.setText("Money Calculator");

        jTextFieldQuantityReader.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextFieldQuantityReader.setText("");
        jTextFieldQuantityReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantityReaderActionPerformed(evt);
            }
        });

        jComboBoxCurrencyFrom.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBoxCurrencyFrom.setModel(new javax.swing.DefaultComboBoxModel<>(currenciesForCombobox));
        jComboBoxCurrencyFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCurrencyFromActionPerformed(evt);
            }
        });

        jComboBoxCurrencyTo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jComboBoxCurrencyTo.setModel(new javax.swing.DefaultComboBoxModel<>(currenciesForCombobox));
        jComboBoxCurrencyTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCurrencyToActionPerformed(evt);
            }
        });

        jLabelCurrencyFromText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelCurrencyFromText.setText("Currency From:");

        jLabelCurrencyToText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelCurrencyToText.setText("Currency To:");

        jTextAreaDisplay.setColumns(20);
        jTextAreaDisplay.setRows(5);
        jTextAreaDisplay.setFont(new Font("Tahoma", 0, 24));
        jScrollPaneForTextAreaDisplay.setViewportView(jTextAreaDisplay);

        jLabelQuatityText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelQuatityText.setText("Quantity:");

        jLabelProbablyUnnecessaryCredits.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jLabelProbablyUnnecessaryCredits.setText("V.1.0 By Isac Añor Santana");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxCurrencyFrom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCurrencyFromText, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jTextFieldQuantityReader)
                    .addComponent(jLabelQuatityText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxCurrencyTo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCurrencyToText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneForTextAreaDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabelTitle)
                .addGap(0, 242, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelProbablyUnnecessaryCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabelTitle)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCurrencyToText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxCurrencyTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCurrencyFromText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxCurrencyFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabelQuatityText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldQuantityReader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPaneForTextAreaDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabelProbablyUnnecessaryCredits)
                .addContainerGap())
        );

        pack();
    }
    
}
