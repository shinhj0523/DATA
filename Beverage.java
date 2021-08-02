class Beverage extends Menu {
    boolean ice;
  
    public Beverage(String name, int price, boolean ice){
      super(name, price);
      this.ice = ice;
  
    }
    @Override
        public String toString(){
            return "이름 : " + name + "가격 : " + price + " ice : " + (ice ? "O" : "X");
        }
  }