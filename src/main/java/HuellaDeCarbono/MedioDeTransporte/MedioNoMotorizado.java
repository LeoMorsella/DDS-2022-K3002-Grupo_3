package HuellaDeCarbono.MedioDeTransporte;

public class MedioNoMotorizado extends Medio {

    private TipoMedioNoMotorizado tipo;

    public TipoMedioNoMotorizado getTipo() {
        return tipo;
    }

    public void setTipo(TipoMedioNoMotorizado tipo) {
        this.tipo = tipo;
    }

    private String ID = "MNM";

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Double getFE() {
        return 0.0;
    }
}
