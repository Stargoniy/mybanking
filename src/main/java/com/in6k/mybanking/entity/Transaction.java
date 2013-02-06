package com.in6k.mybanking.entity;

public class Transaction {
    protected int id;
    protected Account debetAccount;
    protected Account creditAccount;
    protected double sum;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getDebetAccount() {
        return debetAccount;
    }

    public void setDebetAccount(Account debetAccount) {
        this.debetAccount = debetAccount;
    }

    public Account getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(Account creditAccount) {
        this.creditAccount = creditAccount;
    }
}
