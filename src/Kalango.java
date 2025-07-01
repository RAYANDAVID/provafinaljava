public class Kalango extends Personagem {

    public Kalango(int energia) {
        super(energia);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void mover() {
       System.out.println("Terreste com velocidade");
    }

    @Override
    public void fazerSom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fazerSom'");
    }

}
