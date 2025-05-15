package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import control.MainFrameListener;
import model.Post;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	private final int HEIGHT = 700;
	private final int WIDTH = 950;
	
	private Post currentPost;
	private List<Post> posts;
	private int imageIndex = 0;
	private int postIndex = 0;
	
	private JButton btnImgPrevious;
	private JButton btnBan;
	private JButton btnSpare;
	private JButton btnImgNext;
	private JLabel lblUsername;
	private JLabel lblEmail;
	private JLabel lblUserID;
	private JLabel lblPostImage;
	private JTextArea txtaPostCaption;
	private JLabel lblUsername_1;
	private JLabel lblEmail_1;
	private JLabel lblUserID_1;
	private JLabel lblPostId;
	private JLabel lblPostID_1;
	private JButton btnRefresh;
	private JTextArea txtaReason;
	private JLabel lblContador;
	
	public MainFrame() {
		super("Trixo's Report Manager");
		configFrame();
		configComponents();
	}

	private void configComponents() {
		btnImgPrevious = new JButton("<--");
		btnImgPrevious.setFont(new Font("Tahoma", Font.PLAIN, 24));

		btnImgPrevious.setBounds(35, 189, 131, 60);
		getContentPane().add(btnImgPrevious);
		
		btnSpare = new JButton("Keep post up");
		btnSpare.setBounds(35, 523, 119, 23);
		getContentPane().add(btnSpare);
		
		btnBan = new JButton("Take post down");
		btnBan.setBounds(784, 523, 119, 23);
		getContentPane().add(btnBan);
		
		btnImgNext = new JButton("-->");
		btnImgNext.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnImgNext.setBounds(772, 189, 131, 60);
		getContentPane().add(btnImgNext);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(268, 563, 61, 14);
		getContentPane().add(lblUsername);
		
		lblPostImage = new JLabel("");
		lblPostImage.setBounds(197, 11, 538, 400);
		getContentPane().add(lblPostImage);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(268, 590, 61, 14);
		getContentPane().add(lblEmail);
		
		lblUserID = new JLabel("User ID");
		lblUserID.setBounds(268, 617, 61, 14);
		getContentPane().add(lblUserID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(339, 452, 319, 46);
		getContentPane().add(scrollPane);
		
		txtaPostCaption = new JTextArea();
		txtaPostCaption.setEditable(false);
		txtaPostCaption.setEnabled(false);
		scrollPane.setViewportView(txtaPostCaption);
		
		lblUsername_1 = new JLabel("Username");
		lblUsername_1.setBounds(339, 563, 319, 14);
		getContentPane().add(lblUsername_1);
		
		lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(339, 590, 319, 14);
		getContentPane().add(lblEmail_1);
		
		lblUserID_1 = new JLabel("ID");
		lblUserID_1.setBounds(339, 617, 319, 14);
		getContentPane().add(lblUserID_1);
		
		lblPostId = new JLabel("Post ID");
		lblPostId.setBounds(268, 423, 61, 14);
		getContentPane().add(lblPostId);
		
		lblPostID_1 = new JLabel("ID");
		lblPostID_1.setBounds(339, 423, 319, 14);
		getContentPane().add(lblPostID_1);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRefresh.setBounds(784, 51, 119, 37);
		getContentPane().add(btnRefresh);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(339, 509, 319, 46);
		getContentPane().add(scrollPane_1);
		
		txtaReason = new JTextArea();
		txtaReason.setEnabled(false);
		txtaReason.setEditable(false);
		scrollPane_1.setViewportView(txtaReason);
		
		JLabel lblCaption = new JLabel("Caption");
		lblCaption.setBounds(268, 469, 61, 14);
		getContentPane().add(lblCaption);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setBounds(268, 527, 61, 14);
		getContentPane().add(lblReason);
		
		lblContador = new JLabel("L");
		lblContador.setBounds(816, 26, 46, 14);
		getContentPane().add(lblContador);
	}

	private void configFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(WIDTH,HEIGHT);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();                
		setLocation((pantalla.width - this.getSize().width) / 2, (pantalla.height - this.getSize().height) / 2);
		getContentPane().setLayout(null);
	}
	
	public void turnVisible() {
		setVisible(true);
	}
	
	public void setListener(MainFrameListener controller) {
		btnImgPrevious.addActionListener(controller);
		btnBan.addActionListener(controller);
		btnSpare.addActionListener(controller);
		btnImgNext.addActionListener(controller);
		btnRefresh.addActionListener(controller);
	}
	
    public void showNextImage() {
        if (currentPost != null && currentPost.getImages() != null) {
            List<String> images = currentPost.getImages();
            if (imageIndex < images.size() - 1) {
                imageIndex++;
                displayImage();
            }
        }
    }

    public void showPreviousImage() {
        if (currentPost != null && currentPost.getImages() != null) {
            if (imageIndex > 0) {
                imageIndex--;
                displayImage();
            }
        }
    }

    private void displayImage() {
    	try {
    		if (currentPost != null && currentPost.getImages() != null) {
				currentPost.getImages().get(imageIndex);
				String url = currentPost.getImages().get(imageIndex);
				if(url != null) {
					if(!url.isEmpty()) {
						URL imageUrl = new URL(url);
						Image image = ImageIO.read(imageUrl);
						if(image != null) {
							Image scaledImage = image.getScaledInstance(lblPostImage.getWidth(), lblPostImage.getHeight(), Image.SCALE_SMOOTH);
							lblPostImage.setIcon(new ImageIcon(scaledImage));												
						} else {
							lblPostImage.setIcon(null);
						}
					}
				} else {
					lblPostImage.setIcon(null);
				}
			}
    	} catch (MalformedURLException e) {
    		e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
    }
	
    public void nextPost() {
		if (posts != null && !posts.isEmpty()) {
			int index = posts.indexOf(currentPost);
			if(index < posts.size() - 1) {
				currentPost = posts.get(index + 1);
				postIndex++;
				setNextPost(currentPost);
			} else {
				clearPostData();
			}
		}
	}
    
	private void clearPostData() {
		lblPostImage.setIcon(null);
		lblPostID_1.setText("");
		txtaPostCaption.setText("");
		lblUsername_1.setText("");
		lblEmail_1.setText("");
		lblUserID_1.setText("");
		txtaReason.setText("");
		lblContador.setText("0/0");
		imageIndex = 0;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
		System.out.println("Posts: " + posts.size());
        if (!posts.isEmpty()) {
        	lblContador.setText(String.valueOf(postIndex + 1) + "/" + posts.size());
            this.currentPost = posts.get(0);
            
            System.out.println("Current Post: " + currentPost.getCaption() + " - " 
            + currentPost.getId() + " - " 
    		+ currentPost.getUser().getUsername() + " - " 
            + currentPost.getUser().getEmail());
            
            setNextPost(posts.get(0));
            this.imageIndex = 0;
            displayImage();
        }
	}
	
	private void setNextPost(Post post) {
		lblContador.setText(String.valueOf(postIndex + 1) + "/" + posts.size());
		lblPostID_1.setText(post.getId());
		txtaPostCaption.setText(post.getCaption());
		lblUsername_1.setText(post.getUser().getUsername());
		lblEmail_1.setText(post.getUser().getEmail());
		lblUserID_1.setText(post.getUser().getId());
		if(post.getReport() != null) {
			txtaReason.setText(post.getReport().getReason());        	
		}
		displayImage();
	}
	
	public JLabel getLblPostImage() {
		return lblPostImage;
	}
	
	public JButton getBtnBan() {
		return btnBan;
	}
	
	public JButton getBtnImgBack() {
		return btnImgPrevious;
	}
	
	public JButton getBtnImgNext() {
		return btnImgNext;
	}
	
	public JButton getBtnSpare() {
		return btnSpare;
	}

	public List<Post> getPosts() {
		return posts;
	}
	
	public Post getCurrentPost() {
		return currentPost;
	}
	
	public void setCurrentPost(Post currentPost) {
		this.currentPost = currentPost;
	}
	
	public JButton getBtnRefresh() {
		return btnRefresh;
	}
	
	public JLabel getLblContador() {
		return lblContador;
	}
}
