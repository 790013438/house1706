import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {
	private JButton okButton;
	
	public MyFrame() {
		this.setTitle("Shit");
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		
		okButton = new JButton("OK");
		okButton.addActionListener((e) -> {
			JOptionPane.showMessageDialog(null, "hello");
		});
		this.add(okButton);
	}

	public static void main(String[] args) {
		new MyFrame().setVisible(true);
	}
}
