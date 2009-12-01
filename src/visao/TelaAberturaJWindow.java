package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class TelaAberturaJWindow extends JWindow{

	private static final long serialVersionUID = 1L;

	private JProgressBar progressBar;

	public TelaAberturaJWindow(String imgFile) {
		
		JPanel panel;
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imgFile));
		JLabel lab = new JLabel(new ImageIcon(image));

		add(lab, BorderLayout.CENTER);

		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
		progressBar = new JProgressBar(JProgressBar.HORIZONTAL);
		progressBar.setStringPainted(true);
		panel.add(progressBar);

		add(panel, BorderLayout.SOUTH);

		pack();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension labelSize = lab.getPreferredSize();
		setLocation(screenSize.width / 2 - (labelSize.width / 2), screenSize.height / 2 - (labelSize.height / 2));
		setAlwaysOnTop(true);
		
	}

	public void hideSplash() {
		setVisible(false);
		dispose();
		
	}

	public void showSplash() {
		setVisible(true);
		
	}

	public void setProgressMaxMin(int min, int max) {
		progressBar.setMaximum(max);
		progressBar.setMinimum(min);
		
	}

	public void setDisplayString(int v, String s) {
		progressBar.setString(s);
		progressBar.setValue(v);
		
	}

}
