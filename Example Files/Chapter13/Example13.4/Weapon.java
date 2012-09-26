public class Weapon extends Item{
  private int force;

  public Weapon(String nm, String desc, int frc) {
    super(nm, desc);
    force = frc;
  }
}