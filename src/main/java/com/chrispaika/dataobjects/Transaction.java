package com.chrispaika.dataobjects;

//TXID, Time, Paid to, Memo, Outflow, Inflow, Cleared, Budget Category
public class Transaction {
    public long getTxid() {
        return txid;
    }

    public String getPayee() {
        return payee;
    }

    public String getBudgetCategory() {
        return budgetCategory;
    }

    public String getMemo() {
        return memo;
    }

    public int getOutflow() {
        return outflow;
    }

    public int getInflow() {
        return inflow;
    }

    public boolean isCleared() {
        return cleared;
    }

    long txid;
    String payee;
    String budgetCategory;
    String memo;
    int outflow;
    int inflow;
    boolean cleared;

    public Transaction(long txid, String payee, String budgetCategory, String memo, int outflow, int inflow, boolean cleared) {
        this.txid = txid;
        this.payee = payee;
        this.budgetCategory = budgetCategory;
        this.memo = memo;
        this.outflow = outflow;
        this.inflow = inflow;
        this.cleared = cleared;
    }
    @Override
    public String toString() {
        return this.payee + " : " + this.budgetCategory + " : " + this.memo + " : " + this.outflow + " : " + this.inflow + " : " + this.cleared;
    }
}
