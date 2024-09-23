import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements ActionListener{
	ArrayList<JButton> cells = new ArrayList<JButton>();
	
	Image tom = new ImageIcon("tom1.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	ImageIcon tomIcon = new ImageIcon(tom);
	Image jerry = new ImageIcon("jerry1.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	ImageIcon jerryIcon = new ImageIcon(jerry);
	ImageIcon currentPlayer = tomIcon;
	public GameFrame(){
		this.setSize(500, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.gray);
		
		this.setLayout(new BorderLayout());
		
		Image logo = new ImageIcon("Logo.png").getImage().getScaledInstance(500, 200, Image.SCALE_SMOOTH);
		ImageIcon logoIcon = new ImageIcon(logo);
		
		JPanel Header = new JPanel();
		Header.setBackground(Color.gray);
		JLabel LogoHolder = new JLabel();
		LogoHolder.setIcon(logoIcon);
		LogoHolder.setVerticalAlignment(JLabel.CENTER);
		LogoHolder.setBounds(0,0,500,200);
		Header.add(LogoHolder);
		
		JPanel Footer = new JPanel();
		Footer.setBackground(Color.gray);
		Footer.setPreferredSize(new Dimension(100, 100));
		Footer.setLayout(new GridLayout(3,3));

		JPanel Sidebar = new JPanel();
		Sidebar.setBackground(Color.red);
		Sidebar.setPreferredSize(new Dimension(100, 100));
		Sidebar.setLayout(new GridLayout(3,3));
		
		JPanel Right = new JPanel();
		Right.setBackground(Color.red);
		Right.setPreferredSize(new Dimension(100, 100));
		Right.setLayout(new GridLayout(3,3));
		
		JPanel GridContainer = new JPanel();
		GridContainer.setBackground(Color.red);
		GridContainer.setPreferredSize(new Dimension(100, 100));
		GridContainer.setLayout(new GridLayout(3,3, 3, 3));
		
		addCell(GridContainer);
		addCell(GridContainer);
		addCell(GridContainer);
		addCell(GridContainer);
		addCell(GridContainer);
		addCell(GridContainer);
		addCell(GridContainer);
		addCell(GridContainer);
		addCell(GridContainer);

		this.setIconImage(logo);
		this.add(Header, BorderLayout.NORTH);
		this.add(Footer, BorderLayout.SOUTH);
		this.add(GridContainer, BorderLayout.CENTER);
		this.setVisible(true);
	}
	public void addCell(JPanel GridContainer) {
		JButton cell = new JButton();
		cells.add(cell);
		cell.setFocusable(false);
		cell.setBackground(Color.gray);
		cell.addActionListener(this);
		GridContainer.add(cell);
	}
	

	public void changePlayer() {
		System.out.println("changing players");
		ImageIcon changePlayer = (currentPlayer == tomIcon) ? jerryIcon : tomIcon;
		currentPlayer = changePlayer;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<9; i++) {
			if(e.getSource() == cells.get(i)) {
				System.out.println("stop pressing me");
				if(cells.get(i).getIcon() == null) {
					cells.get(i).setIcon(currentPlayer);
					changePlayer();
				}
			}
		}

	}
	
}
