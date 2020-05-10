/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancopoo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Guilh
 */
public class BancoPoo extends JFrame {

    
    private JButton btDeposit;
    private JButton btWhithDraw;
    
    private JLabel lblBalance;    
    private JLabel lblBalanceText;
    
    private JLabel lblSalutation;
    
    private JLabel lblTypeAccount;
    
    private JLabel lblCredit;
    private JLabel lblCreditText;
    
    static String type,name;
    int credit = 0;
    Double balance = 0.0;
    
    static Conta account = new Conta();
   
    
   public static void main(String[] args) {
        
        name = JOptionPane.showInputDialog(null,"Informe o nome do Usuario",JOptionPane.INFORMATION_MESSAGE);
        while(name.trim().length() == 0){
            JOptionPane.showMessageDialog(null,"Informe um nome valido");
            name = JOptionPane.showInputDialog(null,"Informe o nome do Usuario",JOptionPane.INFORMATION_MESSAGE);
        }
        boolean verify = false;
        
        do{
             type = JOptionPane.showInputDialog(null,"Informe o tipo da contra dentre as: \n Padrão \n Especial \n Poupança",JOptionPane.INFORMATION_MESSAGE);

            if(type.trim().equals("padrão")){
                verify = true;
            }else if(type.trim().equals("especial")){
                verify = true;
            }else if(type.trim().equals("poupança")){
                verify = true;
            }
            if(verify == false){
                 JOptionPane.showMessageDialog(null,"Informe um tipo de conta valido");
            }
        }while(type.trim().length() == 0 || verify == false);
       
         
            
          if(verify == true){
            account.register(type, name);

            BancoPoo janela = new BancoPoo();
            janela.setVisible(true);
          }
        
    
    }

   
   public BancoPoo(){
       rideFrame(this);
       actions(this);
   }
   
   public void actions(JFrame janela){
       btDeposit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               
               balance = Double.parseDouble(JOptionPane.showInputDialog(janela,"informe o valor de deposito").trim());
               if(balance <= 0){
                   JOptionPane.showMessageDialog(janela, "Não é possivel depositar esse valor\n Insira um valor de deposito valido");
               }else{
                   
                   janela.dispose();
               account.deposit(balance);
               BancoPoo janela = new BancoPoo();
               janela.setVisible(true);
               }
           }
       });
       
       btWhithDraw.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
                balance = Double.parseDouble(JOptionPane.showInputDialog(janela,"informe o valor para saque").trim());
                if(balance <= 0){
                    JOptionPane.showMessageDialog(janela, "Não é possivel sacar esse valor\n Insira um valor para saque valido");
                }else{
                   
                   janela.dispose();
               JOptionPane.showMessageDialog(janela, account.whithDraw(balance));
               BancoPoo janela = new BancoPoo();
               janela.setVisible(true);
               }
           }
       });
   }
   
   public void rideFrame(JFrame janela){
       janela.setVisible(true);
       janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setSize(600,400);
        janela.setLayout(null);
        janela.getContentPane().setBackground(Color.MAGENTA);
      Dimension dim = janela.getToolkit().getScreenSize();      
      int x = (int) (dim.getWidth()  - janela.getSize().getWidth() ) / 2;
      int y = (int) (dim.getHeight()- janela.getSize().getHeight()) / 2;
      janela.setLocation(x,y);
      janela.setVisible(false);
      
      
      lblSalutation = new JLabel();
      lblSalutation.setText("Olá "+account.getUserName());
      lblSalutation.setFont(new Font("Arial",1,30));      
      lblSalutation.setForeground(Color.WHITE);
      lblSalutation.setLocation(20,20);
      lblSalutation.setSize(500,30);
      
      lblTypeAccount = new JLabel();
      lblTypeAccount.setText("Conta: "+account.getAccountType());
      lblTypeAccount.setFont(new Font("Arial",1,30));      
      lblTypeAccount.setForeground(Color.WHITE);
      lblTypeAccount.setLocation(20,55);
      lblTypeAccount.setSize(500,30);
      
      
      lblBalanceText = new JLabel();
      lblBalanceText.setText("Saldo");
      lblBalanceText.setFont(new Font("Arial",1,30));
      lblBalanceText.setForeground(Color.WHITE);
      lblBalanceText.setLocation(250,100);
      lblBalanceText.setSize(90,30);
      
      lblBalance = new JLabel();
      lblBalance.setText("R$ "+account.getBalance());
      lblBalance.setFont(new Font("Arial",1,30));
      lblBalance.setForeground(Color.BLUE);
      lblBalance.setLocation(225,130);
      lblBalance.setSize(150,30);
     
      lblCreditText = new JLabel();
      lblCreditText.setText("Credito");
      lblCreditText.setFont(new Font("Arial",1,30));
      lblCreditText.setForeground(Color.WHITE);
      lblCreditText.setLocation(240,180);
      lblCreditText.setSize(130,30);
      
      lblCredit = new JLabel();
      lblCredit.setText("R$ "+account.getCredit());
      lblCredit.setFont(new Font("Arial",1,30));
      lblCredit.setForeground(Color.BLUE);
      lblCredit.setLocation(225,210);
      lblCredit.setSize(150,30);
      
      btDeposit = new JButton("Depositar");
      btDeposit.setFont(new Font("Arial",1,18));
      btDeposit.setForeground(Color.BLACK);
      btDeposit.setLocation(160,270);
      btDeposit.setSize(130,40);
      
      btWhithDraw = new JButton("Sacar");
      btWhithDraw.setFont(new Font("Arial",1,18));
      btWhithDraw.setForeground(Color.BLACK);
      btWhithDraw.setLocation(290,270);
      btWhithDraw.setSize(130,40);
      
      
      janela.add(lblSalutation);
      janela.add(lblTypeAccount);
      janela.add(lblBalance);
      janela.add(lblBalanceText);
      janela.add(lblCreditText);
      janela.add(lblCredit);
      janela.add(btDeposit);
      janela.add(btWhithDraw);

   }
    
    
}
