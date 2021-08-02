import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class Kiosk extends JFrame implements ActionListener, ChangeListener {

  JPanel panel2;
  CardLayout card_layout;
  MenuView menu_view;
  MessageView message_view;
  InputView input_view;
  ReceiptView receipt_view;

  int stage = 1;

  static Menu[] menus;
  Menu selected_menu;
  
  int cash;
  int change;

   public Kiosk(Menu[] menus){
      super("DATA Kiosk");
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      setLayout( new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

      JPanel panel1 = new JPanel();
      add(panel1);

      JButton back_btn = new JButton("뒤로");
      back_btn.setActionCommand("back");
      back_btn.addActionListener(this);
      panel1.add(back_btn);

      panel2 = new JPanel();
      card_layout = new CardLayout();
      panel2.setLayout(card_layout);
      add(panel2);

      menu_view = new MenuView(menus, this);
      panel2.add( menu_view, "menu_view" );

      message_view = new MessageView(this);
      panel2.add( message_view, "message_view" );
      
      input_view = new InputView(this);
      panel2.add( input_view, "input_view");

      receipt_view = new ReceiptView(this);
      panel2.add( receipt_view, "receipt_view");

      card_layout.show(panel2, "menu_view");
   }

   public static void main(String[] args){

      menus = new Menu[5];
      menus[0] = new Coffee("아메리카노", 2000, true, "칠레");
      menus[1] = new Coffee("카페 모카", 2500, false, "브라질");
      menus[2] = new Beverage("레몬에이드", 2500, true);
      menus[3] = new Beverage("청포도에이드", 3000, true);
      menus[4] = new Menu("베이글", 3500);

      Kiosk myframe = new Kiosk(menus);
      myframe.setVisible(true);
      myframe.setSize(1300, 800);

   }

   @Override
   public void actionPerformed(ActionEvent e){
      switch ( e.getActionCommand() ) {
          case "back":
            if(stage == 2) {
              card_layout.show(panel2, "menu_view");
              stage--;
            }
          break;

          case "MessageViewOK":
            card_layout.show(panel2, "input_view");
          break;

          case "InputViewOK":
            change = pay();
            if( change == -1 ) input_view.setMessage("돈모자란다.");
            else {
              receipt_view.setMessage("결제가 성공했습니다. \n받은 돈" + cash + "원에서 결제금액" + selected_menu.price + "원 결제하고\n거스름돈"+change+"원 거슬러드리겠습니다.");
              card_layout.show(panel2, "receipt_view");
              stage++;
            }
          break;
          
          case "ReceiptView":
            input_view.setMessage("현금을 입력하고 결제 버튼을 눌러주세요.");
            card_layout.show(panel2,"menu_view");
            reset();
          break;
    
          default:
            for(Menu menu : menus) {

              if( menu.name.equals( e.getActionCommand() ) ){
                selected_menu = menu;
                message_view.setMessage("주문하신 메뉴" + menu.name + "가격은 " + menu.price +"원 입니다." );
                card_layout.show(panel2, "message_view");
                stage++;
                break;
              }
            }
          break;
      }
   }
   
   @Override
   public void stateChanged(ChangeEvent e) {
     cash = (int)( ((JSpinner)e.getSource()).getValue() );
     System.out.println( ((JSpinner)e.getSource()).getValue());
   }


   public int pay(  ) {
     if( cash >= selected_menu.price){
       return cash - selected_menu.price;
     } else {
       return -1;
     }
   }
   public void reset(){
     stage = 1;
     selected_menu = null;
     cash = 0;
     change = -1;
     input_view.setSpinnerValue(0);

    }
}

