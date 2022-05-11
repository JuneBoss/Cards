package cards.view;

import cards.controller.Controller;
import javax.swing.JFrame;

public class CardsFrame extends JFrame
{
		/**
		 * an instance of controller
		 */
		private Controller app;
		/**
		 * an instance of CardsPanel
		 */
		private CardsPanel panel;
		
		/**
		 * creates the frame
		 * @param app
		 * an instance of controller
		 */
		public CardsFrame(Controller app)
		{
			super();
			this.app = app;
			this.panel = new CardsPanel(this.app);
			
			setupFrame();
		}
		
		/**
		 * sets up the frame
		 */
		private void setupFrame()
		{
			this.setContentPane(panel);
			this.setTitle("War 2 electric warbaloo");
			this.setSize(800, 600);
			this.setResizable(false);
			this.setVisible(true);
		}
}