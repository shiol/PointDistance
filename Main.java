import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ProvaParadigmas {

  public static void main(String[] args) {

    // Lista com todos pontos
    List<Ponto> pontos = new ArrayList<Ponto>();
    // Lista com todos distâncias distintas
    List<Double> raios = new ArrayList<Double>();
    // Lista com todas as distâncias
    List<Double> distancias = new ArrayList<Double>();
    Scanner s = new Scanner(System.in);

    // Entrada de dados do ponto central principal
    System.out.print("Digite a quantidade de pontos: ");
    double qtdPontos = s.nextDouble();
    System.out.print("Digite a coordenada X do ponto central: ");
    double xCentral = s.nextDouble();
    System.out.print("Digite a coordenada Y do ponto central: ");
    double yCentral = s.nextDouble();
    Ponto pontoCentral = new Ponto(xCentral, yCentral);

    // Entrada de dados dos outros pontos
    for(int i = 0; i < qtdPontos; i++){
      System.out.println("Insira a coordenada X do ponto " + (i+1));
      double x = s.nextDouble();
      System.out.println("Insira a coordenada Y do ponto " + (i+1));
      double y = s.nextDouble();
      pontos.add(new Ponto(x, y));
    }

    // Calcula todas as distâncias
    for(Ponto ponto : pontos){
      distancias.add(distancia(pontoCentral.x, pontoCentral.y, ponto.x, ponto.y));
    }

    // Verifica todas as distâncias distintas
    for(double distancia : distancias){
      if(!raios.contains(distancia))
        raios.add(distancia);
    }

    // Imprime todos as distâncias distintas
    for(int i = 0; i < raios.size(); i++){
      System.out.printf("Raio %d = %.3f\n", i, raios.get(i));
    }

    s.close();
  }

  // Métodos para calcular a distância entre dois pontos
  private static double distancia(double a, double b, double c, double d) {
    double dist = Math.sqrt(Math.pow(a - c, 2) + Math.pow(b - d, 2));
    return dist;
  }
}

// Classe que representa um Ponto
class Ponto {
  public double x, y;
  public Ponto(double x, double y) {
    this.x = x;
    this.y = y;
  }
}
