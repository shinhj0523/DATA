class Coffee extends Beverage {
    String  beans;
    
    public Coffee(String name, int price, boolean ice, String beans) {
  
      super(name, price, ice);
      this.beans = beans;
    }
    @Override
    public String toString() {
      return "이름: "+name+", 가격: "+price+"원, 테이크 아웃: "+(takeout==true?"테이크아웃 해":"takeout안함")+", 수량: "+quantity+", 아이스: "+(ice==true?"얼음좋아":"얼음안좋아")+ ", 원두: "+beans;
    }
  }