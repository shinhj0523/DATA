import javax.swing.*;

class MessageView extends JPanel{

    JLabel lb;
    JButton ok_btn;

    MessageView(Kiosk kiosk){
        super();
        setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );

        add( Box.createVerticalGlue() );

        lb = new JLabel();
        lb.setAlignmentX(lb.CENTER_ALIGNMENT);
        lb.setHorizontalAlignment(JLabel.CENTER);
        add(lb);

        ok_btn = new JButton("확인");
        ok_btn.setAlignmentX(ok_btn.CENTER_ALIGNMENT);
        ok_btn.setActionCommand("MessageViewOK");
        ok_btn.addActionListener(kiosk);
        add(ok_btn);

        add( Box.createVerticalGlue() );
    }

    void setMessage(String str){
        lb.setText(str);
    }
}