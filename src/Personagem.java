public abstract class Personagem {
  protected int energia;  
  public Personagem(){
     super();
  }
  public Personagem(int energia) {
    this.energia = energia;
  }  
  public abstract void mover();
  public abstract void fazerSom();
  public int getEnergia() {
    return energia;
  }
  public void setEnergia(int energia) {
    this.energia = energia;
  }
}
