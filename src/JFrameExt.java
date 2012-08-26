import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class JFrameExt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameExt frame = new JFrameExt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JPanelExt jpe = new JPanelExt();
	
	public JFrameExt() {
		//create threads
		Thread thread = new Thread (jpe);
		thread.start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		jpe.setBackground(Color.MAGENTA);
		jpe.repaint();
		contentPane.add(jpe, BorderLayout.CENTER);
		
		JPanel jp = new JPanel();
		jp.setBackground(Color.YELLOW);
		contentPane.add(jp, BorderLayout.SOUTH);
		
		JButton jbtStart = new JButton("Start");
		jbtStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("hi");
				jpe.setMoving(true);
			}
		});
		jp.add(jbtStart);
		
		JButton jbtStop = new JButton("Stop");
		jbtStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpe.setMoving(false);
			}
		});
		jp.add(jbtStop);
	}

}
