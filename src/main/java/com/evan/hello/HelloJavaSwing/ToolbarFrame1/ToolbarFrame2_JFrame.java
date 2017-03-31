/**
 * 
 */
package com.evan.hello.HelloJavaSwing.ToolbarFrame1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author hu xiao yi
 *
 */
public class ToolbarFrame2_JFrame extends JFrame{

	
	JButton cutButton, copyButton, pasteButton;
	JButton javaButton, macButton, motifButton, winButton;
	
	public ToolbarFrame2_JFrame() {
		super("Toolbar Example(AWT)");
		
		setSize(450, 250);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ActionListener printListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				
			}
		};
		
		
		JPanel toolbar = new JPanel();
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		cutButton = new JButton("Cut");
		cutButton.addActionListener(printListener);
		toolbar.add(cutButton);
		
		copyButton = new JButton("Copy");
		copyButton.addActionListener(printListener);
		toolbar.add(copyButton);
		
		pasteButton = new JButton("Paste");
		pasteButton.addActionListener(printListener);
		toolbar.add(pasteButton);
		
		
		add(toolbar, BorderLayout.NORTH);
		
		// Add the L&F controls
		JPanel lnfPanel = new JPanel();
		LnFListener lnfListener = new LnFListener(this);
		
		macButton = new JButton("Mac");
		macButton.addActionListener(lnfListener);
		lnfPanel.add(macButton);
		
		javaButton = new JButton("Metal");
		javaButton.addActionListener(lnfListener);
		lnfPanel.add(javaButton);
		
		motifButton = new JButton("Motif");
		motifButton.addActionListener(lnfListener);
		lnfPanel.add(motifButton);
		
		winButton = new JButton("Windows");
		winButton.addActionListener(lnfListener);
		lnfPanel.add(winButton);
		
		add(lnfPanel, BorderLayout.SOUTH);
		
	}

	public static void main(String[] args) {
		ToolbarFrame2_JFrame tf1 = new ToolbarFrame2_JFrame();
		tf1.setVisible(true);
		
	}
	
	static class LnFListener implements ActionListener{
		
		JFrame frame;
		
		public LnFListener(JFrame f) {
			// TODO Auto-generated constructor stub
			frame = f;
		}
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String lnfName = null;
			
			String actionCommand = e.getActionCommand();
			
			if("Mac".equals(actionCommand)){
				lnfName = "com.apple.mrj.swing.MacLookAndFeel";
			}else if("Metal".equals(actionCommand)){
				lnfName = "javax.swing.plaf.metal.MetalLookAndFeel";
			}else if("Motif".equals(actionCommand)){
				lnfName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
			}else if("Windows".equals(actionCommand)){
				lnfName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			}else{
				System.err.println("Unrecognized L&F request action: "+ actionCommand);
			}
			
			try {
				UIManager.setLookAndFeel(lnfName);
				SwingUtilities.updateComponentTreeUI(frame);
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
