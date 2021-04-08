package week14;

import javax.swing.*;
import java.awt.*;

public class Problem_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem_01 gui = new Problem_01();
		gui.go();
	}

	public static void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		frame.add(panel1);
		frame.setLayout(null);
		
		// this is JTextArea
		JTextArea text = new JTextArea(5,5);
		text.setText("This is JTextArea");
		text.setBounds(400,50,150,100);
		frame.add(text);
		
		// ��ư�� ���ȴ��� �ȴ��ȴ��� ǥ��
		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		textField1.setText("1����ư�ȴ���");
		textField2.setText("2����ư�ȴ���");
		textField1.setBounds(150,50,100,20);
		textField2.setBounds(150,100,100,20);
		frame.add(textField1);
		frame.add(textField2);
		
		// 1��, 2�� ���� �׸���
		JLabel label1 = new JLabel("1��");
		label1.setBounds(100,50,20,20);
		JLabel label2 = new JLabel("2��");
		label2.setBounds(100,100,20,20);
		frame.add(label1);
		frame.add(label2);
		
		// JButton ũ�� ������ 
		Dimension dim = new Dimension(100,30);
		
		// 1�� ��ư�� 2�� ��ư
		JButton button1 = new JButton("1�� ��ư");
		button1.setBounds(40,160,100,30);
		button1.setSize(dim);
		JButton button2 = new JButton("2�� ��ư");
		button2.setBounds(150,160,100,30);
		button2.setPreferredSize(dim);
		frame.add(button1);
		frame.add(button2);
		
		// 1�� ��ư�� 2�� ��ư�� ������ textField ���� �� ����
		button1.addActionListener(event ->{
			textField1.setText("1������");
		});
		button2.addActionListener(event->{
			textField2.setText("2������");
		});
		
		// ���� ��ư ����
		JRadioButton radio1 = new JRadioButton();
		radio1.setBounds(40,200,120,30);
		JRadioButton radio2 = new JRadioButton();
		radio2.setBounds(40,230,120,30);
		radio1.setText("Radio Button1");
		// ���α׷� ���۽ú��� üũ�Ǿ�����
		radio1.setSelected(true);
		radio2.setText("Radio Button2");
		frame.add(radio1);
		frame.add(radio2);
		
		// üũ�ڽ� ��ư ����
		JCheckBox check1 = new JCheckBox();
		check1.setBounds(160,200,120,30);
		check1.setText("New Check box1");
		JCheckBox check2 = new JCheckBox();
		check2.setBounds(160,230,120,30);
		check2.setText("New Check box2");
		// ���α׷� ���۽ú��� üũ�Ǿ� ����
		check1.setSelected(true);
		frame.add(check1);
		frame.add(check2);
		
		// Drop-down list 
		// ����Ʈ�� �̸� ����� JComboBox�� �������
		String[] listEntries = {"Apple", "Banana","Gamma", "Delta", "Epsilon"};
		JComboBox list = new JComboBox(listEntries);
		list.setBounds(350,200,150,30);
		frame.add(list);
		
		frame.setSize(600,400);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}

// 2019112130 ������
// week14 - Problem_01.java
