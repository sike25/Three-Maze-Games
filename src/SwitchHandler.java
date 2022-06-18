//Osasikemwen Ogieva

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    class SwitchHandler extends JButton implements ActionListener {
        public SwitchHandler() {
        }

        public void actionPerformed(ActionEvent e) {
            Menu menu = new Menu();
            menu.go();
            menu.pack();
            menu.setVisible(true);
            menu.setSize(new Dimension(500,500));
        }
    }