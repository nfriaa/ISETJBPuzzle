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
import java.awt.event.*;
import javax.swing.*;

public class Apropos extends JInternalFrame implements ActionListener
{
    private JTextArea textArea1;
    private JScrollPane scrollPane1;
    JButton boutonValider;

    /**
     * constructeur
     */
    public Apropos()
    {
        // paramètres de la fenêtre :
        setTitle("A Propos de ISETJBPuzzle v1.0");
        setBounds(250, 100, 350, 250);
        setClosable(false);
        setIconifiable(false);
        setMaximizable(false);
        setResizable(false);

        // cacher la fenêtre lorsqu'on clique sur l'icone fermer :
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        // le mode de disposition :
        this.getContentPane().setLayout(new FlowLayout());

        creerComposants();
        ajouterComposants();
        placerEcouteurs();

        setVisible(false);
    }

    /**
     * créer / instancier les composants et les objets de la fenêtre :
     */
    public void creerComposants()
    {
        textArea1 = new JTextArea(10, 25);
        textArea1.setBackground(Color.orange);
        textArea1.append("******************************************** \n");
        textArea1.append("ISETJBPuzzle v1.0 \n");
        textArea1.append("Jeux de Puzzle en Java \n");
        textArea1.append("******************************************** \n\n");
        textArea1.append("Réalisé par : Nafaa Friaa \n");
        textArea1.append("Email : nafaa.friaa@isetjb.rnu.tn \n\n");
        textArea1.append("Merci d'avoir jouer avec notre Jeu de Puzzle ... \n\n");
        textArea1.append("(c) copyright ISET Djerba. \n");
        textArea1.append("www.isetjb.rnu.tn \n");
        textArea1.append("******************************************** \n");
        textArea1.setEditable(false);

        scrollPane1 = new JScrollPane(textArea1);

        boutonValider = new JButton(" Valider ");
    }

    /**
     * ajouter les composants crées à la fenêtre :
     */
    public void ajouterComposants()
    {
        this.getContentPane().add(scrollPane1);
        this.getContentPane().add(boutonValider);
    }

    /**
     * placer les écouteurs sur les composants :
     */
    public void placerEcouteurs()
    {
        boutonValider.addActionListener(this);
    }

    /**
     * gestion des évènements
     *
     * @param ev
     */
    public void actionPerformed(ActionEvent ev)
    {
        if (ev.getSource() == boutonValider)
        {
            setVisible(false);
        }
    }

}
