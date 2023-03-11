package b314.S2TextEditor.ui.frame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
public class TEFrameConfiguration {

    @Bean
    public TEFrame teFrame(JFileChooser fileChooser,
                           JMenuBar menuBar,
                           JPanel controlPanel,
                           JScrollPane scrollPane) {
        // Creating frame
        TEFrame teFrame = new TEFrame();

        // Add controls directly to frame
        teFrame.add(fileChooser);
        teFrame.setJMenuBar(menuBar);

        // Configuring layout
        var pane = teFrame.getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        GroupLayout.ParallelGroup gh = gl.createParallelGroup();
        gh.addComponent(controlPanel);
        gh.addComponent(scrollPane);
        gl.setHorizontalGroup(gh);
        GroupLayout.SequentialGroup gv = gl.createSequentialGroup();
        gv.addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        gv.addComponent(scrollPane);
        gl.setVerticalGroup(gv);

        // Packing
        teFrame.pack();

        // Returning frame
        return teFrame;
    }

}
