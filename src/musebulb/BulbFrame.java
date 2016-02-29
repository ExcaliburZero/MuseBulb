/*
 * Copyright (C) 2016 Shakhar Dasgupta<sdasgupt@oswego.edu>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package musebulb;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Shakhar Dasgupta<sdasgupt@oswego.edu>
 */
public class BulbFrame extends JFrame {

    private Image on;
    private Image off;
    private JPanel panel;
    private ImageIcon image;
    private boolean isOn;

    public BulbFrame() {
        off = Toolkit.getDefaultToolkit().createImage("res/pic_bulboff.gif");
        on = Toolkit.getDefaultToolkit().createImage("res/pic_bulbon.gif");
        isOn = false;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bulb Frame");
        setSize(250, 250);
        panel = new JPanel();
        image = new ImageIcon(off);
        panel.add(new JLabel(image));
        add(panel);
        setVisible(true);
    }

    public void turnOff() {
        image.setImage(off);
        repaint();
        isOn = false;
    }

    public void turnOn() {
        image.setImage(on);
        repaint();
        isOn = true;
    }

    public boolean isOn() {
        return isOn;
    }

    public void toggle() {
        if (isOn) {
            turnOff();
        } else {
            turnOn();
        }
    }
}
