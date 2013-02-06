package com.in6k.mybanking.entity;

public class Transaction {
    protected int id;
    protected Account debetAccount;
    protected Account creditAccount;
    protected long sum;

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

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }
}
