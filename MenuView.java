import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;


class MenuView extends JPanel{

    MenuView(Menu[] menus, Kiosk kiosk){
        super();
        setLayout( new FlowLayout() );

        JButton[] btns = new JButton[menus.length];

        int coffee_idx = 1, bever_idx = 1, menu_idx = 1, btn_idx = 0;


        for(Menu menu : menus){
            Icon btn_icon;
            if( menu.getClass() == Coffee.class ){
                btn_icon = new ImageIcon( getClass().getResource( "coffee"+coffee_idx+".jpg" ) );
                coffee_idx++;
            }
            else if( menu.getClass() == Beverage.class ){
                btn_icon = new ImageIcon( getClass().getResource( "bever"+bever_idx+".jpg" ) );
                bever_idx++;
            }
            else{
                btn_icon = new ImageIcon( getClass().getResource( "menu"+menu_idx+".jpg" ) );
                menu_idx++;
            }
            btns[btn_idx] = new JButton(menu.toString(), btn_icon);
            btns[btn_idx].setActionCommand(menu.name);
            btns[btn_idx].addActionListener(kiosk);
            add(btns[btn_idx++]);
        }
    }
    
}