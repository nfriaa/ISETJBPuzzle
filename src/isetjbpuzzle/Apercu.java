/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isetjbpuzzle;

/**
 *
 * @author nafaa
 */
import java.awt.*;
import javax.swing.*;

public class Apercu extends JInternalFrame
{
    private JLabel label1, label2;
    private JScrollPane scrollPane1;

    /**
     * constructeur
     */
    public Apercu(String photo)
    {
        // paramètres de la fenêtre :
        setTitle("Aperçu de " + photo);

        if ("photo1".equals(photo))
        {
            setBounds(650, 10, 325, 345);
        }
        else if ("photo2".equals(photo))
        {
            setBounds(670, 40, 325, 345);
        }

        setClosable(true);
        setIconifiable(true);
        setMaximizable(false);
        setResizable(false);

        // cacher la fenêtre lorsqu'on clique sur l'icone fermer :
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        // le mode de disposition :
        this.getContentPane().setLayout(new FlowLayout());

        label1 = new JLabel();
        label2 = new JLabel();

        label1.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/photo1/photo1_small.png")));
        label2.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/photo2/photo2_small.png")));

        if ("photo1".equals(photo))
        {
            this.getContentPane().add(label1);
        }
        else if ("photo2".equals(photo))
        {
            this.getContentPane().add(label2);
        }

        setVisible(false);
    }

}
