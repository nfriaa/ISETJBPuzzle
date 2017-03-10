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

public class Fenetre extends JInternalFrame implements MouseListener
{

    Container contenu;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16;
    int nombre_tentatives = 0;
    String photo = "photo1";
    String grille = "grille9";

    public static int meilleurScoreGrille9 = Integer.MAX_VALUE;
    public static int meilleurScoreGrille16 = Integer.MAX_VALUE;

    public Fenetre(String photo, String grille)
    {
        this.photo = photo;
        this.grille = grille;

        setTitle("Nouvelle Partie : " + this.photo + " / " + this.grille);

        setBounds(10, 10, 630, 650);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(false);
        setResizable(false);

        contenu = this.getContentPane();

        if ("grille9".equals(this.grille))
        {
            contenu.setLayout(new GridLayout(3, 3));
        }
        else if ("grille16".equals(this.grille))
        {
            contenu.setLayout(new GridLayout(4, 4));
        }

        // le tableau avant shuffle (sans le 1 : pas d'icone au démarrage):
        int[] tab_random;

        if ("grille9".equals(this.grille))
        {
            tab_random = new int[8];
            tab_random[0] = 2;
            tab_random[1] = 3;
            tab_random[2] = 4;
            tab_random[3] = 5;
            tab_random[4] = 6;
            tab_random[5] = 7;
            tab_random[6] = 8;
            tab_random[7] = 9;
        }
        else if ("grille16".equals(this.grille))
        {
            tab_random = new int[15];
            tab_random[0] = 2;
            tab_random[1] = 3;
            tab_random[2] = 4;
            tab_random[3] = 5;
            tab_random[4] = 6;
            tab_random[5] = 7;
            tab_random[6] = 8;
            tab_random[7] = 9;
            tab_random[8] = 10;
            tab_random[9] = 11;
            tab_random[10] = 12;
            tab_random[11] = 13;
            tab_random[12] = 14;
            tab_random[13] = 15;
            tab_random[14] = 16;
        }
        else
        {
            // pour corriger erreur syntaxe java :
            tab_random = new int[0];
        }
        // changer alléatoirement l'ordre des éléments :
        tab_random = shffleArray(tab_random);

        // icone1 vide :
        l1 = new JLabel();
        l1.setIcon(null);
        l1.setName("0");
        l1.addMouseListener(this);
        contenu.add(l1);

        l2 = new JLabel();
        l2.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[0] + ".png")));
        l2.setName("" + tab_random[0]);
        l2.addMouseListener(this);
        contenu.add(l2);

        l3 = new JLabel();
        l3.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[1] + ".png")));
        l3.setName("" + tab_random[1]);
        l3.addMouseListener(this);
        contenu.add(l3);

        l4 = new JLabel();
        l4.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[2] + ".png")));
        l4.setName("" + tab_random[2]);
        l4.addMouseListener(this);
        contenu.add(l4);

        l5 = new JLabel();
        l5.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[3] + ".png")));
        l5.setName("" + tab_random[3]);
        l5.addMouseListener(this);
        contenu.add(l5);

        l6 = new JLabel();
        l6.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[4] + ".png")));
        l6.setName("" + tab_random[4]);
        l6.addMouseListener(this);
        contenu.add(l6);

        l7 = new JLabel();
        l7.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[5] + ".png")));
        l7.setName("" + tab_random[5]);
        l7.addMouseListener(this);
        contenu.add(l7);

        l8 = new JLabel();
        l8.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[6] + ".png")));
        l8.setName("" + tab_random[6]);
        l8.addMouseListener(this);
        contenu.add(l8);

        l9 = new JLabel();
        l9.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[7] + ".png")));
        l9.setName("" + tab_random[7]);
        l9.addMouseListener(this);
        contenu.add(l9);

        if ("grille16".equals(this.grille))
        {
            l10 = new JLabel();
            l10.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[8] + ".png")));
            l10.setName("" + tab_random[8]);
            l10.addMouseListener(this);
            contenu.add(l10);

            l11 = new JLabel();
            l11.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[9] + ".png")));
            l11.setName("" + tab_random[9]);
            l11.addMouseListener(this);
            contenu.add(l11);

            l12 = new JLabel();
            l12.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[10] + ".png")));
            l12.setName("" + tab_random[10]);
            l12.addMouseListener(this);
            contenu.add(l12);

            l13 = new JLabel();
            l13.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[11] + ".png")));
            l13.setName("" + tab_random[11]);
            l13.addMouseListener(this);
            contenu.add(l13);

            l14 = new JLabel();
            l14.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[12] + ".png")));
            l14.setName("" + tab_random[12]);
            l14.addMouseListener(this);
            contenu.add(l14);

            l15 = new JLabel();
            l15.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[13] + ".png")));
            l15.setName("" + tab_random[13]);
            l15.addMouseListener(this);
            contenu.add(l15);

            l16 = new JLabel();
            l16.setIcon(new ImageIcon(getClass().getResource("/isetjbpuzzle/images/" + this.photo + "/" + this.grille + "/img" + tab_random[14] + ".png")));
            l16.setName("" + tab_random[14]);
            l16.addMouseListener(this);
            contenu.add(l16);
        }

        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void verifier_resultat()
    {
        nombre_tentatives++;

        this.setTitle("Partie en cours : " + this.photo + " / " + this.grille + " / " + nombre_tentatives + " essais");

        String etat_puzzle = l1.getName() + l2.getName() + l3.getName() + l4.getName() + l5.getName() + l6.getName() + l7.getName() + l8.getName() + l9.getName();

        String etat_gagnant = "023456789";

        if ("grille16".equals(this.grille))
        {
            etat_puzzle += l10.getName() + l11.getName() + l12.getName() + l13.getName() + l14.getName() + l15.getName() + l16.getName();
            etat_gagnant += "10111213141516";
        }

        //System.out.println(etat_puzzle);
        if (etat_gagnant.equals(etat_puzzle))
        {
            this.setTitle("Partie gagnée : " + this.photo + " / " + this.grille + " / " + nombre_tentatives + " essais");

            JOptionPane.showMessageDialog(this, "Bravo, vous avez gagné dans " + nombre_tentatives + " essais !", "Partie terminée", JOptionPane.INFORMATION_MESSAGE);

            if ("grille9".equals(this.grille))
            {
                if (nombre_tentatives < this.meilleurScoreGrille9)
                {
                    String pseudo = (String) JOptionPane.showInputDialog(this, "Bravo c'est le meilleur score !\n" + "Saisir votre pseudo :", "Meilleur score", JOptionPane.PLAIN_MESSAGE);

                    this.meilleurScoreGrille9 = nombre_tentatives;

                    if ((pseudo != null) && (pseudo.length() > 0))
                    {
                        isetjbpuzzle.ISETJBPuzzle.monBureau.fenetreScores.textArea1.append("Grille9 \t " + nombre_tentatives + " \t " + pseudo + "\n");
                    }
                    else
                    {
                        isetjbpuzzle.ISETJBPuzzle.monBureau.fenetreScores.textArea1.append("Grille9 \t " + nombre_tentatives + " \t " + "Inconnu" + "\n");
                    }
                }
            }
            else if ("grille16".equals(this.grille))
            {
                if (nombre_tentatives < this.meilleurScoreGrille16)
                {
                    String pseudo = (String) JOptionPane.showInputDialog(this, "Bravo c'est le meilleur score !\n" + "Saisir votre pseudo :", "Meilleur score", JOptionPane.PLAIN_MESSAGE);

                    this.meilleurScoreGrille16 = nombre_tentatives;

                    if ((pseudo != null) && (pseudo.length() > 0))
                    {
                        isetjbpuzzle.ISETJBPuzzle.monBureau.fenetreScores.textArea1.append("Grille16 \t " + nombre_tentatives + " \t " + pseudo + "\n");
                    }
                    else
                    {
                        isetjbpuzzle.ISETJBPuzzle.monBureau.fenetreScores.textArea1.append("Grille16 \t " + nombre_tentatives + " \t " + "Inconnu" + "\n");
                    }
                }
            }

            l1.removeMouseListener(this);
            l2.removeMouseListener(this);
            l3.removeMouseListener(this);
            l4.removeMouseListener(this);
            l5.removeMouseListener(this);
            l6.removeMouseListener(this);
            l7.removeMouseListener(this);
            l8.removeMouseListener(this);
            l9.removeMouseListener(this);

            if ("grille16".equals(this.grille))
            {
                l10.removeMouseListener(this);
                l11.removeMouseListener(this);
                l12.removeMouseListener(this);
                l13.removeMouseListener(this);
                l14.removeMouseListener(this);
                l15.removeMouseListener(this);
                l16.removeMouseListener(this);
            }
        }
    }

    public void mouseClicked(MouseEvent ev)
    {
        if ("grille9".equals(this.grille))
        {
            mouseClicked_grille9(ev);
        }
        else if ("grille16".equals(this.grille))
        {
            mouseClicked_grille16(ev);
        }
    }

    public void mouseClicked_grille9(MouseEvent ev)
    {
        if (ev.getSource() == l1)
        {
            //System.out.println("clic sur l1");

            // si icone existe et il existe une place voisine => déplacer :
            // 1 peut être échangé avec 2,4
            if (l1.getIcon() != null)
            {
                if (l2.getIcon() == null)
                {
                    l2.setIcon(l1.getIcon());
                    l2.setName(l1.getName());
                    l1.setIcon(null);
                    l1.setName("0");
                    verifier_resultat();
                }
                if (l4.getIcon() == null)
                {
                    l4.setIcon(l1.getIcon());
                    l4.setName(l1.getName());
                    l1.setIcon(null);
                    l1.setName("0");
                    verifier_resultat();
                }
            }
        }
        if (ev.getSource() == l2)
        {
            //System.out.println("clic sur l2");

            // si icone existe et il existe une place voisine => déplacer :  
            // 2 peut être échangé avec 1,3,5
            if (l2.getIcon() != null)
            {
                if (l1.getIcon() == null)
                {
                    l1.setIcon(l2.getIcon());
                    l1.setName(l2.getName());
                    l2.setIcon(null);
                    l2.setName("0");
                    verifier_resultat();
                }
                if (l3.getIcon() == null)
                {
                    l3.setIcon(l2.getIcon());
                    l3.setName(l2.getName());
                    l2.setIcon(null);
                    l2.setName("0");
                    verifier_resultat();
                }
                if (l5.getIcon() == null)
                {
                    l5.setIcon(l2.getIcon());
                    l5.setName(l2.getName());
                    l2.setIcon(null);
                    l2.setName("0");
                    verifier_resultat();
                }
            }
        }
        if (ev.getSource() == l3)
        {
            //System.out.println("clic sur l3");

            // si icone existe et il existe une place voisine => déplacer : 
            // 3 peut être échangé avec 2,6
            if (l3.getIcon() != null)
            {
                if (l2.getIcon() == null)
                {
                    l2.setIcon(l3.getIcon());
                    l2.setName(l3.getName());
                    l3.setIcon(null);
                    l3.setName("0");
                    verifier_resultat();
                }
                if (l6.getIcon() == null)
                {
                    l6.setIcon(l3.getIcon());
                    l6.setName(l3.getName());
                    l3.setIcon(null);
                    l3.setName("0");
                    verifier_resultat();
                }
            }
        }
        if (ev.getSource() == l4)
        {
            //System.out.println("clic sur l4");

            // si icone existe et il existe une place voisine => déplacer : 
            // 4 peut être échangé avec 1,5,7
            if (l4.getIcon() != null)
            {
                if (l1.getIcon() == null)
                {
                    l1.setIcon(l4.getIcon());
                    l1.setName(l4.getName());
                    l4.setIcon(null);
                    l4.setName("0");
                    verifier_resultat();
                }
                if (l5.getIcon() == null)
                {
                    l5.setIcon(l4.getIcon());
                    l5.setName(l4.getName());
                    l4.setIcon(null);
                    l4.setName("0");
                    verifier_resultat();
                }
                if (l7.getIcon() == null)
                {
                    l7.setIcon(l4.getIcon());
                    l7.setName(l4.getName());
                    l4.setIcon(null);
                    l4.setName("0");
                    verifier_resultat();
                }
            }
        }
        if (ev.getSource() == l5)
        {
            //System.out.println("clic sur l5");

            // si icone existe et il existe une place voisine => déplacer : 
            // 5 peut être échangé avec 2,4,6,8
            if (l5.getIcon() != null)
            {
                if (l2.getIcon() == null)
                {
                    l2.setIcon(l5.getIcon());
                    l2.setName(l5.getName());
                    l5.setIcon(null);
                    l5.setName("0");
                    verifier_resultat();
                }
                if (l4.getIcon() == null)
                {
                    l4.setIcon(l5.getIcon());
                    l4.setName(l5.getName());
                    l5.setIcon(null);
                    l5.setName("0");
                    verifier_resultat();
                }
                if (l6.getIcon() == null)
                {
                    l6.setIcon(l5.getIcon());
                    l6.setName(l5.getName());
                    l5.setIcon(null);
                    l5.setName("0");
                    verifier_resultat();
                }
                if (l8.getIcon() == null)
                {
                    l8.setIcon(l5.getIcon());
                    l8.setName(l5.getName());
                    l5.setIcon(null);
                    l5.setName("0");
                    verifier_resultat();
                }
            }
        }
        if (ev.getSource() == l6)
        {
            //System.out.println("clic sur l6");

            // si icone existe et il existe une place voisine => déplacer : 
            // 6 peut être échangé avec 3,5,9
            if (l6.getIcon() != null)
            {
                if (l3.getIcon() == null)
                {
                    l3.setIcon(l6.getIcon());
                    l3.setName(l6.getName());
                    l6.setIcon(null);
                    l6.setName("0");
                    verifier_resultat();
                }
                if (l5.getIcon() == null)
                {
                    l5.setIcon(l6.getIcon());
                    l5.setName(l6.getName());
                    l6.setIcon(null);
                    l6.setName("0");
                    verifier_resultat();
                }
                if (l9.getIcon() == null)
                {
                    l9.setIcon(l6.getIcon());
                    l9.setName(l6.getName());
                    l6.setIcon(null);
                    l6.setName("0");
                    verifier_resultat();
                }
            }
        }
        if (ev.getSource() == l7)
        {
            //System.out.println("clic sur l7");

            // si icone existe et il existe une place voisine => déplacer : 
            // 7 peut être échangé avec 4,8
            if (l7.getIcon() != null)
            {
                if (l4.getIcon() == null)
                {
                    l4.setIcon(l7.getIcon());
                    l4.setName(l7.getName());
                    l7.setIcon(null);
                    l7.setName("0");
                    verifier_resultat();
                }
                if (l8.getIcon() == null)
                {
                    l8.setIcon(l7.getIcon());
                    l8.setName(l7.getName());
                    l7.setIcon(null);
                    l7.setName("0");
                    verifier_resultat();
                }
            }
        }
        if (ev.getSource() == l8)
        {
            //System.out.println("clic sur l8");

            // si icone existe et il existe une place voisine => déplacer : 
            // 8 peut être échangé avec 5,7,9
            if (l8.getIcon() != null)
            {
                if (l5.getIcon() == null)
                {
                    l5.setIcon(l8.getIcon());
                    l5.setName(l8.getName());
                    l8.setIcon(null);
                    l8.setName("0");
                    verifier_resultat();
                }
                if (l7.getIcon() == null)
                {
                    l7.setIcon(l8.getIcon());
                    l7.setName(l8.getName());
                    l8.setIcon(null);
                    l8.setName("0");
                    verifier_resultat();
                }
                if (l9.getIcon() == null)
                {
                    l9.setIcon(l8.getIcon());
                    l9.setName(l8.getName());
                    l8.setIcon(null);
                    l8.setName("0");
                    verifier_resultat();
                }
            }
        }
        if (ev.getSource() == l9)
        {
            //System.out.println("clic sur l9");

            // si icone existe et il existe une place voisine => déplacer : 
            // 9 peut être échangé avec 6,8
            if (l9.getIcon() != null)
            {
                if (l6.getIcon() == null)
                {
                    l6.setIcon(l9.getIcon());
                    l6.setName(l9.getName());
                    l9.setIcon(null);
                    l9.setName("0");
                    verifier_resultat();
                }
                if (l8.getIcon() == null)
                {
                    l8.setIcon(l9.getIcon());
                    l8.setName(l9.getName());
                    l9.setIcon(null);
                    l9.setName("0");
                    verifier_resultat();
                }
            }
        }
    }

    public void mouseClicked_grille16(MouseEvent ev)
    {
        if (ev.getSource() == l1)
        {
            //System.out.println("clic sur l1");

            // si icone existe et il existe une place voisine => déplacer :
            // 1 peut être échangé avec 2,5
            if (l1.getIcon() != null)
            {
                if (l2.getIcon() == null)
                {
                    l2.setIcon(l1.getIcon());
                    l2.setName(l1.getName());
                    l1.setIcon(null);
                    l1.setName("0");
                    verifier_resultat();
                }
                if (l5.getIcon() == null)
                {
                    l5.setIcon(l1.getIcon());
                    l5.setName(l1.getName());
                    l1.setIcon(null);
                    l1.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l2)
        {
            //System.out.println("clic sur l2");

            // si icone existe et il existe une place voisine => déplacer :
            // 2 peut être échangé avec 1,3,6
            if (l2.getIcon() != null)
            {
                if (l1.getIcon() == null)
                {
                    l1.setIcon(l2.getIcon());
                    l1.setName(l2.getName());
                    l2.setIcon(null);
                    l2.setName("0");
                    verifier_resultat();
                }
                if (l3.getIcon() == null)
                {
                    l3.setIcon(l2.getIcon());
                    l3.setName(l2.getName());
                    l2.setIcon(null);
                    l2.setName("0");
                    verifier_resultat();
                }
                if (l6.getIcon() == null)
                {
                    l6.setIcon(l2.getIcon());
                    l6.setName(l2.getName());
                    l2.setIcon(null);
                    l2.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l3)
        {
            //System.out.println("clic sur l3");

            // si icone existe et il existe une place voisine => déplacer :
            // 3 peut être échangé avec 2,4,7
            if (l3.getIcon() != null)
            {
                if (l2.getIcon() == null)
                {
                    l2.setIcon(l3.getIcon());
                    l2.setName(l3.getName());
                    l3.setIcon(null);
                    l3.setName("0");
                    verifier_resultat();
                }
                if (l4.getIcon() == null)
                {
                    l4.setIcon(l3.getIcon());
                    l4.setName(l3.getName());
                    l3.setIcon(null);
                    l3.setName("0");
                    verifier_resultat();
                }
                if (l7.getIcon() == null)
                {
                    l7.setIcon(l3.getIcon());
                    l7.setName(l3.getName());
                    l3.setIcon(null);
                    l3.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l4)
        {
            //System.out.println("clic sur l4");

            // si icone existe et il existe une place voisine => déplacer :
            // 4 peut être échangé avec 3,8
            if (l4.getIcon() != null)
            {
                if (l3.getIcon() == null)
                {
                    l3.setIcon(l4.getIcon());
                    l3.setName(l4.getName());
                    l4.setIcon(null);
                    l4.setName("0");
                    verifier_resultat();
                }
                if (l8.getIcon() == null)
                {
                    l8.setIcon(l4.getIcon());
                    l8.setName(l4.getName());
                    l4.setIcon(null);
                    l4.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l5)
        {
            //System.out.println("clic sur l5");

            // si icone existe et il existe une place voisine => déplacer :
            // 5 peut être échangé avec 1,6,9
            if (l5.getIcon() != null)
            {
                if (l1.getIcon() == null)
                {
                    l1.setIcon(l5.getIcon());
                    l1.setName(l5.getName());
                    l5.setIcon(null);
                    l5.setName("0");
                    verifier_resultat();
                }
                if (l6.getIcon() == null)
                {
                    l6.setIcon(l5.getIcon());
                    l6.setName(l5.getName());
                    l5.setIcon(null);
                    l5.setName("0");
                    verifier_resultat();
                }
                if (l9.getIcon() == null)
                {
                    l9.setIcon(l5.getIcon());
                    l9.setName(l5.getName());
                    l5.setIcon(null);
                    l5.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l6)
        {
            //System.out.println("clic sur l6");

            // si icone existe et il existe une place voisine => déplacer :
            // 6 peut être échangé avec 2,5,7,10
            if (l6.getIcon() != null)
            {
                if (l2.getIcon() == null)
                {
                    l2.setIcon(l6.getIcon());
                    l2.setName(l6.getName());
                    l6.setIcon(null);
                    l6.setName("0");
                    verifier_resultat();
                }
                if (l5.getIcon() == null)
                {
                    l5.setIcon(l6.getIcon());
                    l5.setName(l6.getName());
                    l6.setIcon(null);
                    l6.setName("0");
                    verifier_resultat();
                }
                if (l7.getIcon() == null)
                {
                    l7.setIcon(l6.getIcon());
                    l7.setName(l6.getName());
                    l6.setIcon(null);
                    l6.setName("0");
                    verifier_resultat();
                }
                if (l10.getIcon() == null)
                {
                    l10.setIcon(l6.getIcon());
                    l10.setName(l6.getName());
                    l6.setIcon(null);
                    l6.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l7)
        {
            //System.out.println("clic sur l7");

            // si icone existe et il existe une place voisine => déplacer :
            // 7 peut être échangé avec 3,6,8,11
            if (l7.getIcon() != null)
            {
                if (l3.getIcon() == null)
                {
                    l3.setIcon(l7.getIcon());
                    l3.setName(l7.getName());
                    l7.setIcon(null);
                    l7.setName("0");
                    verifier_resultat();
                }
                if (l6.getIcon() == null)
                {
                    l6.setIcon(l7.getIcon());
                    l6.setName(l7.getName());
                    l7.setIcon(null);
                    l7.setName("0");
                    verifier_resultat();
                }
                if (l8.getIcon() == null)
                {
                    l8.setIcon(l7.getIcon());
                    l8.setName(l7.getName());
                    l7.setIcon(null);
                    l7.setName("0");
                    verifier_resultat();
                }
                if (l11.getIcon() == null)
                {
                    l11.setIcon(l7.getIcon());
                    l11.setName(l7.getName());
                    l7.setIcon(null);
                    l7.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l8)
        {
            //System.out.println("clic sur l8");

            // si icone existe et il existe une place voisine => déplacer :
            // 8 peut être échangé avec 4,7,12
            if (l8.getIcon() != null)
            {
                if (l4.getIcon() == null)
                {
                    l4.setIcon(l8.getIcon());
                    l4.setName(l8.getName());
                    l8.setIcon(null);
                    l8.setName("0");
                    verifier_resultat();
                }
                if (l7.getIcon() == null)
                {
                    l7.setIcon(l8.getIcon());
                    l7.setName(l8.getName());
                    l8.setIcon(null);
                    l8.setName("0");
                    verifier_resultat();
                }
                if (l12.getIcon() == null)
                {
                    l12.setIcon(l8.getIcon());
                    l12.setName(l8.getName());
                    l8.setIcon(null);
                    l8.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l9)
        {
            //System.out.println("clic sur l9");

            // si icone existe et il existe une place voisine => déplacer :
            // 9 peut être échangé avec 5,10,13
            if (l9.getIcon() != null)
            {
                if (l5.getIcon() == null)
                {
                    l5.setIcon(l9.getIcon());
                    l5.setName(l9.getName());
                    l9.setIcon(null);
                    l9.setName("0");
                    verifier_resultat();
                }
                if (l10.getIcon() == null)
                {
                    l10.setIcon(l9.getIcon());
                    l10.setName(l9.getName());
                    l9.setIcon(null);
                    l9.setName("0");
                    verifier_resultat();
                }
                if (l13.getIcon() == null)
                {
                    l13.setIcon(l9.getIcon());
                    l13.setName(l9.getName());
                    l9.setIcon(null);
                    l9.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l10)
        {
            //System.out.println("clic sur l10");

            // si icone existe et il existe une place voisine => déplacer :
            // 10 peut être échangé avec 6,9,11,14
            if (l10.getIcon() != null)
            {
                if (l6.getIcon() == null)
                {
                    l6.setIcon(l10.getIcon());
                    l6.setName(l10.getName());
                    l10.setIcon(null);
                    l10.setName("0");
                    verifier_resultat();
                }
                if (l9.getIcon() == null)
                {
                    l9.setIcon(l10.getIcon());
                    l9.setName(l10.getName());
                    l10.setIcon(null);
                    l10.setName("0");
                    verifier_resultat();
                }
                if (l11.getIcon() == null)
                {
                    l11.setIcon(l10.getIcon());
                    l11.setName(l10.getName());
                    l10.setIcon(null);
                    l10.setName("0");
                    verifier_resultat();
                }
                if (l14.getIcon() == null)
                {
                    l14.setIcon(l10.getIcon());
                    l14.setName(l10.getName());
                    l10.setIcon(null);
                    l10.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l11)
        {
            //System.out.println("clic sur l11");

            // si icone existe et il existe une place voisine => déplacer :
            // 11 peut être échangé avec 7,10,12,15
            if (l11.getIcon() != null)
            {
                if (l7.getIcon() == null)
                {
                    l7.setIcon(l11.getIcon());
                    l7.setName(l11.getName());
                    l11.setIcon(null);
                    l11.setName("0");
                    verifier_resultat();
                }
                if (l10.getIcon() == null)
                {
                    l10.setIcon(l11.getIcon());
                    l10.setName(l11.getName());
                    l11.setIcon(null);
                    l11.setName("0");
                    verifier_resultat();
                }
                if (l12.getIcon() == null)
                {
                    l12.setIcon(l11.getIcon());
                    l12.setName(l11.getName());
                    l11.setIcon(null);
                    l11.setName("0");
                    verifier_resultat();
                }
                if (l15.getIcon() == null)
                {
                    l15.setIcon(l11.getIcon());
                    l15.setName(l11.getName());
                    l11.setIcon(null);
                    l11.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l12)
        {
            //System.out.println("clic sur l12");

            // si icone existe et il existe une place voisine => déplacer :
            // 12 peut être échangé avec 8,11,16
            if (l12.getIcon() != null)
            {
                if (l8.getIcon() == null)
                {
                    l8.setIcon(l12.getIcon());
                    l8.setName(l12.getName());
                    l12.setIcon(null);
                    l12.setName("0");
                    verifier_resultat();
                }
                if (l11.getIcon() == null)
                {
                    l11.setIcon(l12.getIcon());
                    l11.setName(l12.getName());
                    l12.setIcon(null);
                    l12.setName("0");
                    verifier_resultat();
                }
                if (l16.getIcon() == null)
                {
                    l16.setIcon(l12.getIcon());
                    l16.setName(l12.getName());
                    l12.setIcon(null);
                    l12.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l13)
        {
            //System.out.println("clic sur l13");

            // si icone existe et il existe une place voisine => déplacer :
            // 13 peut être échangé avec 9,14
            if (l13.getIcon() != null)
            {
                if (l9.getIcon() == null)
                {
                    l9.setIcon(l13.getIcon());
                    l9.setName(l13.getName());
                    l13.setIcon(null);
                    l13.setName("0");
                    verifier_resultat();
                }
                if (l14.getIcon() == null)
                {
                    l14.setIcon(l13.getIcon());
                    l14.setName(l13.getName());
                    l13.setIcon(null);
                    l13.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l14)
        {
            //System.out.println("clic sur l14");

            // si icone existe et il existe une place voisine => déplacer :
            // 14 peut être échangé avec 10,13,15
            if (l14.getIcon() != null)
            {
                if (l10.getIcon() == null)
                {
                    l10.setIcon(l14.getIcon());
                    l10.setName(l14.getName());
                    l14.setIcon(null);
                    l14.setName("0");
                    verifier_resultat();
                }
                if (l13.getIcon() == null)
                {
                    l13.setIcon(l14.getIcon());
                    l13.setName(l14.getName());
                    l14.setIcon(null);
                    l14.setName("0");
                    verifier_resultat();
                }
                if (l15.getIcon() == null)
                {
                    l15.setIcon(l14.getIcon());
                    l15.setName(l14.getName());
                    l14.setIcon(null);
                    l14.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l15)
        {
            //System.out.println("clic sur l15");

            // si icone existe et il existe une place voisine => déplacer :
            // 15 peut être échangé avec 11,14,16
            if (l15.getIcon() != null)
            {
                if (l11.getIcon() == null)
                {
                    l11.setIcon(l15.getIcon());
                    l11.setName(l15.getName());
                    l15.setIcon(null);
                    l15.setName("0");
                    verifier_resultat();
                }
                if (l14.getIcon() == null)
                {
                    l14.setIcon(l15.getIcon());
                    l14.setName(l15.getName());
                    l15.setIcon(null);
                    l15.setName("0");
                    verifier_resultat();
                }
                if (l16.getIcon() == null)
                {
                    l16.setIcon(l15.getIcon());
                    l16.setName(l15.getName());
                    l15.setIcon(null);
                    l15.setName("0");
                    verifier_resultat();
                }
            }
        }

        if (ev.getSource() == l16)
        {
            //System.out.println("clic sur l16");

            // si icone existe et il existe une place voisine => déplacer :
            // 16 peut être échangé avec 12,15
            if (l16.getIcon() != null)
            {
                if (l12.getIcon() == null)
                {
                    l12.setIcon(l16.getIcon());
                    l12.setName(l16.getName());
                    l16.setIcon(null);
                    l16.setName("0");
                    verifier_resultat();
                }
                if (l15.getIcon() == null)
                {
                    l15.setIcon(l16.getIcon());
                    l15.setName(l16.getName());
                    l16.setIcon(null);
                    l16.setName("0");
                    verifier_resultat();
                }
            }
        }
    }

    public void mouseEntered(MouseEvent ev)
    {
    }

    public void mouseExited(MouseEvent ev)
    {
    }

    public void mousePressed(MouseEvent ev)
    {
    }

    public void mouseReleased(MouseEvent ev)
    {
    }

    /**
     * méthode qui permet d'appliquer un shuffle (ordre aléatoire) sur un
     * tableau
     *
     * @param array
     * @return array
     */
    public int[] shffleArray(int[] array)
    {
        java.util.Random rgen = new java.util.Random();  // Random number generator			

        for (int i = 0; i < array.length; i++)
        {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }
}
