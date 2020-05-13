import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainBreak {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                BreakFrame e1 = new BreakFrame(0,0,1100,700);
                e1.setBounds(200,150,1100,738);
                e1.setVisible(true);                
            }
        });
	}

}
