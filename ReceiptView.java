import javax.swing.*;

class ReceiptView extends JPanel{

    MultiLineLabel lb;
    JButton ok_btn;

    ReceiptView(Kiosk kiosk){
        super();
        setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );

        add( Box.createVerticalGlue() );

        lb = new MultiLineLabel();
        lb.setAlignmentX(lb.CENTER_ALIGNMENT);
        lb.setHorizontalTextAlignment(JLabel.CENTER);
        add(lb);

        ok_btn = new JButton("확인");
        ok_btn.setAlignmentX(ok_btn.CENTER_ALIGNMENT);
        ok_btn.setActionCommand("ReceiptView");
        ok_btn.addActionListener(kiosk);
        add(ok_btn);

        add( Box.createVerticalGlue() );
    }

    void setMessage(String str){
        lb.setText(str);
    }
}