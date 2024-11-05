/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author dell
 */
public class Login extends Commons {
   public void LoginView() {
		Commons common = new Commons();
		JFrame frame = (JFrame)common.Frame();
		Font txt = new Font("", Font.BOLD, 15);
		Pin pin = new Pin();
		
		//---------------CARDNUMBER----------------
		JLabel card = new JLabel("ENTER YOUR CARD NUMBER");
		card.setBounds(50, 270, 250, 20);
		card.setFont(txt);
		JTextField cardNumber = new JTextField();
		cardNumber.setBounds(50, 300, 500, 35);
		cardNumber.setFont(txt);
		frame.add(cardNumber);
		frame.add(card);
		//-----------------------------------------
		
		//----------------ADMIN--------------------
		JLabel admin = new JLabel("ADMIN LOGIN >");
		admin.setBounds(0, 500, 570, 30);
		admin.setHorizontalAlignment(JLabel.RIGHT);
		admin.setFont(txt);
		frame.add(admin);
		admin.addMouseListener(new MouseAdapter() {
                        @Override
			public void mousePressed(MouseEvent e) { 
				pin.pinView("admin");
				frame.dispose();
			}
		});
		//------------------------------------------
		
		//-----------------BUTTON-----------------
		JButton cont = new JButton("CONTINUE");
		cont.setBounds(200, 400, 200, 50);
		cont.setFont(new Font("Rockwell", Font.BOLD, 25));
		frame.add(cont);
		cont.addActionListener((ActionEvent e) -> {
                    if(cardNumber.getText().length() == 16) {
                        pin.pinView(cardNumber.getText());
                        frame.dispose();
                    }
                    else {
                        Fail fail = new Fail();
                        fail.failView("WRONG CARD NUMBER!!!");
                        frame.dispose();
                    }
                });
		//----------------------------------------
		frame.setVisible(true);
	}
}

   