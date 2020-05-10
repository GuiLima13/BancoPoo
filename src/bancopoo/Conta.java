/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancopoo;

import static bancopoo.BancoPoo.type;
import javax.swing.JOptionPane;



public class Conta {
    String accountType,message;
    String userName = "Sem Nome";
    Double creditDefault = 0.0;
    Double credit = 0.0;
    Double balance = 0.0;

    public Double getCreditDefault() {
        return creditDefault;
    }

    public void setCreditDefault(Double creditDefault) {
        this.creditDefault = creditDefault;
    }

    
    
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    public void deposit(Double value){
        Double balanceMoment,aux;
        if(getBalance() <= 0 && getCredit() < getCreditDefault()){
            balanceMoment = getCreditDefault() - getCredit();
            
            if(balanceMoment > value){
                this.setCredit(getCredit()+value);
                this.setBalance(getBalance()+value);
            }else{
                setBalance(balanceMoment - value);
                setCredit(0.0);
            }
        }else{
        this.setBalance(getBalance()+value);
        }
    }
    
    
    
    public String whithDraw(Double value){
        Double balanceMoment;
        balanceMoment = getBalance() + getCredit();
        if(value > balance){
           if(value > balanceMoment){
               

               return this.message = "Você não tem mais credito para saque";
           }else{
               
                setBalance(this.balance - value);
                setCredit(getCredit() - (getBalance()*-1.0));
                return this.message = "Você realizou um saque utilizando seu credito";
           }
        }else{
            setBalance(value);
            return this.message = "Saque realizado com sucesso";
        }
    }
    
    
    
    public void register(String type, String name){  
        this.userName = name;
        
        if(type.trim().equals("padrão")){
                this.setAccountType("Standard");
                this.setCredit(100.0);
                this.setCreditDefault(100.00);
            }else if(type.trim().equals("especial")){
                this.setAccountType("Special");
                this.setCredit(500.0);
                this.setCreditDefault(500.00);
            }else if(type.trim().equals("poupança")){
                this.setAccountType("Saving");
                this.setCredit(0.0);
                this.setCreditDefault(0.0);
            }
    }
}
