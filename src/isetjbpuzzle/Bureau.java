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

public class Bureau extends JFrame implements ActionListener
{
    private JDesktopPane desktop;
    private Apropos fenetreApropos;
    private Apercu fenetreApercu1, fenetreApercu2;
    public Scores fenetreScores;
    private JLabel barreEtat;

    private JMenuBar menuBar;
    private JMenu menuFichier;
    private JMenuItem itemNouveau;
    private JMenuItem itemScores;
    private JMenuItem itemQuitter;

    private JMenu menuParams;

    private JMenu menuGrille;
    private JRadioButtonMenuItem itemGrille9;
    private JRadioButtonMenuItem itemGrille16;

    private JMenu menuPhoto;
    private JRadioButtonMenuItem itemPhoto1;
    private JRadioButtonMenuItem itemPhoto2;

    private JMenu menuAide;
    private JMenuItem itemApropos;
    private JMenuItem itemApercuPhoto1;
    private JMenuItem itemApercuPhoto2;

    /**
     * constructeur
     */
    public Bureau()
    {
        setTitle("ISETJBPuzzle v1.0");
        //setBounds(50, 30, 1024, 750);
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // le conteneur de type bureau :
        desktop = new JDesktopPane();
        this.getContentPane().add(desktop, BorderLayout.CENTER);

        // création des fenêtres : 
        fenetreScores = new Scores();
        fenetreApropos = new Apropos();
        fenetreApercu1 = new Apercu("photo1");
        fenetreApercu2 = new Apercu("photo2");

        // ajout des fenêtres au bureau : 
        desktop.add(fenetreScores);
        desktop.add(fenetreApropos);
        desktop.add(fenetreApercu1);
        desktop.add(fenetreApercu2);

        // barre d'état : 
        barreEtat = new JLabel("Bienvenue dans notre jeux de Puzzle, bonne chance !");
        this.getContentPane().add(barreEtat, BorderLayout.SOUTH);

        // pour afficher le menu en haut sous Mac : 
        if (System.getProperty("os.name").contains("Mac"))
        {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }

        creerMenu();
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public void creerMenu()
    {
        menuBar = new JMenuBar();
        menuFichier = new JMenu("Fichier");
        menuFichier.setMnemonic('F');
        itemNouveau = new JMenuItem("Nouvele Partie");
        itemNouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        itemScores = new JMenuItem("Meilleurs scores");
        itemScores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
        itemQuitter = new JMenuItem("Quitter");
        itemQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));

        menuParams = new JMenu("Paramètres");
        menuParams.setMnemonic('P');

        menuGrille = new JMenu("Grille");
        menuGrille.setMnemonic('G');
        itemGrille9 = new JRadioButtonMenuItem("Grille9", true);
        itemGrille9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        itemGrille16 = new JRadioButtonMenuItem("Grille16");
        itemGrille16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));

        menuPhoto = new JMenu("Photo");
        menuPhoto.setMnemonic('P');
        itemPhoto1 = new JRadioButtonMenuItem("Photo 1", true);
        itemPhoto1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, InputEvent.CTRL_MASK));
        itemPhoto2 = new JRadioButtonMenuItem("Photo 2");
        itemPhoto2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_MASK));

        menuAide = new JMenu("Aide");
        menuAide.setMnemonic('A');
        itemApropos = new JMenuItem("A Propos");
        itemApropos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
        itemApercuPhoto1 = new JMenuItem("Aperçu Photo 1");
        itemApercuPhoto2 = new JMenuItem("Aperçu Photo 2");

        menuBar.add(menuFichier);
        menuBar.add(menuParams);
        menuBar.add(menuAide);

        menuFichier.add(itemNouveau);
        menuFichier.add(itemScores);
        menuFichier.add(itemQuitter);

        menuParams.add(menuGrille);
        menuGrille.add(itemGrille9);
        menuGrille.add(itemGrille16);
        ButtonGroup g1 = new ButtonGroup();
        g1.add(itemGrille9);
        g1.add(itemGrille16);

        menuParams.add(menuPhoto);
        menuPhoto.add(itemPhoto1);
        menuPhoto.add(itemPhoto2);
        ButtonGroup g2 = new ButtonGroup();
        g2.add(itemPhoto1);
        g2.add(itemPhoto2);

        menuAide.add(itemApropos);
        menuAide.add(itemApercuPhoto1);
        menuAide.add(itemApercuPhoto2);

        // écouteurs : 
        itemQuitter.addActionListener(this);
        itemNouveau.addActionListener(this);
        itemScores.addActionListener(this);
        itemApropos.addActionListener(this);
        itemApercuPhoto1.addActionListener(this);
        itemApercuPhoto2.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ev)
    {
        if (ev.getSource() == itemQuitter)
        {
            System.exit(0);
        }

        if (ev.getSource() == itemNouveau)
        {
            Fenetre fenetre;
            String temp_photo = "";
            String temp_grille = "";

            if (itemPhoto1.isSelected())
            {
                temp_photo = "photo1";
            }
            else if (itemPhoto2.isSelected())
            {
                temp_photo = "photo2";
            }

            if (itemGrille9.isSelected())
            {
                temp_grille = "grille9";
            }
            else if (itemGrille16.isSelected())
            {
                temp_grille = "grille16";
            }

            fenetre = new Fenetre(temp_photo, temp_grille);
            desktop.add(fenetre);
            fenetre.moveToFront();

        }

        if (ev.getSource() == itemScores)
        {
            fenetreScores.setVisible(true);
            fenetreScores.moveToFront();
        }

        if (ev.getSource() == itemApropos)
        {
            fenetreApropos.setVisible(true);
            fenetreApropos.moveToFront();
        }

        if (ev.getSource() == itemApercuPhoto1)
        {
            fenetreApercu1.setVisible(true);
            fenetreApercu1.moveToFront();
        }

        if (ev.getSource() == itemApercuPhoto2)
        {
            fenetreApercu2.setVisible(true);
            fenetreApercu2.moveToFront();
        }

    }
}
