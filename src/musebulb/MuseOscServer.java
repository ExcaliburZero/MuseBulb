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

import oscP5.OscMessage;
import oscP5.OscP5;

/**
 *
 * @author Shakhar Dasgupta<sdasgupt@oswego.edu>
 */
public class MuseOscServer {

    private static final int PORT = 5000;
    private OscP5 osc;
    private BulbFrame bulbFrame;
    private boolean done;

    public MuseOscServer(BulbFrame bulbFrame) {
        this.osc = new OscP5(this, PORT);
        this.bulbFrame = bulbFrame;
        done = true;
    }

    public void oscEvent(OscMessage msg) {
        if (msg.checkAddress("/muse/elements/blink")) {
            int value = msg.get(0).intValue();
            if (value == 1) {
                if (done) {
                    bulbFrame.toggle();
                    done = false;
                }
            } else {
                done = true;
            }
        }
    }
}
