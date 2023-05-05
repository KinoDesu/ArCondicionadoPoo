public class ArCondicionado {

    private boolean power = false;
    private int temperatura;
    private int intesidade;
    private boolean oscilacao;

    public ArCondicionado(int temperatura, int intesidade, boolean oscilacao) {
        this.power = true;
        this.temperatura = temperatura;
        this.intesidade = intesidade;
        this.oscilacao = oscilacao;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getIntesidade() {
        return intesidade;
    }

    public void setIntesidade(int intesidade) {
        this.intesidade = intesidade;
    }

    public boolean isOscilacao() {
        return oscilacao;
    }

    public void setOscilacao(boolean oscilacao) {
        this.oscilacao = oscilacao;
    }

    @Override
    public String toString() {

        String textoIntensidade = "";

        if (intesidade == 0) {
            textoIntensidade = "Fraco";
        } else if (intesidade == 1) {
            textoIntensidade = "Médio";
        } else if (intesidade == 2) {
            textoIntensidade = "Forte";
        }

        String textoPower = "";

        if (power == true) {
            textoPower = "ON";
        } else {
            textoPower = "OFF";
        }

        String textoOscilacao = "";

        if (oscilacao == true) {
            textoOscilacao = "ligada";
        } else {
            textoOscilacao = "desligada";
        }

        return "power " + textoPower + "\nTemperatura: " + temperatura + "ºC" + "\nIntesidade: " + textoIntensidade
                + "\nOscilação " + textoOscilacao;
    }

}
