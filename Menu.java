class Menu {
    String name;
    int price;
    boolean takeout;
    int quantity;
   
    
     
  
    public Menu(String name, int price) {
      this.name = name;
      this.price = price;
      this.takeout = true;
      this.quantity = 10;
    }
  
    @Override
    public String toString() {
      return "이름: "+name+", 가격: "+price+"원, 테이크 아웃: "+takeout+", 수량: "+quantity;
    }
    
  }