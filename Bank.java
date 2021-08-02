class Bank {
    int money;
    public Bank() {
        money = 0;
    }
    public void deposit( int m ) {
        money += m;
    }
    
    public void deposit( int m, int bn ) {
        money = money + m + bn;
    }

    public void withdraw( int m ) {
        money -= m;
    }

    public void print() {
        System.out.println("잔액: " + money);
    }

    public static void main(String args[]) {
        Bank myBank = new Bank();
        Bank yourBank = new Bank();

        
        myBank.deposit(5000);
        myBank.deposit(2000, 5000);

        myBank.print();
        yourBank.print();
    }
}


    

