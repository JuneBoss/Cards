package cards.view;

import cards.controller.Controller;
import javax.swing.JFrame;

public class CardsFrame extends JFrame
{
		private Controller app;
		private CardsPanel panel;
		
		public CardsFrame(Controller app)
		{
			super();
			this.app = app;
			this.panel = new CardsPanel(this.app);
			
			setupFrame();
		}
		
		private void setupFrame()
		{
			this.setContentPane(panel);
			this.setTitle("Cards");
			this.setSize(800, 600);
			this.setResizable(false);
			this.setVisible(true);
		}
}