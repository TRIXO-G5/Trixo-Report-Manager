package main;

import java.awt.EventQueue;

import control.MainFrameListener;
import view.MainFrame;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MainFrame mainFrame = new MainFrame();
				MainFrameListener mainFrameListener = new MainFrameListener(mainFrame);
				mainFrame.setListener(mainFrameListener);
				mainFrame.turnVisible();
				mainFrameListener.getOnRevisionPosts();
			}
		});
	}
}
