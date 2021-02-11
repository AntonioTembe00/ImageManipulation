
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Afzal José
 * @author António Tembe
 * @author Thomas Chicuma
 */
public class JanelaPrincipal {

    public static void main(String[] args) {
        JFrame f = new JFrame("Manipulação de Imagem");
        f.add(new Main());
        f.pack();
        f.setSize(800, 1000);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        //meuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setExtendedState(f.MAXIMIZED_BOTH);
        try {

            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green", "licena", "tpcgamers");
            
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
            
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
    }
}
