package examenFraccion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaFraccion extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField numeradorField1;
    private JTextField denominadorField1;
    private JTextField numeradorField2;
    private JTextField denominadorField2;
    private JButton sumaButton;
    private JButton restaButton;
    private JButton multiButton;
    private JButton diviButton;
    private JButton limpiarButton;
    private JButton guardarButton; 
    private JButton cargarButton;

    public VentanaFraccion() {
        
        setTitle("Calculadora de Fracciones");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panel);

       
        panel.add(new JLabel("Numerador 1:"));
        numeradorField1 = new JTextField();
        panel.add(numeradorField1);

        panel.add(new JLabel("Denominador 1:"));
        denominadorField1 = new JTextField();
        panel.add(denominadorField1);

        
        panel.add(new JLabel("Numerador 2:"));
        numeradorField2 = new JTextField();
        panel.add(numeradorField2);

        panel.add(new JLabel("Denominador 2:"));
        denominadorField2 = new JTextField();
        panel.add(denominadorField2);

        
        sumaButton = new JButton("Suma");
        panel.add(sumaButton);
        
        restaButton = new JButton("Resta");
        panel.add(restaButton);
        
        multiButton = new JButton("Multiplicacion");
        panel.add(multiButton);
        
        diviButton = new JButton("Division");
        panel.add(diviButton);
        

        limpiarButton = new JButton("Limpiar");
        panel.add(limpiarButton);

        guardarButton = new JButton("Guardar Fracción");
        panel.add(guardarButton);
        
        cargarButton = new JButton("Cargar Fracciones");
        panel.add(cargarButton);
        
        sumaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int num1 = Integer.parseInt(numeradorField1.getText());
                int den1 = Integer.parseInt(denominadorField1.getText());
                int num2 = Integer.parseInt(numeradorField2.getText());
                int den2 = Integer.parseInt(denominadorField2.getText());

                
                Fraccion fraccion1 = new Fraccion(num1, den1);
                Fraccion fraccion2 = new Fraccion(num2, den2);

                
                Fraccion resultado = new Fraccion(0,0);
                resultado.suma(fraccion1, fraccion2);

                
                JOptionPane.showMessageDialog(null, "Resultado de la suma: " + resultado.getN() + "/" + resultado.getD());
            }
        });
        
        restaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int num1 = Integer.parseInt(numeradorField1.getText());
                int den1 = Integer.parseInt(denominadorField1.getText());
                int num2 = Integer.parseInt(numeradorField2.getText());
                int den2 = Integer.parseInt(denominadorField2.getText());

               
                Fraccion fraccion1 = new Fraccion(num1, den1);
                Fraccion fraccion2 = new Fraccion(num2, den2);

               
                Fraccion resultado = new Fraccion(0, 0);
                resultado.resta(fraccion1, fraccion2);

                
                JOptionPane.showMessageDialog(null, "Resultado de la resta: " + resultado.getN() + "/" + resultado.getD());
            }
        });
        
        multiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int num1 = Integer.parseInt(numeradorField1.getText());
                int den1 = Integer.parseInt(denominadorField1.getText());
                int num2 = Integer.parseInt(numeradorField2.getText());
                int den2 = Integer.parseInt(denominadorField2.getText());

               
                Fraccion fraccion1 = new Fraccion(num1, den1);
                Fraccion fraccion2 = new Fraccion(num2, den2);

                
                Fraccion resultado = new Fraccion(0, 0);
                resultado.multi(fraccion1, fraccion2);

               
                JOptionPane.showMessageDialog(null, "Resultado de la multiplicacion: " + resultado.getN() + "/" + resultado.getD());
            }
        });
        
        diviButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(numeradorField1.getText());
                int den1 = Integer.parseInt(denominadorField1.getText());
                int num2 = Integer.parseInt(numeradorField2.getText());
                int den2 = Integer.parseInt(denominadorField2.getText());

                Fraccion fraccion1 = new Fraccion(num1, den1);
                Fraccion fraccion2 = new Fraccion(num2, den2);

                Fraccion resultado = new Fraccion(0, 0);
                resultado.division(fraccion1, fraccion2);
                
                JOptionPane.showMessageDialog(null, "Resultado de la division: " + resultado.getN() + "/" + resultado.getD());
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                numeradorField1.setText("");
                denominadorField1.setText("");
                numeradorField2.setText("");
                denominadorField2.setText("");
            }
        });
        
        guardarButton.addActionListener(new ActionListener() {
        	@Override public void actionPerformed(ActionEvent e) {
        		try {
        			int num1 = Integer.parseInt(numeradorField1.getText());
        			int den1 = Integer.parseInt(denominadorField1.getText());
        			Fraccion fraccion = new Fraccion(num1, den1);
        			fraccion.escribirFraccionEnArchivo(fraccion, "fracciones.txt");
        			JOptionPane.showMessageDialog(null, "Fracción guardada exitosamente.");
        			} 
        		catch (NumberFormatException ex) {
        			JOptionPane.showMessageDialog(null, "Por favor, ingresa números válidos.");
        			} 
        		} 
        	}); 
        
        cargarButton.addActionListener(new ActionListener() {
        	@Override public void actionPerformed(ActionEvent e) { 
        		Fraccion fraccion = new Fraccion(0, 1);
        		List<Fraccion> fracciones = fraccion.leerFraccionesDesdeArchivo("fracciones.txt");
        		StringBuilder sb = new StringBuilder();
        		for (Fraccion f : fracciones) {
        			sb.append(f.getN()).append("/").append(f.getD()).append("\n");
        			} JOptionPane.showMessageDialog(null, "Fracciones cargadas:\n" + sb.toString());
        			} 
        	});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaFraccion().setVisible(true);
            }
        });
    }
}


