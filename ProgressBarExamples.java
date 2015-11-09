import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingWorker;

import java.awt.BorderLayout;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProgressBarExamples {

    JProgressBar progressBar;
    JCheckBox progressType;
    JCheckBox switchType;
    final JButton goButton;
    
    //Note: Typically the main method will be in a
    //separate class. As this is a simple one class
    //example it's all in the one class.
    public static void main(String[] args) {
     
        
         //Use the event dispatch thread for Swing components
         EventQueue.invokeLater(new Runnable()
         {
             
            public void run()
             {
                 
                 new ProgressBarExamples();         
             }
         });
              
    }
    
    public ProgressBarExamples()
    {
        JFrame guiFrame = new JFrame();
        
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Creating a Table Example");
        guiFrame.setSize(700,200);
      
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
        

        goButton = new JButton("Go");
        goButton.setActionCommand("Go");
        goButton.addActionListener(new ActionListener()
        {
            
            //When the button is clicked the SwingWorker class is executed and
            //the button is disabled
            public void actionPerformed(ActionEvent event)
            {
                

                Sleeper task = new Sleeper();
                task.execute();
                goButton.setEnabled(false);
            }
        });
        
        //create a panel to hold the checkboxes
        JPanel chkPanel = new JPanel();
        
        //Create a checkbox to pick between a determined or indeterminate
        //progressbar



        
        //create progress bar        
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);     
           chkPanel.add(progressBar)  ;
           guiFrame.add(chkPanel);
           goButton.doClick();
 
        
        guiFrame.setVisible(true);
    }

    class Sleeper extends SwingWorker{

		@Override
		protected Object doInBackground() throws Exception {
			int count = 0;
			
			for(int i = 0; i < 101; i++){
				 count = count + 1;
				 try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 progressBar.setValue(i);   
			}
			
			return null;
		}
    	
    	
    }
    }
    