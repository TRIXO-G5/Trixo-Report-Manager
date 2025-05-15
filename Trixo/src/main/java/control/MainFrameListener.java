package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import model.ApiController;
import model.Post;
import view.MainFrame;

public class MainFrameListener implements ActionListener {
	
	private MainFrame mainFrame;
	ApiController apiController;
	
	public MainFrameListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.apiController = new ApiController();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if (e.getSource() == mainFrame.getBtnImgBack()) {
				mainFrame.showPreviousImage();
			} else if (e.getSource() == mainFrame.getBtnImgNext()) {
				mainFrame.showNextImage();
			} else if (e.getSource() == mainFrame.getBtnBan()) {
				nextPost("Banned");
			} else if (e.getSource() == mainFrame.getBtnSpare()) {
				nextPost("notReported");
			} else if (e.getSource() == mainFrame.getBtnRefresh()) {
				getOnRevisionPosts();
			}
		}
		
	}

	private void nextPost(String status) {
		apiController.updatePostStatus(mainFrame.getCurrentPost().getId(), status);
		mainFrame.nextPost();
	}
	
	public void getOnRevisionPosts() {
		List<Post> posts = apiController.getOnRevisionPosts("onRevision");
		if(posts.isEmpty()) {
			mainFrame.getLblPostImage().setText("No posts available for review.");
			mainFrame.getLblContador().setText("0/0");
		} else {
			mainFrame.setPosts(posts);			
		}
	}
	
}
