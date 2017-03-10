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

public class Scores extends JInternalFrame implements ActionListener
{
    public JTextArea textArea1;
    private JScrollPane scrollPane1;
    JButton boutonValider;

    /**
     * constructeur
     */
    public Scores()
    {
        // paramètres de la fenêtre :
        setTitle("Meilleurs scores");
        setBounds(660, 150, 350, 250);
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
        textArea1.setBackground(Color.PINK);
        textArea1.append("******************************************** \n");
        textArea1.append("Grille\t Essais\t Joueur \n");
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
