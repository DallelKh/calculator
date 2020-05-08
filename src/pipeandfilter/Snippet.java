package pipeandfilter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Snippet {
	private JPanel panel1;
	private JButton factorielButton1;
	private JButton sommeButton;
	private JTextField op2;
	private JTextField op1;
	private JButton produitButton1;
	private JButton traceButton1;
	private JButton quitterButton1;
	private JTextField res;


	public Snippet() {


		final Pipe p1 = new BlockingQueue();
		final Pipe p2 = new BlockingQueue();
		final Pipe p3 = new BlockingQueue();


		final Filter a1 = new FilterC(null,p1,op1,op2,sommeButton);
		final Filter b1 = new FilterA(p1,p2);
		final Filter c1 = new FilterB(p2,p3,res);


		final Thread th1 = new Thread( a1 );
		final Thread th2 = new Thread( b1 );
		final Thread th3 = new Thread( c1 );



		traceButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				LinkedList<String> L = new LinkedList<String>();
				// pass the path to the file as a parameter
				File file =
						new File("MyFile.txt");
				Scanner sc = null;
				try {
					sc = new Scanner(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				while (sc.hasNextLine())
					L.add(sc.nextLine());
				String[] tab = new String[L.size()];

				tab = L.toArray(tab);

				JOptionPane.showMessageDialog(null,tab);

			}

		});
		sommeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				a1.setop(sommeButton);
				final Thread th1 = new Thread( a1 );
				final Thread th2 = new Thread( b1 );
				final Thread th3 = new Thread( c1 );
				th1.start();
				th2.start();
				th3.start();
			}
		});
		produitButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				a1.setop(produitButton1);
				final Thread th1 = new Thread( a1 );
				final Thread th2 = new Thread( b1 );
				final Thread th3 = new Thread( c1 );
				th1.start();
				th2.start();
				th3.start();

			}
		});
		factorielButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				a1.setop(factorielButton1);
				final Thread th1 = new Thread( a1 );
				final Thread th2 = new Thread( b1 );
				final Thread th3 = new Thread( c1 );
				th1.start();
				th2.start();
				th3.start();

			}
		});
		quitterButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

						System.exit(0);

			}
		});

	}

	public static void main(String[] args) {
		JFrame frame=new JFrame("Snippet");
		frame.setPreferredSize(new Dimension(450, 400));
		frame.setContentPane(new Snippet().panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);









	}

}

