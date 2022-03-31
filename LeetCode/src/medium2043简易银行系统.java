class Bank {

    long[] accounts;
    int len;

    public Bank(long[] balance) {
        accounts = balance;
        len = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        return withdraw(account1, money) && deposit(account2, money);
    }

    public boolean deposit(int account, long money) {
        if (account > len || account < 1) {
            return false;
        }
        accounts[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > len || account < 1 || accounts[account - 1] < money) {
            return false;
        }
        accounts[account - 1] -= money;
        return true;
    }
}
