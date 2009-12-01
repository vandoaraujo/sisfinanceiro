package exceptions;

import javax.swing.JOptionPane;

public class LoginRepetidoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginRepetidoException(){
		JOptionPane.showMessageDialog(null,"Este login ja existe no sistema!");
	}

}
