
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Afzal José
 * @author António Tembe
 * @author Thomas Chicuma
 */
public class Main extends JPanel {

    JPanel optionsPanel, rotatePanel, valuesPanel, cropPanel, shearPanel, scalePanel, translatePanel;
    JComboBox transformsCB, renderCB;
    String[] transformsOptions;
    String[] renderOptions;
    public static JButton identity = new JButton("movimentar");
    public static JTextField rotationValue, x, y, a, b, shearValueX, shearValueY, scaleValueX, scaleValueY, translateValueX, translateValueY;
    public static JButton rotateRight, rotateLeft, cropBT, shearBT, translateBT, scaleBT, openFile;

    public Main() {
       
        build();
        optionsPanel.setBackground(Color.ORANGE);
        rotatePanel.setBackground(Color.ORANGE);
        valuesPanel.setBackground(Color.ORANGE); 
        cropPanel.setBackground(Color.ORANGE);
        shearPanel.setBackground(Color.ORANGE);
        scalePanel.setBackground(Color.ORANGE);
        translatePanel.setBackground(Color.ORANGE); 
    }

    public void build() {
        TransformImage.TransformingCanvas canvas;
        canvas = new TransformImage.TransformingCanvas();
        TransformImage.TranslateHandler translater = new TransformImage.TranslateHandler(canvas);
        TransformImage.itemHandler itemHandler = new TransformImage.itemHandler(canvas);
        BorderLayout bLayout = new BorderLayout(5, 20);
        identity.addMouseListener(translater);
        optionsPanel = new JPanel(new GridLayout(2, 7, 20, 6));
        rotatePanel = new JPanel();
        cropPanel = new JPanel();
        valuesPanel = new JPanel(new GridLayout(2, 4));
        cropBT = new JButton("Cortar");
        cropBT.addMouseListener(translater);
        x = new JTextField(2);
        y = new JTextField(2);
        a = new JTextField(2);
        b = new JTextField(2);
        valuesPanel.add(new JLabel(" Inicio-X:  "));
        valuesPanel.add(x);
        valuesPanel.add(new JLabel(" Inicio-Y:  "));
        valuesPanel.add(y);
        valuesPanel.add(new JLabel(" Comp-X:  "));
        valuesPanel.add(a);
        valuesPanel.add(new JLabel(" Comp-Y:  "));
        valuesPanel.add(b);
        cropPanel.add(valuesPanel);
        cropPanel.add(cropBT);

        openFile = new JButton("Abrir Ficheiro");
        openFile.addMouseListener(translater);

        shearValueX = new JTextField(3);
        shearValueX.setVisible(false);
        shearValueY = new JTextField(3);
        shearValueY.setVisible(false);
        shearBT = new JButton("Cortar");
        shearBT.setVisible(false);
        shearBT.addMouseListener(translater);
        shearPanel = new JPanel();
        shearPanel.add(new JLabel(""));
        shearPanel.add(shearValueX);
        shearPanel.add(new JLabel(""));
        shearPanel.add(shearValueY);
        shearPanel.add(new JLabel(""));
        shearPanel.add(shearBT);
        

        scaleValueX = new JTextField(3);
        scaleValueY = new JTextField(3);
        scaleBT = new JButton("Escala");
        scaleBT.addMouseListener(translater);
        scalePanel = new JPanel();
        scalePanel.add(new JLabel("Val. escala"));
        scalePanel.add(scaleValueX);
        scalePanel.add(new JLabel("X"));
        scalePanel.add(scaleValueY);
        scalePanel.add(new JLabel("Y"));
        scalePanel.add(scaleBT);

        translateValueX = new JTextField(3);
        translateValueY = new JTextField(3);
        translateBT = new JButton("Trans");
        translateBT.addMouseListener(translater);
        translatePanel = new JPanel();
        translatePanel.add(new JLabel("Val. Trans"));
        translatePanel.add(translateValueX);
        translatePanel.add(new JLabel("X"));
        translatePanel.add(translateValueY);
        translatePanel.add(new JLabel("Y"));
        translatePanel.add(translateBT);

        transformsOptions = new String[]{"Girar", "Escala", "Corte", "identidade"};
        renderOptions = new String[]{"Nenhum", "Preto e Branco"};
        transformsCB = new JComboBox(transformsOptions);
        
        renderCB = new JComboBox(renderOptions);
        renderCB.addItemListener(itemHandler);
        rotateLeft = new JButton();
        rotateRight = new JButton();

        rotationValue = new JTextField(3);
        rotateRight.addMouseListener(translater);
        rotateLeft.addMouseListener(translater);
        rotatePanel.add(rotateLeft);
        rotatePanel.add(rotateRight);
        rotatePanel.add(new JLabel("Val. rotação"));
        rotatePanel.add(rotationValue);

        //optionsPanel.add(transformsCB);  
        optionsPanel.add(openFile);
        optionsPanel.add(scalePanel);
        optionsPanel.add(translatePanel);
        optionsPanel.add(shearPanel);
        optionsPanel.add(renderCB);
        optionsPanel.add(identity);
        optionsPanel.add(cropPanel);
        optionsPanel.add(rotatePanel);

        canvas.addMouseListener(translater);
        canvas.addMouseMotionListener(translater);
        canvas.addMouseWheelListener(new TransformImage.ScaleHandler(canvas));

        this.setLayout(bLayout);
        this.add(optionsPanel, BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER);
    }

}
