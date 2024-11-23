package examenFraccion;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Fraccion {
		private int d;
		private int n;
		
	public Fraccion(int n, int d) {
		this.setD(d);
		this.setN(n);
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
	
	public void suma(Fraccion c1, Fraccion c2) {
		n = (c1.n*c2.d) + (c2.n*c1.d);
		d = c1.d*c2.d;
		simplificar();
	}
	
	public void resta(Fraccion c1, Fraccion c2) {
		n = (c1.n*c2.d) - (c1.d*c2.n);
		d = c1.d*c2.d;
		simplificar();
	}
	
	public void division(Fraccion c1, Fraccion c2) {
		n = c1.n*c2.d;
		d = c1.d*c2.n;
		simplificar();
	}
	
	public void multi(Fraccion c1, Fraccion c2) {
		n = c1.n*c2.n;
		d = c1.d*c2.d;
		simplificar();
	}
	
	private int mcd(int a, int b) {
		if (b == 0) {
			return a;
			} return mcd(b, a % b);
		} 
	
	int mcm(int a, int b) {
		return Math.abs(a * b) / mcd(a, b);
		}
	
	public void simplificar() {
		int divisor = mcd(n, d); n = n / divisor;
		d = d / divisor;
	}
	
	public void escribirFraccionEnArchivo(Fraccion fraccion, String nombreArchivo) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
			writer.write(fraccion.getN() + "/" + fraccion.getD());
			writer.newLine();
			} 
		catch (IOException e) {
			e.printStackTrace(); 
			} 
		} 
	public List<Fraccion> leerFraccionesDesdeArchivo(String nombreArchivo) {
		List<Fraccion> fracciones = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
			String linea; while ((linea = reader.readLine()) != null) {
				String[] partes = linea.split("/");
				if (partes.length == 2) {
					int n = Integer.parseInt(partes[0]);
					int d = Integer.parseInt(partes[1]);
					fracciones.add(new Fraccion(n, d));
					}
				}
			} 
		catch (IOException e) {
			e.printStackTrace(); 
			}
		return fracciones;
	}
}
